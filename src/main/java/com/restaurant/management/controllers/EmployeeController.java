package com.restaurant.management.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.management.dto.EmployeeDto;
import com.restaurant.management.entities.Employee;
import com.restaurant.management.mapper.Mapper;
import com.restaurant.management.services.EmployeeService;
import com.restaurant.management.util.Constants;
import com.restaurant.management.util.EndPointURI;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private Mapper mapper;

	@PostMapping(value = EndPointURI.EMPLOYEE)
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		if (employeeService.isEmployeeId(employeeDto.getEmployeeId())) {
			return new ResponseEntity<>(Constants.EMPLOYEE, HttpStatus.BAD_REQUEST);
		}
		employeeService.saveEmployee(mapper.map(employeeDto, Employee.class));
		return new ResponseEntity<>(Constants.ADD_EMPLOYEE_SUCCESS, HttpStatus.OK);
	}

}
