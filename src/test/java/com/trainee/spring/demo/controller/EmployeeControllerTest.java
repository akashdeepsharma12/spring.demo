package com.trainee.spring.demo.controller;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trainee.spring.demo.client.EmployeeClient;
import com.trainee.spring.demo.model.Address;
import com.trainee.spring.demo.model.Employee;
import com.trainee.spring.demo.model.EmployeeInfo;
import com.trainee.spring.demo.service.EmployeeService;
import com.trainee.spring.demo.service.EmployeeServiceTest;


@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
	@InjectMocks
	private EmployeeController controller;

	@Mock
	private EmployeeService service;
	
	@Mock
	private EmployeeClient client;
	
	private Employee employee;
	
	private Address address;

	@BeforeEach
	void setUp() {
		employee = new Employee();
		employee.setName("abc");
		employee.setId(1L);
		employee.setCity("zxc");
		address = new Address();
		address.setId(1L);
		address.setStreet("css");
		address.setZipcode("acs123");
		
	}

	@Test
	public void testAddEmployee() {
		
	when(service.saveEmployee(employee)).thenReturn(employee);
	Employee employeeTest = controller.addEmployee(employee); 
	assertNotNull(employeeTest);
	assertEquals("abc", employeeTest.getName());
	}
	
	@Test
	public void testFindById() {
		when(service.getEmployeeById(employee.getId())).thenReturn(employee);
		when(client.getAddress(address.getId())).thenReturn(address);
		EmployeeInfo employeeInfo = controller.findById(1L);
		assertNotNull(employeeInfo);
		assertEquals("css", employeeInfo.getStreet());
	}
	
}
