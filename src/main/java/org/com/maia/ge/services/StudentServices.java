package org.com.maia.ge.services;

import java.util.List;
import java.util.Optional;

import org.com.maia.ge.entity.Student;
import org.com.maia.ge.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

	@Autowired
	private StudentRepository repository;

	// save

	// update

	// find by id
	public Student findById(Long id) {
		Optional<Student> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("Student not fount"));
	}

	// find all
	public List<Student> findAll() {
		List<Student> result = repository.findAll();
		return result;
	}

	// find by email

	// find by cpf

	// find all by school grade

	// find all by teacher

	// find all by course

	// find all by date inscription (data de matricula -mês e ano)

}
