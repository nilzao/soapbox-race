package br.com.soapboxrace.jaxb.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.soapboxrace.jaxb.SkillModPartsType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;

@Converter
public class SkillModPartsConverter implements AttributeConverter<SkillModPartsType, String> {
	@Override
	public String convertToDatabaseColumn(SkillModPartsType skillModParts) {
		return MarshalXML.marshal(skillModParts);
	}

	@Override
	public SkillModPartsType convertToEntityAttribute(String skillModPartsString) {
		return (SkillModPartsType) UnmarshalXML.unMarshal(skillModPartsString, new SkillModPartsType());
	}
}
