package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.MatchmakingBO;
import br.com.soapboxrace.jaxb.LobbyInfoType;
import br.com.soapboxrace.jaxb.SessionInfoType;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class Matchmaking extends Router {

	MatchmakingBO matchmakingBO = new MatchmakingBO();

	private Long getEventId() {
		String[] split = getTarget().split("/");
		String eventIdStr = split[5];
		Long eventId = Long.valueOf(eventIdStr);
		return eventId;
	}

	public String launchevent() {
		if (getLoggedPersonaId() == -1L)
			return "";
		SessionInfoType launchevent = matchmakingBO.launchevent(getLoggedPersonaId(), getEventId());
		return MarshalXML.marshal(launchevent);
	}

	public String leavelobby() {
		return "";
	}

	public String joinqueueevent() {
		matchmakingBO.joinqueueevent(getLoggedPersonaId(), getEventId());
		return "";
	}

	public String leavequeue() {
		return "";
	}

	public String makeprivatelobby() {
		return "";
	}

	public String joinqueueracenow() {
		return "";
	}

	public String acceptinvite() {
		String lobbyInviteIdStr = getParam("lobbyInviteId");
		Long lobbyInviteId = Long.valueOf(lobbyInviteIdStr);
		LobbyInfoType acceptinvite = matchmakingBO.acceptinvite(getLoggedPersonaId(), lobbyInviteId);
		return MarshalXML.marshal(acceptinvite);
	}

	public String declineinvite() {
		return "";
	}
}