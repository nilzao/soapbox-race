package br.com.soapboxrace.xmpp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import br.com.soapboxrace.dao.PersonaDao;

public class XmppSystemLobby {

	private HashMap<Long, XmppTalk> xmppSystemChat = new HashMap<Long, XmppTalk>();
	private PersonaDao personaDao = new PersonaDao();

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
	
	public boolean joinRoom(XmppTalk hostXmppTalk) {
		String channelName = hostXmppTalk.getCurrentChannelName();
		Integer channelNumber = hostXmppTalk.getCurrentChannelNumber();
		Long personaId = hostXmppTalk.getPersonaId();
		Long oldPersonaId = 0L;
		
		String joinNoticeChannel = String.format("%s joined the channel.", personaDao.findById(personaId).getName());
		Iterator<Entry<Long, XmppTalk>> iterator = XmppChatLobbies.getFreeroamLobby(channelName, channelNumber).getLobby().entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Long, XmppTalk> next = iterator.next();
			XmppTalk xmppTalk = next.getValue();
			Long toPersonaId = next.getKey();
			if (!toPersonaId.equals(personaId) && !toPersonaId.equals(oldPersonaId)){
				xmppTalk.write(XmppChat.getSystemMessage(xmppTalk.getPersonaId(), joinNoticeChannel));
				oldPersonaId = toPersonaId;
			}
		}
		return true;
	}
	
	public boolean leftRoom(XmppTalk hostXmppTalk) {
		String channelName = hostXmppTalk.getCurrentChannelName();
		Integer channelNumber = hostXmppTalk.getCurrentChannelNumber();
		Long personaId = hostXmppTalk.getPersonaId();
		
		String leftNotice = String.format("You left channel %s %d.", channelName, channelNumber);
		String leftNoticeChannel = String.format("%s left the channel.", personaDao.findById(personaId).getName());
		
		hostXmppTalk.write(XmppChat.getSystemMessage(personaId, leftNotice));
		
		Iterator<Entry<Long, XmppTalk>> iterator = XmppChatLobbies.getFreeroamLobby(channelName, channelNumber).getLobby().entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Long, XmppTalk> next = iterator.next();
			XmppTalk xmppTalk = next.getValue();
			xmppTalk.write(XmppChat.getSystemMessage(xmppTalk.getPersonaId(), leftNoticeChannel));
		}
		return true;
	}
}