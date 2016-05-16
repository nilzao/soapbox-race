package br.com.soapboxrace.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import br.com.soapboxrace.jpa.ISoapBoxEntity;

public abstract class SoapboxDao implements ISoapboxDao {

	@Override
	public ISoapBoxEntity save(ISoapBoxEntity entity) {
		if (entity.getId() == null) {
			this.persist(entity);
		} else {
			entity = (ISoapBoxEntity) this.merge(entity);
		}
		return entity;
	}

	@Override
	public void del(ISoapBoxEntity entity) {
		if (entity.getId() != null) {
			this.remove(entity);
		}
	}

	public ISoapBoxEntity findById(Class<? extends ISoapBoxEntity> entityClass, Long id) {
		EntityManager manager = ConnectionDB.getManager();
		manager.clear();
		return manager.find(entityClass, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ISoapBoxEntity> find(ISoapBoxEntity entity) {
		EntityManager manager = ConnectionDB.getManager();
		manager.clear();
		Session sessao = (Session) manager.getDelegate();
		Example example = Example.create(entity);
		example.excludeZeroes();
		Criteria criteria = sessao.createCriteria(entity.getClass());
		criteria.add(example);
		return criteria.list();
	}

	private void persist(ISoapBoxEntity entity) {
		EntityTransaction tx = null;
		try {
			EntityManager manager = ConnectionDB.getManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(entity);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				e.printStackTrace();
			}
		}
	}

	private Object merge(ISoapBoxEntity entity) {
		EntityTransaction tx = null;
		Object merge = null;
		try {
			EntityManager manager = ConnectionDB.getManager();
			tx = manager.getTransaction();
			tx.begin();
			merge = manager.merge(entity);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				e.printStackTrace();
			}
		}
		return merge;
	}

	private void remove(ISoapBoxEntity entity) {
		EntityTransaction tx = null;
		try {
			EntityManager manager = ConnectionDB.getManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(entity);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				e.printStackTrace();
			}
		}
	}

	protected EntityManager getManager() {
		return ConnectionDB.getManager();
	}

}
