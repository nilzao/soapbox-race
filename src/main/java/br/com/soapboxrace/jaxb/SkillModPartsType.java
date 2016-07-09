package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SkillModPartsType", propOrder = { "skillModPartTrans" })
@XmlRootElement(name = "SkillModParts")
public class SkillModPartsType {
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "IsFixed", "SkillModPartAttribHash" })
	@XmlRootElement(name = "SkillModPartTrans")
	public static class SkillModPartTrans {
		@XmlElement(name = "SkillModPartAttribHash")
		private String SkillModPartAttribHash;
		@XmlElement(name = "IsFixed")
		private String IsFixed;

		public String getIsFixed() {
			return IsFixed;
		}

		public String getSkillModPartAttribHash() {
			return SkillModPartAttribHash;
		}

		public void setIsFixed(String IsFixed) {
			this.IsFixed = IsFixed;
		}

		public void setSkillModPartAttribHash(String SkillModPartAttribHash) {
			this.SkillModPartAttribHash = SkillModPartAttribHash;
		}
	}

	@XmlElement(name = "SkillModPartTrans")
	private SkillModPartTrans[] skillModPartTrans;

	public SkillModPartTrans[] getSkillModPartTrans() {
		return skillModPartTrans;
	}

	public void setSkillModPartTrans(SkillModPartTrans[] SkillModPartTrans) {
		this.skillModPartTrans = SkillModPartTrans;
	}
}