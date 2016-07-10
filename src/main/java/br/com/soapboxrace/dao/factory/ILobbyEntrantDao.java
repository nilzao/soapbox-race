package br.com.soapboxrace.dao.factory;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jpa.LobbyEntrantEntity;
import br.com.soapboxrace.jpa.PersonaEntity;

public interface ILobbyEntrantDao extends ISoapboxDao {

	public LobbyEntrantEntity findById(Long id);

	public void delByPersona(PersonaEntity entity);

}
