package br.com.soapboxrace.openfire;

import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class OpenFireSoapBoxCli {

	private OpenFireTalk xmppTalk;

	private static OpenFireSoapBoxCli instance;

	public static OpenFireSoapBoxCli getInstance() {
		if (instance == null) {
			instance = new OpenFireSoapBoxCli();
		}
		return instance;
	}

	private OpenFireSoapBoxCli() {
		HandShake xmppHandShake = new HandShake();
		xmppTalk = xmppHandShake.getXmppTalk();
	}

	public void send(String msg, Long to) {
		MessageType messageType = new MessageType();
		messageType.setToPersonaId(to);
		messageType.setBody(msg);
		messageType.setSubject(Router.calculateHash(to.toString().toCharArray(), msg.toCharArray()));
		String packet = MarshalXML.marshal(messageType);
		xmppTalk.write(packet);
	}

	public void send(Object object, Long to) {
		String responseXmlStr = MarshalXML.marshal(object);
		this.send(responseXmlStr, to);
	}

}