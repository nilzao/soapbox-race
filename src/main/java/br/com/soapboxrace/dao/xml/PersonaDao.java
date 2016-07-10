package br.com.soapboxrace.dao.xml;

import java.util.List;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.ILobbyEntrantDao;
import br.com.soapboxrace.dao.factory.IPersonaDao;
import br.com.soapboxrace.jpa.ISoapBoxEntity;
import br.com.soapboxrace.jpa.PersonaEntity;

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
		return null;
	}

	public PersonaEntity findByName(String name) {
		return null;
	}

	public void updateStatusMessage(Long personaId, String statusMessage) {
		PersonaEntity personaEntity = findById(personaId);
		personaEntity.setMotto(statusMessage);
		save(personaEntity);
	}

}
