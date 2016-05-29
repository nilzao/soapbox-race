package br.com.soapboxrace.jpa;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.soapboxrace.jaxb.CustomCarType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;

@Entity
@Table(name = "OWNEDCAR")
@XmlRootElement(name = "OwnedCarTrans")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class OwnedCarEntity implements ISoapBoxEntity {

	private static final long serialVersionUID = 6298043520507324814L;

	@XmlTransient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PersonaId", referencedColumnName = "ID")
	private PersonaEntity persona;

	@Transient
	@XmlElement(name = "CustomCar")
	protected CustomCarType customCarType;

	@XmlTransient
	@Access(AccessType.PROPERTY)
	protected String customCar;

	protected short durability;

	protected String expirationDate;

	protected short heatLevel;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	protected String ownershipType;

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}

	public CustomCarType getCustomCarType() {
		return customCarType;
	}

	public void setCustomCar(CustomCarType customCarType) {
		this.customCarType = customCarType;
	}

	public String getCustomCar() {
		if (customCarType != null) {
			return MarshalXML.marshal(customCarType);
		}
		return customCar;
	}

	public void setCustomCar(String customCar) {
		if (customCar != null && !customCar.isEmpty()) {
			CustomCarType customCarType = new CustomCarType();
			customCarType = (CustomCarType) UnmarshalXML.unMarshal(customCar, customCarType);
			this.customCarType = customCarType;
		}
		this.customCar = customCar;
	}

	@XmlElement(name = "Durability")
	public short getDurability() {
		return durability;
	}

	public void setDurability(short durability) {
		this.durability = durability;
	}

	@XmlElement(name = "ExpirationDate")
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@XmlElement(name = "Heat")
	public short getHeatLevel() {
		return heatLevel;
	}

	public void setHeatLevel(short heatLevel) {
		this.heatLevel = heatLevel;
	}

	@XmlElement(name = "Id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "OwnershipType")
	public String getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(String ownershipType) {
		this.ownershipType = ownershipType;
	}

}
