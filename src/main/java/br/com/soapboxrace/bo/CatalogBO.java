package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.dao.ProductDao;
import br.com.soapboxrace.jaxb.ArrayOfProductTransList;
import br.com.soapboxrace.jpa.ISoapBoxEntity;
import br.com.soapboxrace.jpa.ProductEntity;

public class CatalogBO {

	private ProductDao productDao = new ProductDao();

	public ArrayOfProductTransList productsInCategory(String categoryName, String clientProductType) {
		List<ISoapBoxEntity> products = productDao.findByCategoryNameClientProductType(categoryName, clientProductType);
		ArrayOfProductTransList arrayOfProductTransList = new ArrayOfProductTransList();
		for (ISoapBoxEntity prodTmp : products) {
			arrayOfProductTransList.add((ProductEntity) prodTmp);
		}
		return arrayOfProductTransList;
	}
}