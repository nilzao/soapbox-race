package br.com.soapboxrace.xmpp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class XmppFreeroamLobby {

	private HashMap<Long, XmppTalk> xmppFreeroamLobby = new HashMap<Long, XmppTalk>();

	private String channelName;
	private Integer channelNumber;

	public XmppFreeroamLobby(String channelName, Integer channelNumber) {
		this.channelName = channelName;
		this.channelNumber = channelNumber;
	}

	public void addXmppTalk(XmppTalk xmppTalk) {
		Long personaId = xmppTalk.getPersonaId();
		xmppFreeroamLobby.put(personaId, xmppTalk);
	}

	public void removeXmppTalk(Long personaId) {
		if (xmppFreeroamLobby.containsKey(personaId))
			xmppFreeroamLobby.remove(personaId);
	}

	public void broadcast(XmppChat xmppChat) {
		Long hostPersonaId = xmppChat.getPersonaId();
		Iterator<Entry<Long, XmppTalk>> iterator = xmppFreeroamLobby.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Long, XmppTalk> next = iterator.next();
			Long key = next.getKey();
			if (!key.equals(hostPersonaId)) {
				XmppTalk xmppTalk = next.getValue();
				xmppTalk.write(xmppChat.getFreeroamMessage(hostPersonaId, key, channelName, channelNumber));
			}
		}
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getChannelNumber() {
		return channelNumber;
	}

	public void setChannelNumber(Integer channelNumber) {
		this.channelNumber = channelNumber;
	}

}