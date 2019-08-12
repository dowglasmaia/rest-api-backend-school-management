package org.com.maia.ge.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.com.maia.ge.entity.enums.Semester;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/**
 * @author Dowglas Maia
 * @since Class Bimestre Escolar
 *
 */

@Audited
@AuditTable(value = "audit_school_quarter")
@Table
@Entity
public class SchoolQuarter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	private Semester number;

	@ManyToMany
	@JoinTable(name = "Student_Semester", joinColumns = @JoinColumn(name = "semester_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<Student> students = new HashSet<>();
	
	
	@OneToMany(mappedBy = "quarter")
	private Set<StudentNote> notes = new HashSet<>();

	public SchoolQuarter() {
		// TODO Auto-generated constructor stub
	}

	public SchoolQuarter(Long id, Semester number) {
		super();
		this.id = id;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SchoolQuarter(Semester number) {
		super();
		this.number = number;
	}

	public Semester getNumber() {
		return number;
	}

	public void setNumber(Semester number) {
		this.number = number;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public Set<StudentNote> getNotes() {
		return notes;
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
		SchoolQuarter other = (SchoolQuarter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
