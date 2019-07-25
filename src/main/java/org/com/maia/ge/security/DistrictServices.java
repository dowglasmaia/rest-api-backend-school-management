package org.com.maia.ge.security;

import java.util.Optional;

import org.com.maia.ge.entity.District;
import org.com.maia.ge.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServices {

	@Autowired
	private DistrictRepository repository;
	
	

	// Find By ID
	public District findById(Long id) {
		Optional<District> result = repository.findById(id);
		return result.get();
	}

}
