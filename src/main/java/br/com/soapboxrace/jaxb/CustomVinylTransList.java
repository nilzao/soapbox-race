package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import br.com.soapboxrace.jpa.CustomVinylEntity;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomVinylTransList {

	@XmlElement(name = "CustomVinylTrans", required = true)
	protected List<CustomVinylEntity> customVinylList;

	public List<CustomVinylEntity> getCustomVinylList() {
		return customVinylList;
	}

	public void setCustomVinylList(List<CustomVinylEntity> customVinylList) {
		this.customVinylList = customVinylList;
	}

}
