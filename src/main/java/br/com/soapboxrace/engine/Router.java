package br.com.soapboxrace.engine;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.Request;

public class Router {

	private static Long loggedPersonaId;

	private String target;

	private HttpServletRequest request;

	private Request baseRequest;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setBaseRequest(Request baseRequest) {
		this.baseRequest = baseRequest;
	}

	public String getParam(String param) {
		return baseRequest.getParameter(param);
	}

	public String getHeader(String param) {
		return request.getHeader(param);
	}

	protected String readInputStream() {
		StringBuilder buffer = new StringBuilder();
		try {
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) != null)
				buffer.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	public static Long getLoggedPersonaId() {
		return loggedPersonaId;
	}

	public static void setLoggedPersonaId(Long loggedPersonaId) {
		Router.loggedPersonaId = loggedPersonaId;
	}

	String getSecurityToken() {
		return getHeader("securityToken");
	}

	Long getUserId() {
		return Long.valueOf(getHeader("userId"));
	}

}
