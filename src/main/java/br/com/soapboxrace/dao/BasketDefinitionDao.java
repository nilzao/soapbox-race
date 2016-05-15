package br.com.soapboxrace.dao;

import java.util.List;

import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.BasketDefinitionEntity;

public class BasketDefinitionDao extends SoapboxDao {

	@Override
	public BasketDefinitionEntity findById(Long id) {
		BasketDefinitionEntity entity = (BasketDefinitionEntity) super.findById(BasketDefinitionEntity.class, id);
		return entity;
	}

	public List<BasketDefinitionEntity> find(BasketDefinitionEntity entity) {
		return null;
	}

}
