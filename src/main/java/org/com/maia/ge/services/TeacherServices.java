package org.com.maia.ge.services;

import java.util.List;
import java.util.Optional;

import org.com.maia.ge.entity.Teacher;
import org.com.maia.ge.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServices {

	@Autowired
	private TeacherRepository repository;

	// save
	public Teacher save(Teacher obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	// find by id
	public Teacher findById(Long id) {
		Optional<Teacher> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("Teacher not fount"));
	}

	// find all
	public List<Teacher> findAll() {
		List<Teacher> result = repository.findAll();
		return result;
	}

	// update

	// find by email

	// find by cpf

	// find all by school grade

	// find all by course

}
