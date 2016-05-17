package br.com.soapboxrace.engine;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.Request;

public class Router {

	private String target;
	private HttpServletRequest request;
	private Request baseRequest;
	public static Map<Long, Long> activeUsers = new HashMap<Long, Long>();

	protected String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	protected HttpServletRequest getRequest() {
		return request;
	}

	protected String getParam(String param) {
		return baseRequest.getParameter(param);
	}

	protected String getHeader(String param) {
		return request.getHeader(param);
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setBaseRequest(Request baseRequest) {
		this.baseRequest = baseRequest;
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

	protected String getSecurityToken() {
		return (String) getHeader("securityToken");
	}

	protected Long getUserId() {
		return Long.valueOf(getHeader("userId"));
	}
	
	protected Long getLoggedPersonaId() {
		if (Router.activeUsers.containsKey(getUserId()))
			return Router.activeUsers.get(getUserId());
		else
			return null;
	}
	
	protected void setPersonaEntry(Long personaId) {
		Router.activeUsers.putIfAbsent(getUserId(), personaId);
	}
	
	protected void removePersonaEntry() {
		Router.activeUsers.remove(getUserId());
	}
}