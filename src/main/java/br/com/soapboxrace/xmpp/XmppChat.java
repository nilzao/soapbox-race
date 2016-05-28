package br.com.soapboxrace.xmpp;

import br.com.soapboxrace.engine.Session;

public class XmppChat {

	private String chatMsg;
	private int personaId;

	public XmppChat(int personaId, String chatMsg) {
		this.personaId = personaId;
		this.chatMsg = chatMsg;
	}

	public String getChatMsg(Integer targetPersonaId) {
		return transforMsg(targetPersonaId);
	}

	public int getPersonaId() {
		return personaId;
	}

	private String transforMsg(Integer targetPersonaId) {
		String newMsg = chatMsg;
		newMsg = newMsg.replaceFirst("message to=", "message from=");
		newMsg = newMsg.replaceFirst("@conference.".concat(Session.getXmppIp()),
				"@conference.".concat(Session.getXmppIp()).concat("/nfsw." + personaId));
		newMsg = newMsg.replaceFirst("type=", "to='nfsw."
				.concat(String.valueOf(targetPersonaId) + "@" + Session.getXmppIp()).concat("/EA-Chat' type="));
		return newMsg;
	}

}
