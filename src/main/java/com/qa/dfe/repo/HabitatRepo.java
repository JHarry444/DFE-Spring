package com.qa.dfe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dfe.data.Habitat;

@Repository
public interface HabitatRepo extends JpaRepository<Habitat, Integer> {

}
