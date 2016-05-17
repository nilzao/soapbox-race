package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.dao.PersonaDao;
import br.com.soapboxrace.jaxb.ArrayOfPersonaBaseType;
import br.com.soapboxrace.jaxb.ArrayOfstringType;
import br.com.soapboxrace.jaxb.PersonaBaseType;
import br.com.soapboxrace.jaxb.ProfileDataType;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.UserEntity;

public class DriverPersonaBO {

	private PersonaDao personaDao = new PersonaDao();

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
		personaEntity.setPercentToLevel(Float.NaN);
		personaEntity.setRating(Float.NaN);
		personaEntity.setRep(Float.NaN);
		personaEntity.setRepAtCurrentLevel(Float.NaN);
		personaEntity.setScore(Float.NaN);
		personaEntity.setLevel(1);

		personaEntity = personaDao.save(personaEntity);

		ProfileDataType profileDataType = new ProfileDataType();
		profileDataType.setName(personaEntity.getName());
		profileDataType.setCash(personaEntity.getCash());
		profileDataType.setIconIndex(personaEntity.getIconIndex());
		profileDataType.setPersonaId(personaEntity.getId().intValue());
		profileDataType.setLevel(personaEntity.getLevel());
		return profileDataType;
	}

	public void deletePersona(long idPersona) {
		PersonaEntity personaEntity = personaDao.findById(idPersona);
		personaDao.del(personaEntity);
	}

	public ProfileDataType getPersonaInfo(long idPersona) {
		PersonaEntity personaEntity = personaDao.findById(idPersona);
		ProfileDataType profileDataType = new ProfileDataType();
		profileDataType.setCash(personaEntity.getCash());
		profileDataType.setIconIndex(personaEntity.getIconIndex());
		profileDataType.setLevel(personaEntity.getLevel());
		profileDataType.setMotto(personaEntity.getMotto());
		profileDataType.setName(personaEntity.getName());
		profileDataType.setPercentToLevel(personaEntity.getPercentToLevel());
		profileDataType.setRep(personaEntity.getRep());
		profileDataType.setRepAtCurrentLevel(personaEntity.getRepAtCurrentLevel());
		profileDataType.setPersonaId(personaEntity.getId());
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
}