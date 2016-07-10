package br.com.soapboxrace.dao.factory;

import java.util.Date;
import java.util.List;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jpa.LobbyEntity;

public interface ILobbyDao extends ISoapboxDao {

	public LobbyEntity findById(Long id);

	public List<LobbyEntity> findByEventStarted(Long eventId, Date dateNow, Date datePast);

	public LobbyEntity save(LobbyEntity entity);

}
