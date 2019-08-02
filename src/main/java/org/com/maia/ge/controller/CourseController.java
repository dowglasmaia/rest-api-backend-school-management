package org.com.maia.ge.controller;

import java.net.URI;
import java.util.List;

import org.com.maia.ge.entity.Course;
import org.com.maia.ge.entity.dto.course.CourseNewDTO;
import org.com.maia.ge.services.CourseServices;
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
@RequestMapping(value = "/courses")
public class CourseController {

	@Autowired
	private CourseServices services;

	@GetMapping("/{id}")
	public ResponseEntity<Course> findById(@PathVariable Long id) {
		Course obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Course>> findAll() {
		List<Course> result = services.findAll();
		return ResponseEntity.ok().body(result);
	}

	@PostMapping
	public ResponseEntity<Course> save(@RequestBody CourseNewDTO objDTO) {
		Course obj = services.fromDTO(objDTO);
		obj = services.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
