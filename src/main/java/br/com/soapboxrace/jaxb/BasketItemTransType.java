package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasketItemTransType", propOrder = { "productId", "quantity" })
public class BasketItemTransType {

	@XmlElement(name = "ProductId", required = true)
	protected String productId;
	@XmlElement(name = "Quantity")
	protected int quantity;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String value) {
		this.productId = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int value) {
		this.quantity = value;
	}

}
