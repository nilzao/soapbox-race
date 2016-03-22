package br.com.soapboxrace.bo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jaxb.EventsPacketType;
import br.com.soapboxrace.jaxb.EventsType;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
import br.com.soapboxrace.jpa.CustomCarEntity;
import br.com.soapboxrace.jpa.CustomPaintEntity;
import br.com.soapboxrace.jpa.CustomVinylEntity;
import br.com.soapboxrace.jpa.EventDefinitionEntity;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.PerformancePartEntity;
import br.com.soapboxrace.jpa.ProductEntity;
import br.com.soapboxrace.jpa.SkillModPartEntity;
import br.com.soapboxrace.jpa.VisualPartEntity;

public class ImportBO {

	private ConnectionDB connectionDB = new ConnectionDB();

	public static void main(String[] args) throws Exception {
		ImportBO importBO = new ImportBO();
		importBO.importAvailabeAtLevel();
	}

	public void importCars() throws Exception {

		Files.walk(Paths.get("/home/nils/workspaces/nfsw/soapbox-race/rev/startCars")).forEach(filePath -> {
			if (Files.isRegularFile(filePath)) {
				byte[] encoded;
				try {
					String productIdStr = filePath.getFileName().toString();
					productIdStr = productIdStr.replace(".xml", "");
					productIdStr = productIdStr.replace("NFSW-NA", "NFSW-NA:");

					encoded = Files.readAllBytes(Paths.get(filePath.toString()));
					String xmlStr = new String(encoded, "UTF-8");
					xmlStr = xmlStr.replace(" i:nil=\"true\"", "");
					System.out.println(filePath);
					System.out.println(xmlStr);
					System.out.println("=======================\n\n");
					OwnedCarEntity ownedCarEntity = (OwnedCarEntity) UnmarshalXML.unMarshal(xmlStr,
							new OwnedCarEntity());
					ownedCarEntity.setId(0);
					ownedCarEntity.setDurability(100);

					ProductEntity productEntity = new ProductEntity();
					productEntity.setProductId(productIdStr);
					List<?> find = connectionDB.find(productEntity);
					if (find.size() > 0) {
						productEntity = (ProductEntity) find.get(0);
					}
					if (productEntity.getId() == 0) {
						throw new Exception("PRODUTO [" + productIdStr + "] NAO ENCONTRADO");
					}
					ownedCarEntity.setProduct(productEntity);

					CustomCarEntity customCarEntity = ownedCarEntity.getCustomCarList().get(0);
					customCarEntity.setOwnedCar(ownedCarEntity);
					customCarEntity.setId(0);

					List<CustomPaintEntity> customPaintList = customCarEntity.getCustomPaintList();
					for (CustomPaintEntity customPaintEntity : customPaintList) {
						customPaintEntity.setCustomCar(customCarEntity);
					}
					customCarEntity.setCustomPaintList(customPaintList);

					List<PerformancePartEntity> performancePartList = customCarEntity.getPerformancePartList();
					for (PerformancePartEntity performancePartEntity : performancePartList) {
						performancePartEntity.setCustomCar(customCarEntity);
					}
					customCarEntity.setCustomPaintList(customPaintList);

					List<SkillModPartEntity> skillModPartList = customCarEntity.getSkillModPartList();
					for (SkillModPartEntity skillModPartEntity : skillModPartList) {
						skillModPartEntity.setCustomCar(customCarEntity);
					}
					customCarEntity.setCustomPaintList(customPaintList);

					List<CustomVinylEntity> customVinylList = customCarEntity.getCustomVinylList();
					for (CustomVinylEntity customVinylEntity : customVinylList) {
						customVinylEntity.setCustomCar(customCarEntity);
					}
					customCarEntity.setCustomPaintList(customPaintList);

					List<VisualPartEntity> visualPartList = customCarEntity.getVisualPartList();
					for (VisualPartEntity visualPartEntity : visualPartList) {
						visualPartEntity.setCustomCar(customCarEntity);
					}
					customCarEntity.setCustomPaintList(customPaintList);

					connectionDB.merge(ownedCarEntity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public void importAvailabeAtLevel() throws Exception {
		byte[] encoded = Files.readAllBytes(Paths
				.get("/home/nils/workspaces/nfsw/soapbox-race/www/soapbox/Engine.svc/events/availableatlevel.xml"));
		String xmlStr = new String(encoded, "UTF-8");
		EventsPacketType eventPacketType = (EventsPacketType) UnmarshalXML.unMarshal(xmlStr, new EventsPacketType());
		EventsType events = eventPacketType.getEvents();
		List<EventDefinitionEntity> eventDefinition = events.getEventDefinitionList();
		for (EventDefinitionEntity eventDefinitionEntity : eventDefinition) {
			System.out.println(eventDefinitionEntity.getEventId());
			connectionDB.persist(eventDefinitionEntity);
		}
	}

}
