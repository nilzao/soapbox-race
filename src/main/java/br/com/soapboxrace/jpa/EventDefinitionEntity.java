package br.com.soapboxrace.jpa;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jaxb.EngagePointType;
import br.com.soapboxrace.jaxb.RewardModesType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventDefinitionType", propOrder = { "carClassHash", "coins", "engagePoint", "id",
		"eventLocalization", "eventModeDescriptionLocalization", "eventModeIcon", "eventModeId",
		"eventModeLocalization", "isEnabled", "isLocked", "laps", "length", "maxClassRating", "maxEntrants", "maxLevel",
		"minClassRating", "minEntrants", "minLevel", "regionLocalization", "rewardModes", "timeLimit", "trackLayoutMap",
		"trackLocalization" })
@Entity
@Table(name = "EVENTDEFINITION")
public class EventDefinitionEntity implements ISoapBoxEntity {
	private static final long serialVersionUID = -1170162152186670454L;

	@Id
	@Column(name = "eventId")
	@XmlElement(name = "EventId")
	protected Long id;

	@XmlElement(name = "CarClassHash")
	protected int carClassHash;
	@XmlElement(name = "Coins")
	protected int coins;

	@XmlElement(name = "EngagePoint", required = true)
	@Transient
	protected EngagePointType engagePoint = new EngagePointType();

	@XmlTransient
	@Access(AccessType.PROPERTY)
	protected float engagePointX;
	@XmlTransient
	@Access(AccessType.PROPERTY)
	protected float engagePointY;
	@XmlTransient
	@Access(AccessType.PROPERTY)
	protected float engagePointZ;

	@XmlElement(name = "EventLocalization")
	protected int eventLocalization;
	@XmlElement(name = "EventModeDescriptionLocalization")
	protected int eventModeDescriptionLocalization;
	@XmlElement(name = "EventModeIcon", required = true)
	protected String eventModeIcon;
	@XmlElement(name = "EventModeId")
	protected int eventModeId;
	@XmlElement(name = "EventModeLocalization")
	protected int eventModeLocalization;
	@XmlElement(name = "IsEnabled", required = true)
	protected String isEnabled;
	@XmlElement(name = "IsLocked", required = true)
	protected String isLocked;
	@XmlElement(name = "Laps")
	protected int laps;
	@XmlElement(name = "Length")
	protected int length;
	@XmlElement(name = "MaxClassRating")
	protected int maxClassRating;
	@XmlElement(name = "MaxEntrants")
	protected int maxEntrants;
	@XmlElement(name = "MaxLevel")
	protected int maxLevel;
	@XmlElement(name = "MinClassRating")
	protected int minClassRating;
	@XmlElement(name = "MinEntrants")
	protected int minEntrants;
	@XmlElement(name = "MinLevel")
	protected int minLevel;
	@XmlElement(name = "RegionLocalization")
	protected int regionLocalization;
	@XmlElement(name = "RewardModes", required = true)
	@Transient
	protected RewardModesType rewardModes = new RewardModesType();

	@XmlTransient
	@Access(AccessType.PROPERTY)
	protected int rewardMode1;
	@XmlTransient
	@Access(AccessType.PROPERTY)
	protected int rewardMode2;
	@XmlTransient
	@Access(AccessType.PROPERTY)
	protected int rewardMode3;

	@XmlElement(name = "TimeLimit")
	protected int timeLimit;
	@XmlElement(name = "TrackLayoutMap", required = true)
	protected String trackLayoutMap;
	@XmlElement(name = "TrackLocalization")
	protected int trackLocalization;

	@XmlTransient
	@OneToMany(mappedBy = "eventDefinition", targetEntity = EventDataEntity.class)
	protected List<EventDataEntity> eventResults;

	public int getCarClassHash() {
		return carClassHash;
	}

	public void setCarClassHash(int value) {
		this.carClassHash = value;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int value) {
		this.coins = value;
	}

	public EngagePointType getEngagePoint() {
		return engagePoint;
	}

	public void setEngagePoint(EngagePointType value) {
		this.engagePoint = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long eventId) {
		this.id = eventId;
	}

	public List<EventDataEntity> getEventResults() {
		return eventResults;
	}

	public void setEventResults(List<EventDataEntity> eventResults) {
		this.eventResults = eventResults;
	}

	public int getEventLocalization() {
		return eventLocalization;
	}

