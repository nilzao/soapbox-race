package br.com.soapboxrace.dao.factory;

import java.util.List;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jpa.OwnedCarEntity;

public interface IOwnedCarDao extends ISoapboxDao {

	public OwnedCarEntity findById(Long id);

	public List<OwnedCarEntity> findByIdPersona(Long idPersona);

	public void del(Long id);

}
