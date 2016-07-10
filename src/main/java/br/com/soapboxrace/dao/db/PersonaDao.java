package br.com.soapboxrace.dao.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.ILobbyEntrantDao;
import br.com.soapboxrace.dao.factory.IPersonaDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.ISoapBoxEntity;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.UserEntity;

public class PersonaDao extends SoapboxDao implements IPersonaDao {

	@Override
	public PersonaEntity findById(Long id) {
		PersonaEntity entity = (PersonaEntity) super.findById(PersonaEntity.class, id);
		return entity;
	}

	public boolean existsByName(String name) {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setName(name);
		List<ISoapBoxEntity> find = find(personaEntity);
		if (find.size() > 0) {
			return true;
		}
		return false;
	}

	public PersonaEntity save(PersonaEntity entity) {
		return (PersonaEntity) super.save(entity);
	}

	public void del(PersonaEntity entity) {
		ILobbyEntrantDao lobbyEntrantDao = DaoFactory.getLobbyEntrantDao();
		lobbyEntrantDao.delByPersona(entity);
		super.del(entity);
	}

	public List<PersonaEntity> findByUserId(Long userId) {
		EntityManager manager = getManager();
		TypedQuery<PersonaEntity> query = manager.createQuery("SELECT obj FROM PersonaEntity obj WHERE obj.user = :user", PersonaEntity.class);
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);
		query.setParameter("user", userEntity);
		List<PersonaEntity> personaList = query.getResultList();
		return personaList;
	}

	public PersonaEntity findByName(String name) {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setName(name);
		List<ISoapBoxEntity> find = find(personaEntity);
		if (find.size() > 0) {
			return (PersonaEntity) find.get(0);
		}
		return null;
	}

	public void updateStatusMessage(Long personaId, String statusMessage) {
		PersonaEntity personaEntity = findById(personaId);
		personaEntity.setMotto(statusMessage);
		save(personaEntity);
	}

}
