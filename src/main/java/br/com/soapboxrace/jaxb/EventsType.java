package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import br.com.soapboxrace.jpa.EventDefinitionEntity;

@XmlAccessorType(XmlAccessType.FIELD)
public class EventsType {

	@XmlElement(name = "EventDefinition", required = true)
	protected List<EventDefinitionEntity> eventDefinition;

	public List<EventDefinitionEntity> getEventDefinitionList() {
		return eventDefinition;
	}

	public void setEventDefinitionList(List<EventDefinitionEntity> EventDefinitionList) {
		this.eventDefinition = EventDefinitionList;
	}
}
