package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaIdArrayType", propOrder = { "personaIds" })
@XmlRootElement(name = "PersonaIdArray")
public class PersonaIdArrayType {

	@XmlElement(name = "PersonaIds", required = true)
	protected PersonaIdsType personaIds;

	public PersonaIdsType getPersonaIds() {
		return personaIds;
	}

	public void setPersonaIds(PersonaIdsType value) {
		this.personaIds = value;
	}

}
