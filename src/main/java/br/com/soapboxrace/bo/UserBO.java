package br.com.soapboxrace.bo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jaxb.PersonasType;
import br.com.soapboxrace.jaxb.ProfileDataType;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.UserType;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.SessionEntity;
import br.com.soapboxrace.jpa.UserEntity;

public class UserBO {

	private ConnectionDB connectionDB = new ConnectionDB();

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

		EntityManager manager = ConnectionDB.getManager();
		TypedQuery<PersonaEntity> query = manager
				.createQuery("SELECT obj FROM PersonaEntity obj WHERE obj.user = :user", PersonaEntity.class);
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);
		query.setParameter("user", userEntity);
		List<PersonaEntity> resultList = query.getResultList();

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

		SessionEntity sessionEntity = new SessionEntity();
		Date expirationDate = new Date();
		long time = expirationDate.getTime();
		expirationDate.setTime(time + 300000L);
		sessionEntity.setToken(md5);
		sessionEntity.setUserId(userId);
		List<?> find = connectionDB.find(sessionEntity);
		sessionEntity.setExpiration(expirationDate);
		if(find.size() == 0){
			connectionDB.persist(sessionEntity);
		} else {
			sessionEntity = (SessionEntity) find.get(0);
			connectionDB.merge(sessionEntity);
		}
		return userInfo;
	}

	public void secureLoginPersona(String securityToken, Long userId, Long personaId) {
		SessionEntity sessionEntity = new SessionEntity();
		sessionEntity.setToken(securityToken);
		sessionEntity.setUserId(userId);

		List<?> find = connectionDB.find(sessionEntity);
		sessionEntity = (SessionEntity) find.get(0);

		sessionEntity.setPersonaId(personaId);
		connectionDB.merge(sessionEntity);
	}

}
