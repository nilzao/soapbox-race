package br.com.soapboxrace.dao;

import java.util.List;

import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.ISoapBoxEntity;
import br.com.soapboxrace.jpa.ProductEntity;

public class ProductDao extends SoapboxDao {

	@Override
	public ProductEntity findById(Long id) {
		ProductEntity entity = (ProductEntity) super.findById(ProductEntity.class, id);
		return entity;
	}

	public List<ISoapBoxEntity> findByCategoryNameClientProductType(String categoryName, String clientProductType) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setCategoryName(categoryName);
		productEntity.setProductType(clientProductType);
		List<ISoapBoxEntity> find = super.find(productEntity);
		return find;
	}

	public ProductEntity findByProductId(String productId) {
		ProductEntity carSlotProductData = new ProductEntity();
		carSlotProductData.setProductId(productId);
		carSlotProductData = (ProductEntity) super.find(carSlotProductData).get(0);
		return carSlotProductData;
	}

}
