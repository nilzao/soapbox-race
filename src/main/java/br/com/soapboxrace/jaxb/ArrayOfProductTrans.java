package br.com.soapboxrace.jaxb;

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
public class ArrayOfProductTrans {

	@XmlElement(name = "ProductTrans")
	protected List<ProductEntity> productTrans;

	public List<ProductEntity> getProductTrans() {
		return productTrans;
	}

	public void setProductTrans(List<ProductEntity> productTrans) {
		this.productTrans = productTrans;
	}
}