package br.com.soapboxrace.http;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.server.handler.gzip.GzipHttpOutputInterceptor;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.engine.KeepAlive;
import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.engine.Session;
import br.com.soapboxrace.xmpp.XmppSrv;

public class HttpSrv extends GzipHandler {

	private KeepAlive keepAlive = new KeepAlive();

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		keepAlive.setBaseRequest(baseRequest);
		keepAlive.setRequest(request);
		keepAlive.setTarget(target);
		keepAlive.keepSession();
		if ("/favicon.ico".equals(target)) {
			return;
		}
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
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e) {
			e.printStackTrace();
			System.out.println("erro na classe ou metodo");
		} catch (NoSuchMethodException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("classe ou metodo não encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro generico");
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
			response.setStatus(200);
			baseRequest.setHandled(true);
			if (content == null) {
				content = readContent(target);
				System.out.println("=======================================");
				System.out.println("          LIDO DE ARQUIVO XML");
				System.out.println("=======================================");
			}
			response.getOutputStream().write(content.getBytes());
			response.getOutputStream().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String readContent(String target) throws IOException {
		StringBuilder modTarget = new StringBuilder();
		modTarget.append("www");
		modTarget.append(target);
		byte[] content = null;
		String targetClr = modTarget.toString();
		String targetXml = modTarget.append(".xml").toString();
		if (Files.exists(Paths.get(targetXml, new String[0]), new LinkOption[0])) {
			content = Files.readAllBytes(Paths.get(targetXml, new String[0]));
		} else if (Files.exists(Paths.get(targetClr, new String[0]), new LinkOption[0])) {
			content = Files.readAllBytes(Paths.get(targetClr, new String[0]));
		}
		String str = "";
		if (content != null) {
			str = new String(content, "UTF-8");
		}
		return str;
	}

	public static void main(String[] args) {
		Locale newLocale = new Locale("en", "GB");
		Locale.setDefault(newLocale);
		System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
		
		if (args.length > 0) {
			Session.setIp(args[0]);
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