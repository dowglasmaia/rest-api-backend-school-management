package org.com.maia.ge.entity.dto.room;

import org.com.maia.ge.entity.Institution;
import org.com.maia.ge.entity.Room;

public class RoomNewDTO {

	private Long id;

	private String description;

	private String floor;

	private Institution institution;

	public RoomNewDTO() {

	}

	public RoomNewDTO(Room obj) {
		this.id = obj.getId();
		this.description = obj.getDescription();
		this.floor = obj.getFloor();
		this.institution = obj.getInstitution();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}
