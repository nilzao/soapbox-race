package br.com.soapboxrace.bo;

import br.com.soapboxrace.jaxb.ChallengeType;
import br.com.soapboxrace.jaxb.SessionInfoType;

public class MatchmakingBO {

	public SessionInfoType launchevent(Long eventId) {
		ChallengeType challengeType = new ChallengeType();
		challengeType.setChallengeId("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		challengeType.setPattern("FFFFFFFFFFFFFFFF");
		challengeType.setLeftSize(14);
		challengeType.setRightSize(50);

		SessionInfoType sessionInfoType = new SessionInfoType();
		sessionInfoType.setSessionId(1000000000);
		sessionInfoType.setEventId(eventId.intValue());
		sessionInfoType.setChallenge(challengeType);
		return sessionInfoType;
	}

	public void joinqueueevent(int userId, int personaId) {
		// XmppLobby xmppLobby = new XmppLobby(userId, personaId);
		// xmppLobby.joinQueueEvent();
	}

	public void acceptinvite(int userId, int personaId) {
		// XmppLobby xmppLobby = new XmppLobby(userId, personaId);
		// xmppLobby.acceptInvite();
	}

}
