package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomCarType", propOrder = { "baseCarId", "carClassHash", "isPreset", "level", "name", "id", "paints",
		"performanceParts", "physicsProfileHash", "rating", "resalePrice", "rideHeightDrop", "skillModParts",
		"skillModSlotCount", "version", "vinyls", "visualParts" })
@XmlRootElement(name = "CustomCar")
public class CustomCarType {
	@XmlElement(name = "BaseCar", required = true)
	protected long baseCarId;
	@XmlElement(name = "CarClassHash")
	protected int carClassHash;
	@XmlElement(name = "IsPreset")
	protected boolean isPreset;
	@XmlElement(name = "Level")
	protected int level;
	@XmlElement(name = "Name")
	protected String name;
	@XmlElement(name = "Id", required = true)
	protected long id;
	@XmlElement(name = "Paints")
	protected PaintsType paints;
	@XmlElement(name = "PerformanceParts")
	protected PerformancePartsType performanceParts;
	@XmlElement(name = "PhysicsProfileHash")
	protected long physicsProfileHash;
	@XmlElement(name = "Rating")
	protected int rating;
	@XmlElement(name = "ResalePrice")
	protected int resalePrice;
	@XmlElement(name = "RideHeightDrop")
	protected int rideHeightDrop = 0;
	@XmlElement(name = "SkillModParts")
	protected SkillModPartsType skillModParts;
	@XmlElement(name = "SkillModSlotCount")
	protected Short skillModSlotCount;
	@XmlElement(name = "Version")
	protected int version = 0;
	@XmlElement(name = "Vinyls")
	protected VinylsType vinyls;
	@XmlElement(name = "VisualParts")
	protected VisualPartsType visualParts;

	public void setBaseCarId(long value) {
		this.baseCarId = value;
	}

	public long getBaseCarId() {
		return this.baseCarId;
	}

	public void setCarClassHash(int value) {
		this.carClassHash = value;
	}

	public int getCarClassHash() {
		return this.carClassHash;
	}

	public boolean getIsPreset() {
		return isPreset;
	}

	public void setPreset(boolean value) {
		this.isPreset = value;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int value) {
		this.level = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPaints(PaintsType value) {
		this.paints = value;
	}

	public PaintsType getPaints() {
		return this.paints;
	}

	public void setPerformanceParts(PerformancePartsType value) {
		this.performanceParts = value;
	}

	public PerformancePartsType getPerformanceParts() {
		return this.performanceParts;
	}

	public void setPhysicsProfileHash(long value) {
		this.physicsProfileHash = value;
	}

	public long getPhysicsProfileHash() {
		return this.physicsProfileHash;
	}

	public void setRating(int value) {
		this.rating = value;
	}

	public int getRating() {
		return this.rating;
	}

	public void setResalePrice(int value) {
		this.resalePrice = value;
	}

	public int getResalePrice() {
		return this.resalePrice;
	}

	public void setSkillModParts(SkillModPartsType value) {
		this.skillModParts = value;
	}

	public SkillModPartsType getSkillModParts() {
		return this.skillModParts;
	}

	public Short getSkillModSlotCount() {
		return skillModSlotCount;
	}

	public void setSkillModSlotCount(Short skillModSlotCount) {
		this.skillModSlotCount = skillModSlotCount;
	}

	public void setVinyls(VinylsType value) {
		this.vinyls = value;
	}

	public VinylsType getVinyls() {
		return this.vinyls;
	}

	public void setVisualParts(VisualPartsType value) {
		this.visualParts = value;
	}

	public VisualPartsType getVisualParts() {
		return this.visualParts;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRideHeightDrop() {
		return rideHeightDrop;
	}

	public void setRideHeightDrop(int rideHeightDrop) {
		this.rideHeightDrop = rideHeightDrop;
	}

}