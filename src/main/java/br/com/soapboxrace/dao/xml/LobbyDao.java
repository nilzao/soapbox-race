package br.com.soapboxrace.dao.xml;

import java.util.Date;
import java.util.List;

import br.com.soapboxrace.dao.factory.ILobbyDao;
import br.com.soapboxrace.jpa.LobbyEntity;

public class LobbyDao extends SoapboxDao implements ILobbyDao {

	@Override
	public LobbyEntity findById(Long id) {
		LobbyEntity entity = (LobbyEntity) super.findById(LobbyEntity.class, id);
		return entity;
	}

	public List<LobbyEntity> findByEventStarted(Long eventId, Date dateNow, Date datePast) {
		return null;
	}

	public LobbyEntity save(LobbyEntity entity) {
		entity = (LobbyEntity) super.save(entity);
		return entity;
	}
}
