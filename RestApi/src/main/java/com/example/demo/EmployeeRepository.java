package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@SuppressWarnings("unused")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> { //for customizing methods
	Optional<Employee> findByEmpName(String empName);
}
