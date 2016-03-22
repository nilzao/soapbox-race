package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WalletTransType", propOrder = { "balance", "currency" })
public class WalletTransType {

	@XmlElement(name = "Balance")
	protected int balance;
	@XmlElement(name = "Currency", required = true)
	protected String currency;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int value) {
		this.balance = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String value) {
		this.currency = value;
	}

}
