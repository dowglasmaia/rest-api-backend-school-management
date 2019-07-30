package org.com.maia.ge.entity.dto.city;

import org.com.maia.ge.entity.District;

public class NewCityDTO {

	private Long id;

	private String name;

	private District district;

	public NewCityDTO() {
		// TODO Auto-generated constructor stub
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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

}
