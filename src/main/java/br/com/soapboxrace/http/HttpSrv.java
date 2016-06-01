package br.com.soapboxrace.http;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.server.handler.gzip.GzipHttpOutputInterceptor;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.engine.Session;
import br.com.soapboxrace.jaxb.EngineExceptionTrans;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.xmpp.XmppSrv;

public class HttpSrv extends GzipHandler {

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		if ("/favicon.ico".equals(target))
			return;
		System.out.println(baseRequest.toString());
		String[] targetSplitted = target.split("/");
		String className = "Default";
		String methodName = "";
		String content = null;
		if (targetSplitted.length > 4) {
			className = targetSplitted[3];
			className = String.valueOf(Character.toUpperCase(className.charAt(0))).concat(className.substring(1));
			methodName = targetSplitted[4];
			if (methodName.matches(".*\\d+.*")) {
				methodName = targetSplitted[5];
			}
			methodName = String.valueOf(Character.toLowerCase(methodName.charAt(0))).concat(methodName.substring(1));
		} else {
			methodName = targetSplitted[3];
			methodName = String.valueOf(Character.toLowerCase(methodName.charAt(0))).concat(methodName.substring(1));
		}
		try {
			Class<?> dynamicObj = Class.forName("br.com.soapboxrace.engine.".concat(className));
			Router newInstance = (Router) dynamicObj.newInstance();
			newInstance.setBaseRequest(baseRequest);
			newInstance.setRequest(request);
			newInstance.setTarget(target);
			Method declaredMethod;
			declaredMethod = dynamicObj.getDeclaredMethod(methodName);
			content = (String) declaredMethod.invoke(newInstance);
			response.setStatus(200);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
			e.printStackTrace();
			System.out.println("class or method error");
		} catch (NoSuchMethodException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("class not found");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			EngineExceptionTrans error = new EngineExceptionTrans();
			error.setDescription("");
			error.setInnerException("");
			error.setErrorCode("2");
			error.setMessage(e.getCause().getMessage());
			error.setStackTrace("");
			content = MarshalXML.marshal(error);
			response.setStatus(500);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("generic error");
		}
		try {
			setCompressionLevel(9);
			HttpOutput out = baseRequest.getResponse().getHttpOutput();
			out.setInterceptor(new GzipHttpOutputInterceptor(this, GzipHttpOutputInterceptor.VARY_ACCEPT_ENCODING,
					baseRequest.getHttpChannel(), out.getInterceptor()));
			response.setContentType("application/xml;charset=utf-8");
			if (target.contains("accept")) {
				response.addHeader("Keep-Alive", "timeout=70");
			} else {
				response.setHeader("connection", "close");
			}
			baseRequest.setHandled(true);
			if (content == null) {
				content = "";
				System.err.println("empty response.");
			}
			response.getOutputStream().write(content.getBytes("UTF-8"));
			response.getOutputStream().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.setProperty("jsse.enableCBCProtection", "false");

		if (args.length > 0) {
			Session.setXmppIp(args[0]);
			if (args.length > 1) {
				Session.setUdpIp(args[1]);
			}
		}
		new ConnectionDB();
		new XmppSrv();
		try {
			Server server = new Server(1337);
			server.setHandler(new HttpSrv());
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}