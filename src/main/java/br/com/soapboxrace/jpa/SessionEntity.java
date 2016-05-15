package br.com.soapboxrace.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SESSION")
public class SessionEntity implements ISoapBoxEntity {

	private static final long serialVersionUID = -2085857427427352203L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String token;
	private long userId;
	private long personaId;
	private long eventSession;

	private Date expiration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(long personaId) {
		this.personaId = personaId;
	}

	public long getEventSession() {
		return eventSession;
	}

	public void setEventSession(long eventSession) {
		this.eventSession = eventSession;
	}

}
