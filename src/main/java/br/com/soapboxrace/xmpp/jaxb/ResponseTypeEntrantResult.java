package br.com.soapboxrace.xmpp.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jaxb.util.MarshalXML;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseType", propOrder = { "routeEntrantResult" })
@XmlRootElement(name = "response")
public class ResponseTypeEntrantResult {

	@XmlElement(name = "RouteEntrantResult", required = true)
	protected RouteEntrantResultType routeEntrantResult;

	@XmlAttribute(name = "status")
	protected int status = 1;
	@XmlAttribute(name = "ticket")
	protected int ticket = 0;

	public RouteEntrantResultType getRouteEntrantResult() {
		return routeEntrantResult;
	}

	public void setRouteEntrantResult(RouteEntrantResultType routeEntrantResult) {
		this.routeEntrantResult = routeEntrantResult;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public static void main(String[] args) {
		RouteEntrantResultType routeEntrantResultType = new RouteEntrantResultType();
		routeEntrantResultType.setEventDurationInMilliseconds(150000);
		routeEntrantResultType.setEventSessionId(123456789);
		routeEntrantResultType.setFinishReason(22);
		routeEntrantResultType.setPersonaId(100);
		routeEntrantResultType.setRanking(1);
		routeEntrantResultType.setBestLapDurationInMilliseconds(150000);
		routeEntrantResultType.setTopSpeed(59.123F);
		ResponseTypeEntrantResult responseTypeEntrantResult = new ResponseTypeEntrantResult();
		responseTypeEntrantResult.setRouteEntrantResult(routeEntrantResultType);
		MessageType messageType = new MessageType();
		messageType.setBody(responseTypeEntrantResult);
		String marshal = MarshalXML.marshal(messageType);
		System.out.println(marshal);
	}

}
