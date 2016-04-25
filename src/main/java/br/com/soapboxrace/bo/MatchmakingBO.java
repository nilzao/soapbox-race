package br.com.soapboxrace.bo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.engine.Session;
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
import br.com.soapboxrace.xmpp.jaxb.CryptoTicketsType;
import br.com.soapboxrace.xmpp.jaxb.EventSessionType;
import br.com.soapboxrace.xmpp.jaxb.LobbyInviteType;
import br.com.soapboxrace.xmpp.jaxb.LobbyLaunchedType;
import br.com.soapboxrace.xmpp.jaxb.P2PCryptoTicketType;

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
				"SELECT obj FROM LobbyEntity obj WHERE obj.event = :event and obj.lobbyDateTimeStart between :dateTime1 and :dateTime2",
				LobbyEntity.class);
		EventDefinitionEntity eventEntity = new EventDefinitionEntity();
		eventEntity.setEventId(eventId);
		query.setParameter("event", eventEntity);
		Date now = new Date();
		Date past = new Date(now.getTime() - 45000);
		query.setParameter("dateTime1", past);
		query.setParameter("dateTime2", now);
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
		new LobbyCountDown(lobbyEntity.getId()).start();
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

	private void sendJoinMsg(Long personaId, List<LobbyEntrantEntity> lobbyEntrants) {
		for (LobbyEntrantEntity lobbyEntrantEntity : lobbyEntrants) {
			if (personaId != lobbyEntrantEntity.getPersona().getId()) {
				lobbyEntrantEntity.setHeat(1);
				lobbyEntrantEntity.setLevel(lobbyEntrantEntity.getPersona().getLevel());
				lobbyEntrantEntity.setLobbyId(lobbyEntrantEntity.getLobby().getId());
				lobbyEntrantEntity.setPersonaId(personaId);
				XmppLobby xmppLobby = new XmppLobby(lobbyEntrantEntity.getPersona().getId());
				xmppLobby.sendJoinMsg(lobbyEntrantEntity);
			}
		}
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
		countdownType.setLobbyCountdownInMilliseconds(lobbyEntity.getLobbyCountdownInMilliseconds());

		EntrantsType entrantsType = new EntrantsType();
		List<LobbyEntrantInfoType> lobbyEntrantInfo = entrantsType.getLobbyEntrantInfo();

		List<LobbyEntrantEntity> entrants = lobbyEntity.getEntrants();
		sendJoinMsg(personaId, entrants);
		boolean personaInside = false;
		for (LobbyEntrantEntity lobbyEntrantEntity : entrants) {
			LobbyEntrantInfoType lobbyEntrantInfoType = new LobbyEntrantInfoType();
			lobbyEntrantInfoType.setPersonaId(lobbyEntrantEntity.getPersona().getId());
			lobbyEntrantInfoType.setLevel(lobbyEntrantEntity.getPersona().getLevel());
			lobbyEntrantInfo.add(lobbyEntrantInfoType);
			if (lobbyEntrantEntity.getPersona().getId() == personaId) {
				personaInside = true;
			}
		}
		if (!personaInside) {
			LobbyEntrantEntity lobbyEntrantEntity = new LobbyEntrantEntity();
			Object objPersona = connectionDB.findById(new PersonaEntity(), personaId);
			PersonaEntity personaEntity = (PersonaEntity) objPersona;
			lobbyEntrantEntity.setPersona(personaEntity);
			lobbyEntrantEntity.setPersonaId(personaEntity.getId());
			lobbyEntrantEntity.setLevel(personaEntity.getLevel());
			lobbyEntrantEntity.setLobby(lobbyEntity);
			lobbyEntrantEntity.setLobbyId(lobbyEntrantEntity.getId());
			lobbyEntity.getEntrants().add(lobbyEntrantEntity);
			connectionDB.merge(lobbyEntity);
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

	private static class LobbyCountDown extends Thread {

		private Long lobbyId;

		private ConnectionDB connectionDB = new ConnectionDB();

		public LobbyCountDown(Long lobbyId) {
			this.lobbyId = lobbyId;
		}

		public void run() {
			try {
				Thread.sleep(60000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			LobbyEntity lobbyEntity = (LobbyEntity) connectionDB.findById(new LobbyEntity(), lobbyId);
			List<LobbyEntrantEntity> entrants = lobbyEntity.getEntrants();
			LobbyLaunchedType lobbyLaunched = new LobbyLaunchedType();
			EntrantsType entrantsType = new EntrantsType();
			List<LobbyEntrantInfoType> lobbyEntrantInfo = entrantsType.getLobbyEntrantInfo();
			CryptoTicketsType cryptoTicketsType = new CryptoTicketsType();
			List<P2PCryptoTicketType> p2pCryptoTicket = cryptoTicketsType.getP2PCryptoTicket();
			int i = 0;
			for (LobbyEntrantEntity lobbyEntrantEntity : entrants) {
				P2PCryptoTicketType p2pCryptoTicketType = new P2PCryptoTicketType();
				p2pCryptoTicketType.setPersonaId(lobbyEntrantEntity.getPersonaId());
				p2pCryptoTicketType.setSessionKey("AAAAAAAAAAAAAAAAAAAAAA==");
				p2pCryptoTicket.add(p2pCryptoTicketType);

				LobbyEntrantInfoType lobbyEntrantInfoType = new LobbyEntrantInfoType();
				lobbyEntrantInfoType.setPersonaId(lobbyEntrantEntity.getPersona().getId());
				lobbyEntrantInfoType.setLevel(lobbyEntrantEntity.getPersona().getLevel());
				lobbyEntrantInfoType.setHeat(1);
				lobbyEntrantInfoType.setGridIndex(i++);
				lobbyEntrantInfo.add(lobbyEntrantInfoType);
			}
			EventSessionType eventSessionType = new EventSessionType();
			ChallengeType challengeType = new ChallengeType();
			challengeType.setChallengeId("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			challengeType.setPattern("FFFFFFFFFFFFFFFF");
			challengeType.setLeftSize(14);
			challengeType.setRightSize(50);

			eventSessionType.setEventId(lobbyEntity.getEvent().getEventId());
			eventSessionType.setChallenge(challengeType);
			eventSessionType.setSessionId(12345678L);
			lobbyLaunched.setNewRelayServer(true);
			lobbyLaunched.setLobbyId(lobbyEntity.getId());
			lobbyLaunched.setUdpRelayHost(Session.getIp());
			lobbyLaunched.setUdpRelayPort(9999);

			lobbyLaunched.setEntrants(entrantsType);

			lobbyLaunched.setEventSession(eventSessionType);
			XmppLobby.sendRelay(lobbyLaunched);
		}
	}

}
