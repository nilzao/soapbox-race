package br.com.soapboxrace.xmpp;

import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.xmpp.jaxb.LobbyInviteType;
import br.com.soapboxrace.xmpp.jaxb.MessageType;
import br.com.soapboxrace.xmpp.jaxb.ResponseType;

public class XmppLobby {

	private int personaId;

	public XmppLobby(int personaId) {
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

	public void acceptInvite() {
		//
	}

}
