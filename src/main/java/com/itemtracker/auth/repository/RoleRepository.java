package com.itemtracker.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itemtracker.auth.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

	@Query("select r from Role r where r.name=?1")
	Role findByName(String name);
}
