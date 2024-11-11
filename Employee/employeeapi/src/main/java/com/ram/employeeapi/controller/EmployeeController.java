package com.ram.employeeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ram.employeeapi.dto.EmployeeRequest;
import com.ram.employeeapi.dto.EmployeeResponse;
import com.ram.employeeapi.service.EmployeeService;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/api/employees")
@Valid
public class EmployeeController {

	@Autowired
    private  EmployeeService employeeService;
	@PostMapping("/add")
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest request) {
        EmployeeResponse response = employeeService.createEmployee(request);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequest request) {
        EmployeeResponse response = employeeService.updateEmployee(id, request);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
 // Get All Employees
    @GetMapping("/all")
    public Page<EmployeeResponse> getAllEmployees(
    		@RequestParam(defaultValue = "0")int page,
    		@RequestParam(defaultValue = "10")int size,
    		@RequestParam(defaultValue = "id")String sortBy) {
		return employeeService.getAllEmployees(PageRequest.of(page, size));
    }
    // Get Employee by ID
    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
    // Delete Employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
    // Delete All Employees
    @DeleteMapping
    public ResponseEntity<Void> deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return ResponseEntity.noContent().build();
    }
	
}
