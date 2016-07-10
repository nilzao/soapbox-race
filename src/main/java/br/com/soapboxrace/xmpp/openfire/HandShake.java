package br.com.soapboxrace.xmpp.openfire;

import br.com.soapboxrace.engine.Session;

public class HandShake {

	private OpenFireTalk openFireTalk;

	public HandShake() {
		String xmppIp = Session.getXmppIp();
		int xmppPort = Session.getXmppPort();

		SocketClient socketClient = new SocketClient(xmppIp, xmppPort);
		socketClient.send("<?xml version='1.0' ?><stream:stream to='" + xmppIp
				+ "' xmlns='jabber:client' xmlns:stream='http://etherx.jabber.org/streams' version='1.0' xml:lang='en'>");
		String receive = socketClient.receive();
		while (!receive.contains("</stream:features>")) {
			receive = socketClient.receive();
		}
		socketClient.send("<starttls xmlns='urn:ietf:params:xml:ns:xmpp-tls'/>");
		socketClient.receive();
		openFireTalk = new OpenFireTalk(socketClient.getSocket());
		TlsWrapper.wrapXmppTalk(openFireTalk);
		openFireTalk.write("<?xml version='1.0' ?><stream:stream to='" + xmppIp
				+ "' xmlns='jabber:client' xmlns:stream='http://etherx.jabber.org/streams' version='1.0' xml:lang='en'>");
		openFireTalk.write("<iq id='EA-Chat-1' type='get'><query xmlns='jabber:iq:auth'><username>nfsw.engine.engine</username></query></iq>");
		openFireTalk.read();
		openFireTalk.write(
				"<iq xml:lang='en' id='EA-Chat-2' type='set'><query xmlns='jabber:iq:auth'><username>nfsw.engine.engine</username><password>1234567890123456</password><resource>EA_Chat</resource><clientlock xmlns='http://www.jabber.com/schemas/clientlocking.xsd' id='900'>57b8914527daff651df93557aef0387e5aa60fae</clientlock></query></iq>");
		openFireTalk.read();
		openFireTalk.write("<presence><show>chat</show><status>Online</status><priority>0</priority></presence>");
		openFireTalk.write(" ");
		openFireTalk.write("<presence to='channel.EN__1@conference." + xmppIp + "/nfsw.engine.engine'/>");
		openFireTalk.startReader();
	}

	public OpenFireTalk getXmppTalk() {
		return openFireTalk;
	}

}
