package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.CatalogBO;
import br.com.soapboxrace.jaxb.ArrayOfCategoryTrans;
import br.com.soapboxrace.jaxb.ArrayOfProductTrans;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class Catalog extends Router {

	private CatalogBO catalogBO = new CatalogBO();

	public String productsInCategory() {
		String categoryName = getParam("categoryName");
		String clientProductType = getParam("clientProductType");

		ArrayOfProductTrans productsInCategory = catalogBO.productsInCategory(categoryName, clientProductType);

		return MarshalXML.marshal(productsInCategory);
	}

	public String categories() {
		ArrayOfCategoryTrans categories = catalogBO.categories();
		return MarshalXML.marshal(categories);
	}

}