package br.com.soapboxrace.definition;

public enum EventFinishReasons {
	Unknown(0, "FINISHREASON_Unknown"),
	Completed(2, "FINISHREASON_Completed"),
	Succeeded(6, "FINISHREASON_Succeeded"),
	DidNotFinish(10, "FINISHREASON_DidNotFinish"),
	CrossedFinish(22, "FINISHREASON_CrossedFinish"),
	KnockedOut(42, "FINISHREASON_KnockedOut"),
	Totalled(74, "FINISHREASON_Totalled"),
	EngineBlown(138, "FINISHREASON_EngineBlown"),
	Busted(266, "FINISHREASON_Busted"),
	Evaded(518, "FINISHREASON_Evaded"),
	ChallengeCompleted(1030, "FINISHREASON_ChallengeCompleted"),
	Disconnected(2058, "FINISHREASON_Disconnected"),
	FalseStart(4106, "FINISHREASON_FalseStart"),
	Aborted(8202, "FINISHREASON_Aborted"),
	TimedOut(16394, "FINISHREASON_TimedOut"),
	TimeLimitExpired(32774, "FINISHREASON_TimeLimitExpired"),
	PauseDetected(65546, "FINISHREASON_PauseDetected"),
	SpeedHacking(131082, "FINISHREASON_SpeedHacking"),
	CodePatchDetected(262154, "FINISHREASON_CodePatchDetected"),
	BadVerifierResponse(524298, "FINISHREASON_BadVerifierResponse");

	private final Integer finishResonId;
	private final String finishReasonData;

	private EventFinishReasons(Integer finishReasonId, String finishReasonData) {
		this.finishResonId = finishReasonId;
		this.finishReasonData = finishReasonData;
	}

	public Integer getEventFinishReasonId() {
		return finishResonId;
	}

	public String getEventFinishReasonData() {
		return finishReasonData;
	}

	public static EventFinishReasons forId(Integer finishReasonId) {
		for (EventFinishReasons e : EventFinishReasons.values()) {
			if (e.getEventFinishReasonId() == finishReasonId) {
				return e;
			}
		}
		return null;
	}
	public static String getDataFromId(Integer finishReasonId) {
		for (EventFinishReasons e : EventFinishReasons.values()) {
			if (e.getEventFinishReasonId() == finishReasonId) {
				return e.getEventFinishReasonData();
			}
		}
		return null;
	}
}