package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountdownType", propOrder = { "eventId", "isWaiting", "lobbyCountdownInMilliseconds", "lobbyId",
		"lobbyStuckDurationInMilliseconds" })
public class CountdownType {

	@XmlElement(name = "EventId")
	protected int eventId;
	@XmlElement(name = "IsWaiting", required = true)
	protected boolean isWaiting = false;
	@XmlElement(name = "LobbyCountdownInMilliseconds")
	protected int lobbyCountdownInMilliseconds = 10000;
	@XmlElement(name = "LobbyId")
	protected int lobbyId = 12345678;
	@XmlElement(name = "LobbyStuckDurationInMilliseconds")
	protected int lobbyStuckDurationInMilliseconds = 2000;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int value) {
		this.eventId = value;
	}

	public boolean isWaiting() {
		return isWaiting;
	}

	public void setWaiting(boolean isWaiting) {
		this.isWaiting = isWaiting;
	}

	public int getLobbyCountdownInMilliseconds() {
		return lobbyCountdownInMilliseconds;
	}

	public void setLobbyCountdownInMilliseconds(int value) {
		this.lobbyCountdownInMilliseconds = value;
	}

	public int getLobbyId() {
		return lobbyId;
	}

	public void setLobbyId(int value) {
		this.lobbyId = value;
	}

	public int getLobbyStuckDurationInMilliseconds() {
		return lobbyStuckDurationInMilliseconds;
	}

	public void setLobbyStuckDurationInMilliseconds(int value) {
		this.lobbyStuckDurationInMilliseconds = value;
	}

}
