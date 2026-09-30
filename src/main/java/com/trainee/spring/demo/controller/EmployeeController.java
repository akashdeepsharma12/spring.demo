package com.trainee.spring.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.spring.demo.client.EmployeeClient;
import com.trainee.spring.demo.model.Address;
import com.trainee.spring.demo.model.Employee;
import com.trainee.spring.demo.model.EmployeeInfo;
import com.trainee.spring.demo.service.EmployeeService;


@RestController
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeClient client;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee addEmployee) {
		return service.saveEmployee(addEmployee);

	}

	@GetMapping("/findAllEmployee")
	public List<Employee> getEmployee() {
		return service.getAllEmployee();

	}

	@GetMapping("/findById/{id}")
	public EmployeeInfo findById(@PathVariable long id) {
		try {
			logger.debug("getEmployee{}", id);

			Employee employee = service.getEmployeeById(id);
			Address address = client.getAddress(id);
			EmployeeInfo employeeinfo = new EmployeeInfo();
			employeeinfo.setId(employee.getId());
			employeeinfo.setName(employee.getName());
			employeeinfo.setCity(employee.getCity());
			employeeinfo.setStreet(address.getStreet());
			employeeinfo.setZipcode(address.getZipcode());
			return employeeinfo;
		} catch (Exception exception) {
			logger.error("Exception Happened{}", exception.getMessage());

		}
		return null;

	}

	@PutMapping("/updateById/{id}")
	public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);

	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable long id) {
		return service.deleteById(id);

	}

}
