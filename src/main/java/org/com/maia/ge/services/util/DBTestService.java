package org.com.maia.ge.services.util;

import java.text.ParseException;

import org.com.maia.ge.entity.District;
import org.com.maia.ge.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBTestService {


	@Autowired
	private DistrictRepository districtRepository;

	public void instanciateTestDatabase() throws ParseException {
		
		/* District */
		District d1 = new District(null, "Goias", "Go");
		District d2 = new District(null, "Maranhão", "MA");
		districtRepository.save(d1);
		districtRepository.save(d2);
		/*-/ */
		
		

	}

	

}
