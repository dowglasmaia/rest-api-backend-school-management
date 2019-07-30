package org.com.maia.ge.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.com.maia.ge.entity.City;
import org.com.maia.ge.entity.dto.city.CityDTO;
import org.com.maia.ge.services.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

	@Autowired
	private CityServices services;

	@RequestMapping("/{id}")
	public ResponseEntity<City> findById(@PathVariable Long id) {
		City obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping
	public ResponseEntity<List<City>> findAll() {
		List<City> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}

	// finds cities by district
	@RequestMapping("/{districtId}/cities")
	public ResponseEntity<List<CityDTO>> findAllByDistrict(@PathVariable Long districtId) {
		List<City> cities = services.findCityByDistricID(districtId);
		List<CityDTO> listDTO = cities.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
