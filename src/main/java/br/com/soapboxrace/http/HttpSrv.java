package br.com.soapboxrace.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;

import br.com.soapboxrace.config.Config;
import br.com.soapboxrace.dao.factory.SaveType;
import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.engine.Session;
import br.com.soapboxrace.jaxb.EngineExceptionTrans;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.xmpp.XmppFactory;
import br.com.soapboxrace.xmpp.openfire.RestApiCli;

public class HttpSrv extends GzipHandler {

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
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
			error.setErrorCode(2);
			error.setMessage(e.getMessage());
			error.setStackTrace("");
			content = MarshalXML.marshal(error);
			response.setStatus(500);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("generic error");
		}
		try {
			response.setContentType("application/xml;charset=utf-8");
			response.setHeader("Content-Encoding", "gzip");
			if (target.contains("accept")) {
				response.addHeader("Keep-Alive", "timeout=70");
			} else {
				response.setHeader("connection", "close");
			}
			baseRequest.setHandled(true);
			if (content != null && !content.trim().isEmpty()) {
				byte[] bytes = gzip(content.getBytes(StandardCharsets.UTF_8));
				response.setContentLength(bytes.length);
				response.getOutputStream().write(bytes);
				response.getOutputStream().flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private byte[] gzip(byte[] data) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream(data.length);
		try {
			OutputStream gzipout = new GZIPOutputStream(byteStream) {
				{
					def.setLevel(1);
				}
			};
			try {
				gzipout.write(data);
			} finally {
				gzipout.close();
			}
		} finally {
			byteStream.close();
		}
		return byteStream.toByteArray();
	}

	public static void main(String[] args) {
		Config config = Config.getInstance();
		Session.setXmppIp(config.getXmppIp());
		Session.setXmppPort(config.getXmppPort());
		Session.setRaceUdpIp(config.getRaceUdpIp());
		Session.setRaceUdpPort(config.getRaceUdpPort());
		Session.setFreeRoamUdpIp(config.getFreeRoamUdpIp());
		Session.setFreeRoamUdpPort(config.getFreeRoamUdpPort());
		Session.setXmppServerType(config.getXmppServerType());
		RestApiCli.setOpenFireAuthToken(config.getOpenFireToken());

		XmppFactory.getXmppSenderInstance(Session.getXmppServerType());
		SaveType saveType = config.getSaveType();
		if (SaveType.DB.equals(saveType)) {
			new ConnectionDB();
		}
		try {
			Server server = new Server(config.getHttpPort());
			server.setHandler(new HttpSrv());
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}