package br.com.soapboxrace.engine;

import br.com.soapboxrace.xmpp.XmppSrv;

public class Powerups extends Router {

	public String activated() {
		String msg = "<message from='nfsw.engine.engine@127.0.0.1/EA_Chat' id='JN_000000001' to='nfsw.102@127.0.0.1'><body>&lt;response status='1' ticket='0'&gt;&lt;PowerupActivated xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.datacontract.org/2004/07/Victory.DataLayer.Serialization.PowerUp\"&gt;&lt;Count&gt;1&lt;/Count&gt;&lt;Id&gt;-1681514783&lt;/Id&gt;&lt;PersonaId&gt;102&lt;/PersonaId&gt;&lt;TargetPersonaId&gt;0&lt;/TargetPersonaId&gt;&lt;/PowerupActivated&gt;&lt;/response&gt;</body><subject>1</subject></message>";
		XmppSrv.sendMsg(getLoggedPersonaId().intValue(), msg);
		return "";
	}
}
