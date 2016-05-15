package br.com.soapboxrace.jaxb.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.soapboxrace.jaxb.PerformancePartsType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;

@Converter
public class PerformancePartsConverter implements AttributeConverter<PerformancePartsType, String> {
	@Override
	public String convertToDatabaseColumn(PerformancePartsType performanceParts) {
		return MarshalXML.marshal(performanceParts);
	}

	@Override
	public PerformancePartsType convertToEntityAttribute(String performancePartsString) {
		return (PerformancePartsType) UnmarshalXML.unMarshal(performancePartsString, new PerformancePartsType());
	}
}
