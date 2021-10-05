package com.qa.dfe.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfe.data.Marsupial;
import com.qa.dfe.service.DFEService;

@RestController // enables http endpoints AND tells Spring to make a Bean of this class
public class DFEController {

	private DFEService service;

	public DFEController(DFEService service) {
		super();
		this.service = service;
	}

	// if spring receives a GET request at /hello
	// call vv THIS vv method
	@GetMapping("/hello")
	public String hello() {
		return "Hello, DFE!";
	}

	@GetMapping("/goodbye")
	public String bye() {
		return "So long!";
	}

	@GetMapping("/getMarsupial/{id}") // 200
	public Marsupial getMarsupialByIndex(@PathVariable Integer id) {

		return this.service.getMarsupialByIndex(id);
	}

	@GetMapping("/getAllMarsupials") // 200
	public List<Marsupial> getAllMarsupials() {

		return this.service.getAllMarsupials();
	}

	@PostMapping("/createMarsupial") // 201
	public ResponseEntity<Marsupial> createMarsupial(@RequestBody Marsupial marsupial) {
		Marsupial responseBody = this.service.createMarsupial(marsupial);
		ResponseEntity<Marsupial> response = new ResponseEntity<Marsupial>(responseBody, HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/updateMarsupial/{id}") // 202 - Accepted
	public ResponseEntity<Marsupial> updateMarsupial(@RequestBody Marsupial marsupial, @PathVariable Integer id) {
		Marsupial responseBody = this.service.updateMarsupial(marsupial, id); // replaces the marsupial at that index
		return new ResponseEntity<Marsupial>(responseBody, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/removeMarsupial/{id}") // 204 - No content
	public ResponseEntity<?> deleteMarsupial(@PathVariable Integer id) {
		this.service.deleteMarsupial(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 causes the body to be ignored
	}
}
