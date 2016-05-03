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
@XmlType(name = "SkillModPartTransType", propOrder = { "isFixed", "skillModPartAttribHash" })
@Entity
@Table(name = "SKILLMODPART")
public class SkillModPartEntity {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "IDCUSTOMCAR", referencedColumnName = "ID")
	private CustomCarEntity customCar;

	@XmlElement(name = "IsFixed", required = true)
	protected String isFixed;
	@XmlElement(name = "SkillModPartAttribHash")
	protected int skillModPartAttribHash;

	public String getIsFixed() {
		return isFixed;
	}

	public void setIsFixed(String value) {
		this.isFixed = value;
	}

	public int getSkillModPartAttribHash() {
		return skillModPartAttribHash;
	}

	public void setSkillModPartAttribHash(int value) {
		this.skillModPartAttribHash = value;
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
