package br.com.soapboxrace.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RewardModesType", propOrder = { "_int" })
public class RewardModesType {

	@XmlElement(name = "int", type = Integer.class)
	protected List<Integer> _int;

	public List<Integer> getInt() {
		if (_int == null) {
			_int = new ArrayList<Integer>();
		}
		return this._int;
	}

}
