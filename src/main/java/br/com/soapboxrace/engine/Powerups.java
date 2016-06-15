package br.com.soapboxrace.engine;

import br.com.soapboxrace.openfire.OpenFireSoapBoxCli;

public class Powerups extends Router {
	private Long getPowerupHash() {
		long powerupHash = 0L;
		String[] targetSplitted = getTarget().split("/");
		if (targetSplitted.length == 6) {
			powerupHash = Long.valueOf(targetSplitted[5]);
		}
		return powerupHash;
	}

	public String activated() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<response status='1' ticket='0'>");
		stringBuilder.append("<PowerupActivated >");
		stringBuilder.append("<Count>1</Count>");
		stringBuilder.append("<Id>");
		stringBuilder.append(getPowerupHash());
		stringBuilder.append("</Id>");
		stringBuilder.append("<PersonaId>");
		stringBuilder.append(getLoggedPersonaId());
		stringBuilder.append("</PersonaId>");
		stringBuilder.append("<TargetPersonaId>0</TargetPersonaId>");
		stringBuilder.append("</PowerupActivated></response>");
		String msg = stringBuilder.toString();
		OpenFireSoapBoxCli.getInstance().send(msg, getLoggedPersonaId());
		return "";
	}
}
