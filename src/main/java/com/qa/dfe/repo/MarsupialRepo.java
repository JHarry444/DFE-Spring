package com.qa.dfe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dfe.data.Marsupial;

@Repository
public interface MarsupialRepo extends JpaRepository<Marsupial, Integer> {

	List<Marsupial> findByName(String name);
	// auto-generates a query based on method name
	// SELECT * FROM marsupial WHERE name = ?;
}
