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
	protected long eventId;
	@XmlElement(name = "IsWaiting", required = true)
	protected boolean isWaiting = false;
	@XmlElement(name = "LobbyCountdownInMilliseconds")
	protected long lobbyCountdownInMilliseconds = 60000;
	@XmlElement(name = "LobbyId")
	protected long lobbyId = 12345678;
	@XmlElement(name = "LobbyStuckDurationInMilliseconds")
	protected long lobbyStuckDurationInMilliseconds = 5000;

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public boolean isWaiting() {
		return isWaiting;
	}

	public void setWaiting(boolean isWaiting) {
		this.isWaiting = isWaiting;
	}

	public long getLobbyCountdownInMilliseconds() {
		return lobbyCountdownInMilliseconds;
	}

	public void setLobbyCountdownInMilliseconds(long lobbyCountdownInMilliseconds) {
		this.lobbyCountdownInMilliseconds = lobbyCountdownInMilliseconds;
	}

	public long getLobbyId() {
		return lobbyId;
	}

	public void setLobbyId(long lobbyId) {
		this.lobbyId = lobbyId;
	}

	public long getLobbyStuckDurationInMilliseconds() {
		return lobbyStuckDurationInMilliseconds;
	}

	public void setLobbyStuckDurationInMilliseconds(long lobbyStuckDurationInMilliseconds) {
		this.lobbyStuckDurationInMilliseconds = lobbyStuckDurationInMilliseconds;
	}

}
