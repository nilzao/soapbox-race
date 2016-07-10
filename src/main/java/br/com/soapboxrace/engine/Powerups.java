package br.com.soapboxrace.engine;

import br.com.soapboxrace.xmpp.IXmppSender;
import br.com.soapboxrace.xmpp.XmppFactory;
import br.com.soapboxrace.xmpp.jaxb.XMPP_PowerupActivatedType;
import br.com.soapboxrace.xmpp.jaxb.XMPP_ResponseTypePowerupActivated;

public class Powerups extends Router {
	private Long getPowerupHash() {
		long powerupHash = 0L;
		String[] targetSplitted = getTarget().split("/");
		if (targetSplitted.length == 6) {
			powerupHash = Long.valueOf(targetSplitted[5]);
		}
		return powerupHash;
	}

	public String activated() {
		XMPP_ResponseTypePowerupActivated powerupActivatedResponse = new XMPP_ResponseTypePowerupActivated();
		XMPP_PowerupActivatedType powerupActivated = new XMPP_PowerupActivatedType();
		powerupActivated.setId(getPowerupHash());
		powerupActivated.setTargetPersonaId(Long.valueOf(getParam("targetId")));
		powerupActivated.setPersonaId(getLoggedPersonaId());
		powerupActivatedResponse.setPowerupActivated(powerupActivated);

		for (String receiver : getParam("receivers").split("-")) {
			Long receiverPersonaId = Long.valueOf(receiver);
			if (receiverPersonaId > 10) {
				IXmppSender xmppSenderInstance = XmppFactory.getXmppSenderInstance(Session.getXmppServerType());
				xmppSenderInstance.send(powerupActivatedResponse, receiverPersonaId);
			}
		}
		return "";
	}
}