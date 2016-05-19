package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.UserBO;
import br.com.soapboxrace.definition.ServerExceptions.EngineException;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class User extends Router {

	private UserBO userBO = new UserBO();

	public String getPermanentSession() {
		String securityToken = getHeader("securityToken");
		Long userId = Long.valueOf(getHeader("userId"));
		UserInfoType userInfo = userBO.getPermanentSession(userId, securityToken);
		createSessionEntry(securityToken);
		return MarshalXML.marshal(userInfo);
	}

	public String secureLogout() {
		removeSessionEntry();
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

	public String authenticateUser() throws EngineException {
		return "";
	}

}