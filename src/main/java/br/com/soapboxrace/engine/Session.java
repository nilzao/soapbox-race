package br.com.soapboxrace.engine;

public class Session extends Router {

	private static String xmppIp = "127.0.0.1";

	private static String udpIp = "127.0.0.1";

	private static long currentMpSessionId = 10000L;

	public String getChatInfo() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<chatServer>\n");
		stringBuilder.append("  <Rooms>\n");
		stringBuilder.append("    <chatRoom>\n");
		stringBuilder.append("      <channelCount>2</channelCount>\n");
		stringBuilder.append("      <longName>TXT_CHAT_LANG_ENGLISH</longName>\n");
		stringBuilder.append("      <shortName>EN</shortName>\n");
		stringBuilder.append("    </chatRoom>\n");
		stringBuilder.append("  </Rooms>\n");
		stringBuilder.append("  <ip>");
		stringBuilder.append(xmppIp);
		stringBuilder.append("</ip>\n");
		stringBuilder.append("  <port>5222</port>\n");
		stringBuilder.append("  <prefix>nfsw</prefix>\n");
		stringBuilder.append("</chatServer>");
		return stringBuilder.toString();
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