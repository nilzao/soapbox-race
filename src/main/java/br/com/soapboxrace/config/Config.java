package br.com.soapboxrace.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	private int httpPort;
	private String xmppIp;
	private int xmppPort;
	private String freeRoamUdpIp;
	private int freeRoamUdpPort;
	private String raceUdpIp;
	private int raceUdpPort;
	private String openFireToken;
	private String xmppServerType;
	private String dbDriver;

	private static Config instance;

	public static Config getInstance() {
		if (Config.instance == null) {
			Config.instance = new Config();
		}
		return Config.instance;
	}

	private Config() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("soapbox.properties");
			prop.load(input);
			httpPort = Integer.valueOf(prop.getProperty("httpPort"));
			xmppIp = prop.getProperty("xmppIp");
			xmppPort = Integer.valueOf(prop.getProperty("xmppPort"));
			freeRoamUdpIp = prop.getProperty("freeRoamUdpIp");
			freeRoamUdpPort = Integer.valueOf(prop.getProperty("freeRoamUdpPort"));
			raceUdpIp = prop.getProperty("raceUdpIp");
			raceUdpPort = Integer.valueOf(prop.getProperty("raceUdpPort"));
			openFireToken = prop.getProperty("openFireToken");
			xmppServerType = prop.getProperty("xmppServerType");
			dbDriver = prop.getProperty("dbDriver");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public int getHttpPort() {
		return httpPort;
	}

	public void setHttpPort(int httpPort) {
		this.httpPort = httpPort;
	}

	public String getXmppIp() {
		return xmppIp;
	}

	public void setXmppIp(String xmppIp) {
		this.xmppIp = xmppIp;
	}

	public int getXmppPort() {
		return xmppPort;
	}

	public void setXmppPort(int xmppPort) {
		this.xmppPort = xmppPort;
	}

	public String getFreeRoamUdpIp() {
		return freeRoamUdpIp;
	}

	public void setFreeRoamUdpIp(String freeRoamUdpIp) {
		this.freeRoamUdpIp = freeRoamUdpIp;
	}

	public int getFreeRoamUdpPort() {
		return freeRoamUdpPort;
	}

	public void setFreeRoamUdpPort(int freeRoamUdpPort) {
		this.freeRoamUdpPort = freeRoamUdpPort;
	}

	public String getRaceUdpIp() {
		return raceUdpIp;
	}

	public void setRaceUdpIp(String raceUdpIp) {
		this.raceUdpIp = raceUdpIp;
	}

	public int getRaceUdpPort() {
		return raceUdpPort;
	}

	public void setRaceUdpPort(int raceUdpPort) {
		this.raceUdpPort = raceUdpPort;
	}

	public String getOpenFireToken() {
		return openFireToken;
	}

	public void setOpenFireToken(String openFireToken) {
		this.openFireToken = openFireToken;
	}

	public String getXmppServerType() {
		return xmppServerType;
	}

	public void setXmppServerType(String xmppServerType) {
		this.xmppServerType = xmppServerType;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

}
