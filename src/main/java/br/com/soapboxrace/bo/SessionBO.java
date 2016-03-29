package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jpa.SessionEntity;

public class SessionBO {

	private ConnectionDB connectionDB = new ConnectionDB();

	public Long getLoggedPersonaId(String securityToken, Long userId) {
		SessionEntity sessionEntity = new SessionEntity();
		sessionEntity.setToken(securityToken);
		sessionEntity.setUserId(userId);

		List<?> find = connectionDB.find(sessionEntity);
		sessionEntity = (SessionEntity) find.get(0);
		return sessionEntity.getPersonaId();
	}

}
