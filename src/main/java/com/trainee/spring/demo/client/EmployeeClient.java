package com.trainee.spring.demo.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trainee.spring.demo.model.Address;
import com.trainee.spring.demo.model.Employee;
import com.trainee.spring.demo.repository.EmployeeRepository;

@FeignClient(name = "spring.demo.address", url = "http://localhost:8081/springboot-demo/onboard/api/addressproject")
public interface EmployeeClient {
	@GetMapping("/getAddress/{id}")
	Address getAddress(@PathVariable("id")long id);
	
}
