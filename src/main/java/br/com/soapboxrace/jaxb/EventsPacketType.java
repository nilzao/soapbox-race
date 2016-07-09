package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventsPacketType", propOrder = { "events" })
@XmlRootElement(name = "EventsPacket")
public class EventsPacketType {

	@XmlElement(name = "Events", required = true)
	protected EventsType events;

	public EventsType getEvents() {
		return events;
	}

	public void setEvents(EventsType value) {
		this.events = value;
	}

}
