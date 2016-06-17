package br.com.soapboxrace.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.soapboxrace.dao.EventDataDao;
import br.com.soapboxrace.dao.OwnedCarDao;
import br.com.soapboxrace.dao.PersonaDao;
import br.com.soapboxrace.definition.CardDecks;
import br.com.soapboxrace.definition.EventModes;
import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.http.HttpSessionVO;
import br.com.soapboxrace.jaxb.AccoladesType;
import br.com.soapboxrace.jaxb.FinalRewardsType;
import br.com.soapboxrace.jaxb.LuckyDrawInfoType;
import br.com.soapboxrace.jaxb.LuckyDrawItemType;
import br.com.soapboxrace.jaxb.PursuitEventResultType;
import br.com.soapboxrace.jaxb.RouteArbitrationPacketType;
import br.com.soapboxrace.jaxb.RouteEntrantResultType;
import br.com.soapboxrace.jaxb.RouteEventResultType;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
import br.com.soapboxrace.jpa.EventDataEntity;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.openfire.OpenFireSoapBoxCli;
import br.com.soapboxrace.xmpp.jaxb.EventTimingOutType;
import br.com.soapboxrace.xmpp.jaxb.ResponseTypeEntrantResult;
import br.com.soapboxrace.xmpp.jaxb.ResponseTypeEventTimingOut;
import br.com.soapboxrace.xmpp.jaxb.RouteEntrantResultTypeXmpp;

public class EventBO {

	private PersonaDao personaDao = new PersonaDao();
	private OwnedCarDao ownedCarDao = new OwnedCarDao();
	private EventDataDao eventDataDao = new EventDataDao();

	public String launched(Long userId, Long eventSessionId) {
		// Router.getHttpSessionVo(userId).getAlternateEventTimer().start();
		Long personaId = Router.getHttpSessionVo(userId).getPersonaId();
		EventDataEntity eventDataEntity = eventDataDao.findByEventSessionIdAndPersonaId(eventSessionId, personaId);
		eventDataEntity.setBestLapTimeInMS(0L);
		eventDataEntity.setEventDurationInMS(0L);
		eventDataEntity.setEventLaunched(true);
		eventDataEntity.setFinishReason(0);
		eventDataEntity.setRank((short) 0);
		eventDataEntity.setTopSpeed(0F);
		eventDataDao.save(eventDataEntity);
		return "";
	}

	// TODO: add instancedaccolades() for correct reward, bonus and drop
	// calculation
	// TODO: add team-escape, drag, pursuit specific entries to MySQL
	// TODO: add other event results
	// TODO: actually drop items
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
		if (currentCar.getDurability() >= 0) {
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

		switch (EventModes.forId(eventDataEntity.getEventDefinition().getEventModeId())) {
		case Drag:
			break;
		case MeetingPlace:
			break;
		case Pursuit_MP:
			break;
		case Pursuit_SP:
			break;
		case Circuit:
		case Sprint:
			RouteArbitrationPacketType routeArbitrationPacket = (RouteArbitrationPacketType) UnmarshalXML
					.unMarshal(arbitrationXml, new RouteArbitrationPacketType());
			RouteEventResultType routeEventResult = new RouteEventResultType();

			luckyDrawInfo.setCardDeck(CardDecks.forRank(routeArbitrationPacket.getRank()));

			routeEventResult.setAccolades(accolades);
			routeEventResult.setDurability(newCarDurability);
			routeEventResult.setEventId(eventDataEntity.getEventId());
			routeEventResult.setEventSessionId(eventSessionId);

			RouteEntrantResultTypeXmpp xmppResult = new RouteEntrantResultTypeXmpp();
			xmppResult.setBestLapDurationInMilliseconds(routeArbitrationPacket.getBestLapDurationInMilliseconds());
			xmppResult.setEventDurationInMilliseconds(routeArbitrationPacket.getEventDurationInMilliseconds());
			xmppResult.setEventSessionId(eventSessionId);
			xmppResult.setFinishReason(routeArbitrationPacket.getFinishReason());
			xmppResult.setPersonaId(personaId);
			xmppResult.setRanking(routeArbitrationPacket.getRank());
			xmppResult.setTopSpeed(routeArbitrationPacket.getTopSpeed());

			ResponseTypeEntrantResult entrantResultResponse = new ResponseTypeEntrantResult();
			entrantResultResponse.setRouteEntrantResult(xmppResult);

			EventTimingOutType eventTimingOut = new EventTimingOutType();
			eventTimingOut.setEventSessionId(eventSessionId);
			ResponseTypeEventTimingOut eventTimingOutResponse = new ResponseTypeEventTimingOut();
			eventTimingOutResponse.setEventTimingOut(eventTimingOut);

			Boolean isFirstPlace = routeArbitrationPacket.getRank() == 1;

			List<RouteEntrantResultType> entrants = new ArrayList<RouteEntrantResultType>();
			for (EventDataEntity racer : eventDataDao.getRacers(eventSessionId)) {
				RouteEntrantResultType routeEntrantResult = new RouteEntrantResultType();
				routeEntrantResult.setBestLapDurationInMilliseconds(racer.getBestLapTimeInMS());
				routeEntrantResult.setEventDurationInMilliseconds(racer.getEventDurationInMS());
				routeEntrantResult.setEventSessionId(eventSessionId);
				routeEntrantResult.setFinishReason(racer.getFinishReason());
				routeEntrantResult.setPersonaId(racer.getPersonaId());
				routeEntrantResult.setRanking(racer.getRank());
				routeEntrantResult.setTopSpeed(racer.getTopSpeed());

				if (racer.getEventDurationInMS() == 0L && racer.getPersonaId() != personaId
						&& racer.getPersonaId() > 10) {
					OpenFireSoapBoxCli.getInstance().send(entrantResultResponse, racer.getPersonaId());
					if (isFirstPlace) {
						OpenFireSoapBoxCli.getInstance().send(eventTimingOutResponse, racer.getPersonaId());
					}
				}
				entrants.add(routeEntrantResult);
			}
			routeEventResult.setEntrants(entrants);

			eventDataEntity.setBestLapTimeInMS(routeArbitrationPacket.getBestLapDurationInMilliseconds());
			eventDataEntity.setCarId(routeArbitrationPacket.getCarId());
			eventDataEntity.setEventDurationInMS(routeArbitrationPacket.getEventDurationInMilliseconds());
			eventDataEntity.setFinishReason(routeArbitrationPacket.getFinishReason());
			eventDataEntity.setRank(routeArbitrationPacket.getRank());
			eventDataEntity.setTopSpeed(routeArbitrationPacket.getTopSpeed());
			eventDataDao.save(eventDataEntity);

			return routeEventResult;
		default:
			return null;
		}
		return bust(personaId); // adding it to make the game NOT crash until
								// someone (or me) adds other event results
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