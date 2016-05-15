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
import br.com.soapboxrace.jaxb.CommerceSessionResultTransType;
import br.com.soapboxrace.jaxb.InventoryItemsType;
import br.com.soapboxrace.jaxb.ObtainableSlotsList;
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

		// -- Add product data for purchasing car slots in the car dealer
		// (yea it's managed in carslots for some reason...)
		ObtainableSlotsList obtainableSlotsList = new ObtainableSlotsList();

		ArrayList<ProductEntity> productList = new ArrayList<ProductEntity>();
		ProductEntity carSlotProductData = new ProductEntity();
		carSlotProductData.setProductId("SRV-CARSLOT");
		carSlotProductData = (ProductEntity) connectionDB.find(carSlotProductData).get(0);
		productList.add(carSlotProductData);
		obtainableSlotsList.setProductList(productList);

		carSlotInfoTrans.setObtainableSlots(obtainableSlotsList);

		return carSlotInfoTrans;
	}

	public CommerceSessionResultTransType commerce(long idPersona,
			UpdatedCarType updatedCar /* String[] productIds */) {
		// TODO: Economy input, currency calculation, and manual processing of
		// basket items.

		PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(PersonaEntity.class, idPersona);
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

	public OwnedCarEntity defaultcar(long idPersona) {
		PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(PersonaEntity.class, idPersona);
		personaEntity.setId(idPersona);
		List<OwnedCarEntity> ownedCarList = getOwnedCarList(personaEntity);
		return ownedCarList.get(personaEntity.getCurCarIndex());
	}

	public void changeDefaultCar(long idPersona, long defaultCarId) {
		PersonaEntity personaEntity = (PersonaEntity) connectionDB.findById(PersonaEntity.class, idPersona);
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