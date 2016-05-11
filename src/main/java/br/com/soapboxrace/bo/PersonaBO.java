package br.com.soapboxrace.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.definition.ShoppingCartPurchaseResult;
import br.com.soapboxrace.definition.convert;
import br.com.soapboxrace.jaxb.CarSlotInfoTrans;
import br.com.soapboxrace.jaxb.CarsOwnedByPersonaList;
import br.com.soapboxrace.jaxb.CommerceResultTransType;
import br.com.soapboxrace.jaxb.CommerceSessionResultTransType;
import br.com.soapboxrace.jaxb.InventoryItemTransType;
import br.com.soapboxrace.jaxb.InventoryItemsType;
import br.com.soapboxrace.jaxb.ObtainableSlotsList;
import br.com.soapboxrace.jaxb.PurchasedCarsType;
import br.com.soapboxrace.jaxb.UpdatedCarType;
import br.com.soapboxrace.jaxb.WalletTransType;
import br.com.soapboxrace.jaxb.WalletsType;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.ProductEntity;

public class PersonaBO {
	private ConnectionDB connectionDB = new ConnectionDB();

	public CarSlotInfoTrans carslots(long idPersona) {
		EntityManager manager = ConnectionDB.getManager();
		TypedQuery<OwnedCarEntity> query = manager
				.createQuery("SELECT obj FROM OwnedCarEntity obj WHERE obj.persona = :persona", OwnedCarEntity.class);
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setId(idPersona);
		query.setParameter("persona", personaEntity);
		List<OwnedCarEntity> ownedCars = query.getResultList();

		CarSlotInfoTrans carSlotInfoTrans = new CarSlotInfoTrans();
		CarsOwnedByPersonaList carsOwnedByPersonaList = new CarsOwnedByPersonaList();
		carSlotInfoTrans.setCarsOwnedByPersonaList(carsOwnedByPersonaList);
		if (ownedCars.size() > 0) {
			carsOwnedByPersonaList.setOwnedCarList(ownedCars);
		}
		carSlotInfoTrans.setDefaultOwnedCarIndex(personaEntity.getCurCarIndex());
		carSlotInfoTrans.setOwnedCarSlotsCount(1);

		ArrayList<ProductEntity> productList = new ArrayList<ProductEntity>();
		ProductEntity productEntity = new ProductEntity();
		productEntity.setBundleItems("");
		productEntity.setCategoryId("");
		productEntity.setCurrency("CASH");
		productEntity.setDescription("New car slot !!");
		productEntity.setDurationMinute(0);
		productEntity.setHash(-1143680669);
		productEntity.setIcon("128_cash");
		productEntity.setLevel(12);
		productEntity.setLongDescription("New car slot !!");
		productEntity.setPrice(1);
		productEntity.setPriority(0);
		productEntity.setProductId("NFSW-NA:044EC294");
		productEntity.setProductTitle("New car slot !!");
		productEntity.setProductType("CARSLOT");
		productEntity.setSecondaryIcon("");
		productEntity.setUseCount(1);
		productEntity.setVisualStyle("");
		productEntity.setWebIcon("");
		productEntity.setWebLocation("");
		productList.add(productEntity);

		ObtainableSlotsList obtainableSlotsList = new ObtainableSlotsList();
		obtainableSlotsList.setProductList(productList);
		carSlotInfoTrans.setObtainableSlots(obtainableSlotsList);
		return carSlotInfoTrans;
	}

	public CommerceSessionResultTransType commerce(long idPersona,
			UpdatedCarType updatedCar /* String[] productIds */) {
		// TODO: Economy input, currency calculation, and manual processing of basket items.

		PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(new PersonaEntity(), idPersona);
		CommerceSessionResultTransType commerceSessionResultTransType = new CommerceSessionResultTransType();

		// -- Wallet
		WalletTransType walletTransType = new WalletTransType();
		walletTransType.setBalance(personaEntity.getCash());
		walletTransType.setCurrency("CASH");

		WalletsType walletsType = new WalletsType();
		walletsType.setWalletTrans(walletTransType);

		commerceSessionResultTransType.setWallets(walletsType);

		// -- Modify the car on DB
		OwnedCarEntity currentCar = defaultcar(personaEntity.getId());
		currentCar.getCustomCar().setVinyls(updatedCar.getCustomCar().getVinyls());
		currentCar.getCustomCar().setPaints(updatedCar.getCustomCar().getPaints());
		currentCar.getCustomCar().setPerformanceParts(updatedCar.getCustomCar().getPerformanceParts());
		currentCar.getCustomCar().setSkillModParts(updatedCar.getCustomCar().getSkillModParts());
		currentCar.getCustomCar().setVisualParts(updatedCar.getCustomCar().getVisualParts());
		connectionDB.merge(currentCar);

		// -- Set the response car
		commerceSessionResultTransType.setUpdatedCar(convert.fromOwnedCarToUpdatedCar(currentCar));

		// Currently not important, so we just fill in dummy response
		commerceSessionResultTransType.setInvalidBasket("");
		commerceSessionResultTransType.setInventoryItems(new InventoryItemsType());
		commerceSessionResultTransType.setStatus(ShoppingCartPurchaseResult.aSuccess);

		return commerceSessionResultTransType;
	}

