package com.ram.employeeapi.mapper;

import com.ram.employeeapi.dto.EmployeeRequest;
import com.ram.employeeapi.dto.EmployeeResponse;
import com.ram.employeeapi.model.Employee;
import com.ram.employeeapi.model.Status;

public class EmployeeMapper {

	public static Employee toEntity(EmployeeRequest request, String createdBy) {
		Employee employee = new Employee();
		employee.setName(request.getName());
		employee.setAge(request.getAge());
		employee.setDob(request.getDob());
		employee.setMobileNumber(request.getMobileNumber());
		employee.setDepartment(request.getDepartment());
		employee.setEmail(request.getEmail());
		employee.setStatus(Status.CREATE);
		employee.setCreatedBy(createdBy);
		employee.setLastModifiedBy(createdBy);
		employee.setUpdatedAt(null);
		
		return employee;
	}

	public static Employee toEntity(Employee existing, EmployeeRequest request, String lastModifiedBy) {

		existing.setName(request.getName());
		existing.setAge(request.getAge());
		existing.setDob(request.getDob());
		existing.setMobileNumber(request.getMobileNumber());
		existing.setDepartment(request.getDepartment());
		existing.setEmail(request.getEmail());
		existing.setStatus(Status.MODIFIED);
		existing.setLastModifiedBy(lastModifiedBy);
		existing.incrementVersion("MODIFIED");
		return existing;
	}

	public static Employee toCloneEntity(Employee employee,long newid, String email,String clonedBy) {
		Employee cloned = employee.clone();
		cloned.setId(newid);
		cloned.setEmail(email);
		cloned.setCreatedBy(clonedBy);
		cloned.setLastModifiedBy(clonedBy);
		cloned.incrementVersion("CLONED");
		return cloned;
	}

	public static EmployeeResponse toResponse(Employee employee) {
		EmployeeResponse response = new EmployeeResponse(null, null, 0, null, null, null, null, null, null, null, null, null, null);

		response.setId(employee.getId());
		response.setName(employee.getName());
		response.setAge(employee.getAge());
		response.setDob(employee.getDob());
		response.setMobileNumber(employee.getMobileNumber());;
		response.setDepartment(employee.getDepartment());
		response.setEmail(employee.getEmail());
		response.setCreatedBy(employee.getCreatedBy());
		response.setCreatedAt(employee.getCreatedAt());
		response.setLastModifiedBy(employee.getLastModifiedBy());
		response.setUpdatedAt(employee.getUpdatedAt());
		response.setStatus(employee.getStatus());
		response.setVersion(employee.getVersion());

		return response;
	}
}
