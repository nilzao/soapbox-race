package br.com.soapboxrace.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jaxb.CustomPaintTransList;
import br.com.soapboxrace.jaxb.CustomVinylTransList;
import br.com.soapboxrace.jaxb.PerformancePartTransList;
import br.com.soapboxrace.jaxb.SkillModPartTransList;
import br.com.soapboxrace.jaxb.VisualPartTransList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomCarType", propOrder = { "baseCar", "carClassHash", "id", "isPreset", "level", "name",
		"customPaintTransList", "performancePartTransList", "physicsProfileHash", "rating", "resalePrice",
		"rideHeightDrop", "skillModPartTransList", "skillModSlotCount", "version", "customVinylTransList",
		"visualPartTransList" })
@Entity
@Table(name = "CUSTOMCAR")
public class CustomCarEntity implements Serializable {

	private static final long serialVersionUID = 716946554730878667L;

	@XmlElement(name = "BaseCar")
	protected int baseCar;
	@XmlElement(name = "CarClassHash")
	protected int carClassHash;

	@XmlElement(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;

	@XmlElement(name = "IsPreset", required = true)
	protected boolean isPreset;
	@XmlElement(name = "Level")
	protected int level;
	@XmlElement(name = "Name", required = true)
	protected String name;

	@Access(AccessType.PROPERTY)
	@OneToMany(mappedBy = "customCar", targetEntity = CustomPaintEntity.class, cascade = { CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REMOVE })
	@XmlTransient
	protected List<CustomPaintEntity> customPaintList;

	@Transient
	@XmlElement(name = "Paints", required = true)
	protected CustomPaintTransList customPaintTransList = new CustomPaintTransList();

	@XmlTransient
	@OneToMany(mappedBy = "customCar", targetEntity = PerformancePartEntity.class, cascade = { CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REMOVE })
	protected List<PerformancePartEntity> performancePartList;

	@Transient
	@XmlElement(name = "PerformanceParts", required = true)
	protected PerformancePartTransList performancePartTransList = new PerformancePartTransList();

	@XmlElement(name = "PhysicsProfileHash")
	protected int physicsProfileHash;
	@XmlElement(name = "Rating")
	protected int rating;
	@XmlElement(name = "ResalePrice")
	protected int resalePrice;
	@XmlElement(name = "RideHeightDrop")
	protected int rideHeightDrop;

	@XmlTransient
	@OneToMany(mappedBy = "customCar", targetEntity = SkillModPartEntity.class, cascade = { CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REMOVE })
	protected List<SkillModPartEntity> skillModPartList;

	@XmlElement(name = "SkillModParts", required = true)
	@Transient
	protected SkillModPartTransList skillModPartTransList = new SkillModPartTransList();

	@XmlElement(name = "SkillModSlotCount")
	protected int skillModSlotCount;
	@XmlElement(name = "Version", required = true)
	protected int version;

	@XmlTransient
	@OneToMany(mappedBy = "customCar", targetEntity = CustomVinylEntity.class, cascade = { CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REMOVE })
	protected List<CustomVinylEntity> customVinylList;

	@Transient
	@XmlElement(name = "Vinyls", required = true)
	protected CustomVinylTransList customVinylTransList = new CustomVinylTransList();

	@XmlTransient
	@OneToMany(mappedBy = "customCar", targetEntity = VisualPartEntity.class)
	protected List<VisualPartEntity> visualPartList;

	@Transient
	@XmlElement(name = "VisualParts")
	protected VisualPartTransList visualPartTransList = new VisualPartTransList();

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "IDOWNEDCAR", referencedColumnName = "ID")
	private OwnedCarEntity ownedCar;

	public int getBaseCar() {
		return baseCar;
	}

	public void setBaseCar(int value) {
		this.baseCar = value;
	}

	public int getCarClassHash() {
		return carClassHash;
	}

	public void setCarClassHash(int value) {
		this.carClassHash = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long value) {
		this.id = value;
	}

	public boolean isPreset() {
		return isPreset;
	}

