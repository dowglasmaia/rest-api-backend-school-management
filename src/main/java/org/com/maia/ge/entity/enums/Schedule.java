package org.com.maia.ge.entity.enums;

/* Turno*/

public enum Schedule {

	MORNING(1, "Matutine"),
	EVENING(2, "Evening"),
	NIGHT(3, "Night"),
	FULL_TIME(4, "Full-Time");
	 
	private Integer id;
	private String description;
	
	private Schedule() {
		// TODO Auto-generated constructor stub
	}

	private Schedule(Integer id, String description) {
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
