package br.com.soapboxrace.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
		sessionInfoType.setEventId(eventId);
		sessionInfoType.setChallenge(challengeType);
		return sessionInfoType;
	}

	public static void main(String[] args) {
		MatchmakingBO matchmakingBO = new MatchmakingBO();
		matchmakingBO.joinqueueevent(103L, 47L);
	}

	public void joinqueueevent(Long personaId, Long eventId) {
		EntityManager manager = ConnectionDB.getManager();
		TypedQuery<LobbyEntity> query = manager.createQuery(
				"SELECT obj FROM LobbyEntity obj WHERE obj.event = :event and obj.lobbyCountdownInMilliseconds >= 10000",
				LobbyEntity.class);
		EventDefinitionEntity eventEntity = new EventDefinitionEntity();
		eventEntity.setEventId(eventId);
		query.setParameter("event", eventEntity);
		List<LobbyEntity> lobbys = query.getResultList();

		Object objPersonaEntity = connectionDB.findById(new PersonaEntity(), personaId);
		PersonaEntity personaEntity = (PersonaEntity) objPersonaEntity;

		if (lobbys.size() == 0) {
			createLobby(personaEntity, eventEntity);
		} else {
			joinLobby(personaEntity, lobbys);
		}
	}

	private void createLobby(PersonaEntity personaEntity, EventDefinitionEntity eventEntity) {
		LobbyEntity lobbyEntity = new LobbyEntity();
		lobbyEntity.setEvent(eventEntity);

		LobbyEntrantEntity lobbyEntrantEntity = new LobbyEntrantEntity();

		lobbyEntrantEntity.setPersona(personaEntity);
		lobbyEntrantEntity.setLobby(lobbyEntity);
		lobbyEntity.add(lobbyEntrantEntity);

		lobbyEntity = (LobbyEntity) connectionDB.merge(lobbyEntity);

		sendJoinEvent(personaEntity.getId(), lobbyEntity);
	}

	private void joinLobby(PersonaEntity personaEntity, List<LobbyEntity> lobbys) {
		LobbyEntity lobbyEntity = null;
		for (LobbyEntity lobbyEntityTmp : lobbys) {
			int maxEntrants = lobbyEntityTmp.getEvent().getMaxEntrants();
			List<LobbyEntrantEntity> lobbyEntrants = lobbyEntityTmp.getEntrants();
			int entrantsSize = lobbyEntrants.size();
			if (entrantsSize < maxEntrants) {
				lobbyEntity = lobbyEntityTmp;
				if (!isPersonaInside(personaEntity.getId(), lobbyEntrants)) {
					LobbyEntrantEntity lobbyEntrantEntity = new LobbyEntrantEntity();
					lobbyEntrantEntity.setPersona(personaEntity);
					lobbyEntrantEntity.setLobby(lobbyEntity);
					lobbyEntrants.add(lobbyEntrantEntity);
				}
				break;
			}
		}
		if (lobbyEntity != null) {
			sendJoinEvent(personaEntity.getId(), lobbyEntity);
		}
	}

	private boolean isPersonaInside(Long personaId, List<LobbyEntrantEntity> lobbyEntrants) {
		for (LobbyEntrantEntity lobbyEntrantEntity : lobbyEntrants) {
			Long entrantPersonaId = lobbyEntrantEntity.getPersona().getId();
			if (entrantPersonaId == personaId) {
				return true;
			}
		}
		return false;
	}

	private void sendJoinEvent(Long personaId, LobbyEntity lobbyEntity) {
		LobbyInviteType lobbyInviteType = new LobbyInviteType();
		Long eventId = lobbyEntity.getEvent().getEventId();
		lobbyInviteType.setEventId(eventId);
		Long lobbyId = lobbyEntity.getId();
		lobbyInviteType.setLobbyInviteId(lobbyId);
		XmppLobby xmppLobby = new XmppLobby(personaId);
		xmppLobby.joinQueueEvent(lobbyInviteType);
	}

	public LobbyInfoType acceptinvite(Long personaId, Long lobbyInviteId) {
		Object objLobbyEntity = connectionDB.findById(new LobbyEntity(), lobbyInviteId);
		LobbyEntity lobbyEntity = (LobbyEntity) objLobbyEntity;
		Long eventIdLong = lobbyEntity.getEvent().getEventId();

		CountdownType countdownType = new CountdownType();
		long eventId = eventIdLong;
		countdownType.setLobbyId(lobbyInviteId);
		countdownType.setEventId(eventId);

		EntrantsType entrantsType = new EntrantsType();
		List<LobbyEntrantInfoType> lobbyEntrantInfo = entrantsType.getLobbyEntrantInfo();

		List<LobbyEntrantEntity> entrants = lobbyEntity.getEntrants();
		for (LobbyEntrantEntity lobbyEntrantEntity : entrants) {
			LobbyEntrantInfoType lobbyEntrantInfoType = new LobbyEntrantInfoType();
			lobbyEntrantInfoType.setPersonaId(lobbyEntrantEntity.getPersona().getId());
			lobbyEntrantInfoType.setLevel(lobbyEntrantEntity.getPersona().getLevel());
			lobbyEntrantInfo.add(lobbyEntrantInfoType);
		}

		LobbyInfoType lobbyInfoType = new LobbyInfoType();
		lobbyInfoType.setCountdown(countdownType);
		lobbyInfoType.setEntrants(entrantsType);
		lobbyInfoType.setEventId(eventId);
		lobbyInfoType.setLobbyInviteId(lobbyInviteId);
		lobbyInfoType.setLobbyId(lobbyInviteId);

		return lobbyInfoType;
	}

}
