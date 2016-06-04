package br.com.soapboxrace.xmpp.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jaxb.EntrantsType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LobbyLaunchedType", propOrder = { "cryptoTickets", "entrants", "eventSession", "isNewRelayServer",
		"lobbyId", "udpRelayHost", "udpRelayPort" })
public class LobbyLaunchedType {

	@XmlElement(name = "CryptoTickets", required = true)
	protected CryptoTicketsType cryptoTickets;
	@XmlElement(name = "Entrants", required = true)
	protected EntrantsType entrants;
	@XmlElement(name = "EventSession", required = true)
	protected EventSessionType eventSession;
	@XmlElement(name = "IsNewRelayServer", required = true)
	protected boolean isNewRelayServer;
	@XmlElement(name = "LobbyId")
	protected long lobbyId;
	@XmlElement(name = "UdpRelayHost", required = true)
	protected String udpRelayHost;
	@XmlElement(name = "UdpRelayPort", required = true)
	protected int udpRelayPort;

	public CryptoTicketsType getCryptoTickets() {
		return cryptoTickets;
	}

	public void setCryptoTickets(CryptoTicketsType value) {
		this.cryptoTickets = value;
	}

	public EntrantsType getEntrants() {
		return entrants;
	}

	public void setEntrants(EntrantsType value) {
		this.entrants = value;
	}

	public EventSessionType getEventSession() {
		return eventSession;
	}

	public void setEventSession(EventSessionType value) {
		this.eventSession = value;
	}

	public boolean isNewRelayServer() {
		return isNewRelayServer;
	}

	public void setNewRelayServer(boolean isNewRelayServer) {
		this.isNewRelayServer = isNewRelayServer;
	}

	public long getLobbyId() {
		return lobbyId;
	}

	public void setLobbyId(long lobbyId) {
		this.lobbyId = lobbyId;
	}

	public String getUdpRelayHost() {
		return udpRelayHost;
	}

	public void setUdpRelayHost(String value) {
		this.udpRelayHost = value;
	}

	public int getUdpRelayPort() {
		return udpRelayPort;
	}

	public void setUdpRelayPort(int udpRelayPort) {
		this.udpRelayPort = udpRelayPort;
	}

}
