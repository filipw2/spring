package com.itemtracker.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KopalniaRepository extends JpaRepository<Kopalnia, Long>{

	@Query("select k from Kopalnia k where k.name=?1")
	Kopalnia getKopalnia(String name);
}
