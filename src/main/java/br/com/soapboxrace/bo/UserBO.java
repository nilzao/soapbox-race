package br.com.soapboxrace.bo;

import java.util.Date;
import java.util.List;

import br.com.soapboxrace.dao.PersonaDao;
import br.com.soapboxrace.dao.SessionDao;
import br.com.soapboxrace.jaxb.PersonasType;
import br.com.soapboxrace.jaxb.ProfileDataType;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.UserType;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.SessionEntity;

public class UserBO {

	private PersonaDao personaDao = new PersonaDao();

	private SessionDao sessionDao = new SessionDao();

	private String md5() {
		return "9e80b14c371af10bb4432acf8d06f7ed";
	}

	public UserInfoType getPermanentSession(Long userId, String securityToken) {
		UserInfoType userInfo = new UserInfoType();
		UserType userType = new UserType();
		String md5 = md5();
		userType.setSecurityToken(md5());
		userType.setFullGameAccess("false");
		userType.setStarterPackEntitlementTag("NFSW_STARTER_PACK_B");
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
			profileDataType.setMotto("");
			profileDataType.setRep(0);
			profileDataType.setRating(0);
			profileDataType.setRepAtCurrentLevel(0);
			// profileDataType.setCcar("");
			profileDataType.setPercentToLevel(0);
			profileData.add(profileDataType);
		}
		userInfo.setPersonas(personasType);

		SessionEntity sessionEntity = sessionDao.findByUserIdToken(userId, md5);
		Date expirationDate = new Date();
		long time = expirationDate.getTime();
		expirationDate.setTime(time + 300000L);
		sessionEntity.setToken(md5);
		sessionEntity.setUserId(userId);
		sessionDao.save(sessionEntity);
		return userInfo;
	}

	public void secureLoginPersona(String securityToken, Long userId, Long personaId) {
		SessionEntity sessionEntity = sessionDao.findByUserIdToken(userId, securityToken);
		sessionEntity.setPersonaId(personaId);
		sessionDao.save(sessionEntity);
	}

}
