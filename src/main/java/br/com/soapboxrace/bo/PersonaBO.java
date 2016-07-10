package br.com.soapboxrace.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.soapboxrace.dao.factory.DaoFactory;
import br.com.soapboxrace.dao.factory.IBasketDefinitionDao;
import br.com.soapboxrace.dao.factory.IOwnedCarDao;
import br.com.soapboxrace.dao.factory.IPersonaDao;
import br.com.soapboxrace.dao.factory.IProductDao;
import br.com.soapboxrace.definition.ShoppingCartPurchaseResult;
import br.com.soapboxrace.jaxb.ArrayOfOwnedCarTransType;
import br.com.soapboxrace.jaxb.CarSlotInfoTrans;
import br.com.soapboxrace.jaxb.CarsOwnedByPersonaList;
import br.com.soapboxrace.jaxb.CommerceResultTransType;
import br.com.soapboxrace.jaxb.CommerceSessionResultTransType;
import br.com.soapboxrace.jaxb.CustomCarType;
import br.com.soapboxrace.jaxb.InventoryItemTransType;
import br.com.soapboxrace.jaxb.InventoryItemsType;
import br.com.soapboxrace.jaxb.ObtainableSlotsList;
import br.com.soapboxrace.jaxb.PurchasedCarsType;
import br.com.soapboxrace.jaxb.UpdatedCarType;
import br.com.soapboxrace.jaxb.WalletTransType;
import br.com.soapboxrace.jaxb.WalletsType;
import br.com.soapboxrace.jpa.BasketDefinitionEntity;
import br.com.soapboxrace.jpa.CustomCarEntity;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.ProductEntity;

public class PersonaBO {

	private IOwnedCarDao ownedCarDao = DaoFactory.getOwnedCarDao();
	private IBasketDefinitionDao basketDefinitionDao = DaoFactory.getBasketDefinitionDao();
	private IPersonaDao personaDao = DaoFactory.getPersonaDao();
	private IProductDao productDao = DaoFactory.getProductDao();

	public CarSlotInfoTrans carslots(long idPersona) {
		List<OwnedCarEntity> ownedCars = ownedCarDao.findByIdPersona(idPersona);

		CarSlotInfoTrans carSlotInfoTrans = new CarSlotInfoTrans();
		CarsOwnedByPersonaList carsOwnedByPersonaList = new CarsOwnedByPersonaList();
		carSlotInfoTrans.setCarsOwnedByPersonaList(carsOwnedByPersonaList);
		if (ownedCars.size() > 0) {
			carsOwnedByPersonaList.setOwnedCarList(ownedCars);
		}
		carSlotInfoTrans.setDefaultOwnedCarIndex(personaDao.findById(idPersona).getCurCarIndex());
		carSlotInfoTrans.setOwnedCarSlotsCount(1);

		// -- Add product data for purchasing car slots in the car dealer
		// (yea it's managed in carslots for some reason...)
		ObtainableSlotsList obtainableSlotsList = new ObtainableSlotsList();

		ArrayList<ProductEntity> productList = new ArrayList<ProductEntity>();
		ProductEntity carSlotProductData = productDao.findByProductId("SRV-CARSLOT");

		productList.add(carSlotProductData);
		obtainableSlotsList.setProductList(productList);

		carSlotInfoTrans.setObtainableSlots(obtainableSlotsList);

		return carSlotInfoTrans;
	}

	public CommerceSessionResultTransType commerce(long idPersona,
			UpdatedCarType updatedCar /* String[] productIds */) {
		// TODO: Economy input, currency calculation, and manual processing of
		// basket items.

		PersonaEntity personaEntity = personaDao.findById(idPersona);

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
		currentCar.setHeatLevel((short) 1);
		currentCar.setOwnershipType("CustomizedCar");

		ownedCarDao.save(currentCar);

		// -- Set the response car
		UpdatedCarType responseCar = new UpdatedCarType();
		responseCar.setCustomCar(currentCar.getCustomCar().getCustomCarType());
		responseCar.setDurability(currentCar.getDurability());
		responseCar.setHeatLevel((short) 1);
		responseCar.setOwnershipType("CustomizedCar");
		responseCar.setUniqueCarId(currentCar.getUniqueCarId());
		commerceSessionResultTransType.setUpdatedCar(responseCar);

		// Currently not important, so we just fill in dummy response
		commerceSessionResultTransType.setInvalidBasket("");
		commerceSessionResultTransType.setInventoryItems(new InventoryItemsType());
		commerceSessionResultTransType.setStatus(ShoppingCartPurchaseResult.aSuccess);

		return commerceSessionResultTransType;
	}

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
			customCarEntity.setSkillModSlotCount(customCar.getSkillModSlotCount());
			customCarEntity.setVinyls(customCar.getVinyls());
			customCarEntity.setVisualParts(customCar.getVisualParts());
			customCarEntity.setParentOwnedCarTrans(ownedCarEntity);

			ownedCarEntity.setCustomCar(customCarEntity);
			ownedCarEntity.setDurability((short) 100);
			ownedCarEntity.setExpirationDate(null);
			ownedCarEntity.setHeatLevel((short) 0);
			ownedCarEntity.setOwnershipType("PresetCar");
			ownedCarEntity.setPersona(personaEntity);

			ownedCarEntity = (OwnedCarEntity) ownedCarDao.save(ownedCarEntity);
			changeDefaultCar(idPersona, ownedCarEntity.getId());

			purchasedCarsType.setOwnedCarTrans(ownedCarEntity.getOwnedCarTransType());
			commerceResultTransType.setPurchasedCars(purchasedCarsType);
			commerceResultTransType.setStatus(ShoppingCartPurchaseResult.aSuccess);
		}
		return commerceResultTransType;
	}

	public OwnedCarEntity defaultcar(long idPersona) {
		PersonaEntity personaEntity = personaDao.findById(idPersona);
		personaEntity.setId(idPersona);
		List<OwnedCarEntity> ownedCarList = ownedCarDao.findByIdPersona(idPersona);
		Integer curCarIndex = personaEntity.getCurCarIndex();
		if (ownedCarList.size() > 0) {
			if (curCarIndex >= ownedCarList.size()) {
				curCarIndex--;
				OwnedCarEntity ownedCarEntity = ownedCarList.get(curCarIndex);
				changeDefaultCar(idPersona, ownedCarEntity.getId());
			}
			OwnedCarEntity ownedCarEntity = ownedCarList.get(curCarIndex);
			return ownedCarEntity;
		}
		return null;
	}

	public void changeDefaultCar(long idPersona, long defaultCarId) {
		PersonaEntity personaEntity = personaDao.findById(idPersona);
		List<OwnedCarEntity> ownedCarList = ownedCarDao.findByIdPersona(idPersona);
		int i = 0;
		for (OwnedCarEntity ownedCarEntity : ownedCarList) {
			if (ownedCarEntity.getUniqueCarId() == defaultCarId) {
				break;
			}
			i++;
		}
		personaEntity.setCurCarIndex(i);
		personaDao.save(personaEntity);
	}

	public ArrayOfOwnedCarTransType getCars(long personaId) {
		ArrayOfOwnedCarTransType arrayOfOwnedCarTrans = new ArrayOfOwnedCarTransType();
		PersonaEntity personaEntity = personaDao.findById(personaId);
		arrayOfOwnedCarTrans.setOwnedCarTransList(personaEntity.getOwnedCarlist());
		return arrayOfOwnedCarTrans;
	}

	public OwnedCarEntity sellCar(long personaId, long carId) {
		ownedCarDao.del(carId);
		return defaultcar(personaId);
	}

}