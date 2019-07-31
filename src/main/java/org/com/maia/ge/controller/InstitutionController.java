package org.com.maia.ge.controller;

import java.util.List;

import org.com.maia.ge.entity.Institution;
import org.com.maia.ge.services.InstitutionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/institutions")
public class InstitutionController {

	@Autowired
	private InstitutionServices services;

	@GetMapping("/{id}")
	public ResponseEntity<Institution> findById(@PathVariable Long id) {
		Institution obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Institution>> findAll() {
		List<Institution> result = services.findAll();
		return ResponseEntity.ok().body(result);
	}

	// save

	// update

	// find list by cidade
}
