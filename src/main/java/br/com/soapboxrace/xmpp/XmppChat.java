package br.com.soapboxrace.xmpp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.http.HttpSessionVO;

public class XmppChat {

	private String chatMsg;
	private int personaId;

	public XmppChat(int personaId, String chatMsg) {
		this.personaId = personaId;
		this.chatMsg = chatMsg;
	}

	public String getChatMsg(Integer targetPersonaId) {
		return transformChatMsg(targetPersonaId);
	}

	public String getWhisperMsg(Integer targetPersonaId) {
		return transformWhisperMsg(targetPersonaId);
	}

	public int getPersonaId() {
		return personaId;
	}

	private String transformWhisperMsg(Integer targetPersonaId) {
		Pattern regPattern = Pattern.compile(
				"message to='nfsw.(\\d+)@(.*)' type='(\\w+)'><channel>Chat_Whisper</channel>(.*)Uid=&quot;(\\d+)&quot;");
		Matcher match = regPattern.matcher(chatMsg);
		String newMsg = chatMsg;
		if (match.find()) {
			String messageType = match.group(3);
			Long hostUserId = Long.valueOf(match.group(5));
			HttpSessionVO httpSessionVo = Router.getHttpSessionVo(hostUserId);
			Long hostPersonaId = httpSessionVo.getPersonaId();
			String xmppIp = httpSessionVo.getXmppIpAddres();

			String newMessageBlock = String.format("message from='nfsw.%d@%s/EA-Chat' to='nfsw.%d@%s' type='%s'>",
					hostPersonaId, xmppIp, targetPersonaId, xmppIp, messageType);
			newMsg = chatMsg.replaceFirst("message to='nfsw.(\\d+)@(.*)' type='(\\w+)'>", newMessageBlock);
		}
		return newMsg;
	}

	private String transformChatMsg(Integer targetPersonaId) {
		String xmppIp = "127.0.0.1";
		String newMsg = chatMsg;
		newMsg = newMsg.replaceFirst("message to=", "message from=");
		newMsg = newMsg.replaceFirst("@conference.".concat(xmppIp),
				"@conference.".concat(xmppIp).concat("/nfsw." + personaId));
		newMsg = newMsg.replaceFirst("type=",
				"to='nfsw.".concat(String.valueOf(targetPersonaId) + "@" + xmppIp).concat("/EA-Chat' type="));
		return newMsg;
	}

}
