package com.itemtracker.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KopalniaRepository extends JpaRepository<Kopalnia, Long>{

}
