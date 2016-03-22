package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import br.com.soapboxrace.jpa.CustomPaintEntity;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomPaintTransList {

	@XmlElement(name = "CustomPaintTrans", required = true)
	protected List<CustomPaintEntity> customPaintList;

	public List<CustomPaintEntity> getCustomPaintList() {
		return customPaintList;
	}

	public void setCustomPaintList(List<CustomPaintEntity> customPaintList) {
		this.customPaintList = customPaintList;
	}

}
