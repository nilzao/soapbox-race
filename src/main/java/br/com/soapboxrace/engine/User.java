package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.UserBO;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class User extends Router {

	private UserBO userBO = new UserBO();

	public String getPermanentSession() {
		String securityToken = getHeader("securityToken");
		Long userId = Long.valueOf(getHeader("userId"));
		UserInfoType userInfo = userBO.getPermanentSession(userId, securityToken);	
		return MarshalXML.marshal(userInfo);
	}

	public String secureLogout() {
		removePersonaEntry();
		return "";
	}

	public String secureLoginPersona() {
		setPersonaEntry(Long.valueOf(getParam("personaId")));
		return "";
	}

	public String secureLogoutPersona() {
		setPersonaEntry(0L);
		return "";
	}

}