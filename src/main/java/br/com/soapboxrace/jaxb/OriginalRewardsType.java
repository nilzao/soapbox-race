package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalRewardsType", propOrder = { "rep", "tokens" })
public class OriginalRewardsType {
	@XmlElement(name = "Rep", defaultValue = "0", required = true)
	private Integer rep = 0;
	@XmlElement(name = "Tokens", defaultValue = "0", required = true)
	private Integer tokens;

	public Integer getRep() {
		return rep;
	}

	public void setRep(Integer rep) {
		this.rep = rep;
	}

	public Integer getTokens() {
		return tokens;
	}

	public void setTokens(Integer tokens) {
		this.tokens = tokens;
	}
}