package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TeamEscapeEventResultType", propOrder = { "accolades", "durability", "eventId", "eventSessionId",
		"exitPath", "inviteLifetimeInMilliseconds", "lobbyInviteId", "personaId", "entrants" })
@XmlRootElement(name = "TeamEscapeEventResult")
public class TeamEscapeEventResultType {
	@XmlElement(name = "Accolades", required = true, nillable = true)
	private AccoladesType accolades;
	@XmlElement(name = "Durability", required = true)
	private Short durability;
	@XmlElement(name = "EventId", required = true)
	private Long eventId;
	@XmlElement(name = "EventSessionId", required = true)
	private Long eventSessionId;
	@XmlElement(name = "ExitPath", defaultValue = "ExitToFreeroam", required = true)
	private String exitPath = "ExitToFreeroam";
	@XmlElement(name = "InviteLifetimeInMilliseconds", defaultValue = "0", required = true)
	private Long inviteLifetimeInMilliseconds = 0L;
	@XmlElement(name = "LobbyInviteId", defaultValue = "0", required = true)
	private Long lobbyInviteId = 0L;
	@XmlElement(name = "PersonaId", defaultValue = "0", required = true)
	private Long personaId = 0L;
	@XmlElement(name = "TeamEscapeEntrantResult", type = TeamEscapeEntrantResultType.class)
	@XmlElementWrapper(name = "Entrants")
	private List<TeamEscapeEntrantResultType> entrants;

	public AccoladesType getAccolades() {
		return accolades;
	}

	public void setAccolades(AccoladesType accolades) {
		this.accolades = accolades;
	}

	public Short getDurability() {
		return durability;
	}

	public void setDurability(Short durability) {
		this.durability = durability;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getEventSessionId() {
		return eventSessionId;
	}

	public void setEventSessionId(Long eventSessionId) {
		this.eventSessionId = eventSessionId;
	}

	public String getExitPath() {
		return exitPath;
	}

	public void setExitPath(String exitPath) {
		this.exitPath = exitPath;
	}

	public Long getInviteLifetimeInMilliseconds() {
		return inviteLifetimeInMilliseconds;
	}

	public void setInviteLifetimeInMilliseconds(Long inviteLifetimeInMilliseconds) {
		this.inviteLifetimeInMilliseconds = inviteLifetimeInMilliseconds;
	}

	public Long getLobbyInviteId() {
		return lobbyInviteId;
	}

	public void setLobbyInviteId(Long lobbyInviteId) {
		this.lobbyInviteId = lobbyInviteId;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public List<TeamEscapeEntrantResultType> getEntrants() {
		return entrants;
	}

	public void setEntrants(List<TeamEscapeEntrantResultType> entrants) {
		this.entrants = entrants;
	}
}