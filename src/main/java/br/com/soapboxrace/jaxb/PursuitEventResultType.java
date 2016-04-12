package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PursuitEventResultType", propOrder = { "accolades", "durability", "eventId", "eventSessionId",
		"exitPath", "inviteLifetimeInMilliseconds", "lobbyInviteId", "personaId", "heat" })
@XmlRootElement(name = "PursuitEventResult")
public class PursuitEventResultType {

	@XmlElement(name = "Accolades", required = true)
	protected AccoladesType accolades;
	@XmlElement(name = "Durability")
	protected int durability;
	@XmlElement(name = "EventId")
	protected long eventId;
	@XmlElement(name = "EventSessionId")
	protected long eventSessionId;
	@XmlElement(name = "ExitPath", required = true)
	protected String exitPath;
	@XmlElement(name = "InviteLifetimeInMilliseconds")
	protected long inviteLifetimeInMilliseconds;
	@XmlElement(name = "LobbyInviteId")
	protected long lobbyInviteId;
	@XmlElement(name = "PersonaId")
	protected long personaId;
	@XmlElement(name = "Heat")
	protected int heat;

	public AccoladesType getAccolades() {
		return accolades;
	}

	public void setAccolades(AccoladesType accolades) {
		this.accolades = accolades;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public long getEventSessionId() {
		return eventSessionId;
	}

	public void setEventSessionId(long eventSessionId) {
		this.eventSessionId = eventSessionId;
	}

	public String getExitPath() {
		return exitPath;
	}

	public void setExitPath(String exitPath) {
		this.exitPath = exitPath;
	}

	public long getInviteLifetimeInMilliseconds() {
		return inviteLifetimeInMilliseconds;
	}

	public void setInviteLifetimeInMilliseconds(long inviteLifetimeInMilliseconds) {
		this.inviteLifetimeInMilliseconds = inviteLifetimeInMilliseconds;
	}

	public long getLobbyInviteId() {
		return lobbyInviteId;
	}

	public void setLobbyInviteId(long lobbyInviteId) {
		this.lobbyInviteId = lobbyInviteId;
	}

	public long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(long personaId) {
		this.personaId = personaId;
	}

	public int getHeat() {
		return heat;
	}

	public void setHeat(int heat) {
		this.heat = heat;
	}

}
