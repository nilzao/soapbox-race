package br.com.soapboxrace.bo;

import org.hibernate.Hibernate;

import br.com.soapboxrace.dao.BasketDefinitionDao;
import br.com.soapboxrace.dao.OwnedCarDao;
import br.com.soapboxrace.dao.PersonaDao;
import br.com.soapboxrace.definition.ShoppingCartPurchaseResult;
import br.com.soapboxrace.jaxb.CommerceResultTransType;
import br.com.soapboxrace.jaxb.InventoryItemTransType;
import br.com.soapboxrace.jaxb.InventoryItemsType;
import br.com.soapboxrace.jaxb.PurchasedCarsType;
import br.com.soapboxrace.jaxb.WalletTransType;
import br.com.soapboxrace.jaxb.WalletsType;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
import br.com.soapboxrace.jpa.BasketDefinitionEntity;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.PersonaEntity;

public class BasketBO {

	private PersonaDao personaDao = new PersonaDao();
	private BasketDefinitionDao basketDefinitionDao = new BasketDefinitionDao();
	private OwnedCarDao ownedCarDao = new OwnedCarDao();
	PersonaBO personaBO = new PersonaBO();

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
			String ownedCarTrans = basketDefinition.getOwnedCarTrans();
			OwnedCarEntity ownedCarEntity = (OwnedCarEntity) UnmarshalXML.unMarshal(ownedCarTrans,
					new OwnedCarEntity());
			ownedCarEntity.setId(0L);
			ownedCarEntity.setDurability((short) 100);
			ownedCarEntity.setExpirationDate(null);
			ownedCarEntity.setHeatLevel((short) 0);
			ownedCarEntity.setOwnershipType("PresetCar");
			ownedCarEntity.setPersona(personaEntity);

			ownedCarEntity = (OwnedCarEntity) ownedCarDao.save(ownedCarEntity);
			// Hibernate.initialize(personaEntity.getOwnedCarlist());
			personaBO.changeDefaultCar(idPersona, ownedCarEntity.getId());

			purchasedCarsType.setOwnedCarTrans(ownedCarEntity);
			commerceResultTransType.setPurchasedCars(purchasedCarsType);
			commerceResultTransType.setStatus(ShoppingCartPurchaseResult.aSuccess);
		}
		return commerceResultTransType;
	}

}
