package br.com.soapboxrace.jpa;

import java.io.Serializable;

public interface ISoapBoxEntity extends Serializable {

	public void setId(Long id);

	public Long getId();
}
