package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.UserBO;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class User extends Router {

	private UserBO userBO = new UserBO();

	public String getPermanentSession() {
		Long userId = Long.valueOf(getHeader("userId"));
		String tokenText = shuffleString(getSecureRandomText());
		UserInfoType userInfo = userBO.getPermanentSession(userId, tokenText);
		setSessionEntry("SecurityToken", tokenText);
		createSessionEntry(userId, tokenText, getHttpAddress());
		return MarshalXML.marshal(userInfo);
	}

	public String secureLogout() {
		removeSessionEntry(Long.valueOf(getParam("userId")));
		return "";
	}

	public String secureLoginPersona() {
		setSessionEntry("PersonaId", Long.valueOf(getParam("personaId")));
		return "";
	}

	public String secureLogoutPersona() {
		setSessionEntry("PersonaId", 0L);
		return "";
	}

}