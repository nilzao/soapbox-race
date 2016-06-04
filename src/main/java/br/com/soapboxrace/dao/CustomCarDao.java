package br.com.soapboxrace.dao;

import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.CustomCarEntity;

public class CustomCarDao extends SoapboxDao {

	@Override
	public CustomCarEntity findById(Long id) {
		CustomCarEntity entity = (CustomCarEntity) super.findById(CustomCarEntity.class, id);
		return entity;
	}

}
