package br.com.soapboxrace.xmpp.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LobbyInviteType", propOrder = { "eventId", "inviteLifetimeInMilliseconds", "invitedByPersonaId",
		"isPrivate", "lobbyInviteId" })
public class LobbyInviteType {

	@XmlElement(name = "EventId")
	protected int eventId;
	@XmlElement(name = "InviteLifetimeInMilliseconds")
	protected int inviteLifetimeInMilliseconds = 10000;
	@XmlElement(name = "InvitedByPersonaId")
	protected int invitedByPersonaId = 0;
	@XmlElement(name = "IsPrivate", required = true)
	protected boolean isPrivate = false;
	@XmlElement(name = "LobbyInviteId")
	protected int lobbyInviteId;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int value) {
		this.eventId = value;
	}

	public int getInviteLifetimeInMilliseconds() {
		return inviteLifetimeInMilliseconds;
	}

	public void setInviteLifetimeInMilliseconds(int value) {
		this.inviteLifetimeInMilliseconds = value;
	}

	public int getInvitedByPersonaId() {
		return invitedByPersonaId;
	}

	public void setInvitedByPersonaId(int value) {
		this.invitedByPersonaId = value;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public int getLobbyInviteId() {
		return lobbyInviteId;
	}

	public void setLobbyInviteId(int value) {
		this.lobbyInviteId = value;
	}

}
