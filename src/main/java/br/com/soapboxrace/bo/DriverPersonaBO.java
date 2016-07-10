package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.IPersonaDao;
import br.com.soapboxrace.jaxb.ArrayOfPersonaBaseType;
import br.com.soapboxrace.jaxb.ArrayOfstringType;
import br.com.soapboxrace.jaxb.PersonaBaseType;
import br.com.soapboxrace.jaxb.PersonaMottoType;
import br.com.soapboxrace.jaxb.PersonaPresenceType;
import br.com.soapboxrace.jaxb.ProfileDataType;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.UserEntity;
import br.com.soapboxrace.xmpp.openfire.RestApiCli;

public class DriverPersonaBO {

	private IPersonaDao personaDao = DaoFactory.getPersonaDao();

	public ArrayOfstringType reserveName(String name) {
		ArrayOfstringType arrayOfstringType = new ArrayOfstringType();
		if (personaDao.existsByName(name)) {
			arrayOfstringType.setString("NONE");
		}
		return arrayOfstringType;
	}

	public ProfileDataType createPersona(Long userId, String name, int iconIndex) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);

		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setCash(200000);
		personaEntity.setName(name);
		personaEntity.setIconIndex(iconIndex);
		personaEntity.setUser(userEntity);
		personaEntity.setPercentToLevel(0);
		personaEntity.setRating(0);
		personaEntity.setRep(0);
		personaEntity.setRepAtCurrentLevel(0);
		personaEntity.setScore(0);
		personaEntity.setLevel(1);

		personaEntity = personaDao.save(personaEntity);

		ProfileDataType profileDataType = new ProfileDataType();
		profileDataType.setName(personaEntity.getName());
		profileDataType.setCash(personaEntity.getCash());
		profileDataType.setIconIndex(personaEntity.getIconIndex());
		profileDataType.setPersonaId(personaEntity.getId());
		profileDataType.setLevel(personaEntity.getLevel());
		RestApiCli.createUpdatePersona(personaEntity.getId(), "1234567890123456");
		return profileDataType;
	}

	public void deletePersona(long idPersona) {
		PersonaEntity personaEntity = personaDao.findById(idPersona);
		personaDao.del(personaEntity);
	}

	public ProfileDataType getPersonaInfo(long idPersona) {
		PersonaEntity personaEntity = personaDao.findById(idPersona);
		ProfileDataType profileDataType = new ProfileDataType();
		profileDataType.setBadges("");
		profileDataType.setCash(personaEntity.getCash());
		profileDataType.setIconIndex(personaEntity.getIconIndex());
		profileDataType.setLevel(personaEntity.getLevel());
		profileDataType.setMotto(personaEntity.getMotto());
		profileDataType.setName(personaEntity.getName());
		profileDataType.setPercentToLevel(personaEntity.getPercentToLevel());
		profileDataType.setPersonaId(personaEntity.getId());
		profileDataType.setRating(personaEntity.getRating());
		profileDataType.setRep(personaEntity.getRep());
		profileDataType.setRepAtCurrentLevel(personaEntity.getRepAtCurrentLevel());
		profileDataType.setScore(personaEntity.getScore());
		return profileDataType;
	}

	public ArrayOfPersonaBaseType getPersonaBaseFromList(List<Long> idsPersona) {
		ArrayOfPersonaBaseType arrayOfPersonaBaseType = new ArrayOfPersonaBaseType();
		List<PersonaBaseType> personaBase = arrayOfPersonaBaseType.getPersonaBase();
		for (Long idPersonaTmp : idsPersona) {
			PersonaEntity personaEntity = personaDao.findById(idPersonaTmp);
			PersonaBaseType personaBaseType = new PersonaBaseType();
			personaBaseType.setIconIndex(personaEntity.getIconIndex());
			personaBaseType.setLevel(personaEntity.getLevel());
			personaBaseType.setName(personaEntity.getName());
			personaBaseType.setPersonaId(personaEntity.getId().intValue());
			personaBaseType.setMotto(personaEntity.getMotto());
			personaBaseType.setPresence(2);
			personaBaseType.setUserId(personaEntity.getUser().getId().intValue());
			personaBaseType.setScore(personaEntity.getScore());
			personaBaseType.setBadges("");
			personaBase.add(personaBaseType);
		}
		return arrayOfPersonaBaseType;
	}

	public PersonaPresenceType getPersonaPresenceByName(String name) {
		PersonaEntity persona = personaDao.findByName(name);
		if (persona != null) {
			PersonaPresenceType personaPresenceType = new PersonaPresenceType();
			personaPresenceType.setPersonaId(persona.getId());
			personaPresenceType.setPresence(1);
			personaPresenceType.setUserId(persona.getUser().getId());
			return personaPresenceType;
		}
		return null;
	}

	public PersonaMottoType updateStatusMessage(Long personaId, String message) {
		personaDao.updateStatusMessage(personaId, message);
		PersonaMottoType personaMottoType = new PersonaMottoType();
		personaMottoType.setMessage(message);
		personaMottoType.setPersonaId(personaId);
		return personaMottoType;
	}
}