package br.com.soapboxrace.jpa;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.soapboxrace.jaxb.OwnedCarTransType;
import br.com.soapboxrace.jaxb.convert.OwnedCarTransConverter;

@Entity
@Table(name = "BASKETDEFINITION")
public class BasketDefinitionEntity implements ISoapBoxEntity {

	private static final long serialVersionUID = 5314835854384144787L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ProductId")
	private String productId;

	@Convert(converter = OwnedCarTransConverter.class)
	@Column(name = "OwnedCarTrans", length = 40000)
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
