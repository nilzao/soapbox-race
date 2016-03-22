package br.com.soapboxrace.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class ConnectionDB {

	private static EntityManager manager;

	public ConnectionDB() {
		if (manager == null) {
			HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
			EntityManagerFactory createEntityManagerFactory = hibernatePersistenceProvider
					.createEntityManagerFactory("persistenceUnit", null);
			manager = createEntityManagerFactory.createEntityManager();
		}
		// EntityManagerFactory factory =
		// Persistence.createEntityManagerFactory("persistenceUnit");
		// manager = factory.createEntityManager();
	}

	public static EntityManager getManager() {
		return manager;
	}

	public void persist(Object entity) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(entity);
		tx.commit();
	}

	public Object merge(Object entity) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Object merge = manager.merge(entity);
		tx.commit();
		return merge;
	}

	public void remove(Object entity) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(entity);
		tx.commit();
	}

	public Object findById(Object entity, Long id) {
		return manager.find(entity.getClass(), id);
	}

	public List<?> find(Object entity) {
		Session sessao = (Session) manager.getDelegate();
		Example example = Example.create(entity);
		example.excludeZeroes();
		Criteria criteria = sessao.createCriteria(entity.getClass());
		criteria.add(example);
		return criteria.list();
	}
}
