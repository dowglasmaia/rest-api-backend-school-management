package org.com.maia.ge.repository;

import org.com.maia.ge.entity.SchoolQuarter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolQuarterRepository extends JpaRepository<SchoolQuarter, Long> {

}
