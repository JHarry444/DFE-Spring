package com.qa.dfe.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
	void testGetByName() {
		final String name = "Jack";
		final List<Marsupial> marsupials = List.of(new Marsupial(1, name, "Kangaroo", "Red"));

		Mockito.when(this.repo.findByName(name)).thenReturn(marsupials);

		assertThat(this.service.getMarsupialByName(name)).isEqualTo(marsupials);

		Mockito.verify(this.repo, Mockito.times(1)).findByName(name);
	}

	@Test
	void testGetById() {
		final Integer Id = 1;
		final Marsupial marsupial = new Marsupial(Id, "Jack", "Kangaroo", "Red");

		Mockito.when(this.repo.findById(Id)).thenReturn(Optional.of(marsupial));

		assertThat(this.service.getMarsupialByIndex(Id)).isEqualTo(marsupial);

		Mockito.verify(this.repo, Mockito.times(1)).findById(Id);
	}

	@Test
	void testGetAllMarsupials() {
		final List<Marsupial> marsupials = List.of(new Marsupial(1, "Jack", "Kangaroo", "Red"),
				new Marsupial(2, "Wally", "Wallaby", "Grey"));

		Mockito.when(this.repo.findAll()).thenReturn(marsupials);

		assertThat(this.service.getAllMarsupials()).isEqualTo(marsupials);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testUpdate() { // REMEMBER TO OVERRIDE THE equals() METHOD IN YOUR ENTITY
		final Integer id = 1;
		Marsupial marsupial = new Marsupial(id, "Jack", "kangaroo", "red");
		Optional<Marsupial> optionalMarsupial = Optional.of(marsupial);

		Marsupial newMarsupial = new Marsupial(id, "Wally", "Wallabee", "grey");

		Mockito.when(this.repo.findById(id)).thenReturn(optionalMarsupial);
		Mockito.when(this.repo.save(newMarsupial)).thenReturn(newMarsupial);

		assertThat(this.service.updateMarsupial(newMarsupial, marsupial.getId())).isEqualTo(newMarsupial);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(newMarsupial);
	}

	@Test
	void testCreate() {
		Marsupial newMarsupial = new Marsupial(null, "Jack", "Kangaroo", "Red");
		Marsupial savedMarsupial = new Marsupial(1, "Jack", "Kangaroo", "Red");

		Mockito.when(this.repo.save(newMarsupial)).thenReturn(savedMarsupial);

		assertThat(this.service.createMarsupial(newMarsupial)).isEqualTo(savedMarsupial);

		Mockito.verify(this.repo, Mockito.times(1)).save(newMarsupial);
	}

	@Test
	void testDelete() {
		final Integer id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.deleteMarsupial(id)).isEqualTo(true);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}
}
