package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.MatchmakingBO;
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
		SessionInfoType launchevent = matchmakingBO.launchevent(getEventId());
		return MarshalXML.marshal(launchevent);
	}

	public String leavelobby() {
		return "";
	}

	public String joinqueueevent() {
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
}
