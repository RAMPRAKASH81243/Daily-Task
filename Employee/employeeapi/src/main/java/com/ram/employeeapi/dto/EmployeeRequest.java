package com.ram.employeeapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EmployeeRequest {

	@NotBlank(message = "Name is mandatory")
    private String name;
 
    @Min(value = 18, message = "Age must be 18 or above")
    private int age;
 
    @NotNull(message = "Date of birth is mandatory")
    private LocalDate dob;
 
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;
 
    private String department;
 
    @Email(message = "Email should be valid")
    private String email;
 
    @NotBlank(message = "Created by is required")
    private String createdBy;
 
    private String lastModifiedBy;

}
