package br.com.soapboxrace.xmpp;

import java.util.HashMap;

public class XmppChatLobbys {

	private static HashMap<Long, XmppChatLobby> xmppChatLobbys = new HashMap<Long, XmppChatLobby>();

	public XmppChatLobby get(Long sessionId) {
		return xmppChatLobbys.get(sessionId);
	}

	public static XmppChatLobby getChatLobby(Long sessionId) {
		if (xmppChatLobbys.containsKey(sessionId)) {
			return xmppChatLobbys.get(sessionId);
		}
		XmppChatLobby xmppChatLobby = new XmppChatLobby(sessionId);
		xmppChatLobbys.put(sessionId, xmppChatLobby);
		return xmppChatLobby;
	}

}
