package org.com.maia.ge.entity.enums;

/* Turno*/

public enum Semester {

	FIRST(1, "Primeiro"),
	SECOND(2, "Segundo"),
	THIRD(3, "Terceiro"),
	FOUR(4, "Quarto");

	private Integer id;
	private String description;

	private Semester() {
		// TODO Auto-generated constructor stub
	}

	private Semester(Integer id, String description) {
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
