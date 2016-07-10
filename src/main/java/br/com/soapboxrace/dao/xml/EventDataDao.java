package br.com.soapboxrace.dao.xml;

import java.util.List;

import br.com.soapboxrace.dao.factory.IEventDataDao;
import br.com.soapboxrace.jpa.EventDataEntity;

public class EventDataDao extends SoapboxDao implements IEventDataDao {

	@Override
	public EventDataEntity findById(Long id) {
		EventDataEntity entity = (EventDataEntity) super.findById(EventDataEntity.class, id);
		return entity;
	}

	public Long getNextSessionId() {
		return null;
	}

	public List<EventDataEntity> getRacers(Long eventSessionId) {
		return null;
	}

	public List<EventDataEntity> findByEventSessionId(Long eventSessionId) {
		return null;
	}

	public EventDataEntity findByEventSessionIdAndPersonaId(Long eventSessionId, Long personaId) {
		return null;
	}

	public List<EventDataEntity> findByEventId(Long eventId) {
		return null;
	}

	public EventDataEntity save(EventDataEntity entity) {
		return (EventDataEntity) super.save(entity);
	}
}
