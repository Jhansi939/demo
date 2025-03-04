package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Employee;
import com.example.demo.EmployeeRepository;
import com.example.demo.IdNotFoundException;

@Service
public class Employeeservice {
	@Autowired
	private EmployeeRepository empres;

	public Employee saveData(Employee e)// save //insert
	{
		Employee e1 = empres.save(e);
		return e1;

	}

	public List<Employee> getData() { // fecting all

		List<Employee> l = empres.findAll();
		return l;

	}

	public Employee getbyId(Integer id) {// fetch by id
		Employee e = empres.findById(id).get();
		return e;

	}

	public Employee updatebyage(Integer id, Integer age) throws Exception {// fetch by id
		Optional<Employee> e = empres.findById(id);
		if (e.isPresent()) {
			Employee e1 = e.get();
			e1.setEmpAge(age);
			return empres.save(e1);
		} else {
			throw new IdNotFoundException();
		}
	}

	public Employee updatebyname(Integer id, String name) throws Exception {// fetch by id
		Optional<Employee> e = empres.findById(id);
		if (e.isPresent()) {
			Employee e1 = e.get();
			e1.setEmpName(name);
			return empres.save(e1);
		} else {
			throw new IdNotFoundException();
		}

	}

	public void deleteid(Integer id) {
		empres.deleteById(id);
	}

	public void deleteAll() {
		empres.deleteAll();
	}

	public Employee updateDetails(Employee e) {
		Employee e1 = empres.save(e);
		return e1;

	}
	public Employee getName(String name)
	{
		
		return empres.findByEmpName(name).get();
		
	}

}
