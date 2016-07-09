package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InventoryItemsType", propOrder = { "inventoryItemTrans" })
public class InventoryItemsType {

	@XmlElement(name = "InventoryItemTrans", required = true)
	protected InventoryItemTransType inventoryItemTrans;

	public InventoryItemTransType getInventoryItemTrans() {
		return inventoryItemTrans;
	}

	public void setInventoryItemTrans(InventoryItemTransType value) {
		this.inventoryItemTrans = value;
	}

}
