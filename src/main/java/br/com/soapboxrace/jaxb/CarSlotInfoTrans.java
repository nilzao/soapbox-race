package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CarSlotInfoTrans")
public class CarSlotInfoTrans {

	@XmlElement(name = "CarsOwnedByPersona")
	private CarsOwnedByPersonaList carsOwnedByPersonaList = new CarsOwnedByPersonaList();

	@XmlElement(name = "DefaultOwnedCarIndex")
	private int defaultOwnedCarIndex;

	@XmlElement(name = "ObtainableSlots")
	private ObtainableSlotsList obtainableSlots;

	@XmlElement(name = "OwnedCarSlotsCount")
	private int ownedCarSlotsCount;

	public CarsOwnedByPersonaList getCarsOwnedByPersonaList() {
		return carsOwnedByPersonaList;
	}

	public void setCarsOwnedByPersonaList(CarsOwnedByPersonaList carsOwnedByPersonaList) {
		this.carsOwnedByPersonaList = carsOwnedByPersonaList;
	}

	public int getDefaultOwnedCarIndex() {
		return defaultOwnedCarIndex;
	}

	public void setDefaultOwnedCarIndex(int defaultOwnedCarIndex) {
		this.defaultOwnedCarIndex = defaultOwnedCarIndex;
	}

	public ObtainableSlotsList getObtainableSlots() {
		return obtainableSlots;
	}

	public void setObtainableSlots(ObtainableSlotsList obtainableSlots) {
		this.obtainableSlots = obtainableSlots;
	}

	public int getOwnedCarSlotsCount() {
		return ownedCarSlotsCount;
	}

	public void setOwnedCarSlotsCount(int ownedCarSlotsCount) {
		this.ownedCarSlotsCount = ownedCarSlotsCount;
	}

}
