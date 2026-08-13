package com.trainee.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.spring.demo.model.Employee;
import com.trainee.spring.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee addEmployee) {
		return service.saveEmployee(addEmployee);

	}

	@GetMapping("/findAllEmployee")
	public List<Employee> getEmployee() {
		return service.getAllEmployee();
		
	}
	
	@GetMapping("/findById/{id}")
	public Employee findById(@PathVariable long id) {
		return service.getEmployeeById(id);
	}
	@PutMapping("/updateById/{id}")
	public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee){
		return service.updateEmployee(id, employee);
		
		
	}
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable long id) {
		return service.deleteById(id);
		
	}
	
	
	
}
