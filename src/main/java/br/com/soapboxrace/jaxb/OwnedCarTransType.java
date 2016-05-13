package br.com.soapboxrace.jaxb;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OwnedCarTransType", propOrder = { "customCar", "durability", "expirationDate", "heatLevel",
		"uniqueCarId", "ownershipType" })
@XmlRootElement(name = "OwnedCarTrans")
public class OwnedCarTransType {

	@XmlElement(name = "CustomCar")
	protected CustomCarType customCar;
	@XmlElement(name = "Durability")
	protected short durability;
	@XmlElement(name = "ExpirationDate")
	protected String expirationDate;
	@XmlElement(name = "Heat")
	protected short heatLevel;
	@XmlElement(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long uniqueCarId;
	@XmlElement(name = "OwnershipType")
	protected String ownershipType;

	public CustomCarType getCustomCar() {
		return this.customCar;
	}

	public void setCustomCar(CustomCarType value) {
		this.customCar = value;
	}

	public short getDurability() {
		return durability;
	}

	public void setDurability(short value) {
		this.durability = value;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String value) {
		this.expirationDate = value;
	}

	public short getHeatLevel() {
		return heatLevel;
	}

	public void setHeatLevel(short value) {
		this.heatLevel = value;
	}

	public long getUniqueCarId() {
		return uniqueCarId;
	}

	public void setUniqueCarId(long value) {
		this.uniqueCarId = value;
	}

	public String getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(String value) {
		this.ownershipType = value;
	}
}