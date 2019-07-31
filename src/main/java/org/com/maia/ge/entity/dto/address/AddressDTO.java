package org.com.maia.ge.entity.dto.address;

import org.com.maia.ge.entity.Address;

public class AddressDTO {

	private Long id;

	private String street; // Rua / logradouro

	private String district; // Bairro / setor / Zona

	private String postalCode; // cep / codigo postal.

	private String number; // numero

	private String complement; // complemento

	private String pointOfReference; // complemento

	private String city;

	private String uf;

	public AddressDTO() {

	}

	public AddressDTO(Address obj) {
		super();
		this.id = obj.getId();
		this.street = obj.getStreet();
		this.district = obj.getDistrict();
		this.postalCode = obj.getPostalCode();
		this.number = obj.getNumber();
		this.complement = obj.getComplement();
		this.pointOfReference = obj.getPointOfReference();
		this.city = obj.getCity().getName();
		this.uf = obj.getCity().getDistrict().getName();
	}

	/* == GETTERS E SETTERS == */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
