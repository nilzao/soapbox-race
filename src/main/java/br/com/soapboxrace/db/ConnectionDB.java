package br.com.soapboxrace.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.jpa.HibernatePersistenceProvider;

import br.com.soapboxrace.config.Config;

public class ConnectionDB {

	private static final EntityManagerFactory emf;
	private static final ThreadLocal<EntityManager> threadLocal;

	static {
		Config config = Config.getInstance();
		String dbDriver = "persistence".concat(config.getDbDriver());
		HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
		emf = hibernatePersistenceProvider.createEntityManagerFactory(dbDriver, null);
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
