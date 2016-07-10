package br.com.soapboxrace.xmpp.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.engine.Session;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageType", propOrder = { "body", "subject" })
@XmlRootElement(name = "message")
public class XMPP_MessageType {

	@XmlElement(required = true)
	private String body;
	@XmlAttribute(name = "from")
	private String from = "";
	@XmlAttribute(name = "id")
	private String id = "JN_1234567";
	@XmlAttribute(name = "to")
	private String to;
	@XmlElement(required = true)
	private Long subject;

	public XMPP_MessageType() {
		from = "nfsw.engine.engine@" + Session.getXmppIp();
	}

	public String getBody() {
		return body;
	}

	public void setBody(String value) {
		this.body = value;
	}

	public long getSubject() {
		return subject;
	}

	public void setSubject(long value) {
		this.subject = value;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String value) {
		this.from = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String value) {
		this.to = value;
	}

	public void setToPersonaId(Long personaId) {
		this.to = "nfsw." + personaId.toString() + "@" + Session.getXmppIp();
	}

}
