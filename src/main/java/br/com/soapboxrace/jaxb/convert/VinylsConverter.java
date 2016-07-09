package br.com.soapboxrace.jaxb.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.soapboxrace.jaxb.VinylsType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;

@Converter
public class VinylsConverter implements AttributeConverter<VinylsType, String> {
	@Override
	public String convertToDatabaseColumn(VinylsType vinyls) {
		return MarshalXML.marshal(vinyls);
	}

	@Override
	public VinylsType convertToEntityAttribute(String vinylsString) {
		return (VinylsType) UnmarshalXML.unMarshal(vinylsString, new VinylsType());
	}
}