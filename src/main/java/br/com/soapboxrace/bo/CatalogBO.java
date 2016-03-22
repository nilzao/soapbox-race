package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jaxb.ArrayOfProductTransList;
import br.com.soapboxrace.jpa.ProductEntity;

public class CatalogBO {

	public ArrayOfProductTransList productsInCategory(String categoryName, String clientProductType) {
		ConnectionDB connectionDB = new ConnectionDB();
		ProductEntity productEntity = new ProductEntity();
		productEntity.setCategoryName(categoryName);
		productEntity.setProductType(clientProductType);
		List<?> find = connectionDB.find(productEntity);
		ArrayOfProductTransList arrayOfProductTransList = new ArrayOfProductTransList();
		for (Object object : find) {
			ProductEntity prodTmp = (ProductEntity) object;
			arrayOfProductTransList.add(prodTmp);
		}
		return arrayOfProductTransList;
	}
}
