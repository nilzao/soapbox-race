package br.com.soapboxrace.config;

public class Config {

	private int httpPort;
	private String xmppIp;
	private int xmppPort;
	private String freeRoamUdpIp;
	private int freeRoamUdpPort;
	private String raceUdpIp;
	private int raceUdpPort;
	private String openFireToken;

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

}
