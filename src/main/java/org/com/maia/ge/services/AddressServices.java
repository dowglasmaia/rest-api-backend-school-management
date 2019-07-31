package org.com.maia.ge.services;

import java.util.List;
import java.util.Optional;

import org.com.maia.ge.entity.Address;
import org.com.maia.ge.entity.City;
import org.com.maia.ge.entity.dto.address.NewAddressDTO;
import org.com.maia.ge.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServices {

	@Autowired
	private AddressRepository repository;

	// find by id
	public Address findById(Long id) {
		Optional<Address> result = repository.findById(id);			
		return result.orElseThrow(() -> new RuntimeException(" Address not fount"));
	}

	// find all
	public List<Address> findAll() {
		List<Address> result = repository.findAll();
		return result;
	}

	// save
	public Address save(Address obj) {
		obj.setId(null);
		Address newObj = repository.save(obj);
		return newObj;

	}

	// From DTO Address
	public Address fromDTO(NewAddressDTO objDTO) {
		City city = objDTO.getCity();

		Address Address = new Address(null, objDTO.getStreet(), objDTO.getDistrict(), objDTO.getPostalCode(),
				objDTO.getNumber(), objDTO.getComplement(), objDTO.getPointOfReference(), city);

		return Address;
	}

	// update
	public Address update(Address obj) {
		Address objUpdate = repository.save(obj);
		return objUpdate;
	}

	// delete
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