	public CommerceResultTransType basket(long idPersona, String productId) {
		CommerceResultTransType commerceResultTransType = new CommerceResultTransType();
		WalletsType walletsType = new WalletsType();
		WalletTransType walletTransType = new WalletTransType();
		walletTransType.setCurrency("CASH");
		walletsType.setWalletTrans(walletTransType);
		commerceResultTransType.setWallets(walletsType);
		PurchasedCarsType purchasedCarsType = new PurchasedCarsType();
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductId(productId);
		InventoryItemsType inventoryItemsType = new InventoryItemsType();
		InventoryItemTransType inventoryItemTransType = new InventoryItemTransType();
		inventoryItemTransType.setStatus("ACTIVE");
		inventoryItemTransType.setVirtualItemType("presetcar");
		inventoryItemTransType.setExpirationDate("");
		inventoryItemTransType.setHash(831687504);
		inventoryItemTransType.setInventoryId(1234567);
		inventoryItemTransType.setEntitlementTag("NOTHING");
		inventoryItemTransType.setProductId("ANYTHING");
		inventoryItemTransType.setStringHash("0x31928b50");
		commerceResultTransType.setStatus(ShoppingCartPurchaseResult.aFail_insufficientfunds);
		commerceResultTransType.setCommerceItems("");
		commerceResultTransType.setInvalidBasket("");
		inventoryItemsType.setInventoryItemTrans(inventoryItemTransType);
		commerceResultTransType.setInventoryItems(inventoryItemsType);
		commerceResultTransType.setPurchasedCars(new PurchasedCarsType());
		List<?> find = connectionDB.find(productEntity);
		if (find.size() > 0) {
			productEntity = (ProductEntity) find.get(0);
			OwnedCarEntity ownedCar = new OwnedCarEntity();
			purchasedCarsType.setOwnedCarTrans(ownedCar);
			commerceResultTransType.setPurchasedCars(purchasedCarsType);
			commerceResultTransType.setStatus("Success");

			EntityManager manager = ConnectionDB.getManager();

			PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(new PersonaEntity(), idPersona);
			manager.detach(ownedCar);
			ownedCar.setUniqueCarId(0);
			ownedCar.setPersona(personaEntity);
			connectionDB.persist(ownedCar);
		}
		return commerceResultTransType;
	}

	public OwnedCarEntity defaultcar(long idPersona) {
		PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(new PersonaEntity(), idPersona);
		personaEntity.setId(idPersona);
		List<OwnedCarEntity> ownedCarList = getOwnedCarList(personaEntity);
		return ownedCarList.get(personaEntity.getCurCarIndex());
	}

	public void changeDefaultCar(long idPersona, long defaultCarId) {
		PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(new PersonaEntity(), idPersona);
		List<OwnedCarEntity> ownedCarList = getOwnedCarList(personaEntity);
		int i = 0;
		for (OwnedCarEntity ownedCarEntity : ownedCarList) {
			if (ownedCarEntity.getUniqueCarId() == defaultCarId) {
				break;
			}
			i++;
		}
		personaEntity.setCurCarIndex(i);
		connectionDB.merge(personaEntity);
	}

	private List<OwnedCarEntity> getOwnedCarList(PersonaEntity personaEntity) {
		EntityManager manager = ConnectionDB.getManager();
		TypedQuery<OwnedCarEntity> query = manager.createQuery(
				"SELECT obj FROM OwnedCarEntity obj WHERE obj.persona = :persona order by obj.id",
				OwnedCarEntity.class);
		query.setParameter("persona", personaEntity);
		return query.getResultList();
	}
}