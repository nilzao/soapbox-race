package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinalRewardsType", propOrder = { "rep", "tokens" })
public class FinalRewardsType {

	@XmlElement(name = "Rep")
	protected int rep;
	@XmlElement(name = "Tokens")
	protected int tokens;

	public int getRep() {
		return rep;
	}

	public void setRep(int value) {
		this.rep = value;
	}

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int value) {
		this.tokens = value;
	}

}
