package br.com.soapboxrace.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisualPartTransType", propOrder = { "partHash", "slotHash" })
@Entity
@Table(name = "VISUALPART")
public class VisualPartEntity {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "IDCUSTOMCAR", referencedColumnName = "ID")
	private CustomCarEntity customCar;

	@XmlElement(name = "PartHash")
	protected int partHash;
	@XmlElement(name = "SlotHash")
	protected int slotHash;

	public int getPartHash() {
		return partHash;
	}

	public void setPartHash(int value) {
		this.partHash = value;
	}

	public int getSlotHash() {
		return slotHash;
	}

	public void setSlotHash(int value) {
		this.slotHash = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CustomCarEntity getCustomCar() {
		return customCar;
	}

	public void setCustomCar(CustomCarEntity customCar) {
		this.customCar = customCar;
	}

}
