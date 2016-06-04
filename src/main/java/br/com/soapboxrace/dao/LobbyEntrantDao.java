package br.com.soapboxrace.dao;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.LobbyEntrantEntity;
import br.com.soapboxrace.jpa.PersonaEntity;

public class LobbyEntrantDao extends SoapboxDao {

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
