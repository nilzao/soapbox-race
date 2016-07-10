package br.com.soapboxrace.dao.xml;

import java.util.List;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jpa.ISoapBoxEntity;

public abstract class SoapboxDao implements ISoapboxDao {

	@Override
	public ISoapBoxEntity save(ISoapBoxEntity entity) {
		return entity;
	}

	@Override
	public void del(ISoapBoxEntity entity) {

	}

	public ISoapBoxEntity findById(Class<? extends ISoapBoxEntity> entityClass, Long id) {
		return null;
	}

	@Override
	public List<ISoapBoxEntity> find(ISoapBoxEntity entity) {
		return null;
	}

}
