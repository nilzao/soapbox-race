package br.com.soapboxrace.dao.db;

import java.util.List;

import br.com.soapboxrace.dao.factory.IProductDao;
import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.ProductEntity;

public class ProductDao extends SoapboxDao implements IProductDao {

	@Override
	public ProductEntity findById(Long id) {
		ProductEntity entity = (ProductEntity) super.findById(ProductEntity.class, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<ProductEntity> findByCategoryNameClientProductType(String categoryName, String clientProductType) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setCategoryName(categoryName);
		productEntity.setProductType(clientProductType);
		List<ProductEntity> find = (List<ProductEntity>) (List<?>) super.find(productEntity);
		return find;
	}

	public ProductEntity findByProductId(String productId) {
		ProductEntity carSlotProductData = new ProductEntity();
		carSlotProductData.setProductId(productId);
		carSlotProductData = (ProductEntity) super.find(carSlotProductData).get(0);
		return carSlotProductData;
	}
}