package br.com.soapboxrace.dao.xml;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jpa.ISoapBoxEntity;

public abstract class SoapboxDao implements ISoapboxDao {

	private String basePath = "www/soapbox/Engine.svc/";

	protected String findFilePath(String baseDir, String fileName) {
		String path = basePath + baseDir;
		return walk(path, fileName);
	}

	private String walk(String path, String fileName) {
		File root = new File(path);
		File[] list = root.listFiles();
		if (list == null) {
			return "";
		}
		for (File f : list) {
			if (f.isDirectory()) {
				return walk(f.getAbsolutePath(), fileName);
			} else {
				if (fileName.equals(f.getName())) {
					return f.getAbsolutePath();
				}
			}
		}
		return "";
	}

	protected String readAbsoluteFile(String path) {
		String xmlString = "";
		try {
			xmlString = new String(Files.readAllBytes(Paths.get(path)));
		} catch (Exception e) {
			System.err.println(e);
		}
		return xmlString;
	}

	protected String readFile(String path) {
		path = basePath.concat(path);
		return readAbsoluteFile(path);
	}

	@Override
	public ISoapBoxEntity save(ISoapBoxEntity entity) {
		return entity;
	}

	@Override
	public void del(ISoapBoxEntity entity) {

	}

	public ISoapBoxEntity findById(Class<? extends ISoapBoxEntity> entityClass, Long id) {
		return null;
	}

	@Override
	public List<ISoapBoxEntity> find(ISoapBoxEntity entity) {
		return null;
	}

}
