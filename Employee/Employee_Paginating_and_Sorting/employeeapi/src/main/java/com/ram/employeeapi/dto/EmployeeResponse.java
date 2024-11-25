package com.ram.employeeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EmployeeResponse {

	private Long id;
    private String name;
    private int age;
    private LocalDate dob;
    private String mobileNumber;
    private String department;
    private String email;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastModifiedBy;
    private LocalDateTime updatedAt;

}
