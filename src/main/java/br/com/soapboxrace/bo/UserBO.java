package br.com.soapboxrace.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jaxb.PersonasType;
import br.com.soapboxrace.jaxb.ProfileDataType;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.UserType;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.UserEntity;

public class UserBO {

	public UserInfoType getPermanentSession(Long userId, String securityToken) {
		UserInfoType userInfo = new UserInfoType();
		UserType userType = new UserType();
		userType.setSecurityToken("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb");
		userType.setFullGameAccess("false");
		// userType.setStarterPackEntitlementTag("NFSW_STARTER_PACK_B");
		userType.setUserId(userId.intValue());
		userType.setIsComplete("false");
		userType.setRemoteUserId(10001);
		userType.setSubscribeMsg("false");
		userInfo.setUser(userType);

		PersonasType personasType = new PersonasType();
		List<ProfileDataType> profileData = personasType.getProfileData();

		new ConnectionDB();
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
			profileDataType.setCash(personaEntity.getCash().intValue());
			profileDataType.setLevel(personaEntity.getLevel());
			profileDataType.setPersonaId(personaEntity.getId().intValue());
			profileDataType.setIconIndex(personaEntity.getIconIndex());
			profileDataType.setMotto("");
			profileDataType.setRep(0);
			profileDataType.setRating(0);
			profileDataType.setRepAtCurrentLevel(0);
			// profileDataType.setCcar("");
			profileData.add(profileDataType);
			profileDataType.setPercentToLevel(0);
		}
		userInfo.setPersonas(personasType);
		return userInfo;
	}

}
