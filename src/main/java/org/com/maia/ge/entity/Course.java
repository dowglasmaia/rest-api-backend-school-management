package org.com.maia.ge.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/* == Disciplina  ==*/

@Audited
@AuditTable(value = "audit_course")
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

	@ManyToMany(mappedBy = "courses")
	private List<SchoolGrade> grades = new ArrayList<>();

	/*
	 * @OneToOne(mappedBy = "course", cascade = CascadeType.ALL, fetch =
	 * FetchType.EAGER) private Set<Teacher> teachers = new HashSet<>();
	 * 
	 * @OneToOne(mappedBy = "course", cascade = CascadeType.ALL, fetch =
	 * FetchType.EAGER) private Set<Student> students = new HashSet<>();
	 */
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

	public List<SchoolGrade> getGrades() {
		return grades;
	}
	/*
	 * public Set<Teacher> getTeachers() { return teachers; }
	 * 
	 * public Set<Student> getStudents() { return students; }
	 */

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
