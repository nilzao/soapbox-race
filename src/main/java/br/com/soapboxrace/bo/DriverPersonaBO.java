package br.com.soapboxrace.bo;

import java.math.BigDecimal;
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
		personaEntity.setPercentToLevel(BigDecimal.ZERO);
		personaEntity.setRating(BigDecimal.ZERO);
		personaEntity.setRep(BigDecimal.ZERO);
		personaEntity.setRepAtCurrentLevel(BigDecimal.ZERO);
		personaEntity.setScore(BigDecimal.ZERO);
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
		profileDataType.setMotto("");
		profileDataType.setName(personaEntity.getName());
		profileDataType.setPercentToLevel(50F);
		profileDataType.setRep(60);
		profileDataType.setRepAtCurrentLevel(60);
		profileDataType.setPersonaId(personaEntity.getId().intValue());
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
			personaBaseType.setMotto("");
			personaBaseType.setPresence(2);
			personaBaseType.setUserId(personaEntity.getUser().getId().intValue());
			personaBaseType.setScore(55);
			personaBaseType.setBadges("");
			personaBase.add(personaBaseType);
		}
		return arrayOfPersonaBaseType;
	}
}
