package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LobbyInfoType", propOrder = { "countdown", "entrants", "eventId", "isInviteEnabled", "lobbyId",
		"lobbyInviteId" })
@XmlRootElement(name = "LobbyInfo")
public class LobbyInfoType {

	@XmlElement(name = "Countdown", required = true)
	protected CountdownType countdown;
	@XmlElement(name = "Entrants", required = true)
	protected EntrantsType entrants;
	@XmlElement(name = "EventId")
	protected long eventId;
	@XmlElement(name = "IsInviteEnabled", required = true)
	protected boolean isInviteEnabled = false;
	@XmlElement(name = "LobbyId")
	protected long lobbyId;
	@XmlElement(name = "LobbyInviteId")
	protected long lobbyInviteId;

	public CountdownType getCountdown() {
		return countdown;
	}

	public void setCountdown(CountdownType countdown) {
		this.countdown = countdown;
	}

	public EntrantsType getEntrants() {
		return entrants;
	}

	public void setEntrants(EntrantsType entrants) {
		this.entrants = entrants;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public boolean isInviteEnabled() {
		return isInviteEnabled;
	}

	public void setInviteEnabled(boolean isInviteEnabled) {
		this.isInviteEnabled = isInviteEnabled;
	}

	public long getLobbyId() {
		return lobbyId;
	}

	public void setLobbyId(long lobbyId) {
		this.lobbyId = lobbyId;
	}

	public long getLobbyInviteId() {
		return lobbyInviteId;
	}

	public void setLobbyInviteId(long lobbyInviteId) {
		this.lobbyInviteId = lobbyInviteId;
	}

}
