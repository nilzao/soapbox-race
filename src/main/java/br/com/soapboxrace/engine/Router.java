package br.com.soapboxrace.engine;

import java.io.BufferedReader;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.Request;

import br.com.soapboxrace.http.HttpSessionVO;

public class Router {

	private String target;
	private HttpServletRequest request;
	private Request baseRequest;
	public static ConcurrentHashMap<Long, HttpSessionVO> activeUsers = new ConcurrentHashMap<Long, HttpSessionVO>();

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

	public HttpSessionVO getHttpSessionVo(Long userId) {
		HttpSessionVO httpSessionVO = Router.activeUsers.get(userId);
		if (httpSessionVO != null) {
			return httpSessionVO;
		}
		httpSessionVO = new HttpSessionVO();
		httpSessionVO.setUserId(userId);
		return httpSessionVO;
	}

	protected Long getLoggedPersonaId() {
		if (Router.activeUsers.containsKey(getUserId())) {
			HttpSessionVO httpSessionVO = Router.activeUsers.get(getUserId());
			return httpSessionVO.getPersonaId();
		}
		return null;
	}

	protected void setPersonaEntry(Long personaId) {
		HttpSessionVO httpSessionVo = getHttpSessionVo(getUserId());
		httpSessionVo.setPersonaId(personaId);
		Router.activeUsers.put(getUserId(), httpSessionVo);
	}

	protected void removePersonaEntry() {
		Router.activeUsers.remove(getUserId());
	}
}