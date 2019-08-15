package org.com.maia.ge.entity.dto.student;

import org.com.maia.ge.entity.StudentNote;

public class StudentNoteDTO {

	private Long id;

	private String courseName;

	private Double noteValue;

	private Integer semester;

	private String studentName;

	private String studentCpf;

	private String teacherName;

	private String teacherCpf;

	public StudentNoteDTO() {
		// TODO Auto-generated constructor stub
	}

	public StudentNoteDTO(StudentNote obj) {
		super();
		this.id = obj.getId();
		this.courseName = obj.getCourse().getName();
		this.noteValue = obj.getNoteValue();
		this.semester = obj.getQuarter().getNumber().getId();
		this.studentName = obj.getStudent().getName();
		this.studentCpf = obj.getStudent().getCpf();
		this.teacherName = obj.getTeacher().getName();
		this.teacherCpf = obj.getTeacher().getCpf();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Double getNoteValue() {
		return noteValue;
	}

	public void setNoteValue(Double noteValue) {
		this.noteValue = noteValue;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCpf() {
		return studentCpf;
	}

	public void setStudentCpf(String studentCpf) {
		this.studentCpf = studentCpf;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherCpf() {
		return teacherCpf;
	}

	public void setTeacherCpf(String teacherCpf) {
		this.teacherCpf = teacherCpf;
	}

}
