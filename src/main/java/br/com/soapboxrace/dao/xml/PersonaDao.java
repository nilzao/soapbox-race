package br.com.soapboxrace.dao.xml;

import java.util.ArrayList;
import java.util.List;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.ILobbyEntrantDao;
import br.com.soapboxrace.dao.factory.IPersonaDao;
import br.com.soapboxrace.jaxb.PersonasType;
import br.com.soapboxrace.jaxb.ProfileDataType;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
import br.com.soapboxrace.jpa.ISoapBoxEntity;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.UserEntity;

public class PersonaDao extends SoapboxDao implements IPersonaDao {

	@Override
	public PersonaEntity findById(Long id) {
		List<PersonaEntity> personaList = this.findByUserId(1L);
		for (PersonaEntity personaEntity : personaList) {
			if (personaEntity.getId().equals(id)) {
				return personaEntity;
			}
		}
		return null;
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
		String readXml = readFile("User/GetPermanentSession.xml");
		UserInfoType userInfoType = (UserInfoType) UnmarshalXML.unMarshal(readXml, new UserInfoType());
		PersonasType personas = userInfoType.getPersonas();
		List<ProfileDataType> profileData = personas.getProfileData();
		List<PersonaEntity> personasList = new ArrayList<>();
		for (ProfileDataType profileDataType : profileData) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(1L);
			PersonaEntity personaEntity = new PersonaEntity();
			personaEntity.setName(profileDataType.getName());
			personaEntity.setCash(profileDataType.getCash());
			personaEntity.setLevel(profileDataType.getLevel());
			personaEntity.setId(profileDataType.getPersonaId());
			personaEntity.setIconIndex(profileDataType.getIconIndex());
			personaEntity.setMotto(profileDataType.getMotto());
			personaEntity.setRep(profileDataType.getRep());
			personaEntity.setRating(profileDataType.getRating());
			personaEntity.setRepAtCurrentLevel(profileDataType.getRepAtCurrentLevel());
			personaEntity.setPercentToLevel(profileDataType.getPercentToLevel());
			personaEntity.setUser(userEntity);
			personasList.add(personaEntity);
		}
		return personasList;
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
