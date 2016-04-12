package br.com.soapboxrace.bo;

import br.com.soapboxrace.db.ConnectionDB;
import br.com.soapboxrace.jaxb.AccoladesType;
import br.com.soapboxrace.jaxb.FinalRewardsType;
import br.com.soapboxrace.jaxb.OriginalRewardsType;
import br.com.soapboxrace.jaxb.PursuitEventResultType;
import br.com.soapboxrace.jpa.PersonaEntity;

public class EventBO {

	private ConnectionDB connectDb = new ConnectionDB();

	public PursuitEventResultType arbitration(Long personaId, String arbitrationXml) {
		PersonaEntity personaEntity = (PersonaEntity) connectDb.findById(new PersonaEntity(), personaId);
		Integer level = personaEntity.getLevel();
		if (level == 1) {
			personaEntity.setLevel(2);
			connectDb.merge(personaEntity);
		}

		PursuitEventResultType pursuitEventResult = new PursuitEventResultType();
		pursuitEventResult.setDurability(100);
		pursuitEventResult.setEventId(1);
		pursuitEventResult.setEventSessionId(1000000000);
		pursuitEventResult.setExitPath("ExitToFreeroam");
		pursuitEventResult.setInviteLifetimeInMilliseconds(0);
		pursuitEventResult.setLobbyInviteId(0);
		pursuitEventResult.setPersonaId(personaId);
		pursuitEventResult.setHeat(1);

		FinalRewardsType finalRewardsType = new FinalRewardsType();
		finalRewardsType.setRep(0);
		finalRewardsType.setTokens(0);

		OriginalRewardsType originalRewardsType = new OriginalRewardsType();
		originalRewardsType.setRep(0);
		originalRewardsType.setTokens(0);

		AccoladesType accoladesType = new AccoladesType();
		accoladesType.setHasLeveledUp("false");
		accoladesType.setLuckyDrawInfo("");
		accoladesType.setRewardInfo("");
		accoladesType.setFinalRewards(finalRewardsType);
		accoladesType.setOriginalRewards(originalRewardsType);

		pursuitEventResult.setAccolades(accoladesType);

		return pursuitEventResult;
	}

	public PursuitEventResultType bust(Long personaId) {
		PursuitEventResultType pursuitEventResult = new PursuitEventResultType();
		pursuitEventResult.setDurability(100);
		pursuitEventResult.setEventId(1);
		pursuitEventResult.setEventSessionId(1000000000);
		pursuitEventResult.setExitPath("ExitToFreeroam");
		pursuitEventResult.setInviteLifetimeInMilliseconds(0);
		pursuitEventResult.setLobbyInviteId(0);
		pursuitEventResult.setPersonaId(personaId);
		pursuitEventResult.setHeat(1);

		FinalRewardsType finalRewardsType = new FinalRewardsType();
		finalRewardsType.setRep(0);
		finalRewardsType.setTokens(0);

		OriginalRewardsType originalRewardsType = new OriginalRewardsType();
		originalRewardsType.setRep(0);
		originalRewardsType.setTokens(0);

		AccoladesType accoladesType = new AccoladesType();
		accoladesType.setHasLeveledUp("false");
		accoladesType.setLuckyDrawInfo("");
		accoladesType.setRewardInfo("");
		accoladesType.setFinalRewards(finalRewardsType);
		accoladesType.setOriginalRewards(originalRewardsType);

		pursuitEventResult.setAccolades(accoladesType);
		return pursuitEventResult;
	}

}
