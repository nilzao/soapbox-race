package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchasedCarsType")
public class PurchasedCarsType {

	@XmlElement(name = "OwnedCarTrans", required = true)
	protected OwnedCarTransType ownedCarTrans;

	public OwnedCarTransType getOwnedCarTrans() {
		return ownedCarTrans;
	}

	public void setOwnedCarTrans(OwnedCarTransType ownedCarTrans) {
		this.ownedCarTrans = ownedCarTrans;
	}

}