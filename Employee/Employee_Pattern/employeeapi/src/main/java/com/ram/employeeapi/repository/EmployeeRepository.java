package com.ram.employeeapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ram.employeeapi.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee>{

	
	@Query("SELECT e FROM Employee e ORDER BY e.id DESC")
	Optional<Employee> findLatestEmployeeId();
	
	
}
