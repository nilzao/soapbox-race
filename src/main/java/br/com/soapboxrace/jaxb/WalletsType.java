package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WalletsType", propOrder = { "walletTrans" })
public class WalletsType {

	@XmlElement(name = "WalletTrans", required = true)
	protected WalletTransType walletTrans;

	public WalletTransType getWalletTrans() {
		return walletTrans;
	}

	public void setWalletTrans(WalletTransType value) {
		this.walletTrans = value;
	}

}
