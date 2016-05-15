package br.com.soapboxrace.jaxb.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
import br.com.soapboxrace.jpa.OwnedCarEntity;

@Converter
public class OwnedCarEntityConverter implements AttributeConverter<OwnedCarEntity, String> {
	@Override
	public String convertToDatabaseColumn(OwnedCarEntity ownedCarEntity) {
		return MarshalXML.marshal(ownedCarEntity);
	}

	@Override
	public OwnedCarEntity convertToEntityAttribute(String ownedCarEntityString) {
		return (OwnedCarEntity) UnmarshalXML.unMarshal(ownedCarEntityString, new OwnedCarEntity());
	}
}
