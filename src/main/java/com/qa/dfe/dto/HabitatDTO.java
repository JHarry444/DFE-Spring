package com.qa.dfe.dto;

import java.util.List;

public class HabitatDTO {

	private Integer id;

	private String location;

	private List<MarsupialDTO> marsupials;

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

	public List<MarsupialDTO> getMarsupials() {
		return marsupials;
	}

	public void setMarsupials(List<MarsupialDTO> marsupials) {
		this.marsupials = marsupials;
	}

}
