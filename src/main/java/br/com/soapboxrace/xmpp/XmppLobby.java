package br.com.soapboxrace.xmpp;

import java.util.List;

import br.com.soapboxrace.engine.Session;
import br.com.soapboxrace.jaxb.LobbyEntrantInfoType;
import br.com.soapboxrace.jpa.LobbyEntrantEntity;
import br.com.soapboxrace.xmpp.jaxb.XMPP_CryptoTicketsType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_LobbyInviteType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_LobbyLaunchedType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_P2PCryptoTicketType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_ResponseTypeEntrantAdded;
import br.com.soapboxrace.xmpp.jaxb.XMPP_ResponseTypeLobbyInvite;
import br.com.soapboxrace.xmpp.jaxb.XMPP_ResponseTypeLobbyLaunched;

public class XmppLobby {

	private long personaId;

	public XmppLobby(long personaId) {
		this.personaId = personaId;
	}

	public void joinQueueEvent(XMPP_LobbyInviteType xMPP_LobbyInviteType) {
		XMPP_ResponseTypeLobbyInvite responseType = new XMPP_ResponseTypeLobbyInvite();
		responseType.setLobbyInvite(xMPP_LobbyInviteType);
		try {
			Thread.sleep(1000);
			IXmppSender xmppSenderInstance = XmppFactory.getXmppSenderInstance(Session.getXmppServerType());
			xmppSenderInstance.send(responseType, personaId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void sendJoinMsg(LobbyEntrantEntity lobbyEntrantEntity) {
		XMPP_ResponseTypeEntrantAdded responseType = new XMPP_ResponseTypeEntrantAdded();
		responseType.setLobbyInvite(lobbyEntrantEntity);
		try {
			Thread.sleep(1000);
			IXmppSender xmppSenderInstance = XmppFactory.getXmppSenderInstance(Session.getXmppServerType());
			xmppSenderInstance.send(responseType, personaId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void sendRelay(XMPP_LobbyLaunchedType lobbyLaunched, XMPP_CryptoTicketsType xMPP_CryptoTicketsType) {
		List<LobbyEntrantInfoType> lobbyEntrantInfo = lobbyLaunched.getEntrants().getLobbyEntrantInfo();
		for (LobbyEntrantInfoType lobbyEntrantInfoType : lobbyEntrantInfo) {
			long personaId = lobbyEntrantInfoType.getPersonaId();
			XMPP_CryptoTicketsType cryptoTicketsTypeTmp = new XMPP_CryptoTicketsType();
			List<XMPP_P2PCryptoTicketType> p2pCryptoTicket = xMPP_CryptoTicketsType.getP2PCryptoTicket();
			for (XMPP_P2PCryptoTicketType p2pCryptoTicketType : p2pCryptoTicket) {
				if (personaId != p2pCryptoTicketType.getPersonaId()) {
					cryptoTicketsTypeTmp.getP2PCryptoTicket().add(p2pCryptoTicketType);
				}
			}
			lobbyLaunched.setCryptoTickets(cryptoTicketsTypeTmp);
			XMPP_ResponseTypeLobbyLaunched responseType = new XMPP_ResponseTypeLobbyLaunched();
			responseType.setLobbyInvite(lobbyLaunched);
			IXmppSender xmppSenderInstance = XmppFactory.getXmppSenderInstance(Session.getXmppServerType());
			xmppSenderInstance.send(responseType, personaId);
		}
	}

}
