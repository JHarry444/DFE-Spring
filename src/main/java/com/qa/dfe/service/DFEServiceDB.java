package com.qa.dfe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.dfe.data.Marsupial;
import com.qa.dfe.repo.MarsupialRepo;

@Primary
@Service
public class DFEServiceDB implements DFEService {

	private MarsupialRepo repo;

	public DFEServiceDB(MarsupialRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Marsupial> getMarsupialByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public Marsupial getMarsupialByIndex(Integer id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Marsupial> getAllMarsupials() {
		// SELECT * FROM marsupial;
		return this.repo.findAll();
	}

	@Override
	public Marsupial createMarsupial(Marsupial marsupial) {
		return this.repo.save(marsupial);
	}

	@Override
	public Marsupial updateMarsupial(Marsupial marsupial, Integer id) {
		// NEVER TRY AND CHANGE THE ID
		Optional<Marsupial> optionalMarsupial = this.repo.findById(id); // mocked
		Marsupial toUpdate = optionalMarsupial.get(); // not mocked

		toUpdate.setColour(marsupial.getColour());
		toUpdate.setName(marsupial.getName());
		toUpdate.setSpecies(marsupial.getSpecies());

		return this.repo.save(toUpdate); // mocked
	}

	@Override
	public boolean deleteMarsupial(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

}
