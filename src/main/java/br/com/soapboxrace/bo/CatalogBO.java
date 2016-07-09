package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.dao.CategoryDao;
import br.com.soapboxrace.dao.ProductDao;
import br.com.soapboxrace.jaxb.ArrayOfCategoryTrans;
import br.com.soapboxrace.jaxb.ArrayOfProductTrans;
import br.com.soapboxrace.jpa.ProductEntity;

public class CatalogBO {

	private ProductDao productDao = new ProductDao();
	private CategoryDao categoryDao = new CategoryDao();

	public ArrayOfProductTrans productsInCategory(String categoryName, String clientProductType) {
		List<ProductEntity> products = productDao.findByCategoryNameClientProductType(categoryName, clientProductType);
		ArrayOfProductTrans arrayOfProductTrans = new ArrayOfProductTrans();
		arrayOfProductTrans.setProductTransList(products);
		return arrayOfProductTrans;
	}

	public ArrayOfCategoryTrans categories() {
		return categoryDao.getAll();
	}
}