package br.com.soapboxrace.dao.db;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.soapboxrace.dao.factory.ILobbyEntrantDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.LobbyEntrantEntity;
import br.com.soapboxrace.jpa.PersonaEntity;

public class LobbyEntrantDao extends SoapboxDao implements ILobbyEntrantDao {

	@Override
	public LobbyEntrantEntity findById(Long id) {
		LobbyEntrantEntity entity = (LobbyEntrantEntity) super.findById(LobbyEntrantEntity.class, id);
		return entity;
	}

	public void delByPersona(PersonaEntity entity) {
		EntityManager manager = getManager();
		Session delegate = (Session) manager.getDelegate();
		Query query = delegate.createQuery("DELETE from LobbyEntrantEntity obj WHERE obj.persona = :persona ");
		query.setParameter("persona", entity);
		query.executeUpdate();
	}

}
