package com.ultimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ultimate.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
 
	public boolean existsByFirstnameAndLastname(String firstname,String lastname);
	
	public boolean existsById(int id);
}
