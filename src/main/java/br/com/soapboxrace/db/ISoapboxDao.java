package br.com.soapboxrace.db;

import java.util.List;

import br.com.soapboxrace.jpa.ISoapBoxEntity;

public interface ISoapboxDao {

	public ISoapBoxEntity save(ISoapBoxEntity entity);

	public void del(ISoapBoxEntity entity);

	public ISoapBoxEntity findById(Class<? extends ISoapBoxEntity> entityClass, Long id);

	public ISoapBoxEntity findById(Long id);

	public List<ISoapBoxEntity> find(ISoapBoxEntity entity);

}
