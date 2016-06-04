package br.com.soapboxrace.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.jpa.HibernatePersistenceProvider;

public class ConnectionDB {

	private static final EntityManagerFactory emf;
	private static final ThreadLocal<EntityManager> threadLocal;

	static {
		HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
		emf = hibernatePersistenceProvider.createEntityManagerFactory("persistenceUnit", null);
		threadLocal = new ThreadLocal<EntityManager>();
	}

	protected static EntityManager getManager() {
		EntityManager em = threadLocal.get();
		if (em == null) {
			em = emf.createEntityManager();
			threadLocal.set(em);
		}
		return em;
	}

}
