package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChatRoomType", propOrder = { "channelCount", "longName", "shortName" })
@XmlRootElement(name = "chatRoom")
public class ChatRoomType {

	@XmlElement(name = "channelCount", defaultValue = "10")
	protected Integer channelCount;
	@XmlElement(name = "longName")
	protected String longName;
	@XmlElement(name = "shortName")
	protected String shortName;

	public Integer getChannelCount() {
		return channelCount;
	}

	public void setChannelCount(Integer channelCount) {
		this.channelCount = channelCount;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public ChatRoomType() {}
	
	public ChatRoomType(Integer channelCount, String longName, String shortName) {
		this.channelCount = channelCount;
		this.longName = longName;
		this.shortName = shortName;
	}
}