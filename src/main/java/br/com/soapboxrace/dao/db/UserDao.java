package br.com.soapboxrace.dao.db;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.soapboxrace.dao.factory.IUserDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.UserEntity;

public class UserDao extends SoapboxDao implements IUserDao {

	@Override
	public UserEntity findById(Long id) {
		UserEntity entity = (UserEntity) super.findById(UserEntity.class, id);
		return entity;
	}

	public UserEntity findByEmail(String email) {
		EntityManager manager = getManager();
		TypedQuery<UserEntity> query = manager.createQuery("SELECT obj FROM UserEntity obj WHERE obj.email = :email", UserEntity.class);
		query.setParameter("email", email);
		UserEntity user = null;
		if (!query.getResultList().isEmpty())
			user = query.getResultList().get(0);
		return user;
	}

	public UserEntity save(UserEntity entity) {
		return (UserEntity) super.save(entity);
	}
}
