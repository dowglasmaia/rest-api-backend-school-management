package org.com.maia.ge.repository;

import org.com.maia.ge.entity.StudentNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentNoteRepository extends JpaRepository<StudentNote, Long> {

}
