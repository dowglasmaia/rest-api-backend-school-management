package org.com.maia.ge.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

/* == Disciplina  ==*/

@Audited
@AuditTable(value = "course_audit")
@Table
@Entity
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = " Field  name is required")
	@Column(length = 50, nullable = false)
	private String name;

	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private Set<StudentNote> notes = new HashSet<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "courses")
	private Set<SchoolGrade> grades = new HashSet<>();

	@ManyToMany(mappedBy = "courses")
	private Set<Teacher> teachers = new HashSet<>();

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(Long id, @NotBlank(message = " Field  name is required") String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Set<SchoolGrade> getGrades() {
		return grades;
	}

	public Set<StudentNote> getNotes() {
		return notes;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
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
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
