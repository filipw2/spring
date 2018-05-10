package com.itemtracker.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface SortymentRepository extends JpaRepository<Sortyment, Long>{

	
	@Query("select k from Sortyment k where k.name=?1")
	Sortyment getSortyment(String name);
}
