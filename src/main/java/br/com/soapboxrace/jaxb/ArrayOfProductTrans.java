package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jpa.ProductEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProductTrans")
@XmlRootElement(name = "ArrayOfProductTrans")
public class ArrayOfProductTrans {

	@XmlElement(name = "ProductTrans")
	protected List<ProductEntity> productTransList;

	public List<ProductEntity> getProductTransList() {
		return productTransList;
	}

	public void setProductTransList(List<ProductEntity> productTransList) {
		this.productTransList = productTransList;
	}
}