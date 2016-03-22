package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InventoryItemTransType", propOrder = { "entitlementTag", "expirationDate", "hash", "inventoryId",
		"productId", "remainingUseCount", "resellPrice", "status", "stringHash", "virtualItemType" })
public class InventoryItemTransType {

	@XmlElement(name = "EntitlementTag", required = true)
	protected String entitlementTag;
	@XmlElement(name = "ExpirationDate", required = true)
	protected String expirationDate;
	@XmlElement(name = "Hash")
	protected int hash;
	@XmlElement(name = "InventoryId")
	protected int inventoryId;
	@XmlElement(name = "ProductId", required = true)
	protected String productId;
	@XmlElement(name = "RemainingUseCount")
	protected int remainingUseCount;
	@XmlElement(name = "ResellPrice")
	protected float resellPrice;
	@XmlElement(name = "Status", required = true)
	protected String status;
	@XmlElement(name = "StringHash", required = true)
	protected String stringHash;
	@XmlElement(name = "VirtualItemType", required = true)
	protected String virtualItemType;

	public String getEntitlementTag() {
		return entitlementTag;
	}

	public void setEntitlementTag(String value) {
		this.entitlementTag = value;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String value) {
		this.expirationDate = value;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int value) {
		this.hash = value;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int value) {
		this.inventoryId = value;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String value) {
		this.productId = value;
	}

	public int getRemainingUseCount() {
		return remainingUseCount;
	}

	public void setRemainingUseCount(int value) {
		this.remainingUseCount = value;
	}

	public float getResellPrice() {
		return resellPrice;
	}

	public void setResellPrice(float value) {
		this.resellPrice = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	public String getStringHash() {
		return stringHash;
	}

	public void setStringHash(String value) {
		this.stringHash = value;
	}

	public String getVirtualItemType() {
		return virtualItemType;
	}

	public void setVirtualItemType(String value) {
		this.virtualItemType = value;
	}

}
