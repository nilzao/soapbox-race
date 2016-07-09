package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jpa.OwnedCarEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOwnedCarTransType")
@XmlRootElement(name = "ArrayOfOwnedCarTrans")
public class ArrayOfOwnedCarTransType {
	@XmlElement(name = "OwnedCarTrans")
	protected List<OwnedCarEntity> ownedCarTransList;

	public List<OwnedCarEntity> getOwnedCarTransList() {
		return ownedCarTransList;
	}

	public void setOwnedCarTransList(List<OwnedCarEntity> ownedCarTransList) {
		this.ownedCarTransList = ownedCarTransList;
	}
}