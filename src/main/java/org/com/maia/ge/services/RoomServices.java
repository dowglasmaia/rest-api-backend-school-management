package org.com.maia.ge.services;

import java.util.List;
import java.util.Optional;

import org.com.maia.ge.entity.Institution;
import org.com.maia.ge.entity.Room;
import org.com.maia.ge.entity.dto.room.RoomNewDTO;
import org.com.maia.ge.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServices {

	@Autowired
	private RoomRepository repository;

	// find by id
	public Room findById(Long id) {
		Optional<Room> result = repository.findById(id);
		return result.orElseThrow(() -> new RuntimeException(" Room not fount"));
	}

	// find all
	public List<Room> findAll() {
		List<Room> result = repository.findAll();
		return result;
	}

	// save
	public Room save(Room obj) {
		obj.setId(null);
		Room newObj = repository.save(obj);
		return newObj;

	}

	// From DTO Room
	public Room fromDTO(RoomNewDTO objDTO) {
		Institution institution = objDTO.getInstitution();
		Room Room = new Room(null, objDTO.getDescription(), objDTO.getFloor(), institution);
		return Room;
	}

	// update
	public Room update(Room obj) {
		Room objUpdate = repository.save(obj);
		return objUpdate;
	}

	// delete
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
