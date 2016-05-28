package br.com.soapboxrace.xmpp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmppHandler {

	private XmppTalk xmppTalk;

	public XmppHandler(XmppTalk xmppTalk) {
		this.xmppTalk = xmppTalk;
	}

	// <message to='377_6969@conference.127.0.0.1' type='groupchat'>
	// <channel>Chat_All</channel>
	// <body>
	// <ChatMsg Type=
	// &quot;1&quot; Uid=&quot;7&quot; Time=&quot;-3854625021889066203&quot;
	// Cs=&quot;-3854625040761152756&quot;>
	// <From>NEO</From>
	// <Msg>Follow the white rabbit</Msg>
	// </ChatMsg>
	// </body>
	// </message>

	public String read() {
		String read = xmppTalk.read();
		if (!read.isEmpty()) {
			if (read.contains("Chat_All")) {
				// TODO parse 6969 from (to='377_6969@conference.127.0.0.1')
				Long sessionId = 6969L;
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
						xmppTalkTo.write(xmppChat.getWisperMsg(personaIdTo.intValue()));
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
