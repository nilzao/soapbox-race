package br.com.soapboxrace.dao.db;

import br.com.soapboxrace.dao.factory.ICustomCarDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.CustomCarEntity;

public class CustomCarDao extends SoapboxDao implements ICustomCarDao {

	@Override
	public CustomCarEntity findById(Long id) {
		CustomCarEntity entity = (CustomCarEntity) super.findById(CustomCarEntity.class, id);
		return entity;
	}

}
