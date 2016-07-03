package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APIPersonaDataType", propOrder = { "badges", "iconIndex", "level", "motto", "name", "score", "cars",
		"otherPersonas" })
@XmlRootElement(name = "PersonaData")
public class APIPersonaDataType {
	@XmlElement(name = "Badges", required = true, nillable = true)
	private String badges;
	@XmlElement(name = "IconIndex")
	private Integer iconIndex;
	@XmlElement(name = "Level")
	private Integer level;
	@XmlElement(name = "Motto", nillable = true)
	private String motto;
	@XmlElement(name = "Name")
	private String name;
	@XmlElement(name = "Score")
	private Float score;
	@XmlElement(name = "CarsList")
	private ArrayOfOwnedCarTransType cars;
	@XmlElement(name = "personaId", required = true, type = Long.class)
	@XmlElementWrapper(name = "OtherPersonas", nillable = true)
	private List<Long> otherPersonas;

	public String getBadges() {
		return badges;
	}

	public void setBadges(String badges) {
		this.badges = badges;
	}

	public Integer getIconIndex() {
		return iconIndex;
	}

	public void setIconIndex(Integer iconIndex) {
		this.iconIndex = iconIndex;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public ArrayOfOwnedCarTransType getCars() {
		return cars;
	}

	public void setCars(ArrayOfOwnedCarTransType cars) {
		this.cars = cars;
	}

	public List<Long> getOtherPersonas() {
		return otherPersonas;
	}

	public void setOtherPersonas(List<Long> otherPersonas) {
		this.otherPersonas = otherPersonas;
	}
}