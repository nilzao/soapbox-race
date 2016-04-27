package br.com.soapboxrace.xmpp.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "P2PCryptoTicketType", propOrder = { "personaId", "sessionKey" })
public class P2PCryptoTicketType {

	@XmlElement(name = "PersonaId")
	protected long personaId;
	@XmlElement(name = "SessionKey", required = true)
	protected String sessionKey;

	public long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(long personaId) {
		this.personaId = personaId;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String value) {
		this.sessionKey = value;
	}

}
