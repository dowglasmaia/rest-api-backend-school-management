package org.com.maia.ge.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.com.maia.ge.entity.City;
import org.com.maia.ge.entity.dto.city.CityDTO;
import org.com.maia.ge.entity.dto.city.NewCityDTO;
import org.com.maia.ge.services.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

	@Autowired
	private CityServices services;

	// get by ID
	@RequestMapping("/{id}")
	public ResponseEntity<City> findById(@PathVariable Long id) {
		City obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// getAll
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

	// save
	@PostMapping
	public ResponseEntity<City> save(@Valid @RequestBody NewCityDTO objDto) {
		City obj = services.fromDTO(objDto);
		obj = services.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
}
