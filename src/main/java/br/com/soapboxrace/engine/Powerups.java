package br.com.soapboxrace.engine;

import br.com.soapboxrace.xmpp.XmppSrv;

public class Powerups extends Router {

	public String activated() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<message from='nfsw.engine.engine@127.0.0.1/EA_Chat' id='JN_000000001' to='nfsw.");
		stringBuilder.append(getLoggedPersonaId());
		stringBuilder.append("@127.0.0.1'>");
		stringBuilder.append("<body>");
		stringBuilder.append("&lt;response status='1' ticket='0'&gt;");
		stringBuilder.append("&lt;PowerupActivated &gt;");
		stringBuilder.append("&lt;Count&gt;1&lt;/Count&gt;");
		stringBuilder.append("&lt;Id&gt;-1681514783&lt;/Id&gt;");
		stringBuilder.append("&lt;PersonaId&gt;");
		stringBuilder.append(getLoggedPersonaId());
		stringBuilder.append("&lt;/PersonaId&gt;");
		stringBuilder.append("&lt;TargetPersonaId&gt;0&lt;/TargetPersonaId&gt;");
		stringBuilder.append("&lt;/PowerupActivated&gt;&lt;/response&gt;");
		stringBuilder.append("</body>");
		stringBuilder.append("<subject>1</subject>");
		stringBuilder.append("</message>");
		String msg = stringBuilder.toString();
		XmppSrv.sendMsg(getLoggedPersonaId().intValue(), msg);
		return "";
	}
}
