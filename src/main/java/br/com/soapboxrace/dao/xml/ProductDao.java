package br.com.soapboxrace.dao.xml;

import java.util.List;

import br.com.soapboxrace.dao.factory.IProductDao;
import br.com.soapboxrace.jaxb.ArrayOfProductTrans;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
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
		String path = findFilePath("catalog", productId + ".xml");
		String readFile = readAbsoluteFile(path);
		ArrayOfProductTrans arrayOfProductTrans = (ArrayOfProductTrans) UnmarshalXML.unMarshal(readFile, new ArrayOfProductTrans());

		return arrayOfProductTrans.getProductTransList().get(0);
	}
}
