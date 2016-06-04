package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.EventBO;
import br.com.soapboxrace.jaxb.PursuitEventResultType;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class Event extends Router {

	private EventBO eventBO = new EventBO();

	public String launched() {
		return "";
	}

	public String arbitration() {
		PursuitEventResultType arbitration = eventBO.arbitration(getLoggedPersonaId(), "");
		return MarshalXML.marshal(arbitration);
	}

	public String bust() {
		PursuitEventResultType bust = (PursuitEventResultType) eventBO.bust(getLoggedPersonaId());
		return MarshalXML.marshal(bust);
	}

	public String abort() {
		return "";
	}
}
