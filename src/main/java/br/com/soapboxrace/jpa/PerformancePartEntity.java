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
@XmlType(name = "PerformancePartTransType", propOrder = { "performancePartAttribHash" })
@Entity
@Table(name = "PERFORMANCEPART")
public class PerformancePartEntity {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "IDCUSTOMCAR", referencedColumnName = "ID")
	private CustomCarEntity customCar;

	@XmlElement(name = "PerformancePartAttribHash")
	protected int performancePartAttribHash;

	public int getPerformancePartAttribHash() {
		return performancePartAttribHash;
	}

	public void setPerformancePartAttribHash(int value) {
		this.performancePartAttribHash = value;
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
