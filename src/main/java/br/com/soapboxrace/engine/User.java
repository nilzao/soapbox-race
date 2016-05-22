package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.UserBO;
import br.com.soapboxrace.definition.ServerExceptions.EngineException;
import br.com.soapboxrace.definition.UserLoginStatus;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class User extends Router {

	private UserBO userBO = new UserBO();

	public String getPermanentSession() throws EngineException {
		Long userId = Long.valueOf(getHeader("userId"));
		checkSecurityToken();
		String tokenText = shuffleString(getSecureRandomText());
		UserInfoType userInfo = userBO.getPermanentSession(userId, tokenText);
		setSessionEntry("SecurityToken", tokenText);
		return MarshalXML.marshal(userInfo);
	}

	public String secureLogout() throws EngineException {
		checkSecurityToken();
		removeSessionEntry(Long.valueOf(getParam("userId")));
		return "";
	}

	public String secureLoginPersona() throws EngineException {
		checkSecurityToken();
		setSessionEntry("PersonaId", Long.valueOf(getParam("personaId")));
		return "";
	}

	public String secureLogoutPersona() throws EngineException {
		checkSecurityToken();
		setSessionEntry("PersonaId", 0L);
		return "";
	}

	public String authenticateUser() throws EngineException {
		String email = getParam("email");
		String passwordHash = getParam("password");
		String result = userBO.authenticateUser(email, passwordHash);
		switch (result) {
			case UserLoginStatus.emailNotFound:
				throw new EngineException("Login Error: Email wasn't found!");
			case UserLoginStatus.incorrectPassword:
				throw new EngineException("Login Error: Incorrect email-password combination!");
			default:
				String tokenText = shuffleString(String.valueOf(System.currentTimeMillis()));
				createSessionEntry(Long.valueOf(result), tokenText);
				return String.format("<LoginData><UserId>%s</UserId><LoginToken>%s</LoginToken></LoginData>", result, tokenText);
		}
	}
}