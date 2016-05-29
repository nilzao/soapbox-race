package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.dao.PersonaDao;
import br.com.soapboxrace.dao.UserDao;
import br.com.soapboxrace.jaxb.PersonasType;
import br.com.soapboxrace.jaxb.ProfileDataType;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.UserType;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.UserEntity;

public class UserBO {

	private PersonaDao personaDao = new PersonaDao();
	private UserDao userDao = new UserDao();

	public UserInfoType getPermanentSession(Long userId, String securityToken) {
		createUser(userId);

		UserInfoType userInfo = new UserInfoType();
		UserType userType = new UserType();

		userType.setSecurityToken(securityToken);
		userType.setFullGameAccess("false");
		// userType.setStarterPackEntitlementTag("NFSW_STARTER_PACK_B");
		userType.setUserId(userId.intValue());
		userType.setIsComplete("false");
		userType.setRemoteUserId(10001);
		userType.setSubscribeMsg("false");
		userInfo.setUser(userType);

		PersonasType personasType = new PersonasType();
		List<ProfileDataType> profileData = personasType.getProfileData();
		List<PersonaEntity> resultList = personaDao.findByUserId(userId);

		for (PersonaEntity personaEntity : resultList) {
			ProfileDataType profileDataType = new ProfileDataType();
			profileDataType.setName(personaEntity.getName());
			profileDataType.setCash(personaEntity.getCash());
			profileDataType.setLevel(personaEntity.getLevel());
			profileDataType.setPersonaId(personaEntity.getId().intValue());
			profileDataType.setIconIndex(personaEntity.getIconIndex());
			profileDataType.setMotto(personaEntity.getMotto());
			profileDataType.setRep(personaEntity.getRep());
			profileDataType.setRating(personaEntity.getRating());
			profileDataType.setRepAtCurrentLevel(personaEntity.getRepAtCurrentLevel());
			// profileDataType.setCcar("");
			profileDataType.setPercentToLevel(personaEntity.getPercentToLevel());
			profileData.add(profileDataType);
		}
		userInfo.setPersonas(personasType);

		return userInfo;
	}

	public String createUser(long userId) {
		UserEntity userEntity = userDao.findById(userId);
		if (userEntity == null) {
			UserEntity user = new UserEntity();
			user.setId(userId);
			user.setEmail("user_" + userId + "@here");
			user.setPassword("nothing");
			userDao.save(user);
		}
		return "";
	}
}