	public void setEventLocalization(int value) {
		this.eventLocalization = value;
	}

	public int getEventModeDescriptionLocalization() {
		return eventModeDescriptionLocalization;
	}

	public void setEventModeDescriptionLocalization(int value) {
		this.eventModeDescriptionLocalization = value;
	}

	public String getEventModeIcon() {
		return eventModeIcon;
	}

	public void setEventModeIcon(String value) {
		this.eventModeIcon = value;
	}

	public int getEventModeId() {
		return eventModeId;
	}

	public void setEventModeId(int value) {
		this.eventModeId = value;
	}

	public int getEventModeLocalization() {
		return eventModeLocalization;
	}

	public void setEventModeLocalization(int value) {
		this.eventModeLocalization = value;
	}

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String value) {
		this.isEnabled = value;
	}

	public String getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(String value) {
		this.isLocked = value;
	}

	public int getLaps() {
		return laps;
	}

	public void setLaps(int value) {
		this.laps = value;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int value) {
		this.length = value;
	}

	public int getMaxClassRating() {
		return maxClassRating;
	}

	public void setMaxClassRating(int value) {
		this.maxClassRating = value;
	}

	public int getMaxEntrants() {
		return maxEntrants;
	}

	public void setMaxEntrants(int value) {
		this.maxEntrants = value;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int value) {
		this.maxLevel = value;
	}

	public int getMinClassRating() {
		return minClassRating;
	}

	public void setMinClassRating(int value) {
		this.minClassRating = value;
	}

	public int getMinEntrants() {
		return minEntrants;
	}

	public void setMinEntrants(int value) {
		this.minEntrants = value;
	}

	public int getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(int value) {
		this.minLevel = value;
	}

	public int getRegionLocalization() {
		return regionLocalization;
	}

	public void setRegionLocalization(int value) {
		this.regionLocalization = value;
	}

	public RewardModesType getRewardModes() {
		return rewardModes;
	}

	public void setRewardModes(RewardModesType value) {
		this.rewardModes = value;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int value) {
		this.timeLimit = value;
	}

	public String getTrackLayoutMap() {
		return trackLayoutMap;
	}

	public void setTrackLayoutMap(String value) {
		this.trackLayoutMap = value;
	}

	public int getTrackLocalization() {
		return trackLocalization;
	}

	public void setTrackLocalization(int value) {
		this.trackLocalization = value;
	}

	public float getEngagePointX() {
		return engagePoint.getX();
	}

	public void setEngagePointX(float engagePointX) {
		engagePoint.setX(engagePointX);
		this.engagePointX = engagePointX;
	}

	public float getEngagePointY() {
		return engagePoint.getY();
	}

	public void setEngagePointY(float engagePointY) {
		engagePoint.setY(engagePointY);
		this.engagePointY = engagePointY;
	}

	public float getEngagePointZ() {
		return engagePoint.getZ();
	}

	public void setEngagePointZ(float engagePointZ) {
		engagePoint.setZ(engagePointZ);
		this.engagePointZ = engagePointZ;
	}

	public int getRewardMode1() {
		List<Integer> int1 = rewardModes.getInt();
		if (int1.size() > 0) {
			return int1.get(0);
		}
		return rewardMode1;
	}

	public void setRewardMode1(int rewardMode1) {
		List<Integer> int1 = rewardModes.getInt();
		if (int1.size() > 0) {
			int1.set(0, rewardMode1);
		}
		this.rewardMode1 = rewardMode1;
	}

	public int getRewardMode2() {
		List<Integer> int1 = rewardModes.getInt();
		if (int1.size() > 1) {
			return int1.get(1);
		}
		return rewardMode2;
	}

	public void setRewardMode2(int rewardMode2) {
		List<Integer> int1 = rewardModes.getInt();
		if (int1.size() > 1) {
			int1.set(1, rewardMode2);
		}
		this.rewardMode2 = rewardMode2;
	}

	public int getRewardMode3() {
		List<Integer> int1 = rewardModes.getInt();
		if (int1.size() > 2) {
			return int1.get(2);
		}
		return rewardMode3;
	}

	public void setRewardMode3(int rewardMode3) {
		List<Integer> int1 = rewardModes.getInt();
		if (int1.size() > 2) {
			int1.set(2, rewardMode3);
		}
		this.rewardMode3 = rewardMode3;
	}

}
