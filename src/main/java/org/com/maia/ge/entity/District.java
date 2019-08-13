package org.com.maia.ge.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

/* Estado  */

@Audited
@AuditTable(value = "district_audit")
@Table
@Entity
public class District implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Field name is required") // campo nome é requerido
	@Column(length = 50, nullable = false)
	private String name; // nome

	@NotBlank(message = "field initials is required") // campo sigla é obrigatório
	@Column(length = 2, nullable = false)
	private String initials; // Sigla

	@JsonIgnore
	@OneToMany(mappedBy = "district", fetch = FetchType.EAGER)
	private List<City> cities = new ArrayList<>();

	public District() {

	}

	public District(Long id, @NotBlank(message = "Field name is required") String name,
			@NotBlank(message = "field initials is required") String initials) {
		super();
		this.id = id;
		this.name = name;
		this.initials = initials;
	}

	/* == GETTERS E SETTERS == */
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

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public List<City> getCities() {
		return cities;
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
		District other = (District) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
