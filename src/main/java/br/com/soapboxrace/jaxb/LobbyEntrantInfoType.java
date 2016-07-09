package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LobbyEntrantInfoType", propOrder = { "gridIndex", "heat", "level", "personaId", "state" })
public class LobbyEntrantInfoType {

	@XmlElement(name = "GridIndex")
	protected int gridIndex = 0;
	@XmlElement(name = "Heat")
	protected int heat = 1;
	@XmlElement(name = "Level")
	protected int level = 1;
	@XmlElement(name = "PersonaId")
	protected long personaId;
	@XmlElement(name = "State", required = true)
	protected String state = "InLobby";

	public int getGridIndex() {
		return gridIndex;
	}

	public void setGridIndex(int gridIndex) {
		this.gridIndex = gridIndex;
	}

	public int getHeat() {
		return heat;
	}

	public void setHeat(int heat) {
		this.heat = heat;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(long personaId) {
		this.personaId = personaId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
