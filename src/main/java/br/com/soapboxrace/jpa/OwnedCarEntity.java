package br.com.soapboxrace.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jaxb.OwnedCarTransType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OwnedCarTransType", propOrder = { "customCar", "durability", "expirationDate", "heatLevel",
		"uniqueCarId", "ownershipType" })
@Entity
@Table(name = "OWNEDCAR")
@XmlRootElement(name = "OwnedCarTrans")
public class OwnedCarEntity implements ISoapBoxEntity {

	private static final long serialVersionUID = 6298043520507324814L;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "PersonaId", referencedColumnName = "ID")
	private PersonaEntity persona;

	@XmlElement(name = "CustomCar", required = true)
	@OneToMany(mappedBy = "parentOwnedCarTrans", targetEntity = CustomCarEntity.class, cascade = { CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	protected List<CustomCarEntity> customCar;
	@XmlElement(name = "Durability", required = true)
	protected short durability;
	@XmlElement(name = "ExpirationDate", required = true)
	protected String expirationDate;
	@XmlElement(name = "Heat", required = true)
	protected short heatLevel;
	@XmlElement(name = "Id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long uniqueCarId;
	@XmlElement(name = "OwnershipType", required = true)
	protected String ownershipType;

	public CustomCarEntity getCustomCar() {
		return this.customCar.get(0);
	}

	public void setCustomCar(CustomCarEntity value) {
		List<CustomCarEntity> dummyList = new ArrayList<CustomCarEntity>();
		dummyList.add(value);
		this.customCar = dummyList;
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

	public Long getId() {
		return uniqueCarId;
	}

	public void setId(Long value) {
		this.uniqueCarId = value;
	}

	public String getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(String value) {
		this.ownershipType = value;
	}

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}

	public OwnedCarTransType getOwnedCarTransType() {
		OwnedCarTransType result = new OwnedCarTransType();
		result.setCustomCar(getCustomCar().getCustomCarType());
		result.setDurability(getDurability());
		result.setExpirationDate(getExpirationDate());
		result.setHeatLevel(getHeatLevel());
		result.setOwnershipType(getOwnershipType());
		result.setUniqueCarId(getUniqueCarId());
		return result;
	}
}