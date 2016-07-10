package br.com.soapboxrace.dao.db;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;

import br.com.soapboxrace.dao.factory.ILobbyDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.EventDefinitionEntity;
import br.com.soapboxrace.jpa.LobbyEntity;

public class LobbyDao extends SoapboxDao implements ILobbyDao {

	@Override
	public LobbyEntity findById(Long id) {
		LobbyEntity entity = (LobbyEntity) super.findById(LobbyEntity.class, id);
		return entity;
	}

	public List<LobbyEntity> findByEventStarted(Long eventId, Date dateNow, Date datePast) {
		EntityManager manager = getManager();
		TypedQuery<LobbyEntity> query = manager.createQuery(
				"SELECT obj FROM LobbyEntity obj WHERE obj.event = :event and obj.lobbyDateTimeStart between :dateTime1 and :dateTime2", LobbyEntity.class);
		EventDefinitionEntity eventEntity = new EventDefinitionEntity();
		eventEntity.setId(eventId);
		query.setParameter("event", eventEntity);
		query.setParameter("dateTime1", datePast);
		query.setParameter("dateTime2", dateNow);
		List<LobbyEntity> lobbys = query.getResultList();
		for (LobbyEntity lobbyEntity : lobbys) {
			Hibernate.initialize(lobbyEntity.getEntrants());
		}
		return lobbys;
	}

	public LobbyEntity save(LobbyEntity entity) {
		entity = (LobbyEntity) super.save(entity);
		return entity;
	}
}
