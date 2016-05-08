package br.com.soapboxrace.xmpp;

import java.util.List;

import br.com.soapboxrace.jaxb.LobbyEntrantInfoType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jpa.LobbyEntrantEntity;
import br.com.soapboxrace.xmpp.jaxb.CryptoTicketsType;
import br.com.soapboxrace.xmpp.jaxb.LobbyInviteType;
import br.com.soapboxrace.xmpp.jaxb.LobbyLaunchedType;
import br.com.soapboxrace.xmpp.jaxb.MessageType;
import br.com.soapboxrace.xmpp.jaxb.P2PCryptoTicketType;
import br.com.soapboxrace.xmpp.jaxb.ResponseType;
import br.com.soapboxrace.xmpp.jaxb.ResponseTypeEntrantAdd;
import br.com.soapboxrace.xmpp.jaxb.ResponseTypeLobbyLaunched;

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

	public static void sendRelay(LobbyLaunchedType lobbyLaunched, CryptoTicketsType cryptoTicketsType) {
		List<LobbyEntrantInfoType> lobbyEntrantInfo = lobbyLaunched.getEntrants().getLobbyEntrantInfo();
		for (LobbyEntrantInfoType lobbyEntrantInfoType : lobbyEntrantInfo) {
			long personaId = lobbyEntrantInfoType.getPersonaId();
			CryptoTicketsType cryptoTicketsTypeTmp = new CryptoTicketsType();
			List<P2PCryptoTicketType> p2pCryptoTicket = cryptoTicketsType.getP2PCryptoTicket();
			for (P2PCryptoTicketType p2pCryptoTicketType : p2pCryptoTicket) {
				if (personaId != p2pCryptoTicketType.getPersonaId()) {
					cryptoTicketsTypeTmp.getP2PCryptoTicket().add(p2pCryptoTicketType);
				}
			}
			lobbyLaunched.setCryptoTickets(cryptoTicketsTypeTmp);
			ResponseTypeLobbyLaunched responseType = new ResponseTypeLobbyLaunched();
			responseType.setLobbyInvite(lobbyLaunched);
			MessageType messageType = new MessageType();
			messageType.setToPersonaId(personaId);
			messageType.setBody(responseType);
			String packet = MarshalXML.marshal(messageType);
			XmppSrv.sendMsg(personaId, packet);
		}
	}

}
