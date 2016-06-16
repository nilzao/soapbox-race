package br.com.soapboxrace.xmpp.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteEntrantResultTypeXmpp", propOrder = { "eventDurationInMilliseconds", "eventSessionId", "finishReason",
		"personaId", "ranking", "bestLapDurationInMilliseconds", "topSpeed" })
@XmlRootElement(name = "RouteEntrantResult")
public class RouteEntrantResultTypeXmpp {
	@XmlElement(name = "EventDurationInMilliseconds")
	protected long eventDurationInMilliseconds;
	@XmlElement(name = "EventSessionId")
	protected long eventSessionId;
	@XmlElement(name = "FinishReason")
	protected int finishReason;
	@XmlElement(name = "PersonaId")
	protected long personaId;
	@XmlElement(name = "Ranking")
	protected int ranking;
	@XmlElement(name = "BestLapDurationInMilliseconds")
	protected long bestLapDurationInMilliseconds;
	@XmlElement(name = "TopSpeed")
	protected float topSpeed;

	public long getEventDurationInMilliseconds() {
		return eventDurationInMilliseconds;
	}

	public void setEventDurationInMilliseconds(long eventDurationInMilliseconds) {
		this.eventDurationInMilliseconds = eventDurationInMilliseconds;
	}

	public long getEventSessionId() {
		return eventSessionId;
	}

	public void setEventSessionId(long eventSessionId) {
		this.eventSessionId = eventSessionId;
	}

	public int getFinishReason() {
		return finishReason;
	}

	public void setFinishReason(int finishReason) {
		this.finishReason = finishReason;
	}

	public long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(long personaId) {
		this.personaId = personaId;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public long getBestLapDurationInMilliseconds() {
		return bestLapDurationInMilliseconds;
	}

	public void setBestLapDurationInMilliseconds(long bestLapDurationInMilliseconds) {
		this.bestLapDurationInMilliseconds = bestLapDurationInMilliseconds;
	}

	public float getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(float topSpeed) {
		this.topSpeed = topSpeed;
	}

}