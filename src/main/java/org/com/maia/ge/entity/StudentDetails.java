package org.com.maia.ge.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;


/*
@Audited
@AuditTable(value = "student_details_audit")
@Table
@Entity
*/
public class StudentDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long id;

	private Long studentId;

	private Long courseId;

	private Long teacherId;

	private Integer semester;

	private String grade;

	private String clasS;

	private Double courseNote;

	public StudentDetails() {
		// TODO Auto-generated constructor stub
	}

	public StudentDetails(Long id, Long studentId, Long courseId, Long teacherId, Integer semester, String grade,
			String clasS, Double courseNote) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.semester = semester;
		this.grade = grade;
		this.clasS = clasS;
		this.courseNote = courseNote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
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

	public Double getCourseNote() {
		return courseNote;
	}

	public void setCourseNote(Double courseNote) {
		this.courseNote = courseNote;
	}

}
