package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.dao.ProductDao;
import br.com.soapboxrace.jaxb.ArrayOfProductTransList;
import br.com.soapboxrace.jpa.ProductEntity;

public class CatalogBO {

	private ProductDao productDao = new ProductDao();

	public ArrayOfProductTransList productsInCategory(String categoryName, String clientProductType) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setCategoryName(categoryName);
		productEntity.setProductType(clientProductType);
		List<ProductEntity> products = productDao.find(productEntity);
		ArrayOfProductTransList arrayOfProductTransList = new ArrayOfProductTransList();
		for (ProductEntity prodTmp : products) {
			arrayOfProductTransList.add(prodTmp);
		}
		return arrayOfProductTransList;
	}
}