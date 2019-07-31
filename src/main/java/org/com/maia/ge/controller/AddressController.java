package org.com.maia.ge.controller;

import java.util.List;

import org.com.maia.ge.entity.Address;
import org.com.maia.ge.services.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

	@Autowired
	private AddressServices services;

	@GetMapping("/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id) {
		Address obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Address>> findAll() {
		List<Address> result = services.findAll();
		return ResponseEntity.ok().body(result);
	}

	
	
}
