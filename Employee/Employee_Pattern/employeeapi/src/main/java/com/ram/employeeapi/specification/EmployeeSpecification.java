package com.ram.employeeapi.specification;

import org.springframework.data.jpa.domain.Specification;

import com.ram.employeeapi.model.Employee;
import com.ram.employeeapi.model.Status;

public class EmployeeSpecification {

	public static Specification<Employee> hasName(String name){
		return (root, query, CriteriaBuilder)-> name == null ? null :
			CriteriaBuilder.like(CriteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
	}

	public static Specification<Employee> hasDepartment(String department){
		return (root, query, CriteriaBuilder)-> department == null ? null :
			CriteriaBuilder.like(CriteriaBuilder.lower(root.get("department")), "%" + department.toLowerCase() + "%");
	}

	public static Specification<Employee> hasAge(Integer age){
		return (root, query, CriteriaBuilder)-> age == null ? null :
			CriteriaBuilder.equal(root.get("age"),age);
	}

	public static Specification<Employee> hasEmail(String email){
		return (root, query, CriteriaBuilder)-> email == null ? null :
			CriteriaBuilder.like(CriteriaBuilder.lower(root.get("email")), "%" + email.toLowerCase() + "%");
	}

	public static Specification<Employee> hasStatus(Status status){
		return (root, query, CriteriaBuilder)-> status == null ? null :
			CriteriaBuilder.equal(root.get("status"),status);
	}
}
