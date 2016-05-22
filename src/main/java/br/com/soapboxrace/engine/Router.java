package br.com.soapboxrace.engine;

import java.io.BufferedReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.Request;

import br.com.soapboxrace.definition.ServerExceptions.EngineException;
import br.com.soapboxrace.definition.UserLoginStatus;
import br.com.soapboxrace.http.HttpSessionVO;

public class Router {

	public static ConcurrentHashMap<Long, HttpSessionVO> activeUsers = new ConcurrentHashMap<Long, HttpSessionVO>();
	public static SecureRandom random = new SecureRandom();
	public static HttpSessionVO getHttpSessionVo(Long userId) {
		if (Router.activeUsers.containsKey(userId)) {
			HttpSessionVO httpSessionVO = Router.activeUsers.get(userId);
			if (httpSessionVO != null)
				return httpSessionVO;
		}
		return null;
	}
	
	private String target;
	private HttpServletRequest request;
	private Request baseRequest;

	protected void checkSecurityToken() throws EngineException {
		String securityToken = getHeader("securityToken");
		Long userId = Long.valueOf(getHeader("userId"));
		if (getHttpSessionVo(userId) != null) {
			if (!getHttpSessionVo(userId).getSecurityToken().equals(securityToken))
				throw new EngineException("Session error: Invalid token!");
		} else
			throw new EngineException("Session error: Invalid session!");
	}

	protected void createSessionEntry(Long userId, String securityToken) {
		HttpSessionVO session = new HttpSessionVO();
		session.setUserId(userId);
		session.setSecurityToken(securityToken);
		Router.activeUsers.put(userId, session);
	}

	protected String getHeader(String param) {
		return request.getHeader(param);
	}

	protected Long getLoggedPersonaId() {
		if (Router.activeUsers.containsKey(getUserId())) {
			HttpSessionVO httpSessionVO = Router.activeUsers.get(getUserId());
			if (httpSessionVO.getPersonaId() != null)
				return httpSessionVO.getPersonaId();
		}
		return -1L;
	}

	protected String getParam(String param) {
		return baseRequest.getParameter(param);
	}

	protected HttpServletRequest getRequest() {
		return request;
	}

	protected String getSecureRandomText() {
		return new BigInteger(130, Router.random).toString(32);
	}

	protected String getSecurityToken() {
		if (getHeader("securityToken") != null)
			return (String) getHeader("securityToken");
		return null;
	}

	protected String getTarget() {
		return target;
	}

	protected Long getUserId() {
		if (getHeader("userId") != null)
			return Long.valueOf(getHeader("userId"));
		return -1L;
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

	protected void removeSessionEntry(Long userId) {
		if (getHttpSessionVo(userId) != null) {
			Router.activeUsers.remove(userId);
		}
	}

	public void setBaseRequest(Request baseRequest) {
		this.baseRequest = baseRequest;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	protected void setSessionEntry(String toBeModifiedEntry, Object assignedValue) {
		try {
			if (getHttpSessionVo(getUserId()) != null) {
				HttpSessionVO httpSessionVo = getHttpSessionVo(getUserId());
				Method declaredMethod = httpSessionVo.getClass().getMethod("set" + toBeModifiedEntry,
						assignedValue.getClass());
				declaredMethod.invoke(httpSessionVo, assignedValue.getClass().cast(assignedValue));
				Router.activeUsers.put(getUserId(), httpSessionVo);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
	}

	public void setTarget(String target) {
		this.target = target;
	}

	protected String shuffleString(String input) {
		StringBuilder sb = new StringBuilder(input.length());
		double mathRandom;
		for (char c : input.toCharArray()) {
			mathRandom = Math.random();
			if (mathRandom < 0.34)
				sb.append(c);
			else if (mathRandom < 0.67)
				sb.insert(sb.length() / 2, c);
			else
				sb.insert(0, c);
		}
		return sb.toString();
	}
}