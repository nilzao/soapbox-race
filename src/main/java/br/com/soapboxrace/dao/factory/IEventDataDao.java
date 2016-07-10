package br.com.soapboxrace.dao.factory;

import java.util.List;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jpa.EventDataEntity;

public interface IEventDataDao extends ISoapboxDao {

	public EventDataEntity findById(Long id);

	public Long getNextSessionId();

	public List<EventDataEntity> getRacers(Long eventSessionId);

	public List<EventDataEntity> findByEventSessionId(Long eventSessionId);

	public EventDataEntity findByEventSessionIdAndPersonaId(Long eventSessionId, Long personaId);

	public List<EventDataEntity> findByEventId(Long eventId);

	public EventDataEntity save(EventDataEntity entity);
}
