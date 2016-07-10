package br.com.soapboxrace.dao.factory;

import java.util.List;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jpa.EventDefinitionEntity;

public interface IEventDefinitionDao extends ISoapboxDao {

	public EventDefinitionEntity findById(Long id);

	public List<EventDefinitionEntity> getAll();

}
