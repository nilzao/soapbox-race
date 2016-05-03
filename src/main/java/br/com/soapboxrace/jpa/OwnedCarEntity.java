package br.com.soapboxrace.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OwnedCarTransType", propOrder = { "customCarList", "durability", "expirationDate", "heat", "id",
		"ownershipType" })
@Entity
@Table(name = "OWNEDCAR")
@XmlRootElement(name = "OwnedCarTrans")
public class OwnedCarEntity implements Serializable {

	private static final long serialVersionUID = -907326566908852312L;

	@XmlElement(name = "CustomCar", required = true)
	@OneToMany(mappedBy = "ownedCar", targetEntity = CustomCarEntity.class, cascade = { CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REMOVE })
	private List<CustomCarEntity> customCarList;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "IDPERSONA", referencedColumnName = "ID")
	private PersonaEntity persona;

	@XmlTransient
	@OneToOne
	@JoinColumn(name = "IDPRODUCT", referencedColumnName = "ID")
	private ProductEntity product;

	@XmlElement(name = "Durability")
	protected int durability;
	@XmlElement(name = "ExpirationDate", required = true)
	protected String expirationDate;
	@XmlElement(name = "Heat")
	protected int heat;
	@XmlElement(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	@XmlElement(name = "OwnershipType", required = true)
	protected String ownershipType;

	public int getDurability() {
		return durability;
	}

	public void setDurability(int value) {
		this.durability = value;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String value) {
		this.expirationDate = value;
	}

	public int getHeat() {
		return heat;
	}

	public void setHeat(int value) {
		this.heat = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long value) {
		this.id = value;
	}

	public String getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(String value) {
		this.ownershipType = value;
	}

	public List<CustomCarEntity> getCustomCarList() {
		return customCarList;
	}

	public void setCustomCarList(List<CustomCarEntity> customCarList) {
		this.customCarList = customCarList;
	}

	public boolean add(CustomCarEntity e) {
		if (customCarList == null) {
			customCarList = new ArrayList<CustomCarEntity>();
		}
		return customCarList.add(e);
	}

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}
