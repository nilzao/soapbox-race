package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PersonaPresence")
public class PersonaPresenceType {

	private Long personaId;
	private Long userId;
	private int presence;

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public void setPresence(int presence) {
		this.presence = presence;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public Long getUserId() {
		return userId;
	}

	public int getPresence() {
		return presence;
	}

}
