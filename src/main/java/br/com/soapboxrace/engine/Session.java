package br.com.soapboxrace.engine;

public class Session extends Router {

	public String getChatInfo() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<chatServer>\n");
		stringBuilder.append("  <Rooms>\n");
		stringBuilder.append("    <chatRoom>\n");
		stringBuilder.append("      <channelCount>2</channelCount>\n");
		stringBuilder.append("      <longName>TXT_CHAT_LANG_ENGLISH</longName>\n");
		stringBuilder.append("      <shortName>EN</shortName>\n");
		stringBuilder.append("    </chatRoom>\n");
		stringBuilder.append("    <chatRoom>\n");
		stringBuilder.append("      <channelCount>2</channelCount>\n");
		stringBuilder.append("      <longName>TXT_CHAT_LANG_GERMAN</longName>\n");
		stringBuilder.append("      <shortName>DE</shortName>\n");
		stringBuilder.append("    </chatRoom>\n");
		stringBuilder.append("    <chatRoom>\n");
		stringBuilder.append("      <channelCount>2</channelCount>\n");
		stringBuilder.append("      <longName>TXT_CHAT_LANG_FRENCH</longName>\n");
		stringBuilder.append("      <shortName>FR</shortName>\n");
		stringBuilder.append("    </chatRoom>\n");
		stringBuilder.append("    <chatRoom>\n");
		stringBuilder.append("      <channelCount>2</channelCount>\n");
		stringBuilder.append("      <longName>TXT_CHAT_LANG_SPANISH</longName>\n");
		stringBuilder.append("      <shortName>ES</shortName>\n");
		stringBuilder.append("    </chatRoom>\n");
		stringBuilder.append("    <chatRoom>\n");
		stringBuilder.append("      <channelCount>2</channelCount>\n");
		stringBuilder.append("      <longName>TXT_CHAT_LANG_POLISH</longName>\n");
		stringBuilder.append("      <shortName>PL</shortName>\n");
		stringBuilder.append("    </chatRoom>\n");
		stringBuilder.append("    <chatRoom>\n");
		stringBuilder.append("      <channelCount>2</channelCount>\n");
		stringBuilder.append("      <longName>TXT_CHAT_LANG_BRAZILIANPORTUGUESE</longName>\n");
		stringBuilder.append("      <shortName>BR</shortName>\n");
		stringBuilder.append("    </chatRoom>\n");
		stringBuilder.append("    <chatRoom>\n");
		stringBuilder.append("      <channelCount>2</channelCount>\n");
		stringBuilder.append("      <longName>TXT_CHAT_LANG_RUSSIAN</longName>\n");
		stringBuilder.append("      <shortName>RU</shortName>\n");
		stringBuilder.append("    </chatRoom>\n");
		stringBuilder.append("    <chatRoom>\n");
		stringBuilder.append("      <channelCount>2</channelCount>\n");
		stringBuilder.append("      <longName>TXT_CHAT_LANG_GENERAL</longName>\n");
		stringBuilder.append("      <shortName>GN</shortName>\n");
		stringBuilder.append("    </chatRoom>\n");
		stringBuilder.append("  </Rooms>\n");
		stringBuilder.append("  <ip>127.0.0.1</ip>\n");
		stringBuilder.append("  <port>5222</port>\n");
		stringBuilder.append("  <prefix>nfsw</prefix>\n");
		stringBuilder.append("</chatServer>");
		String xmlTmp = stringBuilder.toString();
		return xmlTmp;
	}

}
