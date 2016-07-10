package br.com.soapboxrace.xmpp;

import br.com.soapboxrace.xmpp.offline.XmppSrv;
import br.com.soapboxrace.xmpp.openfire.OpenFireSoapBoxCli;

public class XmppFactory {

	private static IXmppSender instance;

	public static IXmppSender getXmppSenderInstance(String xmppServerType) {
		if (instance == null) {
			instance = newXmppSender(xmppServerType);
		}
		return instance;
	}

	private static IXmppSender newXmppSender(String xmppServerType) {
		if ("OpenFire".equals(xmppServerType)) {
			return new OpenFireSoapBoxCli();
		} else if ("Offline".equals(xmppServerType)) {
			return new XmppSrv();
		}
		return null;
	}

}
