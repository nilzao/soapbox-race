package br.com.soapboxrace.dao.factory;

import java.util.List;

import br.com.soapboxrace.db.ISoapboxDao;
import br.com.soapboxrace.jpa.PersonaEntity;

public interface IPersonaDao extends ISoapboxDao {

	public PersonaEntity findById(Long id);

	public boolean existsByName(String name);

	public PersonaEntity save(PersonaEntity entity);

	public void del(PersonaEntity entity);

	public List<PersonaEntity> findByUserId(Long userId);

	public PersonaEntity findByName(String name);

	public void updateStatusMessage(Long personaId, String statusMessage);

}
