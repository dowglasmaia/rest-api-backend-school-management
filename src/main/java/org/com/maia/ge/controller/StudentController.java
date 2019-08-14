package org.com.maia.ge.controller;

import java.net.URI;
import java.util.List;

import org.com.maia.ge.entity.Student;
import org.com.maia.ge.services.StudentServices;
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
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentServices services;

	// save
	@PostMapping
	public ResponseEntity<Void>save(@RequestBody Student obj){
		Student newObj = services.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}

	// update

	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable Long id) {
		Student obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// find all
	@GetMapping
	public ResponseEntity<List<Student>> getAll() {
		List<Student> result = services.findAll();
		return ResponseEntity.ok().body(result);
	}

	//find notas ***students/notes?studentid=1
	
	
	// find by email

	// find by cpf

	// find all by school grade

	// find all by teacher

	// find all by course

	// find all by date inscription (data de matricula -mês e ano)

}
