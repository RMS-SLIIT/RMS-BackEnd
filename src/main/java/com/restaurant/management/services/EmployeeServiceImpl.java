package com.restaurant.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.management.entities.Employee;
import com.restaurant.management.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public boolean isEmployeeId(String employeeId) {
		return employeeRepository.existsByEmployeeId(employeeId);
	}

	@Transactional
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Transactional
	public boolean isEmployeeIdExists(String id) {
		return employeeRepository.existsByEmployeeId(id);
	}

	@Transactional(readOnly = true)
	public Employee getEmployeeByEmployeeId(String employeeId) {
		return employeeRepository.findAllByEmployeeId(employeeId);
	}

}