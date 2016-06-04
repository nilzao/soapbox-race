package br.com.soapboxrace.xmpp.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CryptoTicketsType", propOrder = { "p2PCryptoTicket" })
public class CryptoTicketsType {

	@XmlElement(name = "P2PCryptoTicket")
	protected List<P2PCryptoTicketType> p2PCryptoTicket;

	public List<P2PCryptoTicketType> getP2PCryptoTicket() {
		if (p2PCryptoTicket == null) {
			p2PCryptoTicket = new ArrayList<P2PCryptoTicketType>();
		}
		return this.p2PCryptoTicket;
	}

}
