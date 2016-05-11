package br.com.soapboxrace.definition;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.soapboxrace.jaxb.PaintsType;
import br.com.soapboxrace.jaxb.PerformancePartsType;
import br.com.soapboxrace.jaxb.SkillModPartsType;
import br.com.soapboxrace.jaxb.UpdatedCarType;
import br.com.soapboxrace.jaxb.VinylsType;
import br.com.soapboxrace.jaxb.VisualPartsType;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.jaxb.util.UnmarshalXML;
import br.com.soapboxrace.jpa.OwnedCarEntity;

public class convert {
	@Converter
	public static class PaintsConverter implements AttributeConverter<PaintsType, String> {
		@Override
		public String convertToDatabaseColumn(PaintsType paints) {
			return MarshalXML.marshal(paints);
		}

		@Override
		public PaintsType convertToEntityAttribute(String paintsString) {
			return (PaintsType) UnmarshalXML.unMarshal(paintsString, new PaintsType());
		}
	}

	@Converter
	public static class PerformancePartsConverter implements AttributeConverter<PerformancePartsType, String> {
		@Override
		public String convertToDatabaseColumn(PerformancePartsType performanceParts) {
			return MarshalXML.marshal(performanceParts);
		}

		@Override
		public PerformancePartsType convertToEntityAttribute(String performancePartsString) {
			return (PerformancePartsType) UnmarshalXML.unMarshal(performancePartsString, new PerformancePartsType());
		}
	}

	@Converter
	public static class SkillModPartsConverter implements AttributeConverter<SkillModPartsType, String> {
		@Override
		public String convertToDatabaseColumn(SkillModPartsType skillModParts) {
			return MarshalXML.marshal(skillModParts);
		}

		@Override
		public SkillModPartsType convertToEntityAttribute(String skillModPartsString) {
			return (SkillModPartsType) UnmarshalXML.unMarshal(skillModPartsString, new SkillModPartsType());
		}
	}

	@Converter
	public static class VinylsConverter implements AttributeConverter<VinylsType, String> {
		@Override
		public String convertToDatabaseColumn(VinylsType vinyls) {
			return MarshalXML.marshal(vinyls);
		}

		@Override
		public VinylsType convertToEntityAttribute(String vinylsString) {
			return (VinylsType) UnmarshalXML.unMarshal(vinylsString, new VinylsType());
		}
	}

	@Converter
	public static class VisualPartsConverter implements AttributeConverter<VisualPartsType, String> {
		@Override
		public String convertToDatabaseColumn(VisualPartsType visualParts) {
			return MarshalXML.marshal(visualParts);
		}

		@Override
		public VisualPartsType convertToEntityAttribute(String visualPartsString) {
			return (VisualPartsType) UnmarshalXML.unMarshal(visualPartsString, new VisualPartsType());
		}
	}

	public static UpdatedCarType fromOwnedCarToUpdatedCar(OwnedCarEntity ownedCar) {
		UpdatedCarType result = new UpdatedCarType();
		result.setCustomCar(ownedCar.getCustomCar().getCustomCarType());
		result.setDurability(ownedCar.getDurability());
		result.setHeatLevel((short) 1);
		result.setOwnershipType("CustomizedCar");
		result.setUniqueCarId(ownedCar.getUniqueCarId());
		return result;
	}
}