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

	private static final long serialVersionUID = -261637507273450837L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventSessionId", nullable = false)
	private Long id;

	@Column(name = "eventId")
	private Long eventId;
	@Column(name = "eventLaunched")
	private Boolean eventLaunched;
	@Column(name = "personaId")
	private Long personaId;
	@Column(name = "carId")
	private Long carId;
	@Column(name = "finishReason")
	private Integer finishReason;
	@Column(name = "rank")
	private Short rank;
	@Column(name = "eventDurationInMS")
	private Long eventDurationInMS;
	@Column(name = "bestLapTimeInMS")
	private Long bestLapTimeInMS;
	@Column(name = "topSpeed")
	private Integer topSpeed;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "eventId", referencedColumnName = "eventId")
	private EventDefinitionEntity eventDefinition;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
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

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Integer getFinishReason() {
		return finishReason;
	}

	public void setFinishReason(Integer finishReason) {
		this.finishReason = finishReason;
	}

	public Short getRank() {
		return rank;
	}

	public void setRank(Short rank) {
		this.rank = rank;
	}

	public Long getEventDurationInMS() {
		return eventDurationInMS;
	}

	public void setEventDurationInMS(Long eventDurationInMS) {
		this.eventDurationInMS = eventDurationInMS;
	}

	public Long getBestLapTimeInMS() {
		return bestLapTimeInMS;
	}

	public void setBestLapTimeInMS(Long bestLapTimeInMS) {
		this.bestLapTimeInMS = bestLapTimeInMS;
	}

	public Integer getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(Integer topSpeed) {
		this.topSpeed = topSpeed;
	}

	public EventDefinitionEntity getEventDefinition() {
		return eventDefinition;
	}

	public void setEventDefinition(EventDefinitionEntity eventDefinition) {
		this.eventDefinition = eventDefinition;
	}
}