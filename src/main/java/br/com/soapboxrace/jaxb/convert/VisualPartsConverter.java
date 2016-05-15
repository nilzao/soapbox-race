package br.com.soapboxrace.jaxb.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.soapboxrace.jaxb.VisualPartsType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;

@Converter
public class VisualPartsConverter implements AttributeConverter<VisualPartsType, String> {
	@Override
	public String convertToDatabaseColumn(VisualPartsType visualParts) {
		return MarshalXML.marshal(visualParts);
	}

	@Override
	public VisualPartsType convertToEntityAttribute(String visualPartsString) {
		return (VisualPartsType) UnmarshalXML.unMarshal(visualPartsString, new VisualPartsType());
	}
}
