package br.com.soapboxrace.xmpp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.engine.Session;

public class XmppChat {

	private String chatMessage;
	private Long personaId;

	public XmppChat(Long personaId, String chatMessage) {
		this.personaId = personaId;
		this.chatMessage = chatMessage;
	}

	public Long getPersonaId() {
		return personaId;
	}
	
	public static void getPresenceResponse(XmppTalk xmppTalk) {
		String channelName = xmppTalk.getCurrentChannelName();
		Integer channelNumber = xmppTalk.getCurrentChannelNumber();
		Long personaId = xmppTalk.getPersonaId();
		String xmppIp = Session.getXmppIp();

		String formatString = "<presence from='channel.%s__%d@conference.%s/nfsw.%d' to='nfsw.%d@%s/EA-Chat' xml:lang='en'>"
				+ "<x xmlns='http://jabber.org/protocol/muc#user'><item affiliation='none' role='none'/></x></presence>";
		xmppTalk.write(String.format(formatString, channelName, channelNumber, xmppIp, personaId, personaId, xmppIp));
		XmppChatLobbies.getFreeroamLobby(channelName, channelNumber).addXmppTalk(xmppTalk);

	}

	public String getEventMessage(Long targetPersonaId) {
		String newMsg = chatMessage;
		newMsg = newMsg.replaceFirst("message to=", "message from=");
		newMsg = newMsg.replaceFirst("@conference.".concat(Session.getXmppIp()),
				"@conference.".concat(Session.getXmppIp()).concat("/nfsw." + personaId));
		newMsg = newMsg.replaceFirst("type=", "to='nfsw."
				.concat(String.valueOf(targetPersonaId) + "@" + Session.getXmppIp()).concat("/EA-Chat' type="));
		return newMsg;
	}

	public String getFreeroamMessage(Long hostPersonaId, Long targetPersonaId, String channelName,
			Integer channelNumber) {
		String xmppIp = Session.getXmppIp();
		String newMessageBlock = String.format(
				"message from='nfsw.%s__%d@conference.%s/nfsw.%d' to='nfsw.%d@%s/EA-Chat'", channelName, channelNumber,
				xmppIp, hostPersonaId, targetPersonaId, xmppIp);
		String newMsg = chatMessage.replaceFirst("message to='(.*)'", newMessageBlock);
		return newMsg;
	}

	public static String getSystemMessage(Long targetPersonaId, String announcementText) {
		String xmppIp = Session.getXmppIp();
		String announcementBlock = String
				.format("<message from='nfsw.engine.engine@conference.%s/EA_Chat' id='JN_2578' to='nfsw.%d@%s'>"
						+ "<body>&lt;response status='1' ticket='0'&gt;&lt;ChatBroadcast &gt;&lt;ChatBlob&gt;&lt;FromName&gt;System&lt;/FromName&gt;"
						+ "&lt;FromPersonaId&gt;0&lt;/FromPersonaId&gt;&lt;FromUserId&gt;0&lt;/FromUserId&gt;&lt;Message&gt;%s"
						+ "&lt;/Message&gt;&lt;ToId&gt;0&lt;/ToId&gt;&lt;Type&gt;2&lt;/Type&gt;&lt;/ChatBlob&gt;&lt;/ChatBroadcast&gt;&lt;/response&gt;</body>"
						+ "<subject>69</subject></message>", xmppIp, targetPersonaId, xmppIp, announcementText);
		return announcementBlock;
	}

	public String getWhisperMessage(Long targetPersonaId) {
		Pattern regPattern = Pattern.compile(
				"message to='nfsw.(\\d+)@(.*)' type='(\\w+)'><channel>Chat_Whisper</channel>(.*)Uid=&quot;(\\d+)&quot;");
		Matcher match = regPattern.matcher(chatMessage);
		String newMsg = chatMessage;
		if (match.find()) {
			String messageType = match.group(3);
			Long hostUserId = Long.valueOf(match.group(5));
			Long hostPersonaId = Router.getHttpSessionVo(hostUserId).getPersonaId();
			String xmppIp = Session.getXmppIp();

			String newMessageBlock = String.format("message from='nfsw.%d@%s/EA-Chat' to='nfsw.%d@%s' type='%s'>",
					hostPersonaId, xmppIp, targetPersonaId, xmppIp, messageType);
			newMsg = chatMessage.replaceFirst("message to='nfsw.(\\d+)@(.*)' type='(\\w+)'>", newMessageBlock);
		}
		return newMsg;
	}

}