package org.com.maia.ge.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Dowglas Maia
 * @since Class Nota
 */

@Audited
@AuditTable(value = "student_note_audit")
@Table
@Entity
public class StudentNote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	private Course course; // materia

	@JsonIgnore
	@NotNull
	@ManyToOne
	private Student student; // aluno

	@NotNull
	private Double noteValue; // nota

	@NotNull
	@ManyToOne
	private SchoolQuarter quarter; // bimestre

	@NotNull
	@ManyToOne
	private Teacher teacher; // Professor

	public StudentNote() {

	}

	public StudentNote(Long id, Course course, Student student, Double noteValue, SchoolQuarter quarter,
			Teacher teacher) {
		super();
		this.id = id;
		this.course = course;
		this.student = student;
		this.noteValue = noteValue;
		this.quarter = quarter;
		this.teacher = teacher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Double getNoteValue() {
		return noteValue;
	}

	public void setNoteValue(Double noteValue) {
		this.noteValue = noteValue;
	}

	public SchoolQuarter getQuarter() {
		return quarter;
	}

	public void setQuarter(SchoolQuarter quarter) {
		this.quarter = quarter;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
		StudentNote other = (StudentNote) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
