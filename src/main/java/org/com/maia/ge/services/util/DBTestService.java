package org.com.maia.ge.services.util;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.com.maia.ge.entity.Address;
import org.com.maia.ge.entity.City;
import org.com.maia.ge.entity.Course;
import org.com.maia.ge.entity.District;
import org.com.maia.ge.entity.Institution;
import org.com.maia.ge.entity.Room;
import org.com.maia.ge.entity.SchoolGrade;
import org.com.maia.ge.repository.AddressRepository;
import org.com.maia.ge.repository.CityRepository;
import org.com.maia.ge.repository.CourseRepository;
import org.com.maia.ge.repository.DistrictRepository;
import org.com.maia.ge.repository.InstitutionRepository;
import org.com.maia.ge.repository.RoomRepository;
import org.com.maia.ge.repository.SchoolGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBTestService {

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private CityRepository cityRespo;

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private InstitutionRepository institutionRepo;

	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private SchoolGradeRepository gradeRepo;

	public void instanciateTestDatabase() throws ParseException {

		/* District */
		District d1 = new District(null, "Goias", "Go");
		District d2 = new District(null, "Maranhão", "MA");
		districtRepository.save(d1);
		districtRepository.save(d2);
		/*-/ */

		// City
		City city = new City(null, "Maya", d1);
		cityRespo.save(city);

		City city2 = new City(null, "Praia Grande", d1);
		cityRespo.save(city2);

		City city3 = new City(null, "Montreal", d1);
		cityRespo.save(city3);

		City city4 = new City(null, "Maios", d1);
		cityRespo.save(city4);

		City city5 = new City(null, "Ahya", d1);
		cityRespo.save(city5);

		City city6 = new City(null, "Aplay", d1);
		cityRespo.save(city6);

		City city7 = new City(null, "Amm Ploi", d1);
		cityRespo.save(city7);

		// ************************************

		City city8 = new City(null, "Niagre", d2);
		cityRespo.save(city8);

		City city9 = new City(null, "Polly Stor", d2);
		cityRespo.save(city9);

		City city10 = new City(null, "City Plus", d2);
		cityRespo.save(city10);

		City city11 = new City(null, "Catedral", d2);
		cityRespo.save(city11);

		// ***************** END - CITY *******************

		Address a1 = new Address(null, "Av. C", "Centro", "74.658", "10-AB", "Qd.14 ,Lt -10", null, city);
		addressRepo.save(a1);

		Address a2 = new Address(null, "Av. C", "Centro", "74.658", "10-AB", "Qd.14 ,Lt -10", null, city7);
		addressRepo.save(a2);

		// ************

		Institution school_1 = new Institution(null, "Maia Institution", "maia.org.edu", "000-9999-7777", null, a1);

		Room room = new Room(null, "Sala-B2", "01ª Piso", school_1);
		Room room1 = new Room(null, "Sala-B3", "01ª Piso", school_1);
		Room room2 = new Room(null, "Sala-B4", "01ª Piso", school_1);
		Room room3 = new Room(null, "Sala-B5", "02ª Piso", school_1);
		Room room4 = new Room(null, "Sala-B6", "02ª Piso", school_1);

		school_1.getRooms().add(room);
		school_1.getRooms().add(room1);
		school_1.getRooms().add(room2);
		school_1.getRooms().add(room3);
		school_1.getRooms().add(room4);

		institutionRepo.save(school_1);

		roomRepo.save(room);
		roomRepo.save(room1);
		roomRepo.save(room2);
		roomRepo.save(room3);
		roomRepo.save(room4);

		// ***************** END *******************

		//Curso  *  Disciplina
		Course c1 = new Course(null, "Analise e Desenvolvimento de Sistemas");
		Course c2 = new Course(null, "Matemática Aplicada");
		Course c3 = new Course(null, "Banco de Dados");
		
		Course c4 = new Course(null, "Analise de Dados");
		
		courseRepo.save(c1);
		courseRepo.save(c2);
		courseRepo.save(c3);		
		courseRepo.save(c4);
		// Lista de Curso para a Class SG1
		Set<Course>courses = new HashSet<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		
		//School Grade - 
		SchoolGrade sg1 =  new SchoolGrade(null, "8ª", "A", 20, 20);
		SchoolGrade sg2 =  new SchoolGrade(null, "8ª", "B", 20, 20);
		SchoolGrade sg3 =  new SchoolGrade(null, "6ª", "C", 20, 20);
		SchoolGrade sg4 =  new SchoolGrade(null, "5ª", "D", 20, 20);
		sg1.getCourses().add(c1);
		sg1.getCourses().add(c2);
		sg1.getCourses().add(c3);
		sg4.getCourses().add(c1);
		
		gradeRepo.save(sg1);
		gradeRepo.save(sg2);
		gradeRepo.save(sg3);
		gradeRepo.save(sg4);
		
		//lista de Series - para a Disciplina C4
		/*Set<SchoolGrade>grades = new HashSet<>();
		grades.add(sg1);
		grades.add(sg2);
		
		c4.getGrades().addAll(grades);
		
		*/
		
	}

}
