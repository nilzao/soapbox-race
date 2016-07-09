package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jpa.EventDataEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APIEventDataType", propOrder = { "eventDataList", "count" })
@XmlRootElement(name = "ArrayOfEventData")
public class APIEventDataType {
	@XmlElement(name = "EventData", required = true, nillable = true)
	private List<EventDataEntity> eventDataList;
	@XmlElement(name = "Count", required = true)
	private Integer count;

	public List<EventDataEntity> getEventDataList() {
		return eventDataList;
	}

	public void setEventDataList(List<EventDataEntity> eventDataList) {
		this.eventDataList = eventDataList;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}