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
	protected int personaId;
	@XmlElement(name = "State", required = true)
	protected String state = "InLobby";

	public int getGridIndex() {
		return gridIndex;
	}

	public void setGridIndex(int value) {
		this.gridIndex = value;
	}

	public int getHeat() {
		return heat;
	}

	public void setHeat(int value) {
		this.heat = value;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int value) {
		this.level = value;
	}

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int value) {
		this.personaId = value;
	}

	public String getState() {
		return state;
	}

	public void setState(String value) {
		this.state = value;
	}

}
