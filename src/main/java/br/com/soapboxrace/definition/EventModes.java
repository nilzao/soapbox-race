package br.com.soapboxrace.definition;

public enum EventModes {
	Sprint(9), Circuit(4), Drag(19), Pursuit_SP(12), Pursuit_MP(24), MeetingPlace(22);

	private final int eventModeId;

	public int getEventModeId() {
		return eventModeId;
	}

	private EventModes(int eventModeId) {
		this.eventModeId = eventModeId;
	}

	public static EventModes forId(Integer eventModeId) {
		for (EventModes e : EventModes.values()) {
			if (e.getEventModeId() == eventModeId) {
				return e;
			}
		}
		return null;
	}
}