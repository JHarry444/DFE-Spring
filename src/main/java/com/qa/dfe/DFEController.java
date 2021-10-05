package com.qa.dfe;

import java.util.ArrayList;
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

@RestController // enables http endpoints
@CrossOrigin
public class DFEController {

	private List<Marsupial> marsupials = new ArrayList<>();

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

		return this.marsupials.get(id);
	}

	@GetMapping("/getAllMarsupials") // 200
	public List<Marsupial> getAllMarsupials() {

		return this.marsupials;
	}

	@PostMapping("/createMarsupial") // 201
	public ResponseEntity<Marsupial> createMarsupial(@RequestBody Marsupial marsupial) {
		System.out.println("CREATED MARSUPIAL: " + marsupial);
		this.marsupials.add(marsupial);
		Marsupial responseBody = this.marsupials.get(this.marsupials.size() - 1);
		ResponseEntity<Marsupial> response = new ResponseEntity<Marsupial>(responseBody, HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/updateMarsupial/{id}") // 202 - Accepted
	public Marsupial updateMarsupial(@RequestBody Marsupial marsupial, @PathVariable Integer id) {
		System.out.println("UPDATED MARSUPIAL: " + marsupial);
		System.out.println("ID: " + id);
		return this.marsupials.set(id, marsupial); // replaces the marsupial at that index
	}

	@DeleteMapping("/removeMarsupial/{id}") // 204 - No content
	public String deleteMarsupial(@PathVariable Integer id) {
		Marsupial toDelete = this.marsupials.get(id);
		this.marsupials.remove(toDelete);
		return "Deleted: " + toDelete;
	}
}
