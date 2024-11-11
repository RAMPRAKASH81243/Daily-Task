package com.ram.employeeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ram.employeeapi.dto.EmployeeRequest;
import com.ram.employeeapi.dto.EmployeeResponse;
import com.ram.employeeapi.model.Employee;
import com.ram.employeeapi.repository.EmployeeRepository;

@Service
public class EmployeeService{

	@Autowired
    private  EmployeeRepository repository;
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setAge(request.getAge());
        employee.setDob(request.getDob());
        employee.setMobileNumber(request.getMobileNumber());
        employee.setDepartment(request.getDepartment());
        employee.setEmail(request.getEmail());
        employee.setCreatedBy(request.getCreatedBy());
        employee.setLastModifiedBy(request.getLastModifiedBy());
        Employee savedEmployee = repository.save(employee);
        return mapToResponse(savedEmployee);
    }

    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) throws RuntimeException {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        // Check for uniqueness only if email or mobile number are changed
        if (!existingEmployee.getEmail().equals(request.getEmail()) &&
                repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }
        if (!existingEmployee.getMobileNumber().equals(request.getMobileNumber()) &&
                repository.existsByMobileNumber(request.getMobileNumber())) {
            throw new RuntimeException("Mobile number already exists.");
        }

        existingEmployee.setName(request.getName());
        existingEmployee.setAge(request.getAge());
        existingEmployee.setDob(request.getDob());
        existingEmployee.setMobileNumber(request.getMobileNumber());
        existingEmployee.setDepartment(request.getDepartment());
        existingEmployee.setEmail(request.getEmail());
        existingEmployee.setLastModifiedBy(request.getLastModifiedBy());
        Employee updatedEmployee = repository.save(existingEmployee);
        return mapToResponse(updatedEmployee);
    }
    
    public Page<EmployeeResponse> getAllEmployees(Pageable pageable) {
        return repository.findAll(pageable).map(this::mapToResponse);
    }
    
    public EmployeeResponse getEmployeeById(Long id) throws RuntimeException {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return mapToResponse(employee);
    }
    public void deleteEmployeeById(Long id) throws RuntimeException{
        if (!repository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        repository.deleteById(id);
    }
    public void deleteAllEmployees() {
        repository.deleteAll();
    }
    private EmployeeResponse mapToResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getDob(),
                employee.getMobileNumber(),
                employee.getDepartment(),
                employee.getEmail(),
                employee.getCreatedBy(),
                employee.getLastModifiedBy(),
                employee.getCreatedAt(),
                employee.getUpdatedAt()
        );
    }
}
