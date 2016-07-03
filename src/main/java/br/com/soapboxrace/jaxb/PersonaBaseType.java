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
	protected long personaId;
	@XmlElement(name = "Presence")
	protected int presence;
	@XmlElement(name = "Score")
	protected float score;
	@XmlElement(name = "UserId")
	protected long userId;

	public String getBadges() {
		return badges;
	}

	public void setBadges(String badges) {
		this.badges = badges;
	}

	public int getIconIndex() {
		return iconIndex;
	}

	public void setIconIndex(int iconIndex) {
		this.iconIndex = iconIndex;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
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

	public long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(long personaId) {
		this.personaId = personaId;
	}

	public int getPresence() {
		return presence;
	}

	public void setPresence(int presence) {
		this.presence = presence;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
