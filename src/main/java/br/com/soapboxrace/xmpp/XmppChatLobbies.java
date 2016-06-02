package br.com.soapboxrace.xmpp;

import java.util.HashMap;

public class XmppChatLobbies {

	private static HashMap<Long, XmppEventLobby> xmppEventLobbies = new HashMap<Long, XmppEventLobby>();
	private static HashMap<Long, XmppFreeroamLobby> xmppFreeroamLobbies = new HashMap<Long, XmppFreeroamLobby>();
	private static XmppSystemLobby xmppSystemLobby = new XmppSystemLobby();

	public static XmppEventLobby getEventLobby(Long sessionId) {
		if (xmppEventLobbies.containsKey(sessionId)) {
			return xmppEventLobbies.get(sessionId);
		}
		XmppEventLobby xmppEventChat = new XmppEventLobby(sessionId);
		xmppEventLobbies.put(sessionId, xmppEventChat);
		return xmppEventChat;
	}

	public static XmppFreeroamLobby getFreeroamLobby(String channelName, Integer channelNumber) {
		Long channelHash = Long.valueOf(channelName.hashCode() + channelNumber);
		
		if (xmppFreeroamLobbies.containsKey(channelHash)) 
			return xmppFreeroamLobbies.get(channelHash);

		XmppFreeroamLobby xmppFreeroamChat = new XmppFreeroamLobby(channelName, channelNumber);
		xmppFreeroamLobbies.put(channelHash, xmppFreeroamChat);
		return xmppFreeroamChat;
	}
	
	public static XmppSystemLobby getSystemLobby() {
		return xmppSystemLobby;
	}
}