	public void setPreset(boolean isPreset) {
		this.isPreset = isPreset;
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

	public int getPhysicsProfileHash() {
		return physicsProfileHash;
	}

	public void setPhysicsProfileHash(int value) {
		this.physicsProfileHash = value;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int value) {
		this.rating = value;
	}

	public int getResalePrice() {
		return resalePrice;
	}

	public void setResalePrice(int value) {
		this.resalePrice = value;
	}

	public int getRideHeightDrop() {
		return rideHeightDrop;
	}

	public void setRideHeightDrop(int value) {
		this.rideHeightDrop = value;
	}

	public int getSkillModSlotCount() {
		return skillModSlotCount;
	}

	public void setSkillModSlotCount(int value) {
		this.skillModSlotCount = value;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int value) {
		this.version = value;
	}

	public List<PerformancePartEntity> getPerformancePartList() {
		if (performancePartTransList.getPerformancePartList() != null) {
			return performancePartTransList.getPerformancePartList();
		}
		if (performancePartList == null) {
			performancePartList = new ArrayList<PerformancePartEntity>();
		}
		return performancePartList;
	}

	public void setPerformancePartList(List<PerformancePartEntity> performancePartList) {
		performancePartTransList.setPerformancePartList(performancePartList);
		this.performancePartList = performancePartList;
	}

	public List<SkillModPartEntity> getSkillModPartList() {
		if (skillModPartTransList.getSkillModPartList() != null) {
			return skillModPartTransList.getSkillModPartList();
		}
		if (skillModPartList == null) {
			skillModPartList = new ArrayList<SkillModPartEntity>();
		}
		return skillModPartList;
	}

	public void setSkillModPartList(List<SkillModPartEntity> skillModPartList) {
		skillModPartTransList.setSkillModPartList(skillModPartList);
		this.skillModPartList = skillModPartList;
	}

	public List<CustomVinylEntity> getCustomVinylList() {
		if (customVinylTransList.getCustomVinylList() != null) {
			return customVinylTransList.getCustomVinylList();
		}
		if (customVinylList == null) {
			customVinylList = new ArrayList<CustomVinylEntity>();
		}
		return customVinylList;
	}

	public void setCustomVinylList(List<CustomVinylEntity> customVinylList) {
		customVinylTransList.setCustomVinylList(customVinylList);
		this.customVinylList = customVinylList;
	}

	public List<VisualPartEntity> getVisualPartList() {
		if (visualPartTransList.getVisualPartList() != null) {
			return visualPartTransList.getVisualPartList();
		}
		if (visualPartList == null) {
			visualPartList = new ArrayList<VisualPartEntity>();
		}
		return visualPartList;
	}

	public void setVisualPartList(List<VisualPartEntity> visualPartList) {
		setVisualPartTransList(visualPartTransList);
		this.visualPartList = visualPartList;
	}

	public OwnedCarEntity getOwnedCar() {
		return ownedCar;
	}

	public void setOwnedCar(OwnedCarEntity ownedCar) {
		this.ownedCar = ownedCar;
	}

	public boolean add(CustomPaintEntity e) {
		if (customPaintList == null) {
			customPaintList = new ArrayList<CustomPaintEntity>();
		}
		boolean add = customPaintList.add(e);
		customPaintTransList.setCustomPaintList(customPaintList);
		return add;
	}

	public boolean add(PerformancePartEntity e) {
		if (performancePartList == null) {
			performancePartList = new ArrayList<PerformancePartEntity>();
		}
		boolean add = performancePartList.add(e);
		performancePartTransList.setPerformancePartList(performancePartList);
		return add;
	}

	public boolean add(SkillModPartEntity e) {
		if (skillModPartList == null) {
			skillModPartList = new ArrayList<SkillModPartEntity>();
		}
		boolean add = skillModPartList.add(e);
		skillModPartTransList.setSkillModPartList(skillModPartList);
		return add;
	}

	public boolean add(CustomVinylEntity e) {
		if (customVinylList == null) {
			customVinylList = new ArrayList<CustomVinylEntity>();
		}
		boolean add = customVinylList.add(e);
		customVinylTransList.setCustomVinylList(customVinylList);
		return add;
	}

	public boolean add(VisualPartEntity e) {
		if (visualPartList == null) {
			visualPartList = new ArrayList<VisualPartEntity>();
		}
		boolean add = visualPartList.add(e);
		visualPartTransList.setVisualPartList(visualPartList);
		return add;
	}

	public CustomPaintTransList getCustomPaintTransList() {
		return customPaintTransList;
	}

	public void setCustomPaintTransList(CustomPaintTransList customPaintTransList) {
		this.customPaintTransList = customPaintTransList;
	}

	public List<CustomPaintEntity> getCustomPaintList() {
		if (customPaintTransList.getCustomPaintList() != null) {
			return customPaintTransList.getCustomPaintList();
		}
		if (customPaintList == null) {
			customPaintList = new ArrayList<CustomPaintEntity>();
		}
		return customPaintList;
	}

	public void setCustomPaintList(List<CustomPaintEntity> customPaintList) {
		customPaintTransList.setCustomPaintList(customPaintList);
		this.customPaintList = customPaintList;
	}

	public PerformancePartTransList getPerformancePartTransList() {
		return performancePartTransList;
	}

	public void setPerformancePartTransList(PerformancePartTransList performancePartTransList) {
		this.performancePartTransList = performancePartTransList;
	}

	public SkillModPartTransList getSkillModPartTransList() {
		return skillModPartTransList;
	}

	public void setSkillModPartTransList(SkillModPartTransList skillModPartTransList) {
		this.skillModPartTransList = skillModPartTransList;
	}

	public CustomVinylTransList getCustomVinylTransList() {
		return customVinylTransList;
	}

	public void setCustomVinylTransList(CustomVinylTransList customVinylTransList) {
		this.customVinylTransList = customVinylTransList;
	}

	public VisualPartTransList getVisualPartTransList() {
		return visualPartTransList;
	}

	public void setVisualPartTransList(VisualPartTransList visualPartTransList) {
		this.visualPartTransList = visualPartTransList;
	}

}
