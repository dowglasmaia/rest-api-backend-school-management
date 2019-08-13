package org.com.maia.ge.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*Endereço */

@Audited
@AuditTable(value = "addres_audit")
@Table
@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Field street is required")
	@Column(length = 50, nullable = false)
	private String street; // Rua / logradouro

	@NotBlank(message = "Field district is required")
	@Column(length = 50, nullable = false)
	private String district; // Bairro / setor / Zona

	@NotBlank(message = "Field postalCode is required")
	@Column(length = 50, nullable = false)
	private String postalCode; // cep / codigo postal.

	@NotBlank(message = "Field number is required")
	@Column(length = 50, nullable = false)
	private String number; // numero

	private String complement; // complemento

	private String pointOfReference; // complemento

	@ManyToOne
	private City city;

	@JsonIgnore
	@OneToMany(mappedBy = "address")
	private Set<Student> students = new HashSet<>();

	public Address() {

	}

	public Address(Long id, @NotBlank(message = "Field street is required") String street,
			@NotBlank(message = "Field district is required") String district,
			@NotBlank(message = "Field postalCode is required") String postalCode,
			@NotBlank(message = "Field number is required") String number, String complement, String pointOfReference,
			City city) {
		super();
		this.id = id;
		this.street = street;
		this.district = district;
		this.postalCode = postalCode;
		this.number = number;
		this.complement = complement;
		this.pointOfReference = pointOfReference;
		this.city = city;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<Student> getStudents() {
		return students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
