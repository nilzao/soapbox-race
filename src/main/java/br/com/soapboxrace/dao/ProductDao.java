package br.com.soapboxrace.dao;

import java.util.List;

import br.com.soapboxrace.db.SoapboxDao;
import br.com.soapboxrace.jpa.ProductEntity;

public class ProductDao extends SoapboxDao {

	@Override
	public ProductEntity findById(Long id) {
		ProductEntity entity = (ProductEntity) super.findById(ProductEntity.class, id);
		return entity;
	}

	public List<ProductEntity> find(ProductEntity entity) {
		return null;
	}

	public ProductEntity findByProductId(String productId) {
		ProductEntity carSlotProductData = new ProductEntity();
		carSlotProductData.setProductId(productId);
		carSlotProductData = (ProductEntity) super.find(carSlotProductData).get(0);
		return carSlotProductData;
	}

}
