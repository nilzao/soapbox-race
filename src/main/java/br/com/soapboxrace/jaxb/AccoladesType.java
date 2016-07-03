package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccoladesType", propOrder = { "finalRewards", "hasLeveledUp", "luckyDrawInfo", "originalRewards",
		"rewardInfo" })
public class AccoladesType {
	@XmlElement(name = "FinalRewards", required = true)
	protected FinalRewardsType finalRewards;
	@XmlElement(name = "HasLeveledUp", required = true)
	protected Boolean hasLeveledUp;
	@XmlElement(name = "LuckyDrawInfo", required = true, nillable = true)
	protected LuckyDrawInfoType luckyDrawInfo;
	@XmlElement(name = "OriginalRewards", required = true)
	protected OriginalRewardsType originalRewards = new OriginalRewardsType();
	@XmlElement(name = "RewardPart", type = RewardPartType.class, required = true, nillable = true)
	@XmlElementWrapper(name = "RewardInfo")
	protected List<RewardPartType> rewardInfo;

	public FinalRewardsType getFinalRewards() {
		return finalRewards;
	}

	public void setFinalRewards(FinalRewardsType finalRewards) {
		this.finalRewards = finalRewards;
	}

	public Boolean getHasLeveledUp() {
		return hasLeveledUp;
	}

	public void setHasLeveledUp(Boolean hasLeveledUp) {
		this.hasLeveledUp = hasLeveledUp;
	}

	public LuckyDrawInfoType getLuckyDrawInfo() {
		return luckyDrawInfo;
	}

	public void setLuckyDrawInfo(LuckyDrawInfoType luckyDrawInfo) {
		this.luckyDrawInfo = luckyDrawInfo;
	}

	public OriginalRewardsType getOriginalRewards() {
		return originalRewards;
	}

	public void setOriginalRewards(OriginalRewardsType originalRewards) {
		this.originalRewards = originalRewards;
	}

	public List<RewardPartType> getRewardInfo() {
		return rewardInfo;
	}

	public void setRewardInfo(List<RewardPartType> rewardInfo) {
		this.rewardInfo = rewardInfo;
	}
}