package br.com.soapboxrace.dao;

import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.SessionEntity;

public class SessionDao extends SoapboxDao {

	@Override
	public SessionEntity findById(Long id) {
		SessionEntity entity = (SessionEntity) super.findById(SessionEntity.class, id);
		return entity;
	}

	public SessionEntity findByUserIdToken(Long userId, String token) {
		// SessionEntity sessionEntity = new SessionEntity();
		// sessionEntity.setToken(securityToken);
		// sessionEntity.setUserId(userId);
		//
		// List<?> find = connectionDB.find(sessionEntity);
		// sessionEntity = (SessionEntity) find.get(0);
		// return sessionEntity.getPersonaId();
		return null;
	}

}
