package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommerceSessionResultTransType", propOrder = { "invalidBasket", "inventoryItems", "status",
		"updatedCar", "wallets" })
@XmlRootElement(name = "CommerceSessionResultTrans")
public class CommerceSessionResultTransType {
	@XmlElement(name = "InvalidBasket", required = true)
	protected String invalidBasket;
	@XmlElement(name = "InventoryItems", required = true)
	protected InventoryItemsType inventoryItems;
	@XmlElement(name = "UpdatedCar", required = true)
	protected UpdatedCarType updatedCar;
	@XmlElement(name = "Status", required = true)
	protected String status;
	@XmlElement(name = "Wallets", required = true)
	protected WalletsType wallets;

	public String getInvalidBasket() {
		return invalidBasket;
	}

	public void setInvalidBasket(String value) {
		this.invalidBasket = value;
	}

	public InventoryItemsType getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(InventoryItemsType value) {
		this.inventoryItems = value;
	}

	public UpdatedCarType getUpdatedCar() {
		return updatedCar;
	}

	public void setUpdatedCar(UpdatedCarType value) {
		this.updatedCar = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	public WalletsType getWallets() {
		return wallets;
	}

	public void setWallets(WalletsType value) {
		this.wallets = value;
	}
}