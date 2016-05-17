package br.com.soapboxrace.engine;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.server.Request;

import br.com.soapboxrace.dao.PersonaDao;
import br.com.soapboxrace.http.HttpSrv;
import br.com.soapboxrace.jpa.PersonaEntity;

public class Router {

	private String target;

	private HttpServletRequest request;

	private Request baseRequest;

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

	protected HttpSession getSession() {
		return request.getSession();
	}

	protected String getSecurityToken() {
		return (String) getSession().getAttribute("securityToken");
	}

	protected Long getUserId() {
		return (Long) getSession().getAttribute("userId");
	}
	
	protected Long getLoggedPersonaId() {
		return (Long) getSession().getAttribute("personaId");
	}
	
	protected void createSession() {
		HttpSession session = getSession();
	    session.setAttribute("userId", Long.valueOf(getHeader("userId")));
	    session.setAttribute("securityToken", getHeader("securityToken"));
	    session.setMaxInactiveInterval(90); //seconds	    
	}
	
	protected void updateSession(String attributeName, Object value) {
		HttpSession session = getSession();
		session.setAttribute(attributeName, value);
		if (attributeName.equals("personaId")) 
			HttpSrv.activePersonas.putIfAbsent(new PersonaDao().findById(getLoggedPersonaId()), session);
	}
	
	protected void closeSession() {
		HttpSrv.activePersonas.remove(new PersonaDao().findById(getLoggedPersonaId()));
		getSession().invalidate();
	}
}