package br.com.soapboxrace.xmpp;

public class XmppChat {

	private String chatMsg;
	private int personaId;

	public XmppChat(int personaId,String chatMsg) {
		this.personaId = personaId;
		this.chatMsg = chatMsg;
	}

	public String getChatMsg() {
		System.out.println("SOMEONE SENDING!");
		return chatMsg;
	}

	public int getPersonaId() {
		return personaId;
	}

	/*
	private void parseTest(String msg) {
		if (!msg.isEmpty()) {
			System.out.println("C->S [" + msg + "]");
			if (msg.contains("Chat_All(.*)Uid="(\\d+)"");
			Matcher match = regPattern.matcher(msg);
			if (match.find()) {
				// Long eventId = Long.valueOf(match.group(1));
				Long lobbyId = Long.valueOf(match.group(2));
				// String messageType = match.group(3);
				Long hostUserId = Long.valueOf(match.group(6));
				Long hostPersonaId = Router.getHttpSessionVo(hostUserId).getPersonaId();

				LobbyEntity lobby = lobbyDao.findById(lobbyId);
				List lobbyEntrants = lobby.getEntrants();
				for (LobbyEntrantEntity lobbyEnt : lobbyEntrants) {
					String newMsg = msg;
					Long targetPersonaId = lobbyEnt.getPersona().getId();
					if (!lobbyEnt.getPersona().getId().equals(hostPersonaId)) {
						newMsg = newMsg.replaceFirst("message to=", "message from=");
						newMsg = newMsg.replaceFirst("@conference.".concat(Session.getXmppIp()),
								"@conference.".concat(Session.getXmppIp()).concat("/nfsw." + hostPersonaId));
						newMsg = newMsg.replaceFirst("type=",
								"to='nfsw.".concat(String.valueOf(targetPersonaId) + "@" + Session.getXmppIp())
										.concat("/EA-Chat' type="));

						XmppSrv.sendMsg(targetPersonaId, newMsg);
					}
				}
			}
		}
	}
	 */

}
