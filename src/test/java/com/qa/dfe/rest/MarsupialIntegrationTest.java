package com.qa.dfe.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dfe.data.Marsupial;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the MockMVC object
public class MarsupialIntegrationTest {

	@Autowired // inject the MockMVC object into this class
	private MockMvc mvc; // object for sending mock http requests

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		final Marsupial testMarsupial = new Marsupial(null, "Jack", "Kangaroo", "Red");
		String testMarsupialAsJSON = this.mapper.writeValueAsString(testMarsupial);

		final Marsupial savedMarsupial = new Marsupial(1, "Jack", "Kangaroo", "Red");
		String savedMarsupialAsJSON = this.mapper.writeValueAsString(savedMarsupial);

		// method, path, headers, body
		RequestBuilder request = post("/createMarsupial").contentType(MediaType.APPLICATION_JSON)
				.content(testMarsupialAsJSON);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedMarsupialAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}

	void testCreateAbrdiged() throws Exception {
		final String testMarsupialAsJSON = this.mapper
				.writeValueAsString(new Marsupial(null, "Jack", "Kangaroo", "Red"));
		final String savedMarsupialAsJSON = this.mapper.writeValueAsString(new Marsupial(1, "Jack", "Kangaroo", "Red"));

		this.mvc.perform(post("/createMarsupial").contentType(MediaType.APPLICATION_JSON).content(testMarsupialAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(savedMarsupialAsJSON));

	}
}
