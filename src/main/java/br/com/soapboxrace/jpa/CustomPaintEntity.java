package br.com.soapboxrace.jpa;

import javax.persistence.Column;
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
@XmlType(name = "CustomPaintTransType", propOrder = { "group", "hue", "sat", "slot", "var" })
@Entity
@Table(name = "CUSTOMPAINT")
public class CustomPaintEntity {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "IDCUSTOMCAR", referencedColumnName = "ID")
	private CustomCarEntity customCar;

	@XmlElement(name = "Group")
	@Column(name = "paintGroup")
	protected int group;
	@XmlElement(name = "Hue")
	protected int hue;
	@XmlElement(name = "Sat")
	protected int sat;
	@XmlElement(name = "Slot")
	protected int slot;
	@XmlElement(name = "Var")
	protected int var;

	public int getGroup() {
		return group;
	}

	public void setGroup(int value) {
		this.group = value;
	}

	public int getHue() {
		return hue;
	}

	public void setHue(int value) {
		this.hue = value;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int value) {
		this.sat = value;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int value) {
		this.slot = value;
	}

	public int getVar() {
		return var;
	}

	public void setVar(int value) {
		this.var = value;
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
