package br.com.soapboxrace.xmpp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import br.com.soapboxrace.dao.PersonaDao;

public class XmppFreeroamLobby {

	private HashMap<Long, XmppTalk> xmppFreeroamLobby = new HashMap<Long, XmppTalk>();
	private PersonaDao personaDao = new PersonaDao();

	private String channelName;
	private Integer channelNumber;

	public XmppFreeroamLobby(String channelName, Integer channelNumber) {
		this.channelName = channelName;
		this.channelNumber = channelNumber;
	}

	public void addXmppTalk(XmppTalk hostXmppTalk) {
		Long personaId = hostXmppTalk.getPersonaId();

		hostXmppTalk.write(XmppChat.getSystemMessage(personaId,
				String.format("There are %d other players in this channel.", xmppFreeroamLobby.size())));

		String joinNoticeChannel = String.format("%s joined the channel.", personaDao.findById(personaId).getName());
		Iterator<Entry<Long, XmppTalk>> iterator = xmppFreeroamLobby.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Long, XmppTalk> next = iterator.next();
			XmppTalk xmppTalk = next.getValue();
			if (!xmppTalk.getPersonaId().equals(personaId))
				xmppTalk.write(XmppChat.getSystemMessage(xmppTalk.getPersonaId(), joinNoticeChannel));
		}

		xmppFreeroamLobby.put(personaId, hostXmppTalk);
	}

	public void removeXmppTalk(Long personaId) {
		if (xmppFreeroamLobby.containsKey(personaId)) {
			XmppTalk hostXmppTalk = xmppFreeroamLobby.get(personaId);

			String channelName = hostXmppTalk.getCurrentChannelName();
			Integer channelNumber = hostXmppTalk.getCurrentChannelNumber();

			String leftNotice = String.format("You left channel %s %d.", channelName, channelNumber);
			String leftNoticeChannel = String.format("%s left the channel.", personaDao.findById(personaId).getName());

			hostXmppTalk.write(XmppChat.getSystemMessage(personaId, leftNotice));
			xmppFreeroamLobby.remove(personaId);

			Iterator<Entry<Long, XmppTalk>> iterator = xmppFreeroamLobby.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Long, XmppTalk> next = iterator.next();
				XmppTalk xmppTalk = next.getValue();
				xmppTalk.write(XmppChat.getSystemMessage(xmppTalk.getPersonaId(), leftNoticeChannel));
			}
		}
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