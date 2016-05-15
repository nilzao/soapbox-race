package br.com.soapboxrace.bo;

import br.com.soapboxrace.dao.BasketDefinitionDao;
import br.com.soapboxrace.dao.CustomCarDao;
import br.com.soapboxrace.dao.OwnedCarDao;
import br.com.soapboxrace.dao.PersonaDao;
import br.com.soapboxrace.definition.ShoppingCartPurchaseResult;
import br.com.soapboxrace.jaxb.CommerceResultTransType;
import br.com.soapboxrace.jaxb.CustomCarType;
import br.com.soapboxrace.jaxb.InventoryItemTransType;
import br.com.soapboxrace.jaxb.InventoryItemsType;
import br.com.soapboxrace.jaxb.PurchasedCarsType;
import br.com.soapboxrace.jaxb.WalletTransType;
import br.com.soapboxrace.jaxb.WalletsType;
import br.com.soapboxrace.jpa.BasketDefinitionEntity;
import br.com.soapboxrace.jpa.CustomCarEntity;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.PersonaEntity;

public class BasketBO {

	private PersonaDao personaDao = new PersonaDao();
	private BasketDefinitionDao basketDefinitionDao = new BasketDefinitionDao();
	private CustomCarDao customCarDao = new CustomCarDao();
	private OwnedCarDao ownedCarDao = new OwnedCarDao();

	public CommerceResultTransType basket(long idPersona, String productId) {
		// TODO: Economy input, currency calculation, and car slot checking.
		PersonaEntity personaEntity = personaDao.findById(idPersona);
		CommerceResultTransType commerceResultTransType = new CommerceResultTransType();
		PurchasedCarsType purchasedCarsType = new PurchasedCarsType();

		// -- Wallet
		WalletTransType walletTransType = new WalletTransType();
		walletTransType.setBalance(personaEntity.getCash());
		walletTransType.setCurrency("CASH");

		WalletsType walletsType = new WalletsType();
		walletsType.setWalletTrans(walletTransType);

		commerceResultTransType.setWallets(walletsType);

		// Currently not important, so we just fill in dummy response
		InventoryItemTransType inventoryItemTransType = new InventoryItemTransType();
		InventoryItemsType inventoryItemsType = new InventoryItemsType();
		inventoryItemsType.setInventoryItemTrans(inventoryItemTransType);

		commerceResultTransType.setCommerceItems("");
		commerceResultTransType.setInvalidBasket("");
		commerceResultTransType.setInventoryItems(inventoryItemsType);

		// -- Set up empty response in case query returns null
		commerceResultTransType.setPurchasedCars(purchasedCarsType);
		commerceResultTransType.setStatus(ShoppingCartPurchaseResult.aFail_itemnotavail);

		BasketDefinitionEntity basketDefinition = basketDefinitionDao.findByProductId(productId);

		if (basketDefinition != null) {
			CustomCarType customCar = basketDefinition.getOwnedCarTrans().getCustomCar();

			OwnedCarEntity ownedCarEntity = new OwnedCarEntity();
			CustomCarEntity customCarEntity = new CustomCarEntity();
			customCarEntity.setApiId(customCar.getApiId());
			customCarEntity.setBaseCarId(customCar.getBaseCarId());
			customCarEntity.setCarClassHash(customCar.getCarClassHash());
			customCarEntity.setPaints(customCar.getPaints());
			customCarEntity.setPerformanceParts(customCar.getPerformanceParts());
			customCarEntity.setPhysicsProfileHash(customCar.getPhysicsProfileHash());
			customCarEntity.setRating(customCar.getRating());
			customCarEntity.setResalePrice(customCar.getResalePrice());
			customCarEntity.setSkillModParts(customCar.getSkillModParts());
			customCarEntity.setSkillModSlotCount((short) 5);
			customCarEntity.setVinyls(customCar.getVinyls());
			customCarEntity.setVisualParts(customCar.getVisualParts());
			customCarEntity.setParentOwnedCarTrans(ownedCarEntity);

			ownedCarEntity.setCustomCar(customCarEntity);
			ownedCarEntity.setDurability((short) 100);
			ownedCarEntity.setExpirationDate(null);
			ownedCarEntity.setHeatLevel((short) 0);
			ownedCarEntity.setOwnershipType("PresetCar");
			ownedCarEntity.setPersona(personaEntity);

			ownedCarDao.save(ownedCarEntity);
			customCarDao.save(customCarEntity);

			purchasedCarsType.setOwnedCarTrans(ownedCarEntity.getOwnedCarTransType());
			commerceResultTransType.setPurchasedCars(purchasedCarsType);
			commerceResultTransType.setStatus(ShoppingCartPurchaseResult.aSuccess);
		}
		return commerceResultTransType;
	}
}
