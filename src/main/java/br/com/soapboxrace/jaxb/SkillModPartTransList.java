package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import br.com.soapboxrace.jpa.SkillModPartEntity;

@XmlAccessorType(XmlAccessType.FIELD)
public class SkillModPartTransList {

	@XmlElement(name = "SkillModPartTrans", required = true)
	protected List<SkillModPartEntity> skillModPartList;

	public List<SkillModPartEntity> getSkillModPartList() {
		return skillModPartList;
	}

	public void setSkillModPartList(List<SkillModPartEntity> skillModPartList) {
		this.skillModPartList = skillModPartList;
	}

}
