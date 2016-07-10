package br.com.soapboxrace.dao.xml;

import java.util.List;

import br.com.soapboxrace.dao.factory.IEventDefinitionDao;
import br.com.soapboxrace.jaxb.EventsPacketType;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
import br.com.soapboxrace.jpa.EventDefinitionEntity;

public class EventDefinitionDao extends SoapboxDao implements IEventDefinitionDao {

	@Override
	public EventDefinitionEntity findById(Long id) {
		EventDefinitionEntity entity = (EventDefinitionEntity) super.findById(EventDefinitionEntity.class, id);
		return entity;
	}

	public List<EventDefinitionEntity> getAll() {
		String readFile = readFile("events/availableatlevel.xml");
		EventsPacketType eventsPacketType = (EventsPacketType) UnmarshalXML.unMarshal(readFile, new EventsPacketType());
		return eventsPacketType.getEvents().getEventDefinitionList();
	}

}
