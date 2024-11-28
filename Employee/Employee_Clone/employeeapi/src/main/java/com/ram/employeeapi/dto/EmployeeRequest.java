package com.ram.employeeapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

import com.ram.employeeapi.model.Status;

@Data
public class EmployeeRequest {

	@NotBlank(message = "Name is mandatory")
	@Size(min = 2, message = "Name must have at least 2 characters")
    private String name;
 
    @Min(value = 18, message = "Age must be 18 or above")
    private int age;
 
    @NotNull(message = "Date of birth is mandatory")
    private LocalDate dob;
 
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;
 
    @NotBlank(message = "Department is required")
    private String department;
 
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;
 
    private Status status;
}

