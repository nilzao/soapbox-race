package br.com.soapboxrace.engine;

import java.io.BufferedReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
		if (getHeader("securityToken") != null)
			return (String) getHeader("securityToken");
		return null;
	}

	protected Long getUserId() {
		if (getHeader("userId") != null)
			return Long.valueOf(getHeader("userId"));
		return (long) -1;
	}

	public static HttpSessionVO getHttpSessionVo(Long userId) {
		HttpSessionVO httpSessionVO = Router.activeUsers.get(userId);
		if (httpSessionVO != null)
			return httpSessionVO;
		return null;
	}

	protected Long getLoggedPersonaId() {
		if (Router.activeUsers.containsKey(getUserId())) {
			HttpSessionVO httpSessionVO = Router.activeUsers.get(getUserId());
			if (httpSessionVO.getPersonaId() != null)
				return httpSessionVO.getPersonaId();
		}
		return (long) -1;
	}

	protected void createSessionEntry(String securityToken) {
		HttpSessionVO session = new HttpSessionVO();
		session.setUserId(getUserId());
		session.setSecurityToken(securityToken);
		Router.activeUsers.put(getUserId(), session);
	}
	
	protected void setSessionEntry(String toBeModifiedEntry, Object assignedValue) {
		try {
			HttpSessionVO httpSessionVo = getHttpSessionVo(getUserId());
			Method declaredMethod = httpSessionVo.getClass().getMethod("set" + toBeModifiedEntry, assignedValue.getClass());
			declaredMethod.invoke(httpSessionVo, assignedValue.getClass().cast(assignedValue));
			Router.activeUsers.put(getUserId(), httpSessionVo);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	protected void removeSessionEntry() {
		Router.activeUsers.remove(getUserId());
	}
}