package br.com.soapboxrace.bo;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.IEventDataDao;
import br.com.soapboxrace.dao.factory.ILobbyDao;
import br.com.soapboxrace.dao.factory.IPersonaDao;
import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.engine.Session;
import br.com.soapboxrace.http.HttpSessionVO;
import br.com.soapboxrace.jaxb.ChallengeType;
import br.com.soapboxrace.jaxb.CountdownType;
import br.com.soapboxrace.jaxb.EntrantsType;
import br.com.soapboxrace.jaxb.LobbyEntrantInfoType;
import br.com.soapboxrace.jaxb.LobbyInfoType;
import br.com.soapboxrace.jaxb.SessionInfoType;
import br.com.soapboxrace.jpa.EventDataEntity;
import br.com.soapboxrace.jpa.EventDefinitionEntity;
import br.com.soapboxrace.jpa.LobbyEntity;
import br.com.soapboxrace.jpa.LobbyEntrantEntity;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.xmpp.XmppLobby;
import br.com.soapboxrace.xmpp.jaxb.XMPP_CryptoTicketsType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_EventSessionType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_LobbyInviteType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_LobbyLaunchedType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_P2PCryptoTicketType;

public class MatchmakingBO {

	private ILobbyDao lobbyDao = DaoFactory.getLobbyDao();
	private IPersonaDao personaDao = DaoFactory.getPersonaDao();
	private IEventDataDao eventDataDao = DaoFactory.getEventDataDao();

