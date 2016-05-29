package br.com.soapboxrace.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "OwnedCarTrans")
	private String ownedCarTrans;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getOwnedCarTrans() {
		return ownedCarTrans;
	}

	public void setOwnedCarTrans(String ownedCarTrans) {
		this.ownedCarTrans = ownedCarTrans;
	}

}
