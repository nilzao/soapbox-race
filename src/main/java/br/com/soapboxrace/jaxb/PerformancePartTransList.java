package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import br.com.soapboxrace.jpa.PerformancePartEntity;

@XmlAccessorType(XmlAccessType.FIELD)
public class PerformancePartTransList {

	@XmlElement(name = "PerformancePartTrans", required = true)
	protected List<PerformancePartEntity> performancePartList;

	public List<PerformancePartEntity> getPerformancePartList() {
		return performancePartList;
	}

	public void setPerformancePartList(List<PerformancePartEntity> performancePartList) {
		this.performancePartList = performancePartList;
	}

}
