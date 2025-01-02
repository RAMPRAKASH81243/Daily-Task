package com.ram.employeeapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data

@Table(name = "employee")
public class Employee implements Cloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false)
	private LocalDate dob;

	@Column(length = 10, nullable = false)
	private String mobileNumber;
	
	@Column(nullable = false)
	private String department;

	@Column(unique=true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String createdBy;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column
	private String lastModifiedBy;

	@UpdateTimestamp
	@Column
	private LocalDateTime updatedAt;
	
	@Column
	private Status status;
	
	@Column(nullable = false)
	private String version;
	
	@Override
	public Employee clone() {
		try {
			return (Employee)super.clone();
		}
		catch (CloneNotSupportedException e) {
			throw new RuntimeException("Cloning not supported", e);
		}
	}
	
	@PrePersist
	private void setDefaultVersion() {
		if(version == null || version.isEmpty()) {
			version = "1.0.0";
		}	
	}
	
	public void incrementVersion(String operationType) {
		this.version = incrementVersionUpdate(this.version,operationType);
	}
	
	public String incrementVersionUpdate(String currentVersion, String operationType) {
		String[] parts = currentVersion.split("\\.");
		int major = Integer.parseInt(parts[0]);
		int minor = Integer.parseInt(parts[1]);
		int patch = Integer.parseInt(parts[2]);
		
		if("MODIFIED".equalsIgnoreCase(operationType)) {
			patch++;
		}else if("CLONED".equalsIgnoreCase(operationType)) {
			minor++;
			patch = 0;
		}
		return major + "." + minor + "." + patch;
	}
	 
} 
