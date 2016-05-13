package br.com.soapboxrace.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.soapboxrace.definition.convert.OwnedCarTransConverter;
import br.com.soapboxrace.jaxb.OwnedCarTransType;

@Entity
@Table(name = "BASKETDEFINITION")
public class BasketDefinitionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "ProductId")
	private String productId;

	@Convert(converter = OwnedCarTransConverter.class)
	@Column(name = "OwnedCarTrans")
	private OwnedCarTransType ownedCarTrans;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public OwnedCarTransType getOwnedCarTrans() {
		return ownedCarTrans;
	}

	public void setOwnedCarTrans(OwnedCarTransType ownedCarTrans) {
		this.ownedCarTrans = ownedCarTrans;
	}
}