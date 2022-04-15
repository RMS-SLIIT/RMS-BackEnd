package com.restaurant.management.services;

import com.restaurant.management.entities.Employee;

public interface EmployeeService {

	public boolean isEmployeeId(String employeeId);

	public void saveEmployee(Employee employee);

}