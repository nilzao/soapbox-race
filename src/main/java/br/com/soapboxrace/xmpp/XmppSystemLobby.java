package br.com.soapboxrace.xmpp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class XmppSystemLobby {

	private HashMap<Long, XmppTalk> xmppSystemChat = new HashMap<Long, XmppTalk>();

	public void addXmppTalk(XmppTalk xmppTalk) {
		Long personaId = xmppTalk.getPersonaId();
		xmppSystemChat.put(personaId, xmppTalk);
	}

	public void removeXmppTalk(Long personaId) {
		if (xmppSystemChat.containsKey(personaId))
			xmppSystemChat.remove(personaId);
	}

	public void broadcast(String announcementText) {
		Iterator<Entry<Long, XmppTalk>> iterator = xmppSystemChat.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Long, XmppTalk> next = iterator.next();
			XmppTalk xmppTalk = next.getValue();
			xmppTalk.write(XmppChat.getSystemMessage(xmppTalk.getPersonaId(), announcementText));
		}
	}
}