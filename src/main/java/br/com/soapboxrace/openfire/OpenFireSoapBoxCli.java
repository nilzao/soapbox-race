package br.com.soapboxrace.openfire;

import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.xmpp.IXmppSender;

public class OpenFireSoapBoxCli implements IXmppSender {

	private OpenFireTalk xmppTalk;

	public OpenFireSoapBoxCli() {
		HandShake xmppHandShake = new HandShake();
		xmppTalk = xmppHandShake.getXmppTalk();
	}

	public void send(String msg, Long to) {
		MessageType messageType = new MessageType();
		messageType.setToPersonaId(to);
		messageType.setBody(msg);
		messageType.setSubject(Router.calculateHash(messageType.getTo().toCharArray(), msg.toCharArray()));
		String packet = MarshalXML.marshal(messageType);
		xmppTalk.write(packet);
	}

	public void send(Object object, Long to) {
		String responseXmlStr = MarshalXML.marshal(object);
		this.send(responseXmlStr, to);
	}

}
