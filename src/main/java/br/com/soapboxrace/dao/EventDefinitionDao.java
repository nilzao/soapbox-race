package br.com.soapboxrace.dao;

import java.util.List;

import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.EventDefinitionEntity;

public class EventDefinitionDao extends SoapboxDao {

	@Override
	public EventDefinitionEntity findById(Long id) {
		EventDefinitionEntity entity = (EventDefinitionEntity) super.findById(EventDefinitionEntity.class, id);
		return entity;
	}

	public List<EventDefinitionEntity> getAll() {
		return null;
	}

}
