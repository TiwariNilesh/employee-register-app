package com.app.registration.services;

import java.util.List;

import com.app.registration.entities.Employee;
import com.app.registration.payloads.EmployeeDto;

public interface EmployeeService {
	
	
	EmployeeDto createEmployee(EmployeeDto employee);
	
	EmployeeDto updateEmployee(EmployeeDto employee,Integer employeeId);
	EmployeeDto getEmployeeById(Integer employeeId);
	List<EmployeeDto> getAllEmployees();
	void deleteUser(Integer employeeId);

}
