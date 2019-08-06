package org.com.maia.ge.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

/* Sala */

@Audited
@AuditTable(value = "audit_room")
@Table
@Entity
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Field description is required")
	@Column(length = 50, nullable = false)
	private String description;

	@NotBlank(message = "Field floor is required")
	@Column(length = 50, nullable = false)
	private String floor; // Andar / piso / solo ...

	@JsonIgnore
	@ManyToOne
	private Institution institution;

	@JsonIgnore
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	private Set<SchoolGrade> grades = new HashSet<>();

	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(Long id, @NotBlank(message = "Field description is required") String description, String floor,
			Institution institution) {
		super();
		this.id = id;
		this.description = description;
		this.floor = floor;
		this.institution = institution;
	}

	/* == GETTERS E SETTERS == */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Set<SchoolGrade> getGrades() {
		return grades;
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
		Room other = (Room) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
