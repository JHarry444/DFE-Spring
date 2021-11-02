package com.qa.dfe.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Habitat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String location;

	@JsonIgnore
	@OneToMany(mappedBy = "habitat") // specify the variable name of the FK
	private List<Marsupial> marsupials;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Marsupial> getMarsupials() {
		return marsupials;
	}

	public void setMarsupials(List<Marsupial> marsupials) {
		this.marsupials = marsupials;
	}

}
