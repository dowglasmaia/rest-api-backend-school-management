package org.com.maia.ge.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.com.maia.ge.entity.enums.Genero;
import org.com.maia.ge.entity.enums.LevelEducation;
import org.com.maia.ge.entity.enums.Schedule;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Audited
@AuditTable(value = "audit_student")
@Table
@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // numero de Matricula

	@NotBlank(message = "Field name is required")
	@Column(length = 50, nullable = false)
	private String name; // nome

	@Enumerated(EnumType.STRING)
	private Genero genero; // sexo

	@NotBlank(message = "Field cpf is required")
	@Column(length = 11, nullable = false, unique = true)
	@CPF(message = "invalid CPF")
	private String cpf; // identification document

	@NotNull(message = "Field Date of Birth is required")
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth; // data de nascimento

	@NotNull(message = "Field Date of Enrollment is required")
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateOfEnrollment; // data de matricula

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate transferDate; // data de trasnferencia

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateOfDeparture; // data de saída

	@Column(length = 50)
	private String responsible; // responsavel

	@NotBlank(message = "Field e-mail is required")
	@Column(length = 50, nullable = false, unique = true)
	@Email(message = "invalid e-mail")
	private String email; // email

	@NotBlank(message = "Field password is required")
	@Column(length = 8, nullable = false)
	private String password; // senha

	@Transient
	private String token;

	@NotBlank(message = "Field telephone is required")
	@Column(length = 12, nullable = false)
	private String telephone; // telefone

	@NotNull(message = "Field school level is required")
	@Enumerated(EnumType.STRING)
	private LevelEducation schoolLevel; // nivel escolar

	
	@NotNull(message = "Field schedule is required")
	@Enumerated(EnumType.STRING)
	private Schedule schedule; // turno / horario

	
	@Valid
	@ManyToOne
	private SchoolGrade schoolGrade; // serie escolar

	@JsonIgnore
	@ManyToMany(mappedBy = "students")
	private Set<Course> courses = new HashSet<>(); // materias
	
	@ManyToMany
	@JoinTable(name = "Teacher_Student", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<Teacher> teachers = new HashSet<>(); // professores

	@JsonIgnore
	@Valid
	@ManyToOne
	private Institution institution; // escola

		
	@Valid
	@ManyToOne
	private Address address; // endereço

	// constructor
	public Student() {

	}

	public Student(Long id, String name, Genero genero, String cpf, LocalDate dateOfBirth, LocalDate dateOfEnrollment,
			LocalDate transferDate, LocalDate dateOfDeparture, String responsible, String email, String password,
			String telephone, LevelEducation schoolLevel, Schedule schedule, SchoolGrade schoolGrade,
			Institution institution, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.genero = genero;
		this.cpf = cpf;
		this.dateOfBirth = dateOfBirth;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transferDate = transferDate;
		this.dateOfDeparture = dateOfDeparture;
		this.responsible = responsible;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.schoolLevel = schoolLevel;
		this.schedule = schedule;
		this.schoolGrade = schoolGrade;
		this.institution = institution;
		this.address = address;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public LocalDate getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}

	public LocalDate getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(LocalDate dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LevelEducation getSchoolLevel() {
		return schoolLevel;
	}

	public void setSchoolLevel(LevelEducation schoolLevel) {
		this.schoolLevel = schoolLevel;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public SchoolGrade getSchoolGrade() {
		return schoolGrade;
	}

	public void setSchoolGrade(SchoolGrade schoolGrade) {
		this.schoolGrade = schoolGrade;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
