package org.com.maia.ge.entity.enums;

/* Turno*/

public enum LevelEducation {

	CHILD_EDUCATION(1, "Educação Infantil"),
	ELEMENTARY_SCHOOL(2, "Ensino Fundamental"),
	HIGH_SCHOOL(3, "Ensino Médio"),
	COLLEGE_EDUCATION(4, "Ensino Superior");
	 
	private Integer id;
	private String description;
	
	private LevelEducation() {
		// TODO Auto-generated constructor stub
	}

	private LevelEducation(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
		
	
}
