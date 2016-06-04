package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccoladesType", propOrder = { "finalRewards", "hasLeveledUp", "luckyDrawInfo", "originalRewards",
		"rewardInfo" })
public class AccoladesType {

	@XmlElement(name = "FinalRewards", required = true)
	protected FinalRewardsType finalRewards;
	@XmlElement(name = "HasLeveledUp", required = true)
	protected String hasLeveledUp;
	@XmlElement(name = "LuckyDrawInfo", required = true)
	protected String luckyDrawInfo;
	@XmlElement(name = "OriginalRewards", required = true)
	protected OriginalRewardsType originalRewards;
	@XmlElement(name = "RewardInfo", required = true)
	protected String rewardInfo;

	public FinalRewardsType getFinalRewards() {
		return finalRewards;
	}

	public void setFinalRewards(FinalRewardsType value) {
		this.finalRewards = value;
	}

	public String getHasLeveledUp() {
		return hasLeveledUp;
	}

	public void setHasLeveledUp(String value) {
		this.hasLeveledUp = value;
	}

	public String getLuckyDrawInfo() {
		return luckyDrawInfo;
	}

	public void setLuckyDrawInfo(String value) {
		this.luckyDrawInfo = value;
	}

	public OriginalRewardsType getOriginalRewards() {
		return originalRewards;
	}

	public void setOriginalRewards(OriginalRewardsType value) {
		this.originalRewards = value;
	}

	public String getRewardInfo() {
		return rewardInfo;
	}

	public void setRewardInfo(String value) {
		this.rewardInfo = value;
	}

}
