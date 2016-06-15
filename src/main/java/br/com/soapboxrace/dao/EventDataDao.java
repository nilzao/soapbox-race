package br.com.soapboxrace.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.EventDataEntity;

public class EventDataDao extends SoapboxDao {

	@Override
	public EventDataEntity findById(Long id) {
		EventDataEntity entity = (EventDataEntity) super.findById(EventDataEntity.class, id);
		return entity;
	}
	
	public List<EventDataEntity> getRacers(Long eventSessionId) {
		EntityManager manager = getManager();
		TypedQuery<EventDataEntity> query = manager.createQuery("SELECT obj FROM EventDataEntity obj WHERE obj.id = :id",
				EventDataEntity.class);
		query.setParameter("id", eventSessionId);
		List<EventDataEntity> eventDataList = null;
		if (!query.getResultList().isEmpty())
			eventDataList = query.getResultList();
		return eventDataList;
	}

	public List<EventDataEntity> findByEventId(Long eventId) {
		EntityManager manager = getManager();
		TypedQuery<EventDataEntity> query = manager.createQuery("SELECT obj FROM EventDataEntity obj WHERE obj.eventId = :eventId",
				EventDataEntity.class);
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