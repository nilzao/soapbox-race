package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChatServerType", propOrder = { "rooms", "ip", "port", "prefix" })
@XmlRootElement(name = "chatServer")
public class ChatServerType {

	@XmlElement(name = "chatRoom", type = ChatRoomType.class)
	@XmlElementWrapper(name = "Rooms", required = true)
	protected List<ChatRoomType> rooms;

	@XmlElement(name = "ip", required = true)
	protected String ip;

	@XmlElement(name = "port", required = true)
	protected int port = 5222;
	@XmlElement(name = "prefix", required = true)
	protected String prefix = "nfsw";

	public List<ChatRoomType> getRooms() {
		return rooms;
	}

	public void setRooms(List<ChatRoomType> rooms) {
		this.rooms = rooms;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}