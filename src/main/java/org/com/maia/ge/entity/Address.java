package org.com.maia.ge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/*Endereço */

@Audited
@AuditTable(value = "audit_Addres")
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

	@JoinColumn(nullable = false)
	@Valid
	@ManyToOne
	private AddressComplement complement;

	public Address() {

	}

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

	public AddressComplement getComplement() {
		return complement;
	}

	public void setComplement(AddressComplement complement) {
		this.complement = complement;
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
