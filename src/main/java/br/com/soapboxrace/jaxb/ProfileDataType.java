package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileDataType", propOrder = { "badges", "boost", "cash", "iconIndex", "level", "motto", "name",
		"percentToLevel", "personaId", "rating", "rep", "repAtCurrentLevel", "ccar", "score" })
@XmlRootElement(name = "ProfileData")
public class ProfileDataType {

	@XmlElement(name = "Badges")
	protected String badges;
	@XmlElement(name = "Boost")
	protected int boost;
	@XmlElement(name = "Cash")
	protected int cash;
	@XmlElement(name = "IconIndex")
	protected int iconIndex;
	@XmlElement(name = "Level")
	protected int level;
	@XmlElement(name = "Motto", required = true)
	protected String motto;
	@XmlElement(name = "Name", required = true)
	protected String name;
	@XmlElement(name = "PercentToLevel")
	protected float percentToLevel;
	@XmlElement(name = "PersonaId")
	protected long personaId;
	@XmlElement(name = "Rating")
	protected float rating;
	@XmlElement(name = "Rep")
	protected float rep;
	@XmlElement(name = "RepAtCurrentLevel")
	protected float repAtCurrentLevel;
	@XmlElement(required = true)
	protected String ccar;
	@XmlElement(name = "Score")
	protected float score;

	public String getBadges() {
		return badges;
	}

	public void setBadges(String badges) {
		this.badges = badges;
	}

	public int getBoost() {
		return boost;
	}

	public void setBoost(int boost) {
		this.boost = boost;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
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

	public float getPercentToLevel() {
		return percentToLevel;
	}

	public void setPercentToLevel(float percentToLevel) {
		this.percentToLevel = percentToLevel;
	}

	public long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(long personaId) {
		this.personaId = personaId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getRep() {
		return rep;
	}

	public void setRep(float rep) {
		this.rep = rep;
	}

	public float getRepAtCurrentLevel() {
		return repAtCurrentLevel;
	}

	public void setRepAtCurrentLevel(float repAtCurrentLevel) {
		this.repAtCurrentLevel = repAtCurrentLevel;
	}

	public String getCcar() {
		return ccar;
	}

	public void setCcar(String ccar) {
		this.ccar = ccar;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}
