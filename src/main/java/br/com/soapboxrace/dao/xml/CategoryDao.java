package br.com.soapboxrace.dao.xml;

import br.com.soapboxrace.dao.factory.ICategoryDao;
import br.com.soapboxrace.jaxb.ArrayOfCategoryTrans;
import br.com.soapboxrace.jpa.CategoryEntity;

public class CategoryDao extends SoapboxDao implements ICategoryDao {

	@Override
	public CategoryEntity findById(Long id) {
		CategoryEntity entity = (CategoryEntity) super.findById(CategoryEntity.class, id);
		return entity;
	}

	public ArrayOfCategoryTrans getAll() {
		return null;
	}

	public CategoryEntity save(CategoryEntity entity) {
		return (CategoryEntity) super.save(entity);
	}
}