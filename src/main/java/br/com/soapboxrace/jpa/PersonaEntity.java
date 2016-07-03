package br.com.soapboxrace.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@Table(name = "PERSONA")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonaEntity implements ISoapBoxEntity {

	private static final long serialVersionUID = 3130318632367993129L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "CASH")
	private Integer cash;

	@Column(name = "ICONINDEX")
	private Integer iconIndex;

	@Column(name = "LEVEL")
	private Integer level;

	@Column(name = "MOTTO", length = 500)
	private String motto;

	@Column(name = "PERCENTTOLEVEL")
	private float percentToLevel;

	@Column(name = "RATING")
	private float rating;

	@Column(name = "REP")
	private float rep;

	@Column(name = "REPATCURRENTLEVEL")
	private float repAtCurrentLevel;

	@Column(name = "SCORE")
	private float score;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "CURCARINDEX")
	private Integer curCarIndex = 0;

	@OneToMany(mappedBy = "persona", targetEntity = OwnedCarEntity.class, cascade = { CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REMOVE })
	private List<OwnedCarEntity> ownedCarlist;

	@ManyToOne
	@JoinColumn(name = "USERID", referencedColumnName = "ID")
	private UserEntity user;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}

	public Integer getCash() {
		return this.cash;
	}

	public void setIconIndex(Integer iconIndex) {
		this.iconIndex = iconIndex;
	}

	public Integer getIconIndex() {
		return this.iconIndex;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getMotto() {
		return this.motto;
	}

	public void setPercentToLevel(float percentToLevel) {
		this.percentToLevel = percentToLevel;
	}

	public float getPercentToLevel() {
		return this.percentToLevel;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getRating() {
		return this.rating;
	}

	public void setRep(float rep) {
		this.rep = rep;
	}

	public float getRep() {
		return this.rep;
	}

	public void setRepAtCurrentLevel(float repAtCurrentLevel) {
		this.repAtCurrentLevel = repAtCurrentLevel;
	}

	public float getRepAtCurrentLevel() {
		return this.repAtCurrentLevel;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public float getScore() {
		return this.score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCurCarIndex(Integer newIndex) {
		this.curCarIndex = newIndex;
	}

	public Integer getCurCarIndex() {
		return this.curCarIndex;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public List<OwnedCarEntity> getOwnedCarlist() {
		return ownedCarlist;
	}

	public void setOwnedCarlist(List<OwnedCarEntity> ownedCarlist) {
		this.ownedCarlist = ownedCarlist;
	}

	public boolean add(OwnedCarEntity e) {
		if (ownedCarlist == null) {
			ownedCarlist = new ArrayList<OwnedCarEntity>();
		}
		return ownedCarlist.add(e);
	}
}
