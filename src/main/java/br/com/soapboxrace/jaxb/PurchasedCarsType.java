package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jpa.OwnedCarEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchasedCarsType")
public class PurchasedCarsType {

	@XmlElement(name = "OwnedCarTrans", required = true)
	protected OwnedCarEntity ownedCarTrans;

	public OwnedCarEntity getOwnedCarTrans() {
		return ownedCarTrans;
	}

	public void setOwnedCarTrans(OwnedCarEntity ownedCarTrans) {
		this.ownedCarTrans = ownedCarTrans;
	}

}
