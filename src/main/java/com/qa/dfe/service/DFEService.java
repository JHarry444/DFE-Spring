package com.qa.dfe.service;

import java.util.List;

import com.qa.dfe.data.Marsupial;
import com.qa.dfe.dto.MarsupialWithLocationDTO;

public interface DFEService {

	public List<Marsupial> getMarsupialByName(String name);

	public MarsupialWithLocationDTO getMarsupialByIndex(Integer id);

	public List<Marsupial> getAllMarsupials();

	public Marsupial createMarsupial(Marsupial marsupial);

	public Marsupial updateMarsupial(Marsupial marsupial, Integer id);

	public boolean deleteMarsupial(Integer id);
}
