package br.com.soapboxrace.jaxb;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jpa.ProductEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObtainableSlotsType", propOrder = { "productTransList" })
public class ObtainableSlotsList {

	@XmlElement(name = "ProductTrans", required = true)
	protected List<ProductEntity> productTransList;

	public List<ProductEntity> getProductList() {
		return productTransList;
	}

	public void setProductList(List<ProductEntity> ProductList) {
		this.productTransList = ProductList;
	}
}
