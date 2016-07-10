package br.com.soapboxrace.dao.factory;

import br.com.soapboxrace.config.Config;

public class DaoFactory {

	private static SaveType saveType;

	static {
		Config config = Config.getInstance();
		saveType = config.getSaveType();
	}

	public static IBasketDefinitionDao getBasketDefinitionDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.BasketDefinitionDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.BasketDefinitionDao();
		}
		return null;
	}

	public static ICategoryDao getCategoryDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.CategoryDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.CategoryDao();
		}
		return null;
	}

	public static IEventDataDao getEventDataDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.EventDataDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.EventDataDao();
		}
		return null;
	}

	public static IEventDefinitionDao getEventDefinitionDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.EventDefinitionDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.EventDefinitionDao();
		}
		return null;
	}

	public static ILobbyDao getLobbyDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.LobbyDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.LobbyDao();
		}
		return null;
	}

	public static ILobbyEntrantDao getLobbyEntrantDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.LobbyEntrantDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.LobbyEntrantDao();
		}
		return null;
	}

	public static IOwnedCarDao getOwnedCarDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.OwnedCarDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.OwnedCarDao();
		}
		return null;
	}

	public static IPersonaDao getPersonaDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.PersonaDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.PersonaDao();
		}
		return null;
	}

	public static IProductDao getProductDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.ProductDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.ProductDao();
		}
		return null;
	}

	public static IProductVinylDao getProductVinylDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.ProductVinylDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.ProductVinylDao();
		}
		return null;
	}

	public static IUserDao getUserDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.UserDao();
		} else if (SaveType.XML.equals(saveType)) {
			return new br.com.soapboxrace.dao.xml.UserDao();
		}
		return null;
	}

}
