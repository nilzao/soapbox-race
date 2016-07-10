package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.dao.db.EventDefinitionDao;
import br.com.soapboxrace.jaxb.EventsPacketType;
import br.com.soapboxrace.jaxb.EventsType;
import br.com.soapboxrace.jpa.EventDefinitionEntity;

public class EventsBO {

	private EventDefinitionDao eventDefinitionDao = new EventDefinitionDao();

	public EventsPacketType availableatlevel(Long userId, String securityToken) {
		EventsPacketType eventsPacketType = new EventsPacketType();
		EventsType eventsType = new EventsType();
		List<EventDefinitionEntity> events = eventDefinitionDao.getAll();
		eventsType.setEventDefinitionList(events);
		eventsPacketType.setEvents(eventsType);
		return eventsPacketType;
	}
}
