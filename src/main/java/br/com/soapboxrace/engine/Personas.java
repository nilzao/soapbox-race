package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.PersonaBO;
import br.com.soapboxrace.jaxb.BasketTransType;
import br.com.soapboxrace.jaxb.CarSlotInfoTrans;
import br.com.soapboxrace.jaxb.CommerceResultTransType;
import br.com.soapboxrace.jaxb.CommerceSessionResultTransType;
import br.com.soapboxrace.jaxb.CommerceSessionTransType;
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

	private long getDefaultCarId() {
		long carId = 0;
		String[] targetSplitted = getTarget().split("/");
		if (targetSplitted.length == 7) {
			carId = Long.valueOf(targetSplitted[6]);
		}
		return carId;
	}

	public String carslots() {
		CarSlotInfoTrans carslots = personaBO.carslots(getPersonaId());
		return MarshalXML.marshal(carslots);// .replaceAll("&gt;",
											// ">").replaceAll("&lt;", "<");
	}

	public String inventory() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<InventoryTrans>\n");
		stringBuilder.append("<InventoryItems>\n");
		stringBuilder.append("<InventoryItemTrans>\n");
		stringBuilder.append("<EntitlementTag>nosshot</EntitlementTag>\n");
		stringBuilder.append("<ExpirationDate i:nil=\"true\" />\n");
		stringBuilder.append("<Hash>-1681514783</Hash>\n");
		stringBuilder.append("<InventoryId>1842996427</InventoryId>\n");
		stringBuilder.append("<ProductId>DO NOT USE ME</ProductId>\n");
		stringBuilder.append("<RemainingUseCount>100</RemainingUseCount>\n");
		stringBuilder.append("<ResellPrice>0.00000</ResellPrice>\n");
		stringBuilder.append("<Status>ACTIVE</Status>\n");
		stringBuilder.append("<StringHash>0x9bc61ee1</StringHash>\n");
		stringBuilder.append("<VirtualItemType>powerup</VirtualItemType>\n");
		stringBuilder.append("</InventoryItemTrans>\n");
		stringBuilder.append("</InventoryItems>\n");
		stringBuilder.append("</InventoryTrans>");
		String inventoryStr = stringBuilder.toString();
		return inventoryStr;
	}

	public String defaultcar() {
		long personaId = getPersonaId();
		long defaultCarId = getDefaultCarId();
		if (defaultCarId != 0) {
			personaBO.changeDefaultCar(personaId, defaultCarId);
			return "";
		}
		OwnedCarEntity ownedCarEntity = personaBO.defaultcar(personaId);
		return MarshalXML.marshal(ownedCarEntity);
	}

	public String commerce() {
		String commerceXml = readInputStream();
		CommerceSessionTransType commerceSessionTransType = new CommerceSessionTransType();
		commerceSessionTransType = (CommerceSessionTransType) UnmarshalXML.unMarshal(commerceXml,
				commerceSessionTransType);
		// String[] productIds = new String[] {"0", "1", "2"};
		// commerceSessionTransType.getBasket().getItems().getBasketItemTrans().getProductId();
		CommerceSessionResultTransType commerceSessionResultTrans = personaBO.commerce(getPersonaId(),
				commerceSessionTransType.getUpdatedCar());
		return MarshalXML.marshal(commerceSessionResultTrans);
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
