package org.com.maia.ge.services;

import java.util.List;
import java.util.Optional;

import org.com.maia.ge.entity.Course;
import org.com.maia.ge.entity.dto.course.CourseNewDTO;
import org.com.maia.ge.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServices {

	@Autowired
	private CourseRepository repository;

	// find by id
	public Course findById(Long id) {
		Optional<Course> result = repository.findById(id);
		return result.orElseThrow(() -> new RuntimeException(" Course not fount"));
	}

	// find all
	public List<Course> findAll() {
		List<Course> result = repository.findAll();
		return result;
	}

	// save
	public Course save(Course obj) {
		obj.setId(null);
		Course newObj = repository.save(obj);
		return newObj;

	}

	// From DTO Course
	public Course fromDTO(CourseNewDTO objDTO) {
		Course course = new Course(null, objDTO.getName());
		return course;
	}

	// update
	public Course update(Course obj) {
		Course objUpdate = repository.save(obj);
		return objUpdate;
	}

	// delete
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
