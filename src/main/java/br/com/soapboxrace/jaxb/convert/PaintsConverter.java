package br.com.soapboxrace.jaxb.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.soapboxrace.jaxb.PaintsType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;

@Converter
public class PaintsConverter implements AttributeConverter<PaintsType, String> {
	@Override
	public String convertToDatabaseColumn(PaintsType paints) {
		return MarshalXML.marshal(paints);
	}

	@Override
	public PaintsType convertToEntityAttribute(String paintsString) {
		return (PaintsType) UnmarshalXML.unMarshal(paintsString, new PaintsType());
	}
}
