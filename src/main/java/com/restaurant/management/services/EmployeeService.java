package com.restaurant.management.services;

import java.util.List;

import com.restaurant.management.entities.Employee;

public interface EmployeeService {

	public boolean isEmployeeId(String employeeId);

	public void saveEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public boolean isEmployeeIdExists(String employeeId);

	public Employee getEmployeeByEmployeeId(String employeeId);

}