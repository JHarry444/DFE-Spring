package com.qa.dfe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfe.data.Marsupial;

//@Primary
@Service // Spring makes an instance of this class
public class DFEServiceList implements DFEService {

	private List<Marsupial> marsupials = new ArrayList<>();

	@Override
	public Marsupial getMarsupialByIndex(Integer id) {

		return this.marsupials.get(id);
	}

	@Override
	public List<Marsupial> getAllMarsupials() {

		return this.marsupials;
	}

	@Override
	public Marsupial createMarsupial(Marsupial marsupial) {
		System.out.println("CREATED MARSUPIAL: " + marsupial);
		this.marsupials.add(marsupial);
		return this.marsupials.get(this.marsupials.size() - 1);
	}

	@Override
	public Marsupial updateMarsupial(Marsupial marsupial, Integer id) {
		System.out.println("UPDATED MARSUPIAL: " + marsupial);
		System.out.println("ID: " + id);
		return this.marsupials.set(id, marsupial); // replaces the marsupial at that index
	}

	@Override
	public void deleteMarsupial(Integer id) {
		Marsupial toDelete = this.marsupials.get(id);
		this.marsupials.remove(toDelete);
	}

}
