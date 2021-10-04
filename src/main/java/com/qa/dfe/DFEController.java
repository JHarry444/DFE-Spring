package com.qa.dfe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // enables http endpoints
public class DFEController {

	// if spring receives a GET request at /hello
	// call vv THIS vv method
	@GetMapping("/hello")
	public String hello() {
		return "Hello, DFE!";
	}
}
