package com.itemtracker.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CenaRepository extends JpaRepository<Cena, Long>{

	
	@Query("select distinct c from Cena c where c.dane_id=?1 order by c.data desc")
	Cena getLatestCena(int dane_id);
	
	@Query("select c from Cena c where c.data in ( select max(b.data) from Cena b)")
	List<Cena> getLatestCenas();
}
