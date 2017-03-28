package br.com.soapboxrace.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity implements ISoapBoxEntity {

	private static final long serialVersionUID = -6748416062022703056L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "EMAIL", length = 255)
	private String email;

	@Column(name = "PASSWORD", length = 41)
	private String password;

	@Column( name = "BAN" )
	private Boolean ban;
	
	@OneToMany(mappedBy = "user", targetEntity = PersonaEntity.class)
	private List<PersonaEntity> listOfPersona;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setBan( Boolean ban ) { this.ban = ban; }
	public Boolean getBan() { return this.ban; }
	
	public void setListOfPersona(List<PersonaEntity> listOfPersona) {
		this.listOfPersona = listOfPersona;
	}

	public List<PersonaEntity> getListOfPersona() {
		return this.listOfPersona;
	}
}
