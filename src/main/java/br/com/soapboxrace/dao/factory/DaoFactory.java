package br.com.soapboxrace.dao.factory;

import br.com.soapboxrace.config.Config;

public class DaoFactory {

	private static SaveType saveType;

	static {
		Config config = Config.getInstance();
		saveType = config.getSaveType();
	}

	public static IProductDao getProductDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.ProductDao();
		} else if (SaveType.XML.equals(saveType)) {
			// TODO XML Dao Type
			return null;
		}
		return null;
	}

	public static IUserDao getUserDao() {
		if (SaveType.DB.equals(saveType)) {
			return new br.com.soapboxrace.dao.db.UserDao();
		} else if (SaveType.XML.equals(saveType)) {
			// TODO XML Dao Type
			return null;
		}
		return null;
	}

}
