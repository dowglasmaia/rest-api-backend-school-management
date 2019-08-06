package org.com.maia.ge.entity.enums;

/* Turno*/

public enum Genero {

	MALE(1, "Masculino"),
	FAMALE(2, "Feminino"),
	OTHERS(3, "Outros");
	 
	private Integer id;
	private String description;
	
	private Genero() {
		// TODO Auto-generated constructor stub
	}

	private Genero(Integer id, String description) {
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
