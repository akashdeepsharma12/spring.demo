package com.trainee.spring.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.spring.demo.model.Employee;
import com.trainee.spring.demo.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService employeeServiceTest;

	@Mock
	private EmployeeRepository employeeRepositoryTest;

	private Employee employee;

	@BeforeEach
	void SetUp() {
		employee = new Employee();
		employee.setName("abc");
		employee.setId(1L);
		employee.setCity("zxc");

	}
	
	@Test
	public void testSaveEmployee() {
		
		when(employeeRepositoryTest.save(employee)).thenReturn(employee);
		Employee employeeTest = employeeServiceTest.saveEmployee(employee);
		assertNotNull(employeeTest);
		assertEquals("abc",employeeTest.getName());
		
	}
	
	@Test
	public void testFindById() {
		
		when(employeeRepositoryTest.findById(employee.getId())).thenReturn(Optional.of(employee));
		Employee employeeTest = employeeServiceTest.getEmployeeById(employee.getId());
		assertNotNull(employeeTest);
		assertEquals(1L, employeeTest.getId());
		
		
		
	}

}
