package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.IPersonaDao;
import br.com.soapboxrace.dao.factory.IUserDao;
import br.com.soapboxrace.definition.ServerExceptions.EngineException;
import br.com.soapboxrace.jaxb.PersonasType;
import br.com.soapboxrace.jaxb.ProfileDataType;
import br.com.soapboxrace.jaxb.UserInfoType;
import br.com.soapboxrace.jaxb.UserType;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.UserEntity;

public class UserBO {

	private IPersonaDao personaDao = DaoFactory.getPersonaDao();
	private IUserDao userDao = DaoFactory.getUserDao();

	public UserInfoType getPermanentSession(Long userId, String securityToken) {
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

	public String authenticateUser(String email, String passwordHash) throws EngineException {
		if (userDao.findByEmail(email) != null) {
			UserEntity user = userDao.findByEmail(email);
			if (user.getPassword().equals(passwordHash)) {
				return user.getId().toString();
			}
			throw new EngineException("Login Error: Incorrect email-password combination!");
		}
		throw new EngineException("Login Error: Email wasn't found!");
	}

	public String createUser(String email, String passwordHash) throws EngineException {
		if (userDao.findByEmail(email) != null)
			throw new EngineException("Registration Error: Email already exists!");

		UserEntity user = new UserEntity();
		user.setEmail(email);
		user.setPassword(passwordHash);
		userDao.save(user);
		return userDao.find(user).get(0).getId().toString();
	}
}