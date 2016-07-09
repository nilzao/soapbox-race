package br.com.soapboxrace.jaxb.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.soapboxrace.jaxb.OwnedCarTransType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;

@Converter
public class OwnedCarTransConverter implements AttributeConverter<OwnedCarTransType, String> {
	@Override
	public String convertToDatabaseColumn(OwnedCarTransType ownedCarTrans) {
		return MarshalXML.marshal(ownedCarTrans);
	}

	@Override
	public OwnedCarTransType convertToEntityAttribute(String ownedCarTransTypeString) {
		return (OwnedCarTransType) UnmarshalXML.unMarshal(ownedCarTransTypeString, new OwnedCarTransType());
	}
}