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

	private static final EntityManagerFactory emf;
	private static final ThreadLocal<EntityManager> threadLocal;

	static {
		HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
		emf = hibernatePersistenceProvider.createEntityManagerFactory("persistenceUnit", null);
		threadLocal = new ThreadLocal<EntityManager>();
	}

	public static EntityManager getManager() {
		EntityManager em = threadLocal.get();
		if (em == null) {
			em = emf.createEntityManager();
			threadLocal.set(em);
		}
		return em;
	}

	public void persist(Object entity) {
		EntityTransaction tx = null;
		try {
			tx = getManager().getTransaction();
			tx.begin();
			getManager().persist(entity);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				e.printStackTrace();
			}
		}
	}

	public Object merge(Object entity) {
		EntityTransaction tx = null;
		Object merge = null;
		try {
			tx = getManager().getTransaction();
			tx.begin();
			merge = getManager().merge(entity);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				e.printStackTrace();
			}
		}
		return merge;
	}

	public void remove(Object entity) {
		EntityTransaction tx = null;
		try {
			tx = getManager().getTransaction();
			tx.begin();
			getManager().remove(entity);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				e.printStackTrace();
			}
		}

	}

	public Object findById(Object entity, Long id) {
		getManager().clear();
		return getManager().find(entity.getClass(), id);
	}

	public List<?> find(Object entity) {
		getManager().clear();
		Session sessao = (Session) getManager().getDelegate();
		Example example = Example.create(entity);
		example.excludeZeroes();
		Criteria criteria = sessao.createCriteria(entity.getClass());
		criteria.add(example);
		return criteria.list();
	}
}
