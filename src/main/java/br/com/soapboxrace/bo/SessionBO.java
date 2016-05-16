package br.com.soapboxrace.bo;

import br.com.soapboxrace.dao.SessionDao;
import br.com.soapboxrace.jpa.SessionEntity;

public class SessionBO {

	private SessionDao sessionDao = new SessionDao();

	public Long getLoggedPersonaId(String securityToken, Long userId) {
		SessionEntity sessionEntity = sessionDao.findByUserIdToken(userId, securityToken);
		return sessionEntity.getPersonaId();
	}

}
