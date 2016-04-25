package br.com.soapboxrace.engine;

public class Session extends Router {

	private static String ip = "127.0.0.1";

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
		stringBuilder.append(ip);
		stringBuilder.append("</ip>\n");
		stringBuilder.append("  <port>5222</port>\n");
		stringBuilder.append("  <prefix>nfsw</prefix>\n");
		stringBuilder.append("</chatServer>");
		return stringBuilder.toString();
	}

	public static void setIp(String ip) {
		Session.ip = ip;
	}

	public static String getIp() {
		return ip;
	}

}
