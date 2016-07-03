package br.com.soapboxrace.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPersonaBaseType", propOrder = { "personaBase" })
@XmlRootElement(name = "ArrayOfPersonaBase")
public class ArrayOfPersonaBaseType {

	@XmlElement(name = "PersonaBase")
	protected List<PersonaBaseType> personaBase;

	public List<PersonaBaseType> getPersonaBase() {
		if (personaBase == null) {
			personaBase = new ArrayList<PersonaBaseType>();
		}
		return this.personaBase;
	}

}
