package com.qa.dfe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.dfe.data.Habitat;
import com.qa.dfe.exception.HabitatNotFoundException;
import com.qa.dfe.repo.HabitatRepo;

@Service
public class HabitatService {

	private HabitatRepo repo;

	public HabitatService(HabitatRepo repo) {
		super();
		this.repo = repo;
	}

	public Habitat getHabitatByIndex(Integer id) {
		return this.repo.findById(id).orElseThrow(HabitatNotFoundException::new);
	}

	public List<Habitat> getAllHabitats() {
		// SELECT * FROM habitat;
		return this.repo.findAll();
	}

	public Habitat createHabitat(Habitat habitat) {
		return this.repo.save(habitat);
	}

	public Habitat updateHabitat(Habitat habitat, Integer id) {
		// NEVER TRY AND CHANGE THE ID
		Optional<Habitat> optionalHabitat = this.repo.findById(id); // mocked
		Habitat toUpdate = optionalHabitat.get(); // not mocked

		toUpdate.setLocation(habitat.getLocation());

		return this.repo.save(toUpdate); // mocked
	}

	public boolean deleteHabitat(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

}
