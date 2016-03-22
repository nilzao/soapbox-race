package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.EventsBO;
import br.com.soapboxrace.jaxb.EventsPacketType;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class Events extends Router {

	EventsBO eventsBO = new EventsBO();

	public String availableatlevel() {
		EventsPacketType availableatlevel = eventsBO.availableatlevel();
		return MarshalXML.marshal(availableatlevel);
	}

	public String gettreasurehunteventsession() {
		return "<TreasureHuntEventSession/>";
	}

	public String instancedaccolades() {
		return "";
	}
}
