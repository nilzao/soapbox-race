package br.com.soapboxrace.jpa;

import java.io.Serializable;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "EMAIL", length = 200)
	private String email;

	@Column(name = "PASSWORD", length = 32)
	private String password;

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

	public void setListOfPersona(List<PersonaEntity> listOfPersona) {
		this.listOfPersona = listOfPersona;
	}

	public List<PersonaEntity> getListOfPersona() {
		return this.listOfPersona;
	}
}
