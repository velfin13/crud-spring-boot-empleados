package me.velfinvelasquez.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.velfinvelasquez.models.Employee;
import me.velfinvelasquez.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = {"http://localhost:4200/"})
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping()
	public List<Employee> listAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@PostMapping()
	public Employee create(@RequestBody Employee employee){
		return employeeRepository.save(employee);
	}
}
