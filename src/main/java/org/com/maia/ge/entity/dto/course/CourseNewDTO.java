package org.com.maia.ge.entity.dto.course;

import org.com.maia.ge.entity.Course;

public class CourseNewDTO {

	private Long id;

	private String name;

	public CourseNewDTO() {
		// TODO Auto-generated constructor stub
	}

	public CourseNewDTO(Course obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
	}

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

}
