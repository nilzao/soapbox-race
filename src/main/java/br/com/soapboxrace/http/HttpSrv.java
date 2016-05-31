package br.com.soapboxrace.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.engine.Session;
import br.com.soapboxrace.xmpp.XmppSrv;

public class HttpSrv extends GzipHandler {

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		if ("/favicon.ico".equals(target))
			return;
		// System.out.println(baseRequest.toString());
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
		} catch (Exception e) {
			response.setStatus(500);
			e.printStackTrace();
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
				content = readContent(target);
				System.out.println("=======================================");
				System.out.println("          READ FROM XML FILE");
				System.out.println("=======================================");
			}
			if (!content.trim().isEmpty()) {
				response.getOutputStream().write(content.getBytes("UTF-8"));
				response.getOutputStream().flush();
			}
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
		String enabledCBC = System.getProperty("jsse.enableCBCProtection");
		if (!"false".equals(enabledCBC)) {
			System.err.println("\n  ERROR!!!  \n\nNeed to run java vm with -Djsse.enableCBCProtection=false\n\n");
			System.out.println("Example:");
			System.out.println("   java -Djsse.enableCBCProtection=false -jar soapbox-race.jar");
			System.exit(0);
		}

		File f = new File("soapbox.mv.db");
		if (!f.exists()) {
			ClassLoader classLoader = HttpSrv.class.getClassLoader();
			InputStream h2DbInputStream = classLoader.getResourceAsStream("soapbox.mv.db");
			try {
				int read = 0;
				byte[] bytes = new byte[1024];
				OutputStream outputStream = new FileOutputStream(new File("soapbox.mv.db"));
				while ((read = h2DbInputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				outputStream.close();
			} catch (Exception e) {
				System.err.println("ERROR CREATING DB FILE");
				e.printStackTrace();
				System.exit(0);
			}
		}

		Locale newLocale = new Locale("en", "GB");
		Locale.setDefault(newLocale);

		if (args.length > 0) {
			Session.setXmppIp(args[0]);
			if (args.length > 1) {
				Session.setUdpIp(args[1]);
			}
		}
		new ConnectionDB();
		System.out.println("Http server is running.");
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