package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaBaseType", propOrder = { "badges", "iconIndex", "level", "motto", "name", "personaId",
		"presence", "score", "userId" })
public class PersonaBaseType {

	@XmlElement(name = "Badges", required = true)
	protected String badges;
	@XmlElement(name = "IconIndex")
	protected int iconIndex;
	@XmlElement(name = "Level")
	protected int level;
	@XmlElement(name = "Motto", required = true)
	protected String motto;
	@XmlElement(name = "Name", required = true)
	protected String name;
	@XmlElement(name = "PersonaId")
	protected int personaId;
	@XmlElement(name = "Presence")
	protected int presence;
	@XmlElement(name = "Score")
	protected int score;
	@XmlElement(name = "UserId")
	protected int userId;

	public String getBadges() {
		return badges;
	}

	public void setBadges(String value) {
		this.badges = value;
	}

	public int getIconIndex() {
		return iconIndex;
	}

	public void setIconIndex(int value) {
		this.iconIndex = value;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int value) {
		this.level = value;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String value) {
		this.motto = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int value) {
		this.personaId = value;
	}

	public int getPresence() {
		return presence;
	}

	public void setPresence(int value) {
		this.presence = value;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int value) {
		this.score = value;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int value) {
		this.userId = value;
	}

}
