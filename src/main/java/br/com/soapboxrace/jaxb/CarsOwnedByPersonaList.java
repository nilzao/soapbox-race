package br.com.soapboxrace.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import br.com.soapboxrace.jpa.OwnedCarEntity;

@XmlAccessorType(XmlAccessType.FIELD)
public class CarsOwnedByPersonaList {

	@XmlElement(name = "OwnedCarTrans", required = true)
	protected List<OwnedCarEntity> ownedCarList;

	public List<OwnedCarEntity> getOwnedCarList() {
		return ownedCarList;
	}

	public void setOwnedCarList(List<OwnedCarEntity> ownedCarList) {
		this.ownedCarList = ownedCarList;
	}

	public boolean add(OwnedCarEntity e) {
		if (ownedCarList == null) {
			ownedCarList = new ArrayList<OwnedCarEntity>();
		}
		return ownedCarList.add(e);
	}

}