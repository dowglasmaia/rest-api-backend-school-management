package org.com.maia.ge.repository;

import org.com.maia.ge.entity.SchoolGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolGradeRepository extends JpaRepository<SchoolGrade, Long> {

}
