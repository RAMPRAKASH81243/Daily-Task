package com.ram.employeeapi.mapper;

import com.ram.employeeapi.dto.EmployeeRequest;
import com.ram.employeeapi.dto.EmployeeResponse;
import com.ram.employeeapi.model.Employee;

public class EmployeeMapper {

	public static Employee toEntity(EmployeeRequest request, String createdBy) {
		Employee employee = new Employee();
		
        employee.setName(request.getName());
        employee.setAge(request.getAge());
        employee.setDob(request.getDob());
        employee.setMobileNumber(request.getMobileNumber());
        employee.setDepartment(request.getDepartment());
        employee.setEmail(request.getEmail());
        employee.setCreatedBy(createdBy);
        
		return employee;
	}
	
	public static Employee toEntity(Employee existing, EmployeeRequest request, String lastModifiedBy) {
		
		existing.setName(request.getName());
        existing.setAge(request.getAge());
        existing.setDob(request.getDob());
        existing.setMobileNumber(request.getMobileNumber());
        existing.setDepartment(request.getDepartment());
        existing.setEmail(request.getEmail());
        existing.setLastModifiedBy(lastModifiedBy);
        
        return existing;
	}
	
	public static EmployeeResponse toResponse(Employee employee) {
		EmployeeResponse response = new EmployeeResponse(null, null, 0, null, null, null, null, null, null, null, null);
		
		response.setId(employee.getId());
		response.setName(employee.getName());
		response.setAge(employee.getAge());
		response.setDob(employee.getDob());
        response.setMobileNumber(employee.getMobileNumber());
        response.setDepartment(employee.getDepartment());
        response.setEmail(employee.getEmail());
        response.setCreatedBy(employee.getCreatedBy());
        response.setCreatedAt(employee.getCreatedAt());
        response.setLastModifiedBy(employee.getLastModifiedBy());
        response.setUpdatedAt(employee.getUpdatedAt());
        
        return response;
	}
}
