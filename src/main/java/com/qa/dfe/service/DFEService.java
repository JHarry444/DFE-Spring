package com.qa.dfe.service;

import java.util.List;

import com.qa.dfe.data.Marsupial;

public interface DFEService {

	public Marsupial getMarsupialByIndex(Integer id);

	public List<Marsupial> getAllMarsupials();

	public Marsupial createMarsupial(Marsupial marsupial);

	public Marsupial updateMarsupial(Marsupial marsupial, Integer id);

	public void deleteMarsupial(Integer id);
}
