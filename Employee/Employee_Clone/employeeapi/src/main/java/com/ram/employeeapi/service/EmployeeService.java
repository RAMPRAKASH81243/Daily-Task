package com.ram.employeeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ram.employeeapi.dto.EmployeeRequest;
import com.ram.employeeapi.dto.EmployeeResponse;
import com.ram.employeeapi.mapper.EmployeeMapper;
import com.ram.employeeapi.model.Employee;
import com.ram.employeeapi.model.Status;
import com.ram.employeeapi.repository.EmployeeRepository;
import com.ram.employeeapi.specification.EmployeeSpecification;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	private Employee employee;
	public EmployeeResponse createEmployee(EmployeeRequest request, String createdBy) throws RuntimeException{

		
			Employee employee = EmployeeMapper.toEntity(request, createdBy);
			return EmployeeMapper.toResponse(repository.save(employee));
		
	}
		

	public EmployeeResponse updateEmployee(Long id, EmployeeRequest request, String lastModifiedBy)
			throws RuntimeException {
		Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		// Check for uniqueness only if email or mobile number are changed
		if (!employee.getEmail().equals(request.getEmail()) && repository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email already exists.");
		}
		if (!employee.getMobileNumber().equals(request.getMobileNumber())
				&& repository.existsByMobileNumber(request.getMobileNumber())) {
			throw new RuntimeException("Mobile number already exists.");
		}

		employee = EmployeeMapper.toEntity(employee, request, lastModifiedBy);
		return EmployeeMapper.toResponse(repository.save(employee));
	}

	public EmployeeResponse getEmployeeById(Long id) throws RuntimeException {
		Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee id not found" + id));
		return EmployeeMapper.toResponse(employee);
	}

	public String deleteEmployeeById(Long id) throws RuntimeException {
		employee = repository.findById(id).orElseThrow(()-> new RuntimeException("Employee id not found" + id));
		repository.deleteById(id);
		return " Employee with Id "+ id +"has been successfully deleted.";
	}

	public String deleteAllEmployees() {
		repository.deleteAll();
		return "All Employee Data is Deleted";
	}

	public Page<EmployeeResponse> getAllEmployees(String name, String department, Integer age, String email, Status status, int page,
			int size, String sortBy, String sortDirection) {
		//sortBy = (sortBy == null || sortBy.isEmpty()) ? "id" : sortBy;
		Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		Pageable pageable = PageRequest.of(page, size, sort);
		Specification<Employee> spec = Specification.where(EmployeeSpecification.hasName(name))
				.and(EmployeeSpecification.hasDepartment(department)).and(EmployeeSpecification.hasAge(age))
				.and(EmployeeSpecification.hasEmail(email))
				.and(EmployeeSpecification.hasStatus(status));
		return repository.findAll(spec, pageable).map(EmployeeMapper::toResponse);
	}

	public EmployeeResponse cloneEmployee(Long id, String email, String clonedBy) {
		Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

		if (!employee.getEmail().equals(email) && repository.existsByEmail(email)) {
			throw new RuntimeException("Email already exists.");
		}

		Employee cloned = EmployeeMapper.toCloneEntity(employee, email, clonedBy);
		return EmployeeMapper.toResponse(repository.save(cloned));
	}
	
}
