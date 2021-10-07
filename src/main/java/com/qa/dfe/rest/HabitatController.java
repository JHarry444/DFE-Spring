package com.qa.dfe.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfe.data.Habitat;
import com.qa.dfe.dto.HabitatDTO;
import com.qa.dfe.service.HabitatService;

@CrossOrigin
@RestController // enables http endpoints AND tells Spring to make a Bean of this class
public class HabitatController {

	private HabitatService service;

	public HabitatController(HabitatService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getHabitat/{id}") // 200
	public HabitatDTO getHabitatByIndex(@PathVariable Integer id) {

		return this.service.getHabitatByIndex(id);
	}

	@GetMapping("/getAllHabitats") // 200
	public List<Habitat> getAllHabitats() {

		return this.service.getAllHabitats();
	}

	@PostMapping("/createHabitat") // 201
	public ResponseEntity<Habitat> createHabitat(@RequestBody Habitat habitat) {
		Habitat responseBody = this.service.createHabitat(habitat);
		ResponseEntity<Habitat> response = new ResponseEntity<Habitat>(responseBody, HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/updateHabitat/{id}") // 202 - Accepted
	public ResponseEntity<Habitat> updateHabitat(@RequestBody Habitat habitat, @PathVariable Integer id) {
		Habitat responseBody = this.service.updateHabitat(habitat, id); // replaces the habitat at that index
		return new ResponseEntity<Habitat>(responseBody, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/removeHabitat/{id}") // 204 - No content
	public ResponseEntity<?> deleteHabitat(@PathVariable Integer id) {
		boolean deleted = this.service.deleteHabitat(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 causes the body to be ignored
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
