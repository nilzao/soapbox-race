package br.com.soapboxrace.engine;

import br.com.soapboxrace.jaxb.ChatServerType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import static br.com.soapboxrace.definition.ChatRooms.getRooms;

public class Session extends Router {

	private static String xmppIp = "127.0.0.1";

	private static String udpIp = "127.0.0.1";

	private static long currentMpSessionId = 10000L;

	public String getChatInfo() {
		ChatServerType chatServer = new ChatServerType();
		chatServer.setRooms(getRooms());
		chatServer.setIp(xmppIp);
		return MarshalXML.marshal(chatServer);
	}

	public static String getXmppIp() {
		return xmppIp;
	}

	public static void setXmppIp(String xmppIp) {
		Session.xmppIp = xmppIp;
	}

	public static String getUdpIp() {
		return udpIp;
	}

	public static void setUdpIp(String udpIp) {
		Session.udpIp = udpIp;
	}

	public static long getNextMpSessionId() {
		return currentMpSessionId++;
	}
}