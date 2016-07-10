package br.com.soapboxrace.dao.xml;

import java.util.List;

import br.com.soapboxrace.dao.factory.IProductVinylDao;
import br.com.soapboxrace.jpa.VinylProductEntity;

public class ProductVinylDao extends SoapboxDao implements IProductVinylDao {

	@Override
	public VinylProductEntity findById(Long id) {
		VinylProductEntity entity = (VinylProductEntity) super.findById(VinylProductEntity.class, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<VinylProductEntity> findByCategoryName(String categoryName) {
		VinylProductEntity productVinylEntity = new VinylProductEntity();
		productVinylEntity.setCategoryName(categoryName);
		List<VinylProductEntity> find = (List<VinylProductEntity>) (List<?>) super.find(productVinylEntity);
		return find;
	}

	public VinylProductEntity findByProductId(String productId) {
		VinylProductEntity vinylProductData = new VinylProductEntity();
		vinylProductData.setProductId(productId);
		vinylProductData = (VinylProductEntity) super.find(vinylProductData).get(0);
		return vinylProductData;
	}

	public VinylProductEntity save(VinylProductEntity entity) {
		return (VinylProductEntity) super.save(entity);
	}
}
