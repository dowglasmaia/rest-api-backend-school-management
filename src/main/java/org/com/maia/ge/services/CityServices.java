package org.com.maia.ge.services;

import java.util.List;
import java.util.Optional;

import org.com.maia.ge.entity.City;
import org.com.maia.ge.entity.District;
import org.com.maia.ge.entity.dto.city.NewCityDTO;
import org.com.maia.ge.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServices {

	@Autowired
	private CityRepository repository;

	// find by id
	public City findById(Long id) {
		Optional<City> result = repository.findById(id);
		return result.orElseThrow(() -> new RuntimeException(" City not fount"));
	}

	// find all
	public List<City> findAll() {
		List<City> result = repository.findAll();
		return result;
	}

	// save
	public City save(City obj) {
		obj.setId(null);
		City newObj = repository.save(obj);
		return newObj;

	}

	// From DTO City
	public City fromDTO(NewCityDTO objDT) {
		District district = objDT.getDistrict();

		City city = new City(null, objDT.getName(), district);

		return city;
	}

	// update
	public City update(City obj) {
		City objUpdate = repository.save(obj);

		return objUpdate;
	}

	// delete
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	// finds cities by district
	public List<City> findCityByDistricID(Long districtID) {
		return repository.findByCities(districtID);
	}

}
