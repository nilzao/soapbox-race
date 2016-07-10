package br.com.soapboxrace.dao.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.soapboxrace.dao.factory.IEventDataDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.EventDataEntity;

public class EventDataDao extends SoapboxDao implements IEventDataDao {

	@Override
	public EventDataEntity findById(Long id) {
		EventDataEntity entity = (EventDataEntity) super.findById(EventDataEntity.class, id);
		return entity;
	}

	public Long getNextSessionId() {
		EntityManager manager = getManager();
		CriteriaBuilder qb = manager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		Root<EventDataEntity> root = cq.from(EventDataEntity.class);
		cq.select(qb.max(root.get("eventSessionId")));
		Object queryResult = manager.createQuery(cq).getSingleResult();
		if (queryResult == null)
			queryResult = 0L;
		Long nextSessionId = (Long) queryResult + 1L;
		return nextSessionId;
	}

	public List<EventDataEntity> getRacers(Long eventSessionId) {
		EntityManager manager = getManager();
		TypedQuery<EventDataEntity> query = manager.createQuery("SELECT obj FROM EventDataEntity obj WHERE obj.eventSessionId = :eventSessionId",
				EventDataEntity.class);
		query.setParameter("eventSessionId", eventSessionId);
		List<EventDataEntity> eventDataList = null;
		if (!query.getResultList().isEmpty())
			eventDataList = query.getResultList();
		return eventDataList;
	}

	public List<EventDataEntity> findByEventSessionId(Long eventSessionId) {
		EntityManager manager = getManager();
		TypedQuery<EventDataEntity> query = manager.createQuery("SELECT obj FROM EventDataEntity obj WHERE obj.eventSessionId = :eventSessionId",
				EventDataEntity.class);
		query.setParameter("eventSessionId", eventSessionId);
		List<EventDataEntity> eventDataEntityList = null;
		if (!query.getResultList().isEmpty())
			eventDataEntityList = query.getResultList();
		return eventDataEntityList;
	}

	public EventDataEntity findByEventSessionIdAndPersonaId(Long eventSessionId, Long personaId) {
		EntityManager manager = getManager();
		TypedQuery<EventDataEntity> query = manager.createQuery(
				"SELECT obj FROM EventDataEntity obj WHERE obj.eventSessionId = :eventSessionId AND obj.personaId = :personaId", EventDataEntity.class);
		query.setParameter("eventSessionId", eventSessionId);
		query.setParameter("personaId", personaId);
		EventDataEntity eventDataEntity = null;
		if (!query.getResultList().isEmpty())
			eventDataEntity = query.getSingleResult();
		return eventDataEntity;
	}

	public List<EventDataEntity> findByEventId(Long eventId) {
		EntityManager manager = getManager();
		TypedQuery<EventDataEntity> query = manager.createQuery("SELECT obj FROM EventDataEntity obj WHERE obj.eventId = :eventId", EventDataEntity.class);
		query.setParameter("eventId", eventId);
		List<EventDataEntity> eventDataList = null;
		if (!query.getResultList().isEmpty())
			eventDataList = query.getResultList();
		return eventDataList;
	}

	public EventDataEntity save(EventDataEntity entity) {
		return (EventDataEntity) super.save(entity);
	}
}
