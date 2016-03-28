package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.UserBO;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class User extends Router {

	private UserBO userBO = new UserBO();

	Long getPersonaId() {
		return Long.valueOf(getParam("personaId"));
	}

	public String getPermanentSession() {
		String securityToken = getSecurityToken();
		Long userId = getUserId();
		UserInfoType userInfo = userBO.getPermanentSession(userId, securityToken);
		return MarshalXML.marshal(userInfo);
	}

	public String secureLogout() {
		return "";
	}

	public String secureLoginPersona() {
		Long personaId = getPersonaId();
		super.setLoggedPersonaId(personaId);
		return "";
	}

	public String secureLogoutPersona() {
		return "";
	}

}
