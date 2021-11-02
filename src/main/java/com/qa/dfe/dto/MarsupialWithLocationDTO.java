package com.qa.dfe.dto;

public class MarsupialWithLocationDTO {

	private Integer id;

	private String name;

	private String species;

	private String colour;

	private String location;

	public MarsupialWithLocationDTO(Integer id, String name, String species, String colour, String location) {
		super();
		this.id = id;
		this.name = name;
		this.species = species;
		this.colour = colour;
		this.location = location;
	}

	public MarsupialWithLocationDTO() {
		// TODO Auto-generated constructor stub
	}

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
