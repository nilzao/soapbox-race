package br.com.soapboxrace.engine;

public class Crypto extends Router {

	public String cryptoticket() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<ClientServerCryptoTicket>\n");
		stringBuilder.append("	<CryptoTicket>AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=</CryptoTicket>\n");
		stringBuilder.append("	<SessionKey>cLdPzTv4UdUvFUIJKHM5eQ==</SessionKey>\n");
		stringBuilder.append("	<TicketIv>sO19FmszN5ii9P3fbob0Xg==</TicketIv>\n");
		stringBuilder.append("</ClientServerCryptoTicket>");
		String cryptoTicket = stringBuilder.toString();
		return cryptoTicket;
	}

	public String relaycryptoticket() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<UdpRelayCryptoTicket>");
		stringBuilder.append("<CryptoTicket>IZcr3NRlW8Qwj8xyqN0DHrjZC8nOf6zRPJLdwVK8gb0E8fWCBZ5c5B+IvPumXOoI</CryptoTicket>");
		stringBuilder.append("<SessionKey>dIgH9XNdV95WVN1EyXX7wQ==</SessionKey>");
		stringBuilder.append("<TicketIv>/mSFI7F6r55DLF1gQXD9ZA==</TicketIv>");
		stringBuilder.append("</UdpRelayCryptoTicket>");
		String relayCrypto = stringBuilder.toString();
		return relayCrypto;
	}
}
