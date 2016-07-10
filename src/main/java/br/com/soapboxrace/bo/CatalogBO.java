package br.com.soapboxrace.bo;

import java.util.List;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.ICategoryDao;
import br.com.soapboxrace.dao.factory.IProductDao;
import br.com.soapboxrace.jaxb.ArrayOfCategoryTrans;
import br.com.soapboxrace.jaxb.ArrayOfProductTrans;
import br.com.soapboxrace.jpa.ProductEntity;

public class CatalogBO {

	private IProductDao productDao = DaoFactory.getProductDao();
	private ICategoryDao categoryDao = DaoFactory.getCategoryDao();

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