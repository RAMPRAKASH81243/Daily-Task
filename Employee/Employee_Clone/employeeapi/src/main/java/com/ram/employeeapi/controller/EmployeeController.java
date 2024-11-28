package com.ram.employeeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ram.employeeapi.dto.CloneEmployeeRequest;
import com.ram.employeeapi.dto.EmployeeRequest;
import com.ram.employeeapi.dto.EmployeeResponse;
import com.ram.employeeapi.model.Status;
import com.ram.employeeapi.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
@Valid
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest request,
			@RequestParam("User") String createdBy) {
		EmployeeResponse response = employeeService.createEmployee(request, createdBy);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// Update Employee
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long id,
			@Valid @RequestBody EmployeeRequest request, @RequestParam("User") String lastModifiedBy) {
		EmployeeResponse response = employeeService.updateEmployee(id, request, lastModifiedBy);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// Get All Employees

	@GetMapping("/all")
	public Page<EmployeeResponse> getAllEmployees(

			@RequestParam(required = false) String name, @RequestParam(required = false) String department,
			@RequestParam(required = false) String email, @RequestParam(required = false) Integer age,
			@RequestBody(required = false) Status status, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "updatedAt") String sortBy,
			@RequestParam(defaultValue = "desc") String sortDirection) {

		return employeeService.getAllEmployees(name, department, age, email, status, page, size, sortBy, sortDirection);
	}

	// Get Employee by ID
	@GetMapping("/{id}")
	public EmployeeResponse getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	// Delete Employee by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
		String message = employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// Delete All Employees
	@DeleteMapping
	public ResponseEntity<String> deleteAllEmployees() {
		String message = employeeService.deleteAllEmployees();
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// Clone Employee by ID
	@PostMapping("/clone")
	public ResponseEntity<EmployeeResponse> cloneEmployee(@Valid @RequestBody CloneEmployeeRequest request,
			@RequestParam("User") String clonedBy) {
		EmployeeResponse response = employeeService.cloneEmployee(request.getId(), request.getEmail(), clonedBy);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
