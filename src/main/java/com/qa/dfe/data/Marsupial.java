package com.qa.dfe.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // tells Spring that this is a table in the db
public class Marsupial {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Integer id;

	private String name;

	private String species;

	private String colour;

	public Marsupial(Integer id, String name, String species, String colour) {
		super();
		this.id = id;
		this.name = name;
		this.species = species;
		this.colour = colour;
	}

	public Marsupial() { // REQUIRED
		super();
	}

	// REQUIRED

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Marsupial [name=" + name + ", species=" + species + ", colour=" + colour + "]";
	}

}
