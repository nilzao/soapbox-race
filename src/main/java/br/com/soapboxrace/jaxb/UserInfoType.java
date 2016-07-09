package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserInfoType", propOrder = { "defaultPersonaIdx", "personas", "user" })
@XmlRootElement(name = "UserInfo")
public class UserInfoType {

	protected int defaultPersonaIdx;
	@XmlElement(required = true)
	protected PersonasType personas;
	@XmlElement(required = true)
	protected UserType user;

	public int getDefaultPersonaIdx() {
		return defaultPersonaIdx;
	}

	public void setDefaultPersonaIdx(int defaultPersonaIdx) {
		this.defaultPersonaIdx = defaultPersonaIdx;
	}

	public PersonasType getPersonas() {
		return personas;
	}

	public void setPersonas(PersonasType personas) {
		this.personas = personas;
	}

	public UserType getUser() {
		return user;
	}

	public void setUser(UserType user) {
		this.user = user;
	}

}
