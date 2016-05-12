package br.com.soapboxrace.bo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jaxb.ArrayOfProductTransList;
import br.com.soapboxrace.jaxb.EventsPacketType;
import br.com.soapboxrace.jaxb.EventsType;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
import br.com.soapboxrace.jpa.EventDefinitionEntity;
import br.com.soapboxrace.jpa.OwnedCarEntity;
import br.com.soapboxrace.jpa.ProductEntity;

public class ImportBO {

	private ConnectionDB connectionDB = new ConnectionDB();

	public static void main(String[] args) throws Exception {
		ImportBO importBO = new ImportBO();
		importBO.importParts();
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
					ownedCarEntity.setUniqueCarId(0);;
					ownedCarEntity.setDurability((short)100);
					
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

	public void importParts() throws Exception {
		Files.walk(Paths.get("D:/_EclipseProjects/soapbox-race/db/fillers")).forEach(filePath -> {
			if (Files.isRegularFile(filePath)) {
				byte[] encoded;
				try {
					String categoryName = filePath.getFileName().toString();
					if (categoryName.startsWith("products")) {
						categoryName = categoryName.replace(".xml", "");
						categoryName = categoryName.replace("productsInCategory_", "");
						
						System.out.println("doing: " + categoryName);
	
						encoded = Files.readAllBytes(Paths.get(filePath.toString()));
						String xmlStr = new String(encoded, "UTF-8");
						xmlStr = xmlStr.replace(" i:nil=\"true\"", "");
						
						if (xmlStr.length() < 200) return;

						ArrayOfProductTransList array = (ArrayOfProductTransList) UnmarshalXML.unMarshal(xmlStr, new ArrayOfProductTransList());
						List<ProductEntity> listofarray = array.getProductTrans();
						if (!listofarray.isEmpty() && listofarray.size() > 0) {
							for (ProductEntity pro : listofarray) {
								//System.out.println("in process productId: " + pro.getProductId());
								pro.setCategoryName(categoryName);
								//pro.setDescription("");
								//pro.setLongDescription("");
								connectionDB.merge(pro);
							}
							System.err.println("done: " + categoryName);
						} else {
							System.err.println("empty: " + categoryName + "\r\n");
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});		
		System.err.println("finished all");
	}
}
