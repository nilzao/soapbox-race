package br.com.soapboxrace.dao.factory;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jaxb.ArrayOfCategoryTrans;
import br.com.soapboxrace.jpa.CategoryEntity;

public interface ICategoryDao extends ISoapboxDao {

	public CategoryEntity findById(Long id);

	public ArrayOfCategoryTrans getAll();

	public CategoryEntity save(CategoryEntity entity);

}
