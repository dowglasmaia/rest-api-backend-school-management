package org.com.maia.ge.services.util;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EnumType;

import org.com.maia.ge.entity.Address;
import org.com.maia.ge.entity.City;
import org.com.maia.ge.entity.Course;
import org.com.maia.ge.entity.District;
import org.com.maia.ge.entity.Institution;
import org.com.maia.ge.entity.Room;
import org.com.maia.ge.entity.SchoolGrade;
import org.com.maia.ge.entity.SchoolQuarter;
import org.com.maia.ge.entity.Student;
import org.com.maia.ge.entity.StudentNote;
import org.com.maia.ge.entity.Teacher;
import org.com.maia.ge.entity.enums.Genero;
import org.com.maia.ge.entity.enums.LevelEducation;
import org.com.maia.ge.entity.enums.Schedule;
import org.com.maia.ge.entity.enums.Semester;
import org.com.maia.ge.repository.AddressRepository;
import org.com.maia.ge.repository.CityRepository;
import org.com.maia.ge.repository.CourseRepository;
import org.com.maia.ge.repository.DistrictRepository;
import org.com.maia.ge.repository.InstitutionRepository;
import org.com.maia.ge.repository.RoomRepository;
import org.com.maia.ge.repository.SchoolGradeRepository;
import org.com.maia.ge.repository.SchoolQuarterRepository;
import org.com.maia.ge.repository.StudentNoteRepository;
import org.com.maia.ge.repository.StudentRepository;
import org.com.maia.ge.repository.TeacherRepository;
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

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private StudentNoteRepository noteRepository;

	@Autowired
	private SchoolQuarterRepository quarterRepo;

	@Autowired
	private TeacherRepository teacherRepo;

	public void instanciateTestDatabase() throws ParseException {

		/* District */
		District d1 = new District(null, "Goias", "Go");
		District d2 = new District(null, "Imperatriz", "MA");
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

		// =-=====SEMESTRE ========//
		SchoolQuarter quarter = new SchoolQuarter(null, Semester.FIRST);
		quarterRepo.save(quarter);

		SchoolQuarter quarter2 = new SchoolQuarter(null, Semester.SECOND);
		quarterRepo.save(quarter2);

		SchoolQuarter quarter3 = new SchoolQuarter(null, Semester.THIRD);
		quarterRepo.save(quarter3);

		SchoolQuarter quarter4 = new SchoolQuarter(null, Semester.FOUR);
		quarterRepo.save(quarter4);

		// Curso * Disciplina
		Course c1 = new Course(null, "Analise e Desenvolvimento de Sistemas");
		Course c2 = new Course(null, "Matemática Aplicada");
		Course c3 = new Course(null, "Banco de Dados");
		Course c4 = new Course(null, "Analise de Dados");

		courseRepo.save(c1);
		courseRepo.save(c2);
		courseRepo.save(c3);
		courseRepo.save(c4);

		// Lista de Curso para a Class SG1
		Set<Course> courses = new HashSet<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);

		// School Grade -
		SchoolGrade sg1 = new SchoolGrade(null, "8ª", "A", 20, 20, room);
		SchoolGrade sg2 = new SchoolGrade(null, "8ª", "B", 20, 20, room);
		SchoolGrade sg3 = new SchoolGrade(null, "6ª", "C", 20, 20, room);
		SchoolGrade sg4 = new SchoolGrade(null, "5ª", "D", 20, 20, room1);

		sg1.getCourses().addAll(courses);

		room.getGrades().add(sg1);
		room.getGrades().add(sg2);
		room.getGrades().add(sg3);
		room1.getGrades().add(sg4);

		gradeRepo.save(sg1);
		gradeRepo.save(sg2);
		gradeRepo.save(sg3);
		gradeRepo.save(sg4);

		// ==== TEACHER ====//
		Teacher t1 = new Teacher(null, "Kamilly Maia", Genero.FAMALE, "31597875082", "(062)99999-9999", "km@maia.com",
				"123");
		Teacher t2 = new Teacher(null, "Kayron Maia", Genero.MALE, "37838419093", "(062)99999-9999", "krom@maia.com",
				"123");
		Teacher t3 = new Teacher(null, "Shirle Maia", Genero.FAMALE, "56934535022", "(062)99999-9999", "sh@maia.com.br",
				"123");
		t1.getCourses().add(c1);
		t1.getCourses().add(c2);
		t1.getCourses().add(c4);

		t2.getCourses().add(c1);
		t2.getCourses().add(c3);

		t3.getCourses().add(c4);

		teacherRepo.save(t1);
		teacherRepo.save(t2);
		teacherRepo.save(t3);

		// **** Student ***//
		// *****Quarter
		Set<SchoolQuarter> qts = new HashSet<>();
		qts.add(quarter);

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nascDatest1 = LocalDate.parse("20/10/1990", formato);
		LocalDate nascDatest2 = LocalDate.parse("02/07/1989", formato);
		LocalDate nascDatest3 = LocalDate.parse("20/07/1999", formato);
		LocalDate nascDatest4 = LocalDate.parse("20/10/2010", formato);

		Student st1 = new Student(null, "Dowglas Maia", Genero.MALE, "57194371006", nascDatest1, LocalDate.now(), null,
				null, null, "dg@maia.com", "123", "62-9000-1111", LevelEducation.COLLEGE_EDUCATION, Schedule.NIGHT, sg1,
				school_1, a1);

		Student st2 = new Student(null, "Kayron Maia", Genero.MALE, "52407199006", nascDatest2, LocalDate.now(), null,
				null, null, "km@maia.com", "123", "62-9000-1111", LevelEducation.COLLEGE_EDUCATION, Schedule.NIGHT, sg2,
				school_1, a1);

		Student st3 = new Student(null, "Shirle Maia", Genero.FAMALE, "84855228001", nascDatest3, LocalDate.now(), null,
				null, null, "sm@maia.com", "123", "62-9000-1111", LevelEducation.HIGH_SCHOOL, Schedule.MORNING, sg2,
				school_1, a2);

		Student st4 = new Student(null, "Marcela Lima", Genero.FAMALE, "04620849065", nascDatest4, LocalDate.now(),
				null, null, "Carlos", "mc@maia.com", "123", "62-9000-1111", LevelEducation.CHILD_EDUCATION,
				Schedule.FULL_TIME, sg3, school_1, a2);

		st1.getQuarters().addAll(qts);
		st2.getQuarters().addAll(qts);
		st3.getQuarters().addAll(qts);
		st4.getQuarters().addAll(qts);

		studentRepo.save(st1);
		studentRepo.save(st2);
		studentRepo.save(st3);
		studentRepo.save(st4);

		// ==== NOTAS DO ALUNO 01 P/ 01 Bimestre === //

		StudentNote note = new StudentNote(null, c1, st1, 10.0, quarter,t1 );
		quarter.getNotes().add(note);
		quarter.getStudents().add(st1);

		noteRepository.save(note);

		StudentNote note1 = new StudentNote(null, c2, st1, 7.0, quarter, t1);
		quarter.getNotes().add(note1);
		quarter.getStudents().add(st1);
		noteRepository.save(note1);

		StudentNote note2 = new StudentNote(null, c3, st1, 6.89, quarter,t2);
		quarter.getNotes().add(note2);
		quarter.getStudents().add(st1);
		noteRepository.save(note2);

		StudentNote note3 = new StudentNote(null, c4, st1, 5.9, quarter,t3);
		quarter.getNotes().add(note3);
		quarter.getStudents().add(st1);
		noteRepository.save(note3);

		// ==== NOTAS DO ALUNO 01 P/ 02 Bimestre === //
		StudentNote nT1 = new StudentNote(null, c1, st1, 6.75, quarter2,t1);
		quarter2.getNotes().add(nT1);
		quarter.getStudents().add(st1);
		noteRepository.save(nT1);

		StudentNote nT2 = new StudentNote(null, c2, st1, 8.75, quarter2,t1);
		quarter2.getNotes().add(nT2);
		quarter.getStudents().add(st1);
		noteRepository.save(nT2);

		StudentNote nT3 = new StudentNote(null, c3, st1, 9.25, quarter2,t2);
		quarter2.getNotes().add(nT3);
		quarter.getStudents().add(st1);
		noteRepository.save(nT3);

		StudentNote nT4 = new StudentNote(null, c4, st1, 5.50, quarter2,t3);
		quarter2.getNotes().add(nT4);
		quarter.getStudents().add(st1);
		noteRepository.save(nT4);

		st1.getNotes().add(note1);
		st1.getNotes().add(note2);
		st1.getNotes().add(note3);
		st1.getNotes().add(note);
		st1.getNotes().add(nT1);
		st1.getNotes().add(nT2);
		st1.getNotes().add(nT3);
		st1.getNotes().add(nT4);
		// ==== and Student ====//

	}

}
