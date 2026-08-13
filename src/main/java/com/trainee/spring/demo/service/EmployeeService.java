package com.trainee.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.spring.demo.model.Employee;
import com.trainee.spring.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);

	}

	public List<Employee> getAllEmployee() {
		return repository.findAll();

	}

	public Employee getEmployeeById(long id) {
		return repository.findById(id).orElse(null);
	}

	public Employee updateEmployee(long id, Employee employee) {
		Employee existingEmployee = repository.findById(id).orElse(null);
		existingEmployee.setName(employee.getName());
		existingEmployee.setCity(employee.getCity());
		return repository.save(existingEmployee);

	}

	public String deleteById(long id) {
		repository.deleteById(id);
		return "Deleted Success";

	}
}
