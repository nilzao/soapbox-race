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
import br.com.soapboxrace.http.HttpSessionVO;

public class Router {

	public static ConcurrentHashMap<Long, HttpSessionVO> activeUsers = new ConcurrentHashMap<Long, HttpSessionVO>();
	public static SecureRandom random = new SecureRandom();
	private String target;
	private HttpServletRequest request;
	private Request baseRequest;

	// CRT function converted to Java.
	// For UInt64 processing on 8086 UInt32 values.
	// Maybe not necessary, but I like to keep it close to the original.
	protected static Object[] __allmul(long multiplier, long multiplicand) {
		long hiMultiplier = (multiplier >>> 32) & 0xffffffffL;
		long loMultiplier = ((multiplier << 32) >>> 32) & 0xffffffffL;

		long hiMultiplicand = (multiplicand >>> 32) & 0xffffffffL;
		long loMultiplicand = ((multiplicand << 32) >>> 32) & 0xffffffffL;

		long multiplied, loMultiplied, hiMultiplied, oldMultiplied;
		if (hiMultiplicand == 0 && hiMultiplier == 0)
			multiplied = loMultiplier * loMultiplicand;
		else
			multiplied = multiplier * multiplicand;
		oldMultiplied = multiplied;
		hiMultiplied = (multiplied >>> 32) & 0xffffffffL;
		loMultiplied = ((multiplied << 32) >>> 32) & 0xffffffffL;
		do { // modulo wrapper on UInt32
			if (loMultiplied < 0L || loMultiplied > 4294967295L)
				loMultiplied %= 4294967296L;
			if (hiMultiplied < 0L || hiMultiplied > 4294967295L)
				hiMultiplied %= 4294967296L;
		} while ((loMultiplied < 0L || hiMultiplied < 0L)
				&& (loMultiplied > 4294967295L || hiMultiplied > 4294967295L));
		multiplied = hiMultiplied << 32 | loMultiplied;
		return new Object[] { multiplied, oldMultiplied == loMultiplied };
	}

	public static Long calculateHash(char[] jid, char[] response) {
		long multiplier = 4294967295L & 0xffffffffL;
		boolean cFlag = true;
		for (char c : jid) {
			Object[] bHash = __allmul(multiplier, 33L & 0xffffffffL);
			long jidHash = (long) bHash[0];
			long hiJidHash = (jidHash >>> 32) & 0xffffffffL;
			long loJidHash = ((jidHash << 32) >>> 32) & 0xffffffffL;

			long hiCdq = hiJidHash;
			long loCdq = Long.valueOf(c) & 0xffffffffL;

			long hiMultiplier = (((hiJidHash >>> 32) + hiCdq) + (cFlag == true ? 1L : 0L)) & 0xffffffffL;
			long loMultiplier = (((loJidHash << 32) >>> 32) + loCdq) & 0xffffffffL;

			multiplier = hiMultiplier << 32 | loMultiplier;
			cFlag = (boolean) bHash[1];
		}

		for (char c : response) {
			Object[] bHash = __allmul(multiplier, 33L & 0xffffffffL);
			long responseHash = (long) bHash[0];
			long hiJidHash = (responseHash >>> 32) & 0xffffffffL;
			long loJidHash = ((responseHash << 32) >>> 32) & 0xffffffffL;

			long hiCdq = hiJidHash;
			long loCdq = Long.valueOf(c) & 0xffffffffL;

			long hiMultiplier = (((hiJidHash >>> 32) + hiCdq) + (cFlag == true ? 1L : 0L)) & 0xffffffffL;
			long loMultiplier = (((loJidHash << 32) >>> 32) + loCdq) & 0xffffffffL;

			multiplier = hiMultiplier << 32 | loMultiplier;
			cFlag = (boolean) bHash[1];
		}
		return multiplier;
	}

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

	public static HttpSessionVO getHttpSessionVo(Long userId) {
		if (Router.activeUsers.containsKey(userId)) {
			HttpSessionVO httpSessionVO = Router.activeUsers.get(userId);
			if (httpSessionVO != null)
				return httpSessionVO;
		}
		return null;
	}

	protected Long getLoggedPersonaId() {
		if (Router.activeUsers.containsKey(getUserId())) {
			try {
				checkSecurityToken();
			} catch (EngineException e) {
				Router.activeUsers.remove(getUserId());
				return null;
			}
			HttpSessionVO httpSessionVO = getHttpSessionVo(getUserId());
			if (httpSessionVO.getPersonaId() != null && httpSessionVO.getPersonaId() != 0L)
				return httpSessionVO.getPersonaId();
		}
		return -1L;
	}

	protected String getParam(String param) {
		return baseRequest.getParameter(param);
	}

	public void setBaseRequest(Request baseRequest) {
		this.baseRequest = baseRequest;
	}

	protected HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
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

	public void setTarget(String target) {
		this.target = target;
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