	public SessionInfoType launchevent(Long personaId, Long eventId) {
		ChallengeType challengeType = new ChallengeType();
		challengeType.setChallengeId("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		challengeType.setPattern("FFFFFFFFFFFFFFFF");
		challengeType.setLeftSize(14);
		challengeType.setRightSize(50);

		EventDataEntity eventDataEntity = new EventDataEntity();
		eventDataEntity.setEventId(eventId);
		eventDataEntity.setEventSessionId(eventDataDao.getNextSessionId());
		eventDataEntity.setIsSinglePlayer(true);
		eventDataEntity.setPersonaId(personaId);
		eventDataDao.save(eventDataEntity);

		SessionInfoType sessionInfoType = new SessionInfoType();
		sessionInfoType.setSessionId(eventDataEntity.getEventSessionId());
		sessionInfoType.setEventId(eventId);
		sessionInfoType.setChallenge(challengeType);
		return sessionInfoType;
	}

	public static void main(String[] args) {
		MatchmakingBO matchmakingBO = new MatchmakingBO();
		matchmakingBO.joinqueueevent(103L, 47L);
	}

	public void joinqueueevent(Long personaId, Long eventId) {
		PersonaEntity personaEntity = personaDao.findById(personaId);
		Date now = new Date();
		Date past = new Date(now.getTime() - 35000);
		List<LobbyEntity> lobbys = lobbyDao.findByEventStarted(eventId, now, past);

		if (lobbys.size() == 0) {
			createLobby(personaEntity, eventId);
		} else {
			joinLobby(personaEntity, lobbys);
		}
	}

	private void createLobby(PersonaEntity personaEntity, Long eventId) {
		EventDefinitionEntity eventEntity = new EventDefinitionEntity();
		eventEntity.setId(eventId);
		LobbyEntity lobbyEntity = new LobbyEntity();
		lobbyEntity.setEvent(eventEntity);

		LobbyEntrantEntity lobbyEntrantEntity = new LobbyEntrantEntity();

		lobbyEntrantEntity.setPersona(personaEntity);
		lobbyEntrantEntity.setLobby(lobbyEntity);
		lobbyEntity.add(lobbyEntrantEntity);

		lobbyEntity = lobbyDao.save(lobbyEntity);

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
		XMPP_LobbyInviteType xMPP_LobbyInviteType = new XMPP_LobbyInviteType();
		Long eventId = lobbyEntity.getEvent().getId();
		xMPP_LobbyInviteType.setEventId(eventId);
		Long lobbyId = lobbyEntity.getId();
		xMPP_LobbyInviteType.setLobbyInviteId(lobbyId);
		XmppLobby xmppLobby = new XmppLobby(personaId);
		xmppLobby.joinQueueEvent(xMPP_LobbyInviteType);
	}

	public LobbyInfoType acceptinvite(Long personaId, Long lobbyInviteId) {
		LobbyEntity lobbyEntity = lobbyDao.findById(lobbyInviteId);
		Long eventIdLong = lobbyEntity.getEvent().getId();

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
			lobbyEntrantInfoType.setGridIndex(lobbyEntrantEntity.getGridIndex());
			lobbyEntrantInfo.add(lobbyEntrantInfoType);
			if (lobbyEntrantEntity.getPersona().getId().equals(personaId)) {
				personaInside = true;
			}
		}
		if (!personaInside) {
			LobbyEntrantEntity lobbyEntrantEntity = new LobbyEntrantEntity();
			PersonaEntity personaEntity = personaDao.findById(personaId);
			lobbyEntrantEntity.setPersona(personaEntity);
			lobbyEntrantEntity.setPersonaId(personaEntity.getId());
			lobbyEntrantEntity.setLevel(personaEntity.getLevel());
			lobbyEntrantEntity.setLobby(lobbyEntity);
			lobbyEntrantEntity.setGridIndex(entrants.size());
			lobbyEntrantEntity.setLobbyId(lobbyEntrantEntity.getId());
			lobbyEntity.getEntrants().add(lobbyEntrantEntity);
			lobbyDao.save(lobbyEntity);
			LobbyEntrantInfoType lobbyEntrantInfoType = new LobbyEntrantInfoType();
			lobbyEntrantInfoType.setPersonaId(lobbyEntrantEntity.getPersona().getId());
			lobbyEntrantInfoType.setLevel(lobbyEntrantEntity.getPersona().getLevel());
			lobbyEntrantInfoType.setGridIndex(lobbyEntrantEntity.getGridIndex());
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

		private ILobbyDao lobbyDao = DaoFactory.getLobbyDao();
		private IEventDataDao eventDataDao = DaoFactory.getEventDataDao();

		public LobbyCountDown(Long lobbyId) {
			this.lobbyId = lobbyId;
		}

		public void run() {
			try {
				Thread.sleep(60000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			Long eventSessionId = eventDataDao.getNextSessionId();
			LobbyEntity lobbyEntity = lobbyDao.findById(lobbyId);
			List<LobbyEntrantEntity> entrants = lobbyEntity.getEntrants();
			XMPP_LobbyLaunchedType lobbyLaunched = new XMPP_LobbyLaunchedType();
			EntrantsType entrantsType = new EntrantsType();
			List<LobbyEntrantInfoType> lobbyEntrantInfo = entrantsType.getLobbyEntrantInfo();
			XMPP_CryptoTicketsType xMPP_CryptoTicketsType = new XMPP_CryptoTicketsType();
			List<XMPP_P2PCryptoTicketType> p2pCryptoTicket = xMPP_CryptoTicketsType.getP2PCryptoTicket();
			int i = 0;
			byte numOfRacers = (byte) entrants.size();
			for (LobbyEntrantEntity lobbyEntrantEntity : entrants) {
				EventDataEntity eventDataEntity = new EventDataEntity();
				eventDataEntity.setEventId(lobbyEntity.getEvent().getId());
				eventDataEntity.setEventSessionId(eventSessionId);
				eventDataEntity.setIsSinglePlayer(false);
				eventDataEntity.setPersonaId(lobbyEntrantEntity.getPersona().getId());
				eventDataDao.save(eventDataEntity);
				byte gridIndex = (byte) i;
				byte[] helloPacket = { 10, 11, 12, 13 };
				int sessionId = eventSessionId.intValue();
				ByteBuffer byteBuffer = ByteBuffer.allocate(48);
				byteBuffer.put(gridIndex);
				byteBuffer.put(helloPacket);
				byteBuffer.putInt(sessionId);
				byteBuffer.put(numOfRacers);
				byte[] cryptoTicketBytes = byteBuffer.array();
				String cryptoTicketBase64 = Base64.getEncoder().encodeToString(cryptoTicketBytes);
				Long userId = lobbyEntrantEntity.getPersona().getUser().getId();
				HttpSessionVO httpSessionVo = Router.getHttpSessionVo(userId);
				if (httpSessionVo != null) {
					httpSessionVo.setRelayCryptoTicket(cryptoTicketBase64);
				}

				XMPP_P2PCryptoTicketType p2pCryptoTicketType = new XMPP_P2PCryptoTicketType();
				p2pCryptoTicketType.setPersonaId(lobbyEntrantEntity.getPersona().getId());
				p2pCryptoTicketType.setSessionKey("AAAAAAAAAAAAAAAAAAAAAA==");
				p2pCryptoTicket.add(p2pCryptoTicketType);

				LobbyEntrantInfoType lobbyEntrantInfoType = new LobbyEntrantInfoType();
				lobbyEntrantInfoType.setPersonaId(lobbyEntrantEntity.getPersona().getId());
				lobbyEntrantInfoType.setLevel(lobbyEntrantEntity.getPersona().getLevel());
				lobbyEntrantInfoType.setHeat(1);
				lobbyEntrantInfoType.setGridIndex(i++);
				lobbyEntrantInfoType.setState("Unknown");
				lobbyEntrantInfo.add(lobbyEntrantInfoType);
			}
			XMPP_EventSessionType xMPP_EventSessionType = new XMPP_EventSessionType();
			ChallengeType challengeType = new ChallengeType();
			challengeType.setChallengeId("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			challengeType.setPattern("FFFFFFFFFFFFFFFF");
			challengeType.setLeftSize(14);
			challengeType.setRightSize(50);

			xMPP_EventSessionType.setEventId(lobbyEntity.getEvent().getId());
			xMPP_EventSessionType.setChallenge(challengeType);
			xMPP_EventSessionType.setSessionId(eventSessionId);
			lobbyLaunched.setNewRelayServer(true);
			lobbyLaunched.setLobbyId(lobbyEntity.getId());
			lobbyLaunched.setUdpRelayHost(Session.getRaceUdpIp());
			lobbyLaunched.setUdpRelayPort(Session.getRaceUdpPort());

			lobbyLaunched.setEntrants(entrantsType);

			lobbyLaunched.setEventSession(xMPP_EventSessionType);
			XmppLobby.sendRelay(lobbyLaunched, xMPP_CryptoTicketsType);
		}
	}

}
