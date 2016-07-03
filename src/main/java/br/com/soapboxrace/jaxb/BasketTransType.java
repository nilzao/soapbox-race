package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasketTransType", propOrder = { "basketItems" })
@XmlRootElement(name = "BasketTrans")
public class BasketTransType {
	@XmlElement(name = "Items", required = true)
	private BasketItemsType basketItems;

	public BasketItemsType getBasketItems() {
		return basketItems;
	}

	public void setBasketItems(BasketItemsType basketItems) {
		this.basketItems = basketItems;
	}
}