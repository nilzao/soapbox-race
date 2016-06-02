package br.com.soapboxrace.xmpp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class XmppEventLobby {

	private HashMap<Long, XmppTalk> xmppEventChats = new HashMap<Long, XmppTalk>();

	private Long sessionId;

	public XmppEventLobby(Long sessionId) {
		this.sessionId = sessionId;
	}

	public void addXmppTalk(XmppTalk xmppTalk) {
		Long personaId = xmppTalk.getPersonaId();
		xmppEventChats.put(personaId, xmppTalk);
	}

	public void broadcast(XmppChat xmppChat) {
		Long hostPersonaId = xmppChat.getPersonaId();
		Iterator<Entry<Long, XmppTalk>> iterator = xmppEventChats.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Long, XmppTalk> next = iterator.next();
			Long key = next.getKey();
			if (!key.equals(hostPersonaId)) {
				XmppTalk xmppTalk = next.getValue();
				xmppTalk.write(xmppChat.getEventMessage(xmppTalk.getPersonaId()));
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