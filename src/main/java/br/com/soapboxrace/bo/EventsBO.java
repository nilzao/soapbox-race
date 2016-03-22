package br.com.soapboxrace.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jaxb.EventsPacketType;
import br.com.soapboxrace.jaxb.EventsType;
import br.com.soapboxrace.jpa.EventDefinitionEntity;

public class EventsBO {

	private ConnectionDB connectDb = new ConnectionDB();

	public EventsPacketType availableatlevel() {
		EventsPacketType eventsPacketType = new EventsPacketType();
		EventsType eventsType = new EventsType();
		List<?> events = connectDb.find(new EventDefinitionEntity());
		List<EventDefinitionEntity> eventList = new ArrayList<EventDefinitionEntity>();
		for (Object object : events) {
			eventList.add((EventDefinitionEntity) object);
		}
		eventsType.setEventDefinitionList(eventList);
		eventsPacketType.setEvents(eventsType);
		return eventsPacketType;
	}
}
