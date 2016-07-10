package br.com.soapboxrace.dao.xml;

import java.util.List;

import br.com.soapboxrace.dao.factory.IOwnedCarDao;
import br.com.soapboxrace.jpa.OwnedCarEntity;

public class OwnedCarDao extends SoapboxDao implements IOwnedCarDao {

	@Override
	public OwnedCarEntity findById(Long id) {
		OwnedCarEntity entity = (OwnedCarEntity) super.findById(OwnedCarEntity.class, id);
		return entity;
	}

	public List<OwnedCarEntity> findByIdPersona(Long idPersona) {
		return null;
	}

	public void del(Long id) {
		OwnedCarEntity entity = findById(id);
		super.del(entity);
	}
}
