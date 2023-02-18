package com.app.registration.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.exceptions.*;
import com.app.registration.EmployeeRegisterAppApplication;
import com.app.registration.entities.Employee;
import com.app.registration.payloads.EmployeeDto;
import com.app.registration.repositories.EmployeeRepo;
import com.app.registration.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDTo) {
		
		
		Employee employee =	this.dtoToEmployee(employeeDTo); 
		
		Employee savedEmployee =this.employeeRepo.save(employee);
		return this.employeeToDto(savedEmployee);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer employeeId) {
		Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee"," id",employeeId));
		
		//employee.setId(employeeDto.getId());
		employee.setEmployeeName(employeeDto.getEmployeeName());
		employee.setCompanyName(employeeDto.getCompanyName());
		employee.setExperiance(employeeDto.getExperiance());
		employee.setAbout(employeeDto.getAbout());
		employee.setEmail(employeeDto.getEmail());
		employee.setPassword(employeeDto.getPassword());
		
		Employee updatedEmployee = this.employeeRepo.save(employee);
		EmployeeDto employeeToDto1 = this.employeeToDto(updatedEmployee);
		return employeeToDto1;
	}

	@Override
	public EmployeeDto getEmployeeById(Integer employeeId) {
		
		Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException ("Employee"," id",employeeId));
		
		return this.employeeToDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
	List<Employee> employee3 = this.employeeRepo.findAll();
	
	List<EmployeeDto> employeeDtos = employee3.stream().map(employee -> this.employeeToDto(employee)).collect(Collectors.toList());
		return employeeDtos;
		
	}

	@Override
	public void deleteUser(Integer employeeId) {

	Employee employee =	this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException ("Employee"," id",employeeId));
	
	this.employeeRepo.delete(employee);
	}
	
	private Employee dtoToEmployee(EmployeeDto employeeDTo) {
		
		Employee employee=new Employee();
		employee.setId(employeeDTo.getId());
		employee.setEmployeeName(employeeDTo.getEmployeeName());
		employee.setCompanyName(employeeDTo.getCompanyName());
		employee.setEmail(employeeDTo.getEmail());
		employee.setAbout(employeeDTo.getAbout());
		employee.setExperiance(employeeDTo.getExperiance());
		employee.setPassword(employeeDTo.getPassword());
		
		
		return employee;	
	}
	
	private EmployeeDto employeeToDto(Employee employee) {
		
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setId(employee.getId());
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setCompanyName(employee.getCompanyName());
		employeeDto.setEmail(employee.getEmail());
		employeeDto.setAbout(employee.getAbout());
		employeeDto.setExperiance(employee.getExperiance());
		employeeDto.setPassword(employee.getPassword());
		
		
		return employeeDto;}
	
	
	

}
