package br.com.soapboxrace.dao.factory;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jpa.UserEntity;

public interface IUserDao extends ISoapboxDao {

	public UserEntity findByEmail(String email);

	public UserEntity save(UserEntity entity);
}
