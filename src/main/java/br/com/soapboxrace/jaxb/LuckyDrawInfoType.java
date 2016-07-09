package br.com.soapboxrace.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LuckyDrawInfoType", propOrder = { "boxes", "cardDeck", "currentStreak", "isStreakBroken",
		"luckyDrawItem", "numBoxAnimations", "numCards" })
public class LuckyDrawInfoType {
	@XmlElement(name = "Boxes", required = true, nillable = true)
	private String boxes = null;
	@XmlElement(name = "CardDeck", required = true)
	private String cardDeck;
	@XmlElement(name = "CurrentStreak", defaultValue = "0", required = true)
	private Integer currentStreak = 0;
	@XmlElement(name = "IsStreakBroken", defaultValue = "false", required = true)
	private Boolean isStreakBroken = false;
	@XmlElement(name = "LuckyDrawItem", type = LuckyDrawItemType.class)
	@XmlElementWrapper(name = "Items")
	private List<LuckyDrawItemType> luckyDrawItem;
	@XmlElement(name = "NumBoxAnimations", defaultValue = "100", required = true)
	private Integer numBoxAnimations = 100;
	@XmlElement(name = "NumCards", defaultValue = "5", required = true)
	private Integer numCards = 5;

	public String getBoxes() {
		return boxes;
	}

	public void setBoxes(String boxes) {
		this.boxes = boxes;
	}

	public String getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(String cardDeck) {
		this.cardDeck = cardDeck;
	}

	public Integer getCurrentStreak() {
		return currentStreak;
	}

	public void setCurrentStreak(Integer currentStreak) {
		this.currentStreak = currentStreak;
	}

	public Boolean getIsStreakBroken() {
		return isStreakBroken;
	}

	public void setIsStreakBroken(Boolean isStreakBroken) {
		this.isStreakBroken = isStreakBroken;
	}

	public LuckyDrawItemType getLuckyDrawItem() {
		return luckyDrawItem.get(0);
	}

	public void setLuckyDrawItem(LuckyDrawItemType luckyDrawItem) {
		List<LuckyDrawItemType> dummyList = new ArrayList<LuckyDrawItemType>();
		dummyList.add(luckyDrawItem);
		this.luckyDrawItem = dummyList;
	}

	public Integer getNumBoxAnimations() {
		return numBoxAnimations;
	}

	public void setNumBoxAnimations(Integer numBoxAnimations) {
		this.numBoxAnimations = numBoxAnimations;
	}

	public Integer getNumCards() {
		return numCards;
	}

	public void setNumCards(Integer numCards) {
		this.numCards = numCards;
	}
}