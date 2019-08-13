package org.com.maia.ge.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.com.maia.ge.entity.enums.Genero;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Audited
@AuditTable(value = "teacher_audit")
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

	@NotNull
	@Enumerated(EnumType.STRING)
	private Genero genero; // sexo

	@NotBlank(message = "Field cpf is required")
	@CPF(message = "invalid CPF")
	@Column(nullable = false)
	private String cpf; // identification document

	@NotBlank(message = "Field telephone is required")
	@Column(length = 16, nullable = false)
	private String telephone; // telefone/ celular

	@NotBlank(message = "Field e-mail is required")
	@Column(length = 50, nullable = false, unique = true)
	@Email(message = "invalid e-mail")
	private String email; // email

	@NotBlank(message = "Field password is required")
	@Column(length = 8, nullable = false)
	private String password; // senha

	@Transient
	private String token;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Teacher_Course", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses = new HashSet<>();

	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(Long id, String name, Genero genero, String cpf, String telephone, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.genero = genero;
		this.cpf = cpf;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
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

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set<Course> getCourses() {
		return courses;
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
