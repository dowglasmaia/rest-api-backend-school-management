package org.com.maia.ge.entity.dto.institution;

import org.com.maia.ge.entity.Address;
import org.com.maia.ge.entity.Institution;

public class InstitutionNewDTO {

	private Long id;

	private String name;

	private String site;

	private String telephone;

	private String cnpj;

	private Address address;

	public InstitutionNewDTO() {
		// TODO Auto-generated constructor stub
	}

	public InstitutionNewDTO(Institution obj) {

		this.id = obj.getId();
		this.name = obj.getName();
		this.site = obj.getSite();
		this.telephone = obj.getTelephone();
		this.cnpj = obj.getCnpj();
		this.address = obj.getAddress();
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
