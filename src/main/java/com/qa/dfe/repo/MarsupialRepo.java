package com.qa.dfe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dfe.data.Marsupial;

@Repository
public interface MarsupialRepo extends JpaRepository<Marsupial, Integer> {

}
