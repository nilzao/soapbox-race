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
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "EVENTDATA")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventDataEntity implements ISoapBoxEntity {
	private static final long serialVersionUID = -8082866443107431905L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "carId")
	private Long carId;
	@Column(name = "eventDurationInMS")
	private Long eventDurationInMS;
	@Column(name = "eventId", nullable = false)
	private Long eventId;
	@Column(name = "eventLaunched")
	private Boolean eventLaunched;
	@Column(name = "eventMode")
	private Integer eventModeId;
	@Column(name = "eventSessionId", nullable = false)
	private Long eventSessionId;
	@Column(name = "finishReason")
	private Integer finishReason;
	@Column(name = "isSinglePlayer")
	private Boolean isSinglePlayer;
	@Column(name = "perfectStart")
	private Boolean perfectStart;
	@Column(name = "personaId", nullable = false)
	private Long personaId;
	@Column(name = "rank")
	private Short rank;
	@Column(name = "topSpeed")
	private Float topSpeed;

	// circuit
	@Column(name = "bestLapTimeInMS")
	private Long bestLapTimeInMS;

	// team escape
	@Column(name = "bustedCount")
	private Integer bustedCount;
	@Column(name = "copsDeployed")
	private Integer copsDeployed;
	@Column(name = "copsDisabled")
	private Integer copsDisabled;
	@Column(name = "copsRammed")
	private Integer copsRammed;
	@Column(name = "costToState")
	private Integer costToState;
	@Column(name = "distanceToFinish")
	private Float distanceToFinish;
	@Column(name = "fractionCompleted")
	private Float fractionCompleted;
	@Column(name = "infractions")
	private Integer infractions;
	@Column(name = "roadBlocksDodged")
	private Integer roadBlocksDodged;
	@Column(name = "spikeStripsDodged")
	private Integer spikeStripsDodged;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "eventId", referencedColumnName = "eventId", insertable = false, updatable = false)
	private EventDefinitionEntity eventDefinition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Long getEventDurationInMS() {
		return eventDurationInMS;
	}

	public void setEventDurationInMS(Long eventDurationInMS) {
		this.eventDurationInMS = eventDurationInMS;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Boolean getEventLaunched() {
		return eventLaunched;
	}

	public void setEventLaunched(Boolean eventLaunched) {
		this.eventLaunched = eventLaunched;
	}

	public Integer getEventModeId() {
		return eventModeId;
	}

	public void setEventModeId(Integer eventModeId) {
		this.eventModeId = eventModeId;
	}

	public Long getEventSessionId() {
		return eventSessionId;
	}

	public void setEventSessionId(Long eventSessionId) {
		this.eventSessionId = eventSessionId;
	}

	public Integer getFinishReason() {
		return finishReason;
	}

	public void setFinishReason(Integer finishReason) {
		this.finishReason = finishReason;
	}

	public Boolean getIsSinglePlayer() {
		return isSinglePlayer;
	}

	public void setIsSinglePlayer(Boolean isSinglePlayer) {
		this.isSinglePlayer = isSinglePlayer;
	}

	public Boolean getPerfectStart() {
		return perfectStart;
	}

	public void setPerfectStart(Boolean perfectStart) {
		this.perfectStart = perfectStart;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public Short getRank() {
		return rank;
	}

	public void setRank(Short rank) {
		this.rank = rank;
	}

	public Float getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(Float topSpeed) {
		this.topSpeed = topSpeed;
	}

	public Long getBestLapTimeInMS() {
		return bestLapTimeInMS;
	}

	public void setBestLapTimeInMS(Long bestLapTimeInMS) {
		this.bestLapTimeInMS = bestLapTimeInMS;
	}

	public Integer getBustedCount() {
		return bustedCount;
	}

	public void setBustedCount(Integer bustedCount) {
		this.bustedCount = bustedCount;
	}

	public Integer getCopsDeployed() {
		return copsDeployed;
	}

	public void setCopsDeployed(Integer copsDeployed) {
		this.copsDeployed = copsDeployed;
	}

	public Integer getCopsDisabled() {
		return copsDisabled;
	}

	public void setCopsDisabled(Integer copsDisabled) {
		this.copsDisabled = copsDisabled;
	}

	public Integer getCopsRammed() {
		return copsRammed;
	}

	public void setCopsRammed(Integer copsRammed) {
		this.copsRammed = copsRammed;
	}

	public Integer getCostToState() {
		return costToState;
	}

	public void setCostToState(Integer costToState) {
		this.costToState = costToState;
	}

	public Float getDistanceToFinish() {
		return distanceToFinish;
	}

	public void setDistanceToFinish(Float distanceToFinish) {
		this.distanceToFinish = distanceToFinish;
	}

	public Float getFractionCompleted() {
		return fractionCompleted;
	}

	public void setFractionCompleted(Float fractionCompleted) {
		this.fractionCompleted = fractionCompleted;
	}

	public Integer getInfractions() {
		return infractions;
	}

	public void setInfractions(Integer infractions) {
		this.infractions = infractions;
	}

	public Integer getRoadBlocksDodged() {
		return roadBlocksDodged;
	}

	public void setRoadBlocksDodged(Integer roadBlocksDodged) {
		this.roadBlocksDodged = roadBlocksDodged;
	}

	public Integer getSpikeStripsDodged() {
		return spikeStripsDodged;
	}

	public void setSpikeStripsDodged(Integer spikeStripsDodged) {
		this.spikeStripsDodged = spikeStripsDodged;
	}

	public EventDefinitionEntity getEventDefinition() {
		return eventDefinition;
	}

	public void setEventDefinition(EventDefinitionEntity eventDefinition) {
		this.eventDefinition = eventDefinition;
	}
}