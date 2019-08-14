package org.com.maia.ge.entity.dto.student;

import java.time.LocalDate;

import org.com.maia.ge.entity.Address;
import org.com.maia.ge.entity.enums.Genero;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StudentDTO {

	/*
	 * EM DESENVOLVIMENTO
	 * 
	 */
	private Long id; // numero de Matricula

	private String name; // nome

	private Genero genero; // sexo

	private String cpf; // identification document

	private LocalDate dateOfBirth; // data de nascimento

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateOfEnrollment; // data de matricula

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate transferDate; // data de trasnferencia

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateOfDeparture; // data de saída

	private String responsible; // responsavel

	private String email; // email

	private String telephone; // telefone

	private String schoolLevel; // nivel escolar

	private String schedule; // turno / horario

	private String grade; // serie

	private String clasS; // classe

	private String roomDescription;

	private String roomFloor; // Andar / piso / solo ..

	private Address address; // endereço

	private String street; // Rua / logradouro

	private String district; // Bairro / setor / Zona

	private String postalCode; // cep / codigo postal.

	private String number; // numero

	private String complement; // complemento

	private String pointOfReference; // complemento

	private String cityName; // Cidade

	private String districtName; // nome

	private String districtInitials; // Sigla

	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public LocalDate getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}

	public LocalDate getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(LocalDate dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSchoolLevel() {
		return schoolLevel;
	}

	public void setSchoolLevel(String schoolLevel) {
		this.schoolLevel = schoolLevel;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClasS() {
		return clasS;
	}

	public void setClasS(String clasS) {
		this.clasS = clasS;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public String getRoomFloor() {
		return roomFloor;
	}

	public void setRoomFloor(String roomFloor) {
		this.roomFloor = roomFloor;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getPointOfReference() {
		return pointOfReference;
	}

	public void setPointOfReference(String pointOfReference) {
		this.pointOfReference = pointOfReference;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictInitials() {
		return districtInitials;
	}

	public void setDistrictInitials(String districtInitials) {
		this.districtInitials = districtInitials;
	}

}
