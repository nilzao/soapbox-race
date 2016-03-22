package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.PersonaBO;
import br.com.soapboxrace.jaxb.BasketTransType;
import br.com.soapboxrace.jaxb.CarSlotInfoTrans;
import br.com.soapboxrace.jaxb.CommerceResultTransType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
import br.com.soapboxrace.jpa.OwnedCarEntity;

public class Personas extends Router {

	private PersonaBO personaBO = new PersonaBO();

	private long getPersonaId() {
		String[] targetSplitted = getTarget().split("/");
		Long idPersona = Long.valueOf(targetSplitted[4]);
		return idPersona;
	}

	public String carslots() {
		CarSlotInfoTrans carslots = personaBO.carslots(getPersonaId());
		return MarshalXML.marshal(carslots);
	}

	public String inventory() {
		return "<InventoryTrans/>";
	}

	public String defaultcar() {
		long personaId = getPersonaId();
		OwnedCarEntity ownedCarEntity = personaBO.defaultcar(personaId);
		return MarshalXML.marshal(ownedCarEntity);
	}

	public String baskets() {
		String basketXml = readInputStream();
		BasketTransType basketTransType = new BasketTransType();
		basketTransType = (BasketTransType) UnmarshalXML.unMarshal(basketXml, basketTransType);
		String productId = basketTransType.getItems().getBasketItemTrans().getProductId();
		CommerceResultTransType commerceResultTrans = personaBO.basket(getPersonaId(), productId);
		return MarshalXML.marshal(commerceResultTrans);
	}

	public String cars() {
		return "";
	}
}
