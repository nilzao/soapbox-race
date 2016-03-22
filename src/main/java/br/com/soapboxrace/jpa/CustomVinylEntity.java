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
@XmlType(name = "CustomVinylTransType", propOrder = { "hash", "hue1", "hue2", "hue3", "hue4", "layer", "mir", "rot",
		"sat1", "sat2", "sat3", "sat4", "scaleX", "scaleY", "shear", "tranX", "tranY", "var1", "var2", "var3", "var4" })
@Entity
@Table(name = "CUSTOMVINYL")
public class CustomVinylEntity {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "IDCUSTOMCAR", referencedColumnName = "ID")
	private CustomCarEntity customCar;

	@XmlElement(name = "Hash")
	protected int hash;
	@XmlElement(name = "Hue1")
	protected int hue1;
	@XmlElement(name = "Hue2")
	protected int hue2;
	@XmlElement(name = "Hue3")
	protected int hue3;
	@XmlElement(name = "Hue4")
	protected int hue4;
	@XmlElement(name = "Layer")
	protected int layer;
	@XmlElement(name = "Mir")
	protected String mir;
	@XmlElement(name = "Rot")
	protected int rot;
	@XmlElement(name = "Sat1")
	protected int sat1;
	@XmlElement(name = "Sat2")
	protected int sat2;
	@XmlElement(name = "Sat3")
	protected int sat3;
	@XmlElement(name = "Sat4")
	protected int sat4;
	@XmlElement(name = "ScaleX")
	protected int scaleX;
	@XmlElement(name = "ScaleY")
	protected int scaleY;
	@XmlElement(name = "Shear")
	protected int shear;
	@XmlElement(name = "TranX")
	protected int tranX;
	@XmlElement(name = "TranY")
	protected int tranY;
	@XmlElement(name = "Var1")
	protected int var1;
	@XmlElement(name = "Var2")
	protected int var2;
	@XmlElement(name = "Var3")
	protected int var3;
	@XmlElement(name = "Var4")
	protected int var4;

	public int getHash() {
		return hash;
	}

	public void setHash(int value) {
		this.hash = value;
	}

	public int getHue1() {
		return hue1;
	}

	public void setHue1(int value) {
		this.hue1 = value;
	}

	public int getHue2() {
		return hue2;
	}

	public void setHue2(int value) {
		this.hue2 = value;
	}

	public int getHue3() {
		return hue3;
	}

	public void setHue3(int value) {
		this.hue3 = value;
	}

	public int getHue4() {
		return hue4;
	}

	public void setHue4(int value) {
		this.hue4 = value;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int value) {
		this.layer = value;
	}

	public String getMir() {
		return mir;
	}

	public void setMir(String value) {
		this.mir = value;
	}

	public int getRot() {
		return rot;
	}

	public void setRot(int value) {
		this.rot = value;
	}

	public int getSat1() {
		return sat1;
	}

	public void setSat1(int value) {
		this.sat1 = value;
	}

	public int getSat2() {
		return sat2;
	}

	public void setSat2(int value) {
		this.sat2 = value;
	}

	public int getSat3() {
		return sat3;
	}

	public void setSat3(int value) {
		this.sat3 = value;
	}

	public int getSat4() {
		return sat4;
	}

	public void setSat4(int value) {
		this.sat4 = value;
	}

	public int getScaleX() {
		return scaleX;
	}

	public void setScaleX(int value) {
		this.scaleX = value;
	}

	public int getScaleY() {
		return scaleY;
	}

	public void setScaleY(int value) {
		this.scaleY = value;
	}

	public int getShear() {
		return shear;
	}

	public void setShear(int value) {
		this.shear = value;
	}

	public int getTranX() {
		return tranX;
	}

	public void setTranX(int value) {
		this.tranX = value;
	}

	public int getTranY() {
		return tranY;
	}

	public void setTranY(int value) {
		this.tranY = value;
	}

	public int getVar1() {
		return var1;
	}

	public void setVar1(int value) {
		this.var1 = value;
	}

	public int getVar2() {
		return var2;
	}

	public void setVar2(int value) {
		this.var2 = value;
	}

	public int getVar3() {
		return var3;
	}

	public void setVar3(int value) {
		this.var3 = value;
	}

	public int getVar4() {
		return var4;
	}

	public void setVar4(int value) {
		this.var4 = value;
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
