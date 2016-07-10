package br.com.soapboxrace.engine;

import java.util.ArrayList;
import java.util.List;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.IEventDataDao;
import br.com.soapboxrace.dao.factory.IPersonaDao;
import br.com.soapboxrace.jaxb.APIEventDataType;
import br.com.soapboxrace.jaxb.APIPersonaDataType;
import br.com.soapboxrace.jaxb.ArrayOfOwnedCarTransType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jpa.EventDataEntity;
import br.com.soapboxrace.jpa.ISoapBoxEntity;
import br.com.soapboxrace.jpa.PersonaEntity;

public class SoapboxAPI extends Router {

	IPersonaDao personaDao = DaoFactory.getPersonaDao();
	IEventDataDao eventDataDao = DaoFactory.getEventDataDao();

	public String getPersonaData() {
		Long personaId = Long.valueOf(getParam("personaId"));
		PersonaEntity personaEntity = personaDao.findById(personaId);

		ArrayOfOwnedCarTransType cars = new ArrayOfOwnedCarTransType();
		cars.setOwnedCarTransList(personaEntity.getOwnedCarlist());

		List<Long> otherPersonas = null;
		if (personaEntity.getUser().getListOfPersona().size() > 1) {
			otherPersonas = new ArrayList<Long>();
			for (PersonaEntity persona : personaEntity.getUser().getListOfPersona()) {
				otherPersonas.add(persona.getId());
			}
		}

		APIPersonaDataType apiPersonaData = new APIPersonaDataType();
		apiPersonaData.setBadges(null);
		apiPersonaData.setCars(cars);
		apiPersonaData.setIconIndex(personaEntity.getIconIndex());
		apiPersonaData.setLevel(personaEntity.getLevel());
		apiPersonaData.setMotto(personaEntity.getMotto());
		apiPersonaData.setName(personaEntity.getName());
		apiPersonaData.setOtherPersonas(otherPersonas);
		apiPersonaData.setScore(personaEntity.getScore());

		return MarshalXML.marshal(apiPersonaData);
	}

	public String getEventData() {
		if (!getRequest().getParameterNames().hasMoreElements())
			return "<Error>No parameters set</Error>";

		Object eventIdParam = getParam("eventId");
		Object eventModeIdParam = getParam("eventModeId");
		Object personaIdParam = getParam("personaId");
		Object singlePlayerParam = getParam("singlePlayer");

		EventDataEntity reqEventData = new EventDataEntity();
		if (eventIdParam != null)
			reqEventData.setEventId(Long.valueOf(eventIdParam.toString()));
		if (eventModeIdParam != null)
			reqEventData.setEventModeId(Integer.valueOf(eventModeIdParam.toString()));
		if (personaIdParam != null)
			reqEventData.setPersonaId(Long.valueOf(personaIdParam.toString()));
		if (singlePlayerParam != null)
			reqEventData.setIsSinglePlayer(Boolean.valueOf(singlePlayerParam.toString()));

		List<EventDataEntity> eventDataList = new ArrayList<EventDataEntity>();
		for (ISoapBoxEntity iEvent : eventDataDao.find(reqEventData)) {
			EventDataEntity event = (EventDataEntity) iEvent;
			event.setId(null);
			event.setEventSessionId(null);
			event.setEventLaunched(null);
			eventDataList.add(event);
		}
		Integer count = eventDataList.size();

		APIEventDataType apiEventData = new APIEventDataType();
		apiEventData.setCount(count);
		apiEventData.setEventDataList(eventDataList);

		return MarshalXML.marshal(apiEventData);
	}
}