package org.com.maia.ge.controller;

import java.util.List;

import org.com.maia.ge.entity.District;
import org.com.maia.ge.services.DistrictServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/districts")
public class DistrictController {

	@Autowired
	private DistrictServices services;

	@GetMapping("/{id}")
	public ResponseEntity<District> findById(@PathVariable Long id) {
		District obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<District>> findAll() {
		List<District> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}

}
