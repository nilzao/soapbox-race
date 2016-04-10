package br.com.soapboxrace.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaIdsType", propOrder = { "array" })
public class PersonaIdsType {

	@XmlElement(type = Long.class)
	protected List<Long> array;

	public List<Long> getArray() {
		if (array == null) {
			array = new ArrayList<Long>();
		}
		return this.array;
	}

}
