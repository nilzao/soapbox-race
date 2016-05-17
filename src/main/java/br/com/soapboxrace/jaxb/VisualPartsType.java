package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisualPartsType", propOrder = { "visualPartTrans" })
@XmlRootElement(name = "VisualParts")
public class VisualPartsType {
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "PartHash", "SlotHash" })
	@XmlRootElement(name = "VisualPartTrans")
	public static class VisualPartTrans {
		@XmlElement(name = "PartHash")
		private String PartHash;
		@XmlElement(name = "SlotHash")
		private String SlotHash;

		public String getPartHash() {
			return PartHash;
		}

		public String getSlotHash() {
			return SlotHash;
		}

		public void setPartHash(String PartHash) {
			this.PartHash = PartHash;
		}

		public void setSlotHash(String SlotHash) {
			this.SlotHash = SlotHash;
		}
	}

	@XmlElement(name = "VisualPartTrans")
	private VisualPartTrans[] visualPartTrans;

	public VisualPartTrans[] getVisualPartTrans() {
		return visualPartTrans;
	}

	public void setVisualPartTrans(VisualPartTrans[] VisualPartTrans) {
		this.visualPartTrans = VisualPartTrans;
	}
}