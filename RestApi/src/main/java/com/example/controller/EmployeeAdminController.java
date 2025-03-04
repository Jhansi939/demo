package com.example.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Employee;
import com.example.service.Employeeservice;

import jakarta.servlet.http.HttpServletRequest;







@RestController
@RequestMapping("/admin")
public class EmployeeAdminController {
	private static final Logger logger=LogManager.getLogger(EmployeeAdminController.class);

	@Autowired
	private Employeeservice ser;
	
	@GetMapping("/gettoken")
	public CsrfToken csrftoken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");//cross site request forgery
	}
	


	@GetMapping("/getdata") // to get the data
	public List<Employee> getDetails() {
		logger.info("fecting the all details");

		return ser.getData();
	}
	
//	 //300000ms=5mins
//	@Scheduled(fixedRate=60000)// 1min
//	public List<Employee> schedulegetDetails() {
//        List<Employee> details=ser.getData();
//        System.out.println("retrived data:"+details);
//		return details;
//	}
	

	@PostMapping("/save") // save
	public Employee getSaveDetails(@RequestBody Employee e) {
	logger.info("saving the  employee details");
		return ser.saveData(e);

	}

	@PutMapping("/update") // update
	public Employee updateDetails(@RequestBody Employee e) {
		return ser.updateDetails(e);
	}

	@PatchMapping("/updatebyage/{id}/{age}")
	public Employee updatebyage(@PathVariable("id") Integer id, @PathVariable("age") Integer age) throws Exception {
		return ser.updatebyage(id, age);

	}

	@PatchMapping("/updatebyname/{id}/{name}")
	public Employee updatebyname(@PathVariable("id") Integer id, @PathVariable("name") String name) throws Exception {
		return ser.updatebyname(id, name);
	}
	@GetMapping("/getbyid/{id}")
	public Employee getbyid(@PathVariable("id")  Integer id)
	{
		   return ser.getbyId(id);
	}
	@GetMapping("/getbyname/{name}")
    public Employee getbyname(@PathVariable("name") String name) {
        return  ser.getName(name);
    }
	

	@DeleteMapping("/delete/{id}")
	public void deletedetails(@PathVariable("id") Integer id) {
		ser.deleteid(id);
	}
	@DeleteMapping("/deleteall")
	public void deleteall() {
		ser.deleteAll();
	}
	
	
}
