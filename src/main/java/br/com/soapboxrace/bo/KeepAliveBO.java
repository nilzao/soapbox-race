package br.com.soapboxrace.bo;

import java.util.Date;
import java.util.List;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jpa.SessionEntity;

public class KeepAliveBO {

	private ConnectionDB connectionDB = new ConnectionDB();

	public void keepAlive(long userId, String securityToken) {
		SessionEntity sessionEntity = new SessionEntity();
		sessionEntity.setToken(securityToken);
		sessionEntity.setUserId(userId);

		List<?> find = connectionDB.find(sessionEntity);
		sessionEntity = (SessionEntity) find.get(0);

		if (sessionEntity.getPersonaId() != 0) {
			Date expirationDate = new Date();
			long time = expirationDate.getTime();
			expirationDate.setTime(time + 300000L);
			sessionEntity.setExpiration(expirationDate);
			connectionDB.merge(sessionEntity);
		}
	}

}
