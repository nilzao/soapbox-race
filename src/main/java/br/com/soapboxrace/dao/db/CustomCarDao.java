package br.com.soapboxrace.dao.db;

import br.com.soapboxrace.dao.factory.IEventDataDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.CustomCarEntity;

public class CustomCarDao extends SoapboxDao implements IEventDataDao {

	@Override
	public CustomCarEntity findById(Long id) {
		CustomCarEntity entity = (CustomCarEntity) super.findById(CustomCarEntity.class, id);
		return entity;
	}

}
