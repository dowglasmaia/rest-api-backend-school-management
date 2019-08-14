package org.com.maia.ge.repository;

import java.util.List;

import org.com.maia.ge.entity.Student;
import org.com.maia.ge.entity.StudentNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT sn FROM StudentNote sn WHERE sn.student.id = ?1 ORDER BY sn.course.name")
	 List<StudentNote> findByNote(Long studentId);
	
	
}
