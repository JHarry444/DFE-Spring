package com.qa.dfe.dto;

public class MarsupialDTO {

	private Integer id;

	private String name;

	private String species;

	private String colour;

	public MarsupialDTO(Integer id, String name, String species, String colour) {
		super();
		this.id = id;
		this.name = name;
		this.species = species;
		this.colour = colour;
	}

	public MarsupialDTO() { // REQUIRED
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

}
