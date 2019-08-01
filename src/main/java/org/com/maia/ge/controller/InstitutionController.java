package org.com.maia.ge.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.com.maia.ge.entity.Institution;
import org.com.maia.ge.entity.dto.institution.InstitutionNewDTO;
import org.com.maia.ge.services.InstitutionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody InstitutionNewDTO objDTO) {
		Institution obj = services.fromDTO(objDTO);
		obj = services.save(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// update
	

	// find list by cidade
}
