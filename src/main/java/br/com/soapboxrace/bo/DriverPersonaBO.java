package br.com.soapboxrace.bo;

import java.math.BigDecimal;
import java.util.List;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jaxb.ArrayOfPersonaBaseType;
import br.com.soapboxrace.jaxb.ArrayOfstringType;
import br.com.soapboxrace.jaxb.PersonaBaseType;
import br.com.soapboxrace.jaxb.ProfileDataType;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.UserEntity;

public class DriverPersonaBO {

	private ConnectionDB connectionDB = new ConnectionDB();

	public ArrayOfstringType reserveName(String name) {
		ConnectionDB connectionDB = new ConnectionDB();
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setName(name);
		List<?> find = connectionDB.find(personaEntity);

		ArrayOfstringType arrayOfstringType = new ArrayOfstringType();
		if (find.size() > 0) {
			arrayOfstringType.setString("NONE");
		}
		return arrayOfstringType;
	}

	public ProfileDataType createPersona(Long userId, String name, int iconIndex) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);

		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setCash(BigDecimal.valueOf(200000L));
		personaEntity.setName(name);
		personaEntity.setIconIndex(iconIndex);
		personaEntity.setUser(userEntity);
		personaEntity.setPercentToLevel(BigDecimal.ZERO);
		personaEntity.setRating(BigDecimal.ZERO);
		personaEntity.setRep(BigDecimal.ZERO);
		personaEntity.setRepAtCurrentLevel(BigDecimal.ZERO);
		personaEntity.setScore(BigDecimal.ZERO);
		personaEntity.setLevel(1);

		personaEntity = (PersonaEntity) connectionDB.merge(personaEntity);

		ProfileDataType profileDataType = new ProfileDataType();
		profileDataType.setName(personaEntity.getName());
		profileDataType.setCash(personaEntity.getCash().intValue());
		profileDataType.setIconIndex(personaEntity.getIconIndex());
		profileDataType.setPersonaId(personaEntity.getId().intValue());
		profileDataType.setLevel(personaEntity.getLevel());
		return profileDataType;
	}

	public void deletePersona(long idPersona) {
		ConnectionDB connectionDB = new ConnectionDB();
		PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(new PersonaEntity(), idPersona);
		connectionDB.remove(personaEntity);
	}

	public ProfileDataType getPersonaInfo(long idPersona) {
		PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(new PersonaEntity(), idPersona);
		ProfileDataType profileDataType = new ProfileDataType();
		profileDataType.setCash(personaEntity.getCash().intValue());
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

	public ArrayOfPersonaBaseType getPersonaBaseFromList(long idPersona) {
		PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(new PersonaEntity(), idPersona);
		ArrayOfPersonaBaseType arrayOfPersonaBaseType = new ArrayOfPersonaBaseType();
		PersonaBaseType personaBaseType = new PersonaBaseType();
		personaBaseType.setIconIndex(personaEntity.getIconIndex());
		personaBaseType.setLevel(personaEntity.getLevel());
		personaBaseType.setName(personaEntity.getName());
		personaBaseType.setPersonaId(personaEntity.getId().intValue());
		personaBaseType.setMotto("");
		personaBaseType.setPresence(1);
		personaBaseType.setUserId(personaEntity.getUser().getId().intValue());
		personaBaseType.setScore(55);
		personaBaseType.setBadges("");
		arrayOfPersonaBaseType.setPersonaBase(personaBaseType);
		return arrayOfPersonaBaseType;
	}
}
