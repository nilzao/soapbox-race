package br.com.soapboxrace.xmpp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmppHandler {

	private XmppTalk xmppTalk;

	public XmppHandler(XmppTalk xmppTalk) {
		this.xmppTalk = xmppTalk;
	}

	public String read() {
		String read = xmppTalk.read();
		if (read != null && read.isEmpty()) {
			if (read.contains("Chat_All")) {
				Long sessionId = 0L;
				Pattern regPattern = Pattern.compile("message to='(\\d+)_(\\d+)");
				Matcher match = regPattern.matcher(read);
				if (match.find()) {
					sessionId = Long.valueOf(match.group(2));
				}
				XmppChatLobby chatLobby = XmppChatLobbys.getChatLobby(sessionId);
				XmppChat xmppChat = new XmppChat(xmppTalk.getPersonaId(), read);
				chatLobby.broadcast(xmppChat);
			}
			if (read.contains("Chat_Whisper")) {
				Long personaIdTo = parsePersonaId(read);
				if (personaIdTo != 0) {
					int personaIdFrom = xmppTalk.getPersonaId();
					XmppChat xmppChat = new XmppChat(personaIdFrom, read);
					XmppTalk xmppTalkTo = XmppSrv.get(personaIdTo);
					if (xmppTalkTo != null) {
						xmppTalkTo.write(xmppChat.getWhisperMsg(personaIdTo.intValue()));
					} else {
						System.err.println("persona: " + personaIdTo + " not online in xmpp server");
					}
				}
			}
		}
		return read;
	}

	private Long parsePersonaId(String read) {
		Pattern regPattern = Pattern.compile("message to='nfsw.(\\d+)@(.*)");
		Matcher match = regPattern.matcher(read);
		if (match.find()) {
			return Long.valueOf(match.group(1));
		}
		return 0L;
	}

}
