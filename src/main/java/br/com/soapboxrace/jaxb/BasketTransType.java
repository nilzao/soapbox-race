package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasketTransType", propOrder = { "items" })
@XmlRootElement(name = "BasketTrans")
public class BasketTransType {

	@XmlElement(name = "Items", required = true)
	protected ItemsType items;

	public ItemsType getItems() {
		return items;
	}

	public void setItems(ItemsType value) {
		this.items = value;
	}

}
