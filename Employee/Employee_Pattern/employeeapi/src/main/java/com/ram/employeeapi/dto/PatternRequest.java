package com.ram.employeeapi.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatternRequest {

	@Size(max = 17, message = "input must have at least 17 characters")
	String input;
	
	String pattern;
}
