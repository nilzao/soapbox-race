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

	// CRT function converted to Java.
	// For UInt64 processing on 8086 UInt32 values.
	// Maybe not necessary, but I like to keep it close to the original.
	protected static Object[] __allmul(long multiplier, long multiplicand) {
		long hiMultiplier = (multiplier >>> 32) & 0xffffffffL;
		long loMultiplier = ((multiplier << 32) >>> 32) & 0xffffffffL;

		long hiMultiplicand = (multiplicand >>> 32) & 0xffffffffL;
		long loMultiplicand = ((multiplicand << 32) >>> 32) & 0xffffffffL;

		long multiplied, loMultiplied, hiMultiplied, oldMultiplied;
		if (hiMultiplicand == 0 && hiMultiplier == 0) {
			multiplied = loMultiplier * loMultiplicand;
		} else {/*
			long hi_lo = 
				((hiMultiplier * loMultiplicand) >>> 32) & 0xffffffffL;
			long lo_hi = 
				((loMultiplier * hiMultiplicand) >>> 32) & 0xffffffffL;
			long lo_lo = 
				(loMultiplier * loMultiplicand) & 0xffffffffL;
			multiplied = 
				(hi_lo + lo_hi) << 32 | lo_lo;*/
			multiplied = multiplier * multiplicand;
		}
		oldMultiplied = multiplied;
		hiMultiplied = (multiplied >>> 32) & 0xffffffffL;
		loMultiplied = ((multiplied << 32) >>> 32) & 0xffffffffL;
		do { // modulo wrapper on UInt32
			if (loMultiplied > 4294967295L)
				loMultiplied %= 4294967296L;
			if (hiMultiplied > 4294967295L)
				hiMultiplied %= 4294967296L;

			if (loMultiplied < 0L)
				loMultiplied %= 4294967296L;
			if (hiMultiplied < 0L)
				hiMultiplied %= 4294967296L;
		} while ((loMultiplied < 0L || hiMultiplied < 0L)
				&& (loMultiplied > 4294967295L || hiMultiplied > 4294967295L));
		multiplied = hiMultiplied << 32 | loMultiplied;
		return new Object[] { multiplied, oldMultiplied == loMultiplied };
	}

	public static void main(String[] args) {
		long multiplier = 4294967295L & 0xffffffffL; // ecx : ??
		boolean cFlag = true;
		char[] jid = String.format("nfsw.%d@%s", 101L, "192.168.2.33").toCharArray();
		for (int i = 0; i < jid.length; i++) {
			System.out.printf("Char: %s, multiplier: %d, cFlag: %b\r\n", jid[i], multiplier, cFlag);
			Object[] resHash = __allmul(multiplier, 33L & 0xffffffffL);
			long jidHash = (long) resHash[0]; // edx:eax
			// Long jidHash = multiplier * (33L & 0xffffffffL);
			long hiJidHash = (jidHash >>> 32) & 0xffffffffL; // edi = edx
			long loJidHash = ((jidHash << 32) >>> 32) & 0xffffffffL; // ecx = eax

			System.out.printf("h: %d,	lo: %d,	hi: %d\r\n", jidHash, loJidHash, hiJidHash);
			System.out.printf("hex-h: %s,	hex-lo: %s,	hex-hi: %s\r\n", Long.toHexString(jidHash),
					Long.toHexString(loJidHash), Long.toHexString(hiJidHash));

			long hiCdq = hiJidHash; // edx
			long loCdq = Long.valueOf(jid[i]) & 0xffffffffL; // eax
			long cdq = hiCdq << 32 | loCdq; // edx:eax

			long hiMultiplier = (((hiJidHash >>> 32) + hiCdq) + (cFlag == true ? 1L : 0L)) & 0xffffffffL;
			long loMultiplier = (((loJidHash << 32) >>> 32) + loCdq) & 0xffffffffL;

			multiplier = hiMultiplier << 32 | loMultiplier;
			cFlag = (boolean) resHash[1];

			System.out.printf("cdq: %d,	loCdq: %d,	hiCdq: %d\r\n", cdq, loCdq, hiCdq);
			System.out.printf("multiplier: %d,	loMultiplier: %s,	hiMultiplier: %s\r\n\r\n", multiplier,
					Long.toHexString(loMultiplier), Long.toHexString(hiMultiplier));
		}

		jid = "<response status=\"1\" ticket=\"0\"><PowerupActivated><Count>1</Count><Id>-1681514783</Id><PersonaId>101</PersonaId><TargetPersonaId>0</TargetPersonaId></PowerupActivated></response>"
				.toCharArray();
		for (int i = 0; i < jid.length; i++) {
			System.out.printf("Char: %s, multiplier: %d, cFlag: %b\r\n", jid[i], multiplier, cFlag);
			Object[] resHash = __allmul(multiplier, 33L & 0xffffffffL);
			long jidHash = (long) resHash[0]; // edx:eax
			// Long jidHash = multiplier * (33L & 0xffffffffL);
			long hiJidHash = (jidHash >>> 32) & 0xffffffffL; // edx << edi
			long loJidHash = ((jidHash << 32) >>> 32) & 0xffffffffL; // eax << ecx

			System.out.printf("h: %d,	lo: %d,	hi: %d\r\n", jidHash, loJidHash, hiJidHash);
			System.out.printf("hex-h: %s,	hex-lo: %s,	hex-hi: %s\r\n", Long.toHexString(jidHash),
					Long.toHexString(loJidHash), Long.toHexString(hiJidHash));

			long hiCdq = hiJidHash; // edx
			long loCdq = Long.valueOf(jid[i]) & 0xffffffffL; // eax
			long cdq = hiCdq << 32 | loCdq; // edx:eax

			long hiMultiplier = (((hiJidHash >>> 32) + hiCdq) + (cFlag == true ? 1L : 0L)) & 0xffffffffL;
			long loMultiplier = (((loJidHash << 32) >>> 32) + loCdq) & 0xffffffffL;

			multiplier = hiMultiplier << 32 | loMultiplier;
			cFlag = (boolean) resHash[1];

			System.out.printf("cdq: %d,	loCdq: %d,	hiCdq: %d\r\n", cdq, loCdq, hiCdq);
			System.out.printf("multiplier: %d,	loMultiplier: %s,	hiMultiplier: %s\r\n\r\n", multiplier,
					Long.toHexString(loMultiplier), Long.toHexString(hiMultiplier));
		}
	}

	public static Long calculateHash(char[] jid, char[] response) {
		long multiplier = 4294967295L & 0xffffffffL;
		boolean cFlag = true;
		for (int i = 0; i < jid.length; i++) {
			Object[] bHash = __allmul(multiplier, 33L & 0xffffffffL);
			long jidHash = (long) bHash[0];
			long hiJidHash = (jidHash >>> 32) & 0xffffffffL;
			long loJidHash = ((jidHash << 32) >>> 32) & 0xffffffffL;

			long hiCdq = hiJidHash;
			long loCdq = Long.valueOf(jid[i]) & 0xffffffffL;

			long hiMultiplier = (((hiJidHash >>> 32) + hiCdq) + (cFlag == true ? 1L : 0L)) & 0xffffffffL;
			long loMultiplier = (((loJidHash << 32) >>> 32) + loCdq) & 0xffffffffL;

			multiplier = hiMultiplier << 32 | loMultiplier;
			cFlag = (boolean) bHash[1];
		}

		for (int i = 0; i < response.length; i++) {
			Object[] bHash = __allmul(multiplier, 33L & 0xffffffffL);
			long responseHash = (long) bHash[0];
			long hiJidHash = (responseHash >>> 32) & 0xffffffffL;
			long loJidHash = ((responseHash << 32) >>> 32) & 0xffffffffL;

			long hiCdq = hiJidHash;
			long loCdq = Long.valueOf(response[i]) & 0xffffffffL;

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