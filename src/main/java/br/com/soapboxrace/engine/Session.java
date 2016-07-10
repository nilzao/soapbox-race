package br.com.soapboxrace.engine;

import br.com.soapboxrace.jaxb.ChatServerType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import static br.com.soapboxrace.definition.ChatRooms.getRooms;

public class Session extends Router {

	private static String xmppIp = "127.0.0.1";

	private static int xmppPort = 5222;

	private static String raceUdpIp = "127.0.0.1";

	private static int raceUdpPort = 9998;

	private static String freeRoamUdpIp = "127.0.0.1";

	private static int freeRoamUdpPort = 9999;

	private static String xmppServerType = "OpenFire";

	private static long currentMpSessionId = 10000L;

	public String getChatInfo() {
		ChatServerType chatServer = new ChatServerType();
		chatServer.setRooms(getRooms());
		chatServer.setIp(xmppIp);
		chatServer.setPort(xmppPort);
		return MarshalXML.marshal(chatServer);
	}

	public static String getXmppIp() {
		return xmppIp;
	}

	public static void setXmppIp(String xmppIp) {
		Session.xmppIp = xmppIp;
	}

	public static long getNextMpSessionId() {
		return currentMpSessionId++;
	}

	public static int getXmppPort() {
		return xmppPort;
	}

	public static void setXmppPort(int xmppPort) {
		Session.xmppPort = xmppPort;
	}

	public static String getRaceUdpIp() {
		return raceUdpIp;
	}

	public static void setRaceUdpIp(String raceUdpIp) {
		Session.raceUdpIp = raceUdpIp;
	}

	public static int getRaceUdpPort() {
		return raceUdpPort;
	}

	public static void setRaceUdpPort(int raceUdpPort) {
		Session.raceUdpPort = raceUdpPort;
	}

	public static String getFreeRoamUdpIp() {
		return freeRoamUdpIp;
	}

	public static void setFreeRoamUdpIp(String freeRoamUdpIp) {
		Session.freeRoamUdpIp = freeRoamUdpIp;
	}

	public static int getFreeRoamUdpPort() {
		return freeRoamUdpPort;
	}

	public static void setFreeRoamUdpPort(int freeRoamUdpPort) {
		Session.freeRoamUdpPort = freeRoamUdpPort;
	}

	public static String getXmppServerType() {
		return xmppServerType;
	}

	public static void setXmppServerType(String xmppServerType) {
		Session.xmppServerType = xmppServerType;
	}

}
