package br.com.soapboxrace.dao.factory;

import java.util.List;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jpa.ProductEntity;

public interface IProductDao extends ISoapboxDao {

	public List<ProductEntity> findByCategoryNameClientProductType(String categoryName, String clientProductType);

	public ProductEntity findByProductId(String productId);
}
