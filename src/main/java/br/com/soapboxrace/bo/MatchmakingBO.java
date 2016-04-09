package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jaxb.ChallengeType;
import br.com.soapboxrace.jaxb.CountdownType;
import br.com.soapboxrace.jaxb.EntrantsType;
import br.com.soapboxrace.jaxb.LobbyEntrantInfoType;
import br.com.soapboxrace.jaxb.LobbyInfoType;
import br.com.soapboxrace.jaxb.SessionInfoType;
import br.com.soapboxrace.jpa.EventDefinitionEntity;
import br.com.soapboxrace.jpa.LobbyEntity;
import br.com.soapboxrace.jpa.LobbyEntrantEntity;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.xmpp.XmppLobby;
import br.com.soapboxrace.xmpp.jaxb.LobbyInviteType;

public class MatchmakingBO {

	private ConnectionDB connectionDB = new ConnectionDB();

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

	public void joinqueueevent(Long personaId, Long eventId) {
		LobbyEntity lobbyEntity = new LobbyEntity();
		Object objEventEntity = connectionDB.findById(new EventDefinitionEntity(), eventId);
		EventDefinitionEntity eventEntity = (EventDefinitionEntity) objEventEntity;
		lobbyEntity.setEvent(eventEntity);

		LobbyEntrantEntity lobbyEntrantEntity = new LobbyEntrantEntity();
		Object objPersonaEntity = connectionDB.findById(new PersonaEntity(), personaId);
		PersonaEntity personaEntity = (PersonaEntity) objPersonaEntity;
		lobbyEntrantEntity.setPersona(personaEntity);
		lobbyEntrantEntity.setLobby(lobbyEntity);
		lobbyEntity.add(lobbyEntrantEntity);

		lobbyEntity = (LobbyEntity) connectionDB.merge(lobbyEntity);

		LobbyInviteType lobbyInviteType = new LobbyInviteType();
		lobbyInviteType.setEventId(eventId.intValue());
		Long lobbyId = lobbyEntity.getId();
		lobbyInviteType.setLobbyInviteId(lobbyId.intValue());
		XmppLobby xmppLobby = new XmppLobby(personaId.intValue());
		xmppLobby.joinQueueEvent(lobbyInviteType);
	}

	public LobbyInfoType acceptinvite(Long personaId, Long lobbyInviteId) {
		Object objLobbyEntity = connectionDB.findById(new LobbyEntity(), lobbyInviteId);
		LobbyEntity lobbyEntity = (LobbyEntity) objLobbyEntity;
		Long eventIdLong = lobbyEntity.getEvent().getEventId();

		CountdownType countdownType = new CountdownType();
		int eventId = eventIdLong.intValue();
		countdownType.setLobbyId(lobbyInviteId.intValue());

		countdownType.setEventId(eventId);

		EntrantsType entrantsType = new EntrantsType();
		List<LobbyEntrantInfoType> lobbyEntrantInfo = entrantsType.getLobbyEntrantInfo();

		LobbyEntrantInfoType lobbyEntrantInfoType = new LobbyEntrantInfoType();
		lobbyEntrantInfoType.setPersonaId(personaId.intValue());

		lobbyEntrantInfo.add(lobbyEntrantInfoType);

		LobbyInfoType lobbyInfoType = new LobbyInfoType();
		lobbyInfoType.setCountdown(countdownType);
		lobbyInfoType.setEntrants(entrantsType);
		lobbyInfoType.setEventId(eventId);
		lobbyInfoType.setLobbyInviteId(lobbyInviteId.intValue());
		lobbyInfoType.setLobbyId(lobbyInviteId.intValue());

		return lobbyInfoType;
	}

}
