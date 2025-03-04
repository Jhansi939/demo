package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Employee;
import com.example.service.Employeeservice;

import jakarta.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/user")
public class EmployeeUserController {
	@Autowired
	private Employeeservice ser;
	@Autowired
	private EmployeeAdminController emp;
	
	@GetMapping("/gettokens")
	public CsrfToken csrftoken(HttpServletRequest request) {
		return emp.csrftoken(request);//cross site request forgery
	}
	  
	
	@GetMapping("/getdata") 
	public List<Employee> getDetails() {
//		logger.info("fecting the all details");

		return ser.getData();
	}
	@PostMapping("/save") // save
	public Employee getSaveDetails(@RequestBody Employee e) {
//	logger.info("saving the  employee details");
		return ser.saveData(e);

	}

}
