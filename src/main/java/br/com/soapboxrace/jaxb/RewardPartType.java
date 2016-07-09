package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RewardPartType", propOrder = { "repPart", "rewardCategory", "rewardType", "tokenPart" })
public class RewardPartType {
	@XmlElement(name = "RepPart", required = true)
	private Integer repPart;
	@XmlElement(name = "RewardCategory", required = true)
	private String rewardCategory;
	@XmlElement(name = "RewardType", required = true)
	private String rewardType;
	@XmlElement(name = "TokenPart", required = true)
	private Integer tokenPart;
	// TODO: add RewardTypes + RewardCategories

	public Integer getRepPart() {
		return repPart;
	}

	public void setRepPart(Integer repPart) {
		this.repPart = repPart;
	}

	public String getRewardCategory() {
		return rewardCategory;
	}

	public void setRewardCategory(String rewardCategory) {
		this.rewardCategory = rewardCategory;
	}

	public String getRewardType() {
		return rewardType;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public Integer getTokenPart() {
		return tokenPart;
	}

	public void setTokenPart(Integer tokenPart) {
		this.tokenPart = tokenPart;
	}

}