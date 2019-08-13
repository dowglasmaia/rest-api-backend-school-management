package org.com.maia.ge.controller;

import java.net.URI;
import java.util.List;

import org.com.maia.ge.entity.Teacher;
import org.com.maia.ge.services.TeacherServices;
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
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	private TeacherServices services;

	// save
	@PostMapping
	public ResponseEntity<Void>save(@RequestBody Teacher obj){
		Teacher newObj = services.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}

	// update

	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Teacher> findById(@PathVariable Long id) {
		Teacher obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// find all
	@GetMapping
	public ResponseEntity<List<Teacher>> getAll() {
		List<Teacher> result = services.findAll();
		return ResponseEntity.ok().body(result);
	}

	// find by email

	// find by cpf

	// find all by school grade

	// find all by teacher

	// find all by course

	// find all by date inscription (data de matricula -mês e ano)

}
