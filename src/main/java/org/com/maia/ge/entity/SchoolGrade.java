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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*Serie Escolar */

@Audited
@AuditTable(value = "audit_school_grade")
@Table
@Entity
public class SchoolGrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Field grade is required")
	@Column(length = 20, nullable = false)
	private String grade; // serie

	@NotBlank(message = "Field class is required")
	@Column(length = 5, nullable = false)
	private String clasS; // classe

	@NotNull(message = "Field maximum student is required")
	@Column(nullable = false)
	private Integer maxStudent; // maximo de estudantes

	@NotNull(message = "Field current student is required")
	@Column(nullable = false)
	private Integer currentStudent;

	@Valid
	@ManyToOne
	private Room room;

	@ManyToMany // muitos pra muitos - uma Seria tem varias disciplinas
	@JoinTable(name = "Grade_Course", joinColumns = @JoinColumn(name = "school_grade_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses = new HashSet<>(); // materias

	// private Set<Teacher> teachers = new HashSet<>(); // professores

	@JsonIgnore
	@OneToMany(mappedBy = "schoolGrade", fetch = FetchType.LAZY)
	private Set<Student> students = new HashSet<>(); // Alunos

	public SchoolGrade() {
		// TODO Auto-generated constructor stub
	}

	public SchoolGrade(Long id, String grade, String clasS, Integer maxStudent, Integer currentStudent, Room room) {
		super();
		this.id = id;
		this.grade = grade;
		this.clasS = clasS;
		this.maxStudent = maxStudent;
		this.currentStudent = currentStudent;
		this.room = room;
	}

	/* vagas disponiveis */
	protected Integer getVacancies() {
		Integer vgs = (this.maxStudent - this.currentStudent);
		return vgs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClasS() {
		return clasS;
	}

	public void setClasS(String clasS) {
		this.clasS = clasS;
	}

	public Integer getMaxStudent() {
		return maxStudent;
	}

	public void setMaxStudent(Integer maxStudent) {
		this.maxStudent = maxStudent;
	}

	public Integer getCurrentStudent() {
		return currentStudent;
	}

	public void setCurrentStudent(Integer currentStudent) {
		this.currentStudent = currentStudent;
	}

	public Set<Course> getCourses() {
		return courses;
	}

//	public Set<Teacher> getTeachers() {
//		return teachers;
//	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Set<Student> getStudents() {
		return students;
	}

}
