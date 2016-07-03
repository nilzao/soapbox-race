package br.com.soapboxrace.http;

import java.util.Date;

public class HttpSessionVO {
	private Long userId;
	private Long personaId;
	private Long eventSessionId;
	private String relayCryptoTicket;
	private String relaySessionKey;
	private Date expirationDate;
	private String securityToken;
	private Stopwatch alternateEventTimer = new Stopwatch();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public Long getEventSessionId() {
		return eventSessionId;
	}

	public void setEventSessionId(Long eventSessionId) {
		this.eventSessionId = eventSessionId;
	}

	public String getRelayCryptoTicket() {
		return relayCryptoTicket;
	}

	public void setRelayCryptoTicket(String relayCryptoTicket) {
		this.relayCryptoTicket = relayCryptoTicket;
	}

	public String getRelaySessionKey() {
		return relaySessionKey;
	}

	public void setRelaySessionKey(String relaySessionKey) {
		this.relaySessionKey = relaySessionKey;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityToken() {
		return securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	public Stopwatch getAlternateEventTimer() {
		return alternateEventTimer;
	}

	public void setAlternateEventTimer(Stopwatch alternateEventTimer) {
		this.alternateEventTimer = alternateEventTimer;
	}

	public class Stopwatch {
		public long startTime;
		public long endTime;

		public void start() {
			startTime = System.currentTimeMillis();
		}

		public void stop() {
			endTime = System.currentTimeMillis();
		}

		public long getElapsed() {
			stop();
			return endTime - startTime;
		}
	}
}