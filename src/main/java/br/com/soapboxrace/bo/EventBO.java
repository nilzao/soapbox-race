package br.com.soapboxrace.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.IEventDataDao;
import br.com.soapboxrace.dao.factory.IOwnedCarDao;
import br.com.soapboxrace.dao.factory.IPersonaDao;
import br.com.soapboxrace.definition.CardDecks;
import br.com.soapboxrace.definition.EventModes;
import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.engine.Session;
import br.com.soapboxrace.http.HttpSessionVO;
import br.com.soapboxrace.jaxb.AccoladesType;
import br.com.soapboxrace.jaxb.FinalRewardsType;
import br.com.soapboxrace.jaxb.LuckyDrawInfoType;
import br.com.soapboxrace.jaxb.LuckyDrawItemType;
import br.com.soapboxrace.jaxb.PursuitEventResultType;
import br.com.soapboxrace.jaxb.RouteArbitrationPacketType;
import br.com.soapboxrace.jaxb.RouteEntrantResultType;
import br.com.soapboxrace.jaxb.RouteEventResultType;
import br.com.soapboxrace.jaxb.TeamEscapeArbitrationPacketType;
import br.com.soapboxrace.jaxb.TeamEscapeEntrantResultType;
import br.com.soapboxrace.jaxb.TeamEscapeEventResultType;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
import br.com.soapboxrace.jpa.EventDataEntity;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.xmpp.IXmppSender;
import br.com.soapboxrace.xmpp.XmppFactory;
import br.com.soapboxrace.xmpp.jaxb.XMPP_EventTimingOutType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_ResponseTypeEventTimingOut;
import br.com.soapboxrace.xmpp.jaxb.XMPP_ResponseTypeRouteEntrantResult;
import br.com.soapboxrace.xmpp.jaxb.XMPP_ResponseTypeTeamEscapeEntrantResult;
import br.com.soapboxrace.xmpp.jaxb.XMPP_RouteEntrantResultType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_TeamEscapeEntrantResultType;

public class EventBO {

	private IPersonaDao personaDao = DaoFactory.getPersonaDao();
	private IOwnedCarDao ownedCarDao = DaoFactory.getOwnedCarDao();
	private IEventDataDao eventDataDao = DaoFactory.getEventDataDao();

	public String launched(Long userId, Long eventSessionId) {
		// Router.getHttpSessionVo(userId).getAlternateEventTimer().start();
		Long personaId = Router.getHttpSessionVo(userId).getPersonaId();
		EventDataEntity eventDataEntity = eventDataDao.findByEventSessionIdAndPersonaId(eventSessionId, personaId);
		eventDataEntity.setEventDurationInMS(0L);
		eventDataEntity.setEventLaunched(true);
		eventDataEntity.setFinishReason(0);
		eventDataEntity.setRank((short) 0);
		eventDataEntity.setTopSpeed(0F);
		eventDataDao.save(eventDataEntity);
		return "";
	}

	// TODO: add instancedaccolades() for team escape
	// TODO: add drag, pursuit specific entries to MySQL
	// TODO: add other event results
	// TODO: actually drop items
	// TODO: add drop rates
	// TODO: manage FinishReason

	// TODO: maybe add custom arbitration functions:
	// -> would make everything easier to read and understand
	// -> would make it easier to add drop rates
	// -> would make it easier to calculate exp,cash&drops
	// -> would make it easier to manage MySQL
	// -> ex: routeArbitration, teamEscapeArbitration, pursuitArbitration
	public Object arbitration(Long userId, String arbitrationXml) {
		HttpSessionVO httpSessionVo = Router.getHttpSessionVo(userId);
		Long eventSessionId = httpSessionVo.getEventSessionId();
		Long personaId = httpSessionVo.getPersonaId();

		EventDataEntity eventDataEntity = eventDataDao.findByEventSessionIdAndPersonaId(eventSessionId, personaId);
		if (!eventDataEntity.getEventLaunched())
			return null;

		// Long alternateEventDurationInMilliseconds =
		// httpSessionVo.getAlternateEventTimer().getElapsed();

		PersonaEntity personaEntity = personaDao.findById(personaId);
		Integer level = personaEntity.getLevel();
		if (level == 1) {
			personaEntity.setLevel(2);
			personaDao.save(personaEntity);
		}

		OwnedCarEntity currentCar = personaEntity.getOwnedCarlist().get(personaEntity.getCurCarIndex());
		Short newCarDurability = 0;
		if (currentCar.getDurability() > 0) {
			newCarDurability = (short) (currentCar.getDurability() - 5);
			currentCar.setDurability(newCarDurability);
			ownedCarDao.save(currentCar);
		}

		FinalRewardsType finalRewardsType = new FinalRewardsType();
		finalRewardsType.setRep(7331);
		finalRewardsType.setTokens(1337);

		LuckyDrawItemType luckyDrawItem = new LuckyDrawItemType();
		luckyDrawItem.setDescription("TEST DROP");
		luckyDrawItem.setHash(-1681514783L);
		luckyDrawItem.setIcon("product_nos_x1");
		luckyDrawItem.setRemainingUseCount(0);
		luckyDrawItem.setResellPrice(7331);
		luckyDrawItem.setVirtualItem("nosshot");
		luckyDrawItem.setVirtualItemType("POWERUP");
		luckyDrawItem.setWasSold(true);

		LuckyDrawInfoType luckyDrawInfo = new LuckyDrawInfoType();
		luckyDrawInfo.setLuckyDrawItem(luckyDrawItem);

		AccoladesType accolades = new AccoladesType();
		accolades.setFinalRewards(finalRewardsType);
		accolades.setLuckyDrawInfo(luckyDrawInfo);

		Integer eventModeId = eventDataEntity.getEventDefinition().getEventModeId();
		switch (EventModes.forId(eventModeId)) {
		case Drag:
			break;
		// case MeetingPlace:
		case Pursuit_MP:
			TeamEscapeArbitrationPacketType teamEscapeArbitrationPacket = (TeamEscapeArbitrationPacketType) UnmarshalXML.unMarshal(arbitrationXml,
					new TeamEscapeArbitrationPacketType());
			TeamEscapeEventResultType teamEscapeEventResult = new TeamEscapeEventResultType();

			teamEscapeEventResult.setAccolades(null);
			teamEscapeEventResult.setDurability(newCarDurability);
			teamEscapeEventResult.setEventId(eventDataEntity.getEventId());
			teamEscapeEventResult.setEventSessionId(eventSessionId);

			XMPP_TeamEscapeEntrantResultType xmppTeamEscapeResult = new XMPP_TeamEscapeEntrantResultType();
			xmppTeamEscapeResult.setDistanceToFinish(teamEscapeArbitrationPacket.getDistanceToFinish());
			xmppTeamEscapeResult.setEventDurationInMilliseconds(teamEscapeArbitrationPacket.getEventDurationInMilliseconds());
			xmppTeamEscapeResult.setEventSessionId(eventSessionId);
			xmppTeamEscapeResult.setFinishReason(teamEscapeArbitrationPacket.getFinishReason());
			xmppTeamEscapeResult.setFractionCompleted(teamEscapeArbitrationPacket.getFractionCompleted());
			xmppTeamEscapeResult.setPersonaId(personaId);
			xmppTeamEscapeResult.setRanking(teamEscapeArbitrationPacket.getRank());

			XMPP_ResponseTypeTeamEscapeEntrantResult teamEscapeEntrantResultResponse = new XMPP_ResponseTypeTeamEscapeEntrantResult();
			teamEscapeEntrantResultResponse.setTeamEscapeEntrantResult(xmppTeamEscapeResult);

			Boolean teamEscapeIsFirstPlace = teamEscapeArbitrationPacket.getRank() == 1;

			eventDataEntity.setBustedCount(teamEscapeArbitrationPacket.getBustedCount());
			eventDataEntity.setCarId(teamEscapeArbitrationPacket.getCarId());
			eventDataEntity.setCopsDeployed(teamEscapeArbitrationPacket.getCopsDeployed());
			eventDataEntity.setCopsDisabled(teamEscapeArbitrationPacket.getCopsDisabled());
			eventDataEntity.setCopsRammed(teamEscapeArbitrationPacket.getCopsRammed());
			eventDataEntity.setCostToState(teamEscapeArbitrationPacket.getCostToState());
			eventDataEntity.setDistanceToFinish(teamEscapeArbitrationPacket.getDistanceToFinish());
			eventDataEntity.setEventDurationInMS(teamEscapeArbitrationPacket.getEventDurationInMilliseconds());
			eventDataEntity.setEventModeId(eventModeId);
			eventDataEntity.setFinishReason(teamEscapeArbitrationPacket.getFinishReason());
			eventDataEntity.setFractionCompleted(teamEscapeArbitrationPacket.getFractionCompleted());
			eventDataEntity.setInfractions(teamEscapeArbitrationPacket.getInfractions());
			eventDataEntity.setPerfectStart(teamEscapeArbitrationPacket.getPerfectStart());
			eventDataEntity.setRank(teamEscapeArbitrationPacket.getRank());
			eventDataEntity.setRoadBlocksDodged(teamEscapeArbitrationPacket.getRoadBlocksDodged());
			eventDataEntity.setSpikeStripsDodged(teamEscapeArbitrationPacket.getSpikeStripsDodged());
			eventDataEntity.setTopSpeed(teamEscapeArbitrationPacket.getTopSpeed());
			eventDataDao.save(eventDataEntity);

			List<TeamEscapeEntrantResultType> teamEscapeEntrants = new ArrayList<TeamEscapeEntrantResultType>();
			for (EventDataEntity racer : eventDataDao.getRacers(eventSessionId)) {
				TeamEscapeEntrantResultType teamEscapeEntrantResult = new TeamEscapeEntrantResultType();
				teamEscapeEntrantResult.setDistanceToFinish(racer.getDistanceToFinish());
				teamEscapeEntrantResult.setEventDurationInMilliseconds(racer.getEventDurationInMS());
				teamEscapeEntrantResult.setEventSessionId(eventSessionId);
				teamEscapeEntrantResult.setFinishReason(racer.getFinishReason());
				teamEscapeEntrantResult.setFractionCompleted(racer.getFractionCompleted());
				teamEscapeEntrantResult.setPersonaId(racer.getPersonaId());
				teamEscapeEntrantResult.setRanking(racer.getRank());
				teamEscapeEntrants.add(teamEscapeEntrantResult);

				if (racer.getPersonaId() != personaId) {
					IXmppSender xmppSenderInstance = XmppFactory.getXmppSenderInstance(Session.getXmppServerType());
					xmppSenderInstance.send(teamEscapeEntrantResultResponse, racer.getPersonaId());
					if (teamEscapeIsFirstPlace) {
						XMPP_EventTimingOutType eventTimingOut = new XMPP_EventTimingOutType();
						eventTimingOut.setEventSessionId(eventSessionId);
						XMPP_ResponseTypeEventTimingOut eventTimingOutResponse = new XMPP_ResponseTypeEventTimingOut();
						eventTimingOutResponse.setEventTimingOut(eventTimingOut);

						xmppSenderInstance.send(eventTimingOutResponse, racer.getPersonaId());
					}
				}
			}
			teamEscapeEventResult.setEntrants(teamEscapeEntrants);

			return teamEscapeEventResult;
		case Pursuit_SP:
			break;
		case Circuit:
		case Sprint:
			RouteArbitrationPacketType routeArbitrationPacket = (RouteArbitrationPacketType) UnmarshalXML.unMarshal(arbitrationXml,
					new RouteArbitrationPacketType());
			RouteEventResultType routeEventResult = new RouteEventResultType();

			luckyDrawInfo.setCardDeck(CardDecks.forRank(routeArbitrationPacket.getRank()));

			routeEventResult.setAccolades(accolades);
			routeEventResult.setDurability(newCarDurability);
			routeEventResult.setEventId(eventDataEntity.getEventId());
			routeEventResult.setEventSessionId(eventSessionId);

			XMPP_RouteEntrantResultType xmppRouteResult = new XMPP_RouteEntrantResultType();
			xmppRouteResult.setBestLapDurationInMilliseconds(routeArbitrationPacket.getBestLapDurationInMilliseconds());
			xmppRouteResult.setEventDurationInMilliseconds(routeArbitrationPacket.getEventDurationInMilliseconds());
			xmppRouteResult.setEventSessionId(eventSessionId);
			xmppRouteResult.setFinishReason(routeArbitrationPacket.getFinishReason());
			xmppRouteResult.setPersonaId(personaId);
			xmppRouteResult.setRanking(routeArbitrationPacket.getRank());
			xmppRouteResult.setTopSpeed(routeArbitrationPacket.getTopSpeed());

			XMPP_ResponseTypeRouteEntrantResult routeEntrantResultResponse = new XMPP_ResponseTypeRouteEntrantResult();
			routeEntrantResultResponse.setRouteEntrantResult(xmppRouteResult);

			Boolean routeIsFirstPlace = routeArbitrationPacket.getRank() == 1;

			eventDataEntity.setBestLapTimeInMS(routeArbitrationPacket.getBestLapDurationInMilliseconds());
			eventDataEntity.setCarId(routeArbitrationPacket.getCarId());
			eventDataEntity.setEventDurationInMS(routeArbitrationPacket.getEventDurationInMilliseconds());
			eventDataEntity.setEventModeId(eventModeId);
			eventDataEntity.setFinishReason(routeArbitrationPacket.getFinishReason());
			eventDataEntity.setPerfectStart(routeArbitrationPacket.getPerfectStart());
			eventDataEntity.setRank(routeArbitrationPacket.getRank());
			eventDataEntity.setTopSpeed(routeArbitrationPacket.getTopSpeed());
			eventDataDao.save(eventDataEntity);

			List<RouteEntrantResultType> routeEntrants = new ArrayList<RouteEntrantResultType>();
			for (EventDataEntity racer : eventDataDao.getRacers(eventSessionId)) {
				RouteEntrantResultType routeEntrantResult = new RouteEntrantResultType();
				routeEntrantResult.setBestLapDurationInMilliseconds(racer.getBestLapTimeInMS());
				routeEntrantResult.setEventDurationInMilliseconds(racer.getEventDurationInMS());
				routeEntrantResult.setEventSessionId(eventSessionId);
				routeEntrantResult.setFinishReason(racer.getFinishReason());
				routeEntrantResult.setPersonaId(racer.getPersonaId());
				routeEntrantResult.setRanking(racer.getRank());
				routeEntrantResult.setTopSpeed(racer.getTopSpeed());
				routeEntrants.add(routeEntrantResult);

				if (racer.getPersonaId() != personaId) {
					IXmppSender xmppSenderInstance = XmppFactory.getXmppSenderInstance(Session.getXmppServerType());
					xmppSenderInstance.send(routeEntrantResultResponse, racer.getPersonaId());
					if (routeIsFirstPlace) {
						XMPP_EventTimingOutType eventTimingOut = new XMPP_EventTimingOutType();
						eventTimingOut.setEventSessionId(eventSessionId);
						XMPP_ResponseTypeEventTimingOut eventTimingOutResponse = new XMPP_ResponseTypeEventTimingOut();
						eventTimingOutResponse.setEventTimingOut(eventTimingOut);

						xmppSenderInstance.send(eventTimingOutResponse, racer.getPersonaId());
					}
				}
			}
			routeEventResult.setEntrants(routeEntrants);

			return routeEventResult;
		default:
			break;
		}
		return bust(personaId); // fake data
	}

	public PursuitEventResultType bust(Long personaId) {
		PursuitEventResultType pursuitEventResult = new PursuitEventResultType();
		pursuitEventResult.setDurability(100);
		pursuitEventResult.setEventId(1);
		pursuitEventResult.setEventSessionId(1000000000);
		pursuitEventResult.setExitPath("ExitToFreeroam");
		pursuitEventResult.setInviteLifetimeInMilliseconds(0);
		pursuitEventResult.setLobbyInviteId(0);
		pursuitEventResult.setPersonaId(personaId);
		pursuitEventResult.setHeat(1);

		FinalRewardsType finalRewardsType = new FinalRewardsType();
		finalRewardsType.setRep(0);
		finalRewardsType.setTokens(0);

		AccoladesType accoladesType = new AccoladesType();
		accoladesType.setHasLeveledUp(false);
		accoladesType.setLuckyDrawInfo(null);
		accoladesType.setRewardInfo(null);
		accoladesType.setFinalRewards(finalRewardsType);

		pursuitEventResult.setAccolades(accoladesType);
		return pursuitEventResult;
	}

}