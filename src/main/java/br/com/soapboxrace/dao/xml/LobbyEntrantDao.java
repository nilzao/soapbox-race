package br.com.soapboxrace.dao.xml;

import br.com.soapboxrace.dao.factory.ILobbyEntrantDao;
import br.com.soapboxrace.jpa.LobbyEntrantEntity;
import br.com.soapboxrace.jpa.PersonaEntity;

public class LobbyEntrantDao extends SoapboxDao implements ILobbyEntrantDao {

	@Override
	public LobbyEntrantEntity findById(Long id) {
		LobbyEntrantEntity entity = (LobbyEntrantEntity) super.findById(LobbyEntrantEntity.class, id);
		return entity;
	}

	public void delByPersona(PersonaEntity entity) {

	}

}
