package com.qa.dfe.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.dfe.data.Habitat;
import com.qa.dfe.dto.HabitatDTO;
import com.qa.dfe.exception.HabitatNotFoundException;
import com.qa.dfe.repo.HabitatRepo;

@Service
public class HabitatService {

	private HabitatRepo repo;

	private ModelMapper mapper;

	public HabitatService(HabitatRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

//	private HabitatDTO mapToDTO(Habitat habitat) {
//		HabitatDTO dto = new HabitatDTO();
//		dto.setId(habitat.getId());
//		dto.setLocation(habitat.getLocation());
//		List<MarsupialDTO> mDTOs = new ArrayList<>();
//
//		for (Marsupial m : habitat.getMarsupials()) {
//			MarsupialDTO mDTO = new MarsupialDTO();
//			mDTO.setId(m.getId());
//			mDTO.setColour(m.getColour());
//			mDTO.setName(m.getName());
//			mDTO.setSpecies(m.getSpecies());
//			mDTOs.add(mDTO);
//		}
//
//		dto.setMarsupials(mDTOs);
//		return dto;
//	}

	private HabitatDTO mapToDTO(Habitat habitat) {
		return this.mapper.map(habitat, HabitatDTO.class);
	}

	public HabitatDTO getHabitatByIndex(Integer id) {
		Habitat saved = this.repo.findById(id).orElseThrow(HabitatNotFoundException::new);

		return this.mapToDTO(saved);
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
