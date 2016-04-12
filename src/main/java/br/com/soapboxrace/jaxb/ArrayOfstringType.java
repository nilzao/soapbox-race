package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfstringType", propOrder = { "string" })
@XmlRootElement(name = "ArrayOfstring")
public class ArrayOfstringType {

	@XmlElement(required = true)
	protected String string;

	public String getString() {
		return string;
	}

	public void setString(String value) {
		this.string = value;
	}

}
