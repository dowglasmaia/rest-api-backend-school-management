package org.com.maia.ge.services;

import java.util.List;
import java.util.Optional;

import org.com.maia.ge.entity.Address;
import org.com.maia.ge.entity.Institution;
import org.com.maia.ge.entity.dto.institution.InstitutionNewDTO;
import org.com.maia.ge.repository.InstitutionRepository;
import org.com.maia.ge.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionServices {

	@Autowired
	private InstitutionRepository repository;

	@Autowired
	private RoomRepository roomRepo;

	// find by id
	public Institution findById(Long id) {
		Optional<Institution> result = repository.findById(id);
		return result.orElseThrow(() -> new RuntimeException(" Institution not fount"));
	}

	// find all
	public List<Institution> findAll() {
		List<Institution> result = repository.findAll();
		return result;
	}

	// save
	public Institution save(Institution obj) {
		obj.setId(null);
		Institution newObj = repository.save(obj);
		return newObj;

	}

	// From DTO Institution
	public Institution fromDTO(InstitutionNewDTO objDTO) {
		Address address = objDTO.getAddress();

		Institution Institution = new Institution(null, objDTO.getName(), objDTO.getSite(), objDTO.getTelephone(),
				objDTO.getCnpj(), address);

		return Institution;
	}

	// update
	public Institution update(Institution obj) {
		Institution objUpdate = repository.save(obj);
		return objUpdate;
	}

	// delete
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	// BUSCAR PELO CNPJ

	// BSUCAR PELA CIDADE
}
