package br.com.soapboxrace.engine;

import br.com.soapboxrace.http.HttpSessionVO;

public class Session extends Router {

	private static long currentMpSessionId = 10000L;

	public String getChatInfo() {
		HttpSessionVO httpSessionVo = getHttpSessionVo(getUserId());
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
		stringBuilder.append(httpSessionVo.getXmppIpAddres());
		stringBuilder.append("</ip>\n");
		stringBuilder.append("  <port>5222</port>\n");
		stringBuilder.append("  <prefix>nfsw</prefix>\n");
		stringBuilder.append("</chatServer>");
		return stringBuilder.toString();
	}

	public static long getNextMpSessionId() {
		return currentMpSessionId++;
	}
}
