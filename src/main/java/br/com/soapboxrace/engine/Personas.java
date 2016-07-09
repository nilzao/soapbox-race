package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.PersonaBO;
import br.com.soapboxrace.definition.ServerExceptions;
import br.com.soapboxrace.definition.ServerExceptions.PersonaIdMismatchException;
import br.com.soapboxrace.jaxb.ArrayOfOwnedCarTransType;
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

	private long getPersonaId(boolean isBypass) throws PersonaIdMismatchException {
		String[] targetSplitted = getTarget().split("/");
		Long personaId = Long.valueOf(targetSplitted[4]);
		if (((isBypass || personaId.equals(getLoggedPersonaId()) || getLoggedPersonaId() == -1L)))
			if (getUserId() != -1L && !getSecurityToken().isEmpty() && Router.activeUsers.get(getUserId()).getSecurityToken().equals(getSecurityToken()))
				return personaId;
		throw new ServerExceptions.PersonaIdMismatchException(getLoggedPersonaId(), personaId);
	}

	private long getPersonaId() throws PersonaIdMismatchException {
		return getPersonaId(false);
	}

	private long getDefaultCarId() {
		long carId = 0;
		String[] targetSplitted = getTarget().split("/");
		if (targetSplitted.length == 7) {
			carId = Long.valueOf(targetSplitted[6]);
		}
		return carId;
	}

	public String carslots() throws PersonaIdMismatchException {
		CarSlotInfoTrans carslots = personaBO.carslots(getPersonaId());
		return MarshalXML.marshal(carslots);
	}

	public String inventory() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<InventoryTrans>");
		stringBuilder.append("<InventoryItems>");
		stringBuilder.append("<InventoryItemTrans>");
		stringBuilder.append("<EntitlementTag>nosshot</EntitlementTag>");
		stringBuilder.append("<ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("<Hash>-1681514783</Hash>");
		stringBuilder.append("<InventoryId>1842996427</InventoryId>");
		stringBuilder.append("<ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("<RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("<ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("<Status>ACTIVE</Status>");
		stringBuilder.append("<StringHash>0x9bc61ee1</StringHash>");
		stringBuilder.append("<VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("</InventoryItemTrans>");
		stringBuilder.append("<InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>runflattires</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>-537557654</Hash>");
		stringBuilder.append("      <InventoryId>2876729160</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0xdff5856a</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans>");
		stringBuilder.append("    <InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>instantcooldown</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>-1692359144</Hash>");
		stringBuilder.append("      <InventoryId>2876729162</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0x9b20a618</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans>");
		stringBuilder.append("    <InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>shield</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>-364944936</Hash>");
		stringBuilder.append("      <InventoryId>2876729163</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0xea3f61d8</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans>");
		stringBuilder.append("    <InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>slingshot</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>2236629</Hash>");
		stringBuilder.append("      <InventoryId>2876729164</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0x2220d5</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans>");
		stringBuilder.append("    <InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>ready</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>957701799</Hash>");
		stringBuilder.append("      <InventoryId>2876729165</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0x39155ea7</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans>");
		stringBuilder.append("    <InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>juggernaut</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>1805681994</Hash>");
		stringBuilder.append("      <InventoryId>2876729166</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0x6ba0854a</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans>");
		stringBuilder.append("    <InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>emergencyevade</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>-611661916</Hash>");
		stringBuilder.append("      <InventoryId>2876729167</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0xdb8ac7a4</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans>");
		stringBuilder.append("    <InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>team_emergencyevade</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>-1564932069</Hash>");
		stringBuilder.append("      <InventoryId>2876729168</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0xa2b9081b</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans>");
		stringBuilder.append("    <InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>onemorelap</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>1627606782</Hash>");
		stringBuilder.append("      <InventoryId>2876729170</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0x61034efe</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans>");
		stringBuilder.append("    <InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>team_slingshot</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>1113720384</Hash>");
		stringBuilder.append("      <InventoryId>2876729171</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0x42620640</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans><InventoryItemTrans>");
		stringBuilder.append("      <EntitlementTag>trafficmagnet</EntitlementTag>");
		stringBuilder.append("      <ExpirationDate i:nil=\"true\" />");
		stringBuilder.append("      <Hash>125509666</Hash>");
		stringBuilder.append("      <InventoryId>2880783203</InventoryId>");
		stringBuilder.append("      <ProductId>DO NOT USE ME</ProductId>");
		stringBuilder.append("      <RemainingUseCount>100</RemainingUseCount>");
		stringBuilder.append("      <ResellPrice>0.00000</ResellPrice>");
		stringBuilder.append("      <Status>ACTIVE</Status>");
		stringBuilder.append("      <StringHash>0x77b2022</StringHash>");
		stringBuilder.append("      <VirtualItemType>powerup</VirtualItemType>");
		stringBuilder.append("    </InventoryItemTrans>");
		stringBuilder.append("  </InventoryItems>");
		stringBuilder.append("</InventoryTrans>");
		String inventoryStr = stringBuilder.toString();
		return inventoryStr;
	}

	public String defaultcar() throws PersonaIdMismatchException {
		long personaId = getPersonaId(true);
		long defaultCarId = getDefaultCarId();
		if (defaultCarId != 0) {
			personaBO.changeDefaultCar(personaId, defaultCarId);
			return "";
		}
		OwnedCarEntity ownedCarEntity = personaBO.defaultcar(personaId);
		if (ownedCarEntity != null) {
			return MarshalXML.marshal(ownedCarEntity);
		}
		return "";
	}

	public String commerce() throws PersonaIdMismatchException {
		String commerceXml = readInputStream();
		CommerceSessionTransType commerceSessionTransType = new CommerceSessionTransType();
		commerceSessionTransType = (CommerceSessionTransType) UnmarshalXML.unMarshal(commerceXml, commerceSessionTransType);
		CommerceSessionResultTransType commerceSessionResultTrans = personaBO.commerce(getPersonaId(), commerceSessionTransType.getUpdatedCar());
		return MarshalXML.marshal(commerceSessionResultTrans);
	}

	public String baskets() throws PersonaIdMismatchException {
		String basketXml = readInputStream();
		BasketTransType basketTransType = new BasketTransType();
		basketTransType = (BasketTransType) UnmarshalXML.unMarshal(basketXml, basketTransType);
		String productId = basketTransType.getBasketItems().getBasketItemTrans().getProductId();
		CommerceResultTransType commerceResultTrans = personaBO.basket(getPersonaId(), productId);
		return MarshalXML.marshal(commerceResultTrans);
	}

	public String cars() throws PersonaIdMismatchException {
		if (getRequest().getMethod().equals("POST")) { // sell car
			String serialNumber = getParam("serialNumber");
			if (serialNumber != null) {
				Long personaId = getPersonaId();
				Long carId = Long.valueOf(serialNumber);
				OwnedCarEntity defaultCar = personaBO.sellCar(personaId, carId);
				return MarshalXML.marshal(defaultCar);
			}
		} else if (getRequest().getMethod().equals("PUT")) {
			long personaId = getPersonaId();
			OwnedCarEntity ownedCarEntity = personaBO.defaultcar(personaId);
			if (ownedCarEntity != null) {
				ownedCarEntity.setExpirationDate("");
				return MarshalXML.marshal(ownedCarEntity);
			}
		} else { // get cars
			Long personaId = getPersonaId(true);
			ArrayOfOwnedCarTransType arrayofOwnedCarTrans = personaBO.getCars(personaId);
			return MarshalXML.marshal(arrayofOwnedCarTrans);
		}
		return "";
	}
}