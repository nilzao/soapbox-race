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
	protected int eventId;
	@XmlElement(name = "IsInviteEnabled", required = true)
	protected boolean isInviteEnabled = false;
	@XmlElement(name = "LobbyId")
	protected int lobbyId = 12345678;
	@XmlElement(name = "LobbyInviteId")
	protected int lobbyInviteId = 12345678;

	public CountdownType getCountdown() {
		return countdown;
	}

	public void setCountdown(CountdownType value) {
		this.countdown = value;
	}

	public EntrantsType getEntrants() {
		return entrants;
	}

	public void setEntrants(EntrantsType value) {
		this.entrants = value;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int value) {
		this.eventId = value;
	}

	public boolean isInviteEnabled() {
		return isInviteEnabled;
	}

	public void setInviteEnabled(boolean isInviteEnabled) {
		this.isInviteEnabled = isInviteEnabled;
	}

	public int getLobbyId() {
		return lobbyId;
	}

	public void setLobbyId(int value) {
		this.lobbyId = value;
	}

	public int getLobbyInviteId() {
		return lobbyInviteId;
	}

	public void setLobbyInviteId(int value) {
		this.lobbyInviteId = value;
	}

}
