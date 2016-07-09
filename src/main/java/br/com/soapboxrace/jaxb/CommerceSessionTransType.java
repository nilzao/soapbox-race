package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommerceSessionTransType", propOrder = { "basketTrans", "entitlementsToSell", "updatedCar" })
@XmlRootElement(name = "CommerceSessionTrans")
public class CommerceSessionTransType {
	@XmlElement(name = "Basket", required = true)
	protected BasketTransType basketTrans;
	@XmlElement(name = "EntitlementsToSell", required = true)
	protected String entitlementsToSell;
	@XmlElement(name = "UpdatedCar", required = true)
	protected UpdatedCarType updatedCar;

	public BasketTransType getBasketTrans() {
		return basketTrans;
	}

	public void setBasketTrans(BasketTransType value) {
		this.basketTrans = value;
	}

	public String getEntitlementsToSell() {
		return entitlementsToSell;
	}

	public void setEntitlementsToSell(String value) {
		this.entitlementsToSell = value;
	}

	public UpdatedCarType getUpdatedCar() {
		return updatedCar;
	}

	public void setUpdatedCar(UpdatedCarType value) {
		this.updatedCar = value;
	}
}