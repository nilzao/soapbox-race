package br.com.soapboxrace.engine;

import java.nio.ByteBuffer;
import java.util.Base64;

public class Crypto extends Router {

	public String cryptoticket() {
		byte[] helloPacket = { 10, 11, 12, 13 };
		int personaId = getHttpSessionVo(getUserId()).getPersonaId().intValue();
		ByteBuffer byteBuffer = ByteBuffer.allocate(32);
		byteBuffer.put(helloPacket);
		byteBuffer.putInt(personaId);
		byte[] cryptoTicketBytes = byteBuffer.array();
		String cryptoTicketBase64 = Base64.getEncoder().encodeToString(cryptoTicketBytes);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<ClientServerCryptoTicket>\n");
		stringBuilder.append("<CryptoTicket>");
		stringBuilder.append(cryptoTicketBase64);
		stringBuilder.append("</CryptoTicket>\n");
		stringBuilder.append("<SessionKey>AAAAAAAAAAAAAAAAAAAAAA==</SessionKey>\n");
		stringBuilder.append("<TicketIv>AAAAAAAAAAAAAAAAAAAAAA==</TicketIv>\n");
		stringBuilder.append("</ClientServerCryptoTicket>");
		String cryptoTicket = stringBuilder.toString();
		return cryptoTicket;
	}

	public String relaycryptoticket() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<UdpRelayCryptoTicket>");
		stringBuilder.append("<CryptoTicket>");
		stringBuilder.append(getHttpSessionVo(getUserId()).getRelayCryptoTicket());
		stringBuilder.append("</CryptoTicket>\n");
		stringBuilder.append("<SessionKey>AAAAAAAAAAAAAAAAAAAAAA==</SessionKey>\n");
		stringBuilder.append("<TicketIv>AAAAAAAAAAAAAAAAAAAAAA==</TicketIv>\n");
		stringBuilder.append("</UdpRelayCryptoTicket>");
		String relayCrypto = stringBuilder.toString();
		return relayCrypto;
	}
}
