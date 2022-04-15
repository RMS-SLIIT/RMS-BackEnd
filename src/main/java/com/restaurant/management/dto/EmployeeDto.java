package com.restaurant.management.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	private Long id;
	private String employeeId;
	private Date dateOfBirth;
	private String email;
	private Long mobileNumber;
	private String address;
	private String jobPost;
}
