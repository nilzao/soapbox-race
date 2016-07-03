package br.com.soapboxrace.jaxb;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteEntrantResultType", propOrder = { "eventDurationInMilliseconds", "eventSessionId", "finishReason",
		"personaId", "ranking", "bestLapDurationInMilliseconds", "topSpeed" })
public class RouteEntrantResultType implements Serializable {
	private static final long serialVersionUID = 431841959208132804L;
	
	@XmlElement(name = "EventDurationInMilliseconds", required = true)
	private Long eventDurationInMilliseconds;
	@XmlElement(name = "EventSessionId", required = true)
	private Long eventSessionId;
	@XmlElement(name = "FinishReason", required = true)
	private Integer finishReason;
	@XmlElement(name = "PersonaId", required = true)
	private Long personaId;
	@XmlElement(name = "Ranking", required = true)
	private Short ranking;
	@XmlElement(name = "BestLapDurationInMilliseconds", required = true)
	private Long bestLapDurationInMilliseconds;
	@XmlElement(name = "TopSpeed", required = true)
	private Float topSpeed;

	public Long getEventDurationInMilliseconds() {
		return eventDurationInMilliseconds;
	}

	public void setEventDurationInMilliseconds(Long eventDurationInMilliseconds) {
		this.eventDurationInMilliseconds = eventDurationInMilliseconds;
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

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public Short getRanking() {
		return ranking;
	}

	public void setRanking(Short ranking) {
		this.ranking = ranking;
	}

	public Long getBestLapDurationInMilliseconds() {
		return bestLapDurationInMilliseconds;
	}

	public void setBestLapDurationInMilliseconds(Long bestLapDurationInMilliseconds) {
		this.bestLapDurationInMilliseconds = bestLapDurationInMilliseconds;
	}

	public Float getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(Float topSpeed) {
		this.topSpeed = topSpeed;
	}
}