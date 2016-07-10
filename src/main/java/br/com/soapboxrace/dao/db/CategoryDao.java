package br.com.soapboxrace.dao.db;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.soapboxrace.dao.factory.ICategoryDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jaxb.ArrayOfCategoryTrans;
import br.com.soapboxrace.jpa.CategoryEntity;

public class CategoryDao extends SoapboxDao implements ICategoryDao {

	@Override
	public CategoryEntity findById(Long id) {
		CategoryEntity entity = (CategoryEntity) super.findById(CategoryEntity.class, id);
		return entity;
	}

	public ArrayOfCategoryTrans getAll() {
		EntityManager manager = getManager();
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<CategoryEntity> cq = cb.createQuery(CategoryEntity.class);
		Root<CategoryEntity> rootEntry = cq.from(CategoryEntity.class);
		CriteriaQuery<CategoryEntity> all = cq.select(rootEntry);
		TypedQuery<CategoryEntity> allQuery = manager.createQuery(all);
		// Query query = ;
		ArrayOfCategoryTrans catTrans = new ArrayOfCategoryTrans();
		catTrans.setCategoryEntityList(allQuery.getResultList());
		return catTrans;
	}

	public CategoryEntity save(CategoryEntity entity) {
		return (CategoryEntity) super.save(entity);
	}
}