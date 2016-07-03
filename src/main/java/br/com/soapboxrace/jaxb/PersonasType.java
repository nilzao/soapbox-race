package br.com.soapboxrace.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personasType", propOrder = { "profileData" })
public class PersonasType {

	@XmlElement(name = "ProfileData")
	protected List<ProfileDataType> profileData;

	public List<ProfileDataType> getProfileData() {
		if (profileData == null) {
			profileData = new ArrayList<ProfileDataType>();
		}
		return this.profileData;
	}

}
