package org.com.maia.ge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.br.CPF;

@Audited
@AuditTable(value = "audit_teacher")
@Table
@Entity
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Field name is required")
	@Column(length = 50, nullable = false)
	private String name; // nome

	@NotBlank(message = "Field genero is required")
	@Column(length = 50, nullable = false)
	private String genero;// genero / sexo

	@NotBlank(message = "Field cpf is required")
	@CPF(message = "invalid CPF")
	@Column(nullable = false)
	private String cpf; // identification document

	@NotBlank(message = "Field telephone is required")
	@Column(length = 12, nullable = false)
	private String telephone; // telefone/ celular

	@NotBlank(message = "Field e-mail is required")
	@Column(length = 50, nullable = false, unique = true)
	@Email(message = "invalid e-mail")
	private String email;

	@NotBlank(message = "Field password is required")
	@Column(length = 8, nullable = false)
	private String password; // senha 

	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	

	/* == GETTERS E SETTERS == */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
