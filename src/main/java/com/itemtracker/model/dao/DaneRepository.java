package com.itemtracker.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DaneRepository extends JpaRepository<Dane, Long>{

}
