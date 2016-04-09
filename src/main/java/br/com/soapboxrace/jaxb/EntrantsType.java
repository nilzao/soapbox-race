package br.com.soapboxrace.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntrantsType", propOrder = { "lobbyEntrantInfo" })
public class EntrantsType {

	@XmlElement(name = "LobbyEntrantInfo")
	protected List<LobbyEntrantInfoType> lobbyEntrantInfo;

	public List<LobbyEntrantInfoType> getLobbyEntrantInfo() {
		if (lobbyEntrantInfo == null) {
			lobbyEntrantInfo = new ArrayList<LobbyEntrantInfoType>();
		}
		return this.lobbyEntrantInfo;
	}

}
