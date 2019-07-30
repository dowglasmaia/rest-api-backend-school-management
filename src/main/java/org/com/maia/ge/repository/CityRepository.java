package org.com.maia.ge.repository;

import java.util.List;

import org.com.maia.ge.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	//finds cities by district
	@Query("SELECT c FROM City c WHERE c.district.id = :districtId ORDER BY c.name")
	public List<City>findByCities(@Param(value = "districtId") Long districID);
	


}
