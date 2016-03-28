package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.KeepAliveBO;

public class KeepAlive extends Router {

	KeepAliveBO keepAliveBO = new KeepAliveBO();

	public void keepSession() {
		if (getTarget().contains("GetPermanentSession")) {
			return;
		}
		String securityToken = getSecurityToken();
		Long userId = getUserId();
		keepAliveBO.keepAlive(userId, securityToken);
	}
}
