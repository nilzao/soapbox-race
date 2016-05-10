package br.com.soapboxrace.engine;

public class Crypto extends Router {

	public String cryptoticket() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<ClientServerCryptoTicket>\n");
		stringBuilder.append("<CryptoTicket>AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=</CryptoTicket>\n");
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
		stringBuilder.append("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		stringBuilder.append("</CryptoTicket>\n");
		stringBuilder.append("<SessionKey>AAAAAAAAAAAAAAAAAAAAAA==</SessionKey>\n");
		stringBuilder.append("<TicketIv>AAAAAAAAAAAAAAAAAAAAAA==</TicketIv>\n");
		stringBuilder.append("</UdpRelayCryptoTicket>");
		String relayCrypto = stringBuilder.toString();
		return relayCrypto;
	}
}
