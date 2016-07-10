package br.com.soapboxrace.dao.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;

import br.com.soapboxrace.dao.factory.IOwnedCarDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.PersonaEntity;

public class OwnedCarDao extends SoapboxDao implements IOwnedCarDao {

	@Override
	public OwnedCarEntity findById(Long id) {
		OwnedCarEntity entity = (OwnedCarEntity) super.findById(OwnedCarEntity.class, id);
		return entity;
	}

	public List<OwnedCarEntity> findByIdPersona(Long idPersona) {
		EntityManager manager = getManager();
		TypedQuery<OwnedCarEntity> query = manager.createQuery("SELECT obj FROM OwnedCarEntity obj WHERE obj.persona = :persona order by obj.id",
				OwnedCarEntity.class);
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setId(idPersona);
		query.setParameter("persona", personaEntity);
		List<OwnedCarEntity> ownedCars = query.getResultList();
		for (OwnedCarEntity ownedCarEntity : ownedCars) {
			// @Convert performance problem:
			Hibernate.initialize(ownedCarEntity.getCustomCar());
		}
		return ownedCars;
	}

	public void del(Long id) {
		OwnedCarEntity entity = findById(id);
		super.del(entity);
	}
}
