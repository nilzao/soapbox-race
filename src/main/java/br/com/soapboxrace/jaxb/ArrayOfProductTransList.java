package br.com.soapboxrace.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jpa.ProductEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProductTransType")
@XmlRootElement(name = "ArrayOfProductTrans")
public class ArrayOfProductTransList {

	@XmlElement(name = "ProductTrans")
	protected List<ProductEntity> productTrans;

	public List<ProductEntity> getProductTrans() {
		return productTrans;
	}

	public void setProductTrans(List<ProductEntity> productTrans) {
		this.productTrans = productTrans;
	}

	public boolean add(ProductEntity e) {
		if (productTrans == null) {
			productTrans = new ArrayList<ProductEntity>();
		}
		return productTrans.add(e);
	}

}
