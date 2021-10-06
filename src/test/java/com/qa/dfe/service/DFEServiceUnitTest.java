package com.qa.dfe.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.dfe.data.Marsupial;
import com.qa.dfe.repo.MarsupialRepo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DFEServiceUnitTest {

	@Autowired
	private DFEServiceDB service;

	@MockBean
	private MarsupialRepo repo;

	@Test
	void testUpdate() { // REMEMBER TO OVERRIDE THE equals() METHOD IN YOUR ENTITY
		final Integer id = 1;
		Marsupial marsupial = new Marsupial(id, "Jack", "kangaroo", "red");
		Optional<Marsupial> optionalMarsupial = Optional.of(marsupial);

		Marsupial newMarsupial = new Marsupial(id, "Wally", "Wallabee", "grey");

		Mockito.when(this.repo.findById(id)).thenReturn(optionalMarsupial);
		Mockito.when(this.repo.save(newMarsupial)).thenReturn(newMarsupial);

		assertThat(newMarsupial).isEqualTo(this.service.updateMarsupial(newMarsupial, marsupial.getId()));

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(newMarsupial);
	}
}
