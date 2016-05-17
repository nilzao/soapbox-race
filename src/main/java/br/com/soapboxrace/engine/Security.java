package br.com.soapboxrace.engine;

public class Security extends Router {

	public String fraudConfig() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<FraudConfig>\n");
		stringBuilder.append("	<enabledBitField>12</enabledBitField>\n");
		stringBuilder.append("	<gameFileFreq>1000000</gameFileFreq>\n");
		stringBuilder.append("	<moduleFreq>360000</moduleFreq>\n");
		stringBuilder.append("	<startUpFreq>1000000</startUpFreq>\n");
		stringBuilder.append("	<userID>" + getUserId() + "</userID>\n");
		stringBuilder.append("</FraudConfig>");
		String xmlTmp = stringBuilder.toString();
		return xmlTmp;
	}

	public String generateWebToken() {
		return "";
	}

}