package me.velfinvelasquez.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.velfinvelasquez.exceptions.ResourceNotFoundException;
import me.velfinvelasquez.models.Employee;
import me.velfinvelasquez.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = { "http://localhost:4200/" })
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping()
	public List<Employee> listAllEmployees() {
		return employeeRepository.findAll();
	}

	@PostMapping()
	public Employee create(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getOneById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empleado no existe!"));
		return ResponseEntity.ok(employee);

	}
	

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateOneById(@PathVariable Long id, @RequestBody Employee employeeRequest) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empleado no existe!"));

		employee.setName(employeeRequest.getName());
		employee.setLastname(employeeRequest.getLastname());
		employee.setEmail(employeeRequest.getEmail());

		Employee employeeUpdated = employeeRepository.save(employee);

		return ResponseEntity.ok(employeeUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteOneById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empleado no existe!"));
		employeeRepository.deleteById(id);
		return ResponseEntity.ok(employee);

	}
}
