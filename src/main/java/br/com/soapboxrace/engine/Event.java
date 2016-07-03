package br.com.soapboxrace.engine;

import br.com.soapboxrace.bo.EventBO;
import br.com.soapboxrace.jaxb.PursuitEventResultType;
import br.com.soapboxrace.jaxb.util.MarshalXML;

public class Event extends Router {

	private EventBO eventBO = new EventBO();

	public String launched() {
		Long eventSessionId = Long.valueOf(getParam("eventSessionId"));
		setSessionEntry("EventSessionId", eventSessionId);
		return eventBO.launched(getUserId(), eventSessionId);
	}

	public String arbitration() {
		if (getHttpSessionVo(getUserId()).getEventSessionId() == 0L)
			return "";
		Object arbitration = eventBO.arbitration(getUserId(), readInputStream());
		if (arbitration == null)
			return "";
		setSessionEntry("EventSessionId", 0L);
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