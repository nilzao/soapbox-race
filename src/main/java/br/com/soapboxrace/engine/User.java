package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.UserBO;
import br.com.soapboxrace.definition.ServerExceptions.EngineException;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.xmpp.IXmppSender;
import br.com.soapboxrace.xmpp.XmppFactory;

public class User extends Router {

	private UserBO userBO = new UserBO();

	public String getPermanentSession() throws EngineException {
		Long userId = Long.valueOf(getHeader("userId"));
		checkSecurityToken();
		// first 16 token chars used to login xmpp server
		String tokenText = "1234567890123456" + shuffleString(getSecureRandomText());
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
		IXmppSender xmppSenderInstance = XmppFactory.getXmppSenderInstance(Session.getXmppServerType());
		xmppSenderInstance.createUpdatePersona(Long.valueOf(getParam("personaId")), "1234567890123456");
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
		String tokenText = shuffleString(String.valueOf(System.currentTimeMillis()));
		createSessionEntry(Long.valueOf(result), tokenText);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<LoginData><UserId>");
		stringBuilder.append(result);
		stringBuilder.append("</UserId><LoginToken>");
		stringBuilder.append(tokenText);
		stringBuilder.append("</LoginToken></LoginData>");
		return stringBuilder.toString();
	}

	public String createUser() throws EngineException {
		String email = getParam("email");
		String passwordHash = getParam("password");
		if (!userBO.createUser(email, passwordHash).isEmpty())
			return authenticateUser();
		else
			throw new EngineException("Registration Error: Couldn't authenticate user.");
	}
}