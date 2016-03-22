package br.com.soapboxrace.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jaxb.CarSlotInfoTrans;
import br.com.soapboxrace.jaxb.CarsOwnedByPersonaList;
import br.com.soapboxrace.jaxb.CommerceResultTransType;
import br.com.soapboxrace.jaxb.InventoryItemTransType;
import br.com.soapboxrace.jaxb.InventoryItemsType;
import br.com.soapboxrace.jaxb.ObtainableSlotsList;
import br.com.soapboxrace.jaxb.PurchasedCarsType;
import br.com.soapboxrace.jaxb.WalletTransType;
import br.com.soapboxrace.jaxb.WalletsType;
import br.com.soapboxrace.jpa.CustomCarEntity;
import br.com.soapboxrace.jpa.CustomPaintEntity;
import br.com.soapboxrace.jpa.CustomVinylEntity;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.PerformancePartEntity;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.ProductEntity;
import br.com.soapboxrace.jpa.SkillModPartEntity;
import br.com.soapboxrace.jpa.VisualPartEntity;

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
		commerceResultTransType.setCommerceItems("");
		commerceResultTransType.setInvalidBasket("");
		inventoryItemsType.setInventoryItemTrans(inventoryItemTransType);
		commerceResultTransType.setInventoryItems(inventoryItemsType);
		commerceResultTransType.setPurchasedCars(new PurchasedCarsType());
		List<?> find = connectionDB.find(productEntity);
		if (find.size() > 0) {
			productEntity = (ProductEntity) find.get(0);
			OwnedCarEntity ownedCar = productEntity.getOwnedCar();
			CustomCarEntity customCarEntity = ownedCar.getCustomCarList().get(0);
			purchasedCarsType.setOwnedCarTrans(productEntity.getOwnedCar());
			commerceResultTransType.setPurchasedCars(purchasedCarsType);
			commerceResultTransType.setStatus("Success");

			EntityManager manager = ConnectionDB.getManager();

			List<CustomPaintEntity> customPaintList = customCarEntity.getCustomPaintList();
			for (CustomPaintEntity customPaintEntity : customPaintList) {
				manager.detach(customPaintEntity);
				customPaintEntity.setId(0L);
				customPaintEntity.setCustomCar(customCarEntity);
			}
			List<CustomVinylEntity> customVinylList = customCarEntity.getCustomVinylList();
			for (CustomVinylEntity customVinylEntity : customVinylList) {
				manager.detach(customVinylEntity);
				customVinylEntity.setId(0L);
				customVinylEntity.setCustomCar(customCarEntity);
			}
			List<SkillModPartEntity> skillModPartList = customCarEntity.getSkillModPartList();
			for (SkillModPartEntity skillModPartEntity : skillModPartList) {
				manager.detach(skillModPartEntity);
				skillModPartEntity.setId(0L);
				skillModPartEntity.setCustomCar(customCarEntity);
			}
			List<PerformancePartEntity> performancePartList = customCarEntity.getPerformancePartList();
			for (PerformancePartEntity performancePartEntity : performancePartList) {
				manager.detach(performancePartEntity);
				performancePartEntity.setId(0L);
				performancePartEntity.setCustomCar(customCarEntity);
			}
			List<VisualPartEntity> visualPartList = customCarEntity.getVisualPartList();
			for (VisualPartEntity visualPartEntity : visualPartList) {
				manager.detach(visualPartEntity);
				visualPartEntity.setId(0L);
				visualPartEntity.setCustomCar(customCarEntity);
			}

			PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(new PersonaEntity(), idPersona);
			manager.detach(ownedCar);
			ownedCar.setId(0);
			ownedCar.setCustomCarList(null);
			ownedCar.setProduct(null);
			ownedCar.setPersona(personaEntity);
			connectionDB.persist(ownedCar);

			manager.detach(customCarEntity);
			customCarEntity.setId(0);
			customCarEntity.setOwnedCar(ownedCar);
			ownedCar.add(customCarEntity);
			connectionDB.merge(customCarEntity);
		}
		return commerceResultTransType;
	}

	public OwnedCarEntity defaultcar(long idPersona) {
		EntityManager manager = ConnectionDB.getManager();
		TypedQuery<OwnedCarEntity> query = manager
				.createQuery("SELECT obj FROM OwnedCarEntity obj WHERE obj.persona = :persona", OwnedCarEntity.class);
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setId(idPersona);
		query.setParameter("persona", personaEntity);
		OwnedCarEntity ownedCar = query.getSingleResult();
		return ownedCar;
	}

}
