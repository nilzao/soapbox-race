package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.IEventDefinitionDao;
import br.com.soapboxrace.jaxb.EventsPacketType;
import br.com.soapboxrace.jaxb.EventsType;
import br.com.soapboxrace.jpa.EventDefinitionEntity;

public class EventsBO {

	private IEventDefinitionDao eventDefinitionDao = DaoFactory.getEventDefinitionDao();

	public EventsPacketType availableatlevel(Long userId, String securityToken) {
		EventsPacketType eventsPacketType = new EventsPacketType();
		EventsType eventsType = new EventsType();
		List<EventDefinitionEntity> events = eventDefinitionDao.getAll();
		eventsType.setEventDefinitionList(events);
		eventsPacketType.setEvents(eventsType);
		return eventsPacketType;
	}
}
