package br.com.soapboxrace.xmpp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class XmppChatLobby {

	private HashMap<Integer, XmppTalk> xmppChatLobby = new HashMap<Integer, XmppTalk>();

	private Long sessionId;

	public XmppChatLobby(Long sessionId) {
		this.sessionId = sessionId;
	}

	public void addXmppTalk(XmppTalk xmppTalk) {
		int personaId = xmppTalk.getPersonaId();
		if (!xmppChatLobby.containsKey(personaId)) {
			xmppChatLobby.put(personaId, xmppTalk);
		}
	}

	public void broadcast(XmppChat xmppChat) {
		Iterator<Entry<Integer, XmppTalk>> iterator = xmppChatLobby.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, XmppTalk> next = iterator.next();
			Integer key = next.getKey();
			Integer personaId = (int) xmppChat.getPersonaId();
			if (!personaId.equals(key)) {
				XmppTalk xmppTalk = next.getValue();
				xmppTalk.write(xmppChat.getChatMsg(xmppTalk.getPersonaId()));
			}
		}
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

}
