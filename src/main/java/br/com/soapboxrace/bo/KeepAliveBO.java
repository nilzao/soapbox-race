package br.com.soapboxrace.bo;

import java.util.Date;

import br.com.soapboxrace.dao.SessionDao;
import br.com.soapboxrace.jpa.SessionEntity;

public class KeepAliveBO {

	private SessionDao sessionDao = new SessionDao();

	public void keepAlive(long userId, String securityToken) {
		SessionEntity sessionEntity = sessionDao.findByUserIdToken(userId, securityToken);

		if (sessionEntity.getPersonaId() != 0) {
			Date expirationDate = new Date();
			long time = expirationDate.getTime();
			expirationDate.setTime(time + 300000L);
			sessionEntity.setExpiration(expirationDate);
			sessionDao.save(sessionEntity);
		}
	}

}
