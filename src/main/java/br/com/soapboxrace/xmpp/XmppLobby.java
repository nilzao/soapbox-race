package br.com.soapboxrace.xmpp;

import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jpa.LobbyEntrantEntity;
import br.com.soapboxrace.xmpp.jaxb.LobbyInviteType;
import br.com.soapboxrace.xmpp.jaxb.MessageType;
import br.com.soapboxrace.xmpp.jaxb.ResponseType;
import br.com.soapboxrace.xmpp.jaxb.ResponseTypeEntrantAdd;

public class XmppLobby {

	private long personaId;

	public XmppLobby(long personaId) {
		this.personaId = personaId;
	}

	public void joinQueueEvent(LobbyInviteType lobbyInviteType) {
		ResponseType responseType = new ResponseType();
		responseType.setLobbyInvite(lobbyInviteType);
		MessageType messageType = new MessageType();
		messageType.setToPersonaId(personaId);
		messageType.setBody(responseType);
		String packet = MarshalXML.marshal(messageType);
		try {
			Thread.sleep(1000);
			XmppSrv.sendMsg(personaId, packet);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void sendJoinMsg(LobbyEntrantEntity lobbyEntrantEntity) {
		System.out.println("-------------------------------------");
		System.out.println(this.personaId);
		System.out.println(lobbyEntrantEntity.getPersona().getName());
		System.out.println(lobbyEntrantEntity.getLobby());
		System.out.println("-------------------------------------");
		lobbyEntrantEntity.setPersonaId(lobbyEntrantEntity.getPersona().getId().intValue());
		ResponseTypeEntrantAdd responseType = new ResponseTypeEntrantAdd();
		responseType.setLobbyInvite(lobbyEntrantEntity);
		MessageType messageType = new MessageType();
		messageType.setToPersonaId(personaId);
		messageType.setBody(responseType);
		String packet = MarshalXML.marshal(messageType);
		try {
			Thread.sleep(1000);
			XmppSrv.sendMsg(personaId, packet);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void acceptInvite() {
		//
	}

}
