package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import br.com.soapboxrace.jpa.VisualPartEntity;

@XmlAccessorType(XmlAccessType.FIELD)
public class VisualPartTransList {

	@XmlElement(name = "VisualPartTrans", required = true)
	protected List<VisualPartEntity> visualPartList;

	public List<VisualPartEntity> getVisualPartList() {
		return visualPartList;
	}

	public void setVisualPartList(List<VisualPartEntity> visualPartList) {
		this.visualPartList = visualPartList;
	}

}
