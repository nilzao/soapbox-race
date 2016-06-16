package br.com.soapboxrace.openfire;

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
public class MessageType {

	@XmlElement(required = true)
	protected String body;
	protected int subject = 1;
	@XmlAttribute(name = "from")
	protected String from = "";
	@XmlAttribute(name = "id")
	protected String id = "JN_1234567";
	@XmlAttribute(name = "to")
	protected String to;

	public MessageType() {
		from = "nfsw.engine.engine@" + Session.getXmppIp();
	}

	public String getBody() {
		return body;
	}

	public void setBody(String value) {
		this.body = value;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int value) {
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
