package br.com.soapboxrace.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jaxb.CustomCarType;
import br.com.soapboxrace.jaxb.PaintsType;
import br.com.soapboxrace.jaxb.PerformancePartsType;
import br.com.soapboxrace.jaxb.SkillModPartsType;
import br.com.soapboxrace.jaxb.VinylsType;
import br.com.soapboxrace.jaxb.VisualPartsType;
import br.com.soapboxrace.jaxb.convert.PaintsConverter;
import br.com.soapboxrace.jaxb.convert.PerformancePartsConverter;
import br.com.soapboxrace.jaxb.convert.SkillModPartsConverter;
import br.com.soapboxrace.jaxb.convert.VinylsConverter;
import br.com.soapboxrace.jaxb.convert.VisualPartsConverter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomCarType", propOrder = { "baseCarId", "carClassHash", "isPreset", "level", "name", "apiId", "paints", "performanceParts",
		"physicsProfileHash", "rating", "resalePrice", "skillModParts", "skillModSlotCount", "vinyls", "visualParts" })
@Entity
@Table(name = "CUSTOMCAR")
@XmlRootElement(name = "CustomCar")
public class CustomCarEntity implements ISoapBoxEntity {

	private static final long serialVersionUID = -5031050484246275477L;

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
	protected long apiId;
	@Convert(converter = PaintsConverter.class)
	@XmlElement(name = "Paints")
	@Column(length = 20000)
	protected PaintsType paints;
	@Convert(converter = PerformancePartsConverter.class)
	@XmlElement(name = "PerformanceParts")
	@Column(length = 20000)
	protected PerformancePartsType performanceParts;
	@XmlElement(name = "PhysicsProfileHash")
	protected long physicsProfileHash;
	@XmlElement(name = "Rating")
	protected int rating;
	@XmlElement(name = "ResalePrice")
	protected int resalePrice;
	@Convert(converter = SkillModPartsConverter.class)
	@Column(length = 20000)
	@XmlElement(name = "SkillModParts")
	protected SkillModPartsType skillModParts;
	@XmlElement(name = "SkillModSlotCount")
	protected Short skillModSlotCount;
	@Convert(converter = VinylsConverter.class)
	@XmlElement(name = "Vinyls")
	@Column(length = 20000)
	protected VinylsType vinyls;
	@Convert(converter = VisualPartsConverter.class)
	@XmlElement(name = "VisualParts")
	@Column(length = 20000)
	protected VisualPartsType visualParts;

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;

	@XmlTransient
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE })
	@JoinColumn(name = "IdParentOwnedCarTrans", referencedColumnName = "UniqueCarId")
	private OwnedCarEntity parentOwnedCarTrans;

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

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public void setApiId(long value) {
		this.apiId = value;
	}

	public long getApiId() {
		return this.apiId;
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

	public OwnedCarEntity getParentOwnedCarTrans() {
		return this.parentOwnedCarTrans;
	}

	public void setParentOwnedCarTrans(OwnedCarEntity newParent) {
		this.parentOwnedCarTrans = newParent;
	}

	public CustomCarType getCustomCarType() {
		CustomCarType result = new CustomCarType();
		result.setApiId(this.getApiId());
		result.setBaseCarId(this.getBaseCarId());
		result.setCarClassHash(this.getCarClassHash());
		result.setPaints(this.getPaints());
		result.setPerformanceParts(this.getPerformanceParts());
		result.setPhysicsProfileHash(this.getPhysicsProfileHash());
		result.setRating(this.getRating());
		result.setResalePrice(this.getResalePrice());
		result.setSkillModParts(this.getSkillModParts());
		result.setSkillModSlotCount((short) 5);
		result.setVinyls(this.getVinyls());
		result.setVisualParts(this.getVisualParts());
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
