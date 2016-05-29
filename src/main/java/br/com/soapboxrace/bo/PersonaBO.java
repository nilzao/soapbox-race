package br.com.soapboxrace.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.soapboxrace.dao.OwnedCarDao;
import br.com.soapboxrace.dao.PersonaDao;
import br.com.soapboxrace.dao.ProductDao;
import br.com.soapboxrace.jaxb.CarSlotInfoTrans;
import br.com.soapboxrace.jaxb.CarsOwnedByPersonaList;
import br.com.soapboxrace.jaxb.CommerceSessionResultTransType;
import br.com.soapboxrace.jaxb.ObtainableSlotsList;
import br.com.soapboxrace.jaxb.UpdatedCarType;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.PersonaEntity;
import br.com.soapboxrace.jpa.ProductEntity;

public class PersonaBO {

	private OwnedCarDao ownedCarDao = new OwnedCarDao();

	private PersonaDao personaDao = new PersonaDao();

	private ProductDao productDao = new ProductDao();

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

		// PersonaEntity personaEntity = personaDao.findById(idPersona);
		//
		CommerceSessionResultTransType commerceSessionResultTransType = new CommerceSessionResultTransType();
		//
		// // -- Wallet
		// WalletTransType walletTransType = new WalletTransType();
		// walletTransType.setBalance(personaEntity.getCash());
		// walletTransType.setCurrency("CASH");
		//
		// WalletsType walletsType = new WalletsType();
		// walletsType.setWalletTrans(walletTransType);
		//
		// commerceSessionResultTransType.setWallets(walletsType);
		//
		// // -- Modify the car on DB
		// OwnedCarEntity currentCar = defaultcar(personaEntity.getId());
		// currentCar.getCustomCar().setVinyls(updatedCar.getCustomCar().getVinyls());
		// currentCar.getCustomCar().setPaints(updatedCar.getCustomCar().getPaints());
		// currentCar.getCustomCar().setPerformanceParts(updatedCar.getCustomCar().getPerformanceParts());
		// currentCar.getCustomCar().setSkillModParts(updatedCar.getCustomCar().getSkillModParts());
		// currentCar.getCustomCar().setVisualParts(updatedCar.getCustomCar().getVisualParts());
		//
		// ownedCarDao.save(currentCar);
		//
		// // -- Set the response car
		// UpdatedCarType responseCar = new UpdatedCarType();
		// responseCar.setCustomCar(currentCar.getCustomCar().getCustomCarType());
		// responseCar.setDurability(currentCar.getDurability());
		// responseCar.setHeatLevel((short) 1);
		// responseCar.setOwnershipType("CustomizedCar");
		// responseCar.setUniqueCarId(currentCar.getUniqueCarId());
		// commerceSessionResultTransType.setUpdatedCar(responseCar);
		//
		// // Currently not important, so we just fill in dummy response
		// commerceSessionResultTransType.setInvalidBasket("");
		// commerceSessionResultTransType.setInventoryItems(new
		// InventoryItemsType());
		// commerceSessionResultTransType.setStatus(ShoppingCartPurchaseResult.aSuccess);

		return commerceSessionResultTransType;
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
			if (ownedCarEntity.getId() == defaultCarId) {
				break;
			}
			i++;
		}
		personaEntity.setCurCarIndex(i);
		personaDao.save(personaEntity);
	}

	public OwnedCarEntity deleteCar(long idPersona, long carId) {
		ownedCarDao.del(carId);
		return defaultcar(idPersona);
	}

}