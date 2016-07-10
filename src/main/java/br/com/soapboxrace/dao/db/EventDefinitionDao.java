package br.com.soapboxrace.dao.db;

import java.util.ArrayList;
import java.util.List;

import br.com.soapboxrace.dao.factory.IEventDefinitionDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.EventDefinitionEntity;
import br.com.soapboxrace.jpa.ISoapBoxEntity;

public class EventDefinitionDao extends SoapboxDao implements IEventDefinitionDao {

	@Override
	public EventDefinitionEntity findById(Long id) {
		EventDefinitionEntity entity = (EventDefinitionEntity) super.findById(EventDefinitionEntity.class, id);
		return entity;
	}

	public List<EventDefinitionEntity> getAll() {
		List<ISoapBoxEntity> find = super.find(new EventDefinitionEntity());
		ArrayList<EventDefinitionEntity> eventDefinitionList = new ArrayList<EventDefinitionEntity>();
		for (ISoapBoxEntity eventDefTmp : find) {
			eventDefinitionList.add((EventDefinitionEntity) eventDefTmp);
		}
		return eventDefinitionList;
	}

}
