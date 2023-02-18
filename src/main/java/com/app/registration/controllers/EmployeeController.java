package com.app.registration.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.payloads.ApiResponse;
import com.app.registration.payloads.EmployeeDto;
import com.app.registration.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService  employeeService;
	
	// POST-  create Employee
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
	
	EmployeeDto createEmployeeDto = this.employeeService.createEmployee(employeeDto);
	
	return  new ResponseEntity<>(createEmployeeDto, HttpStatus.CREATED);
	}
	
	// PUT-  update Employee
	@PutMapping("/{userId}")
	public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto,@PathVariable ("userId") Integer uid )
	{
		EmployeeDto updatedEmployee = this.employeeService.updateEmployee(employeeDto, uid);
		return ResponseEntity.ok(updatedEmployee);
	}
	// DELETE-  delete Employee

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable("userId") Integer uid){
		
		this.employeeService.deleteUser(uid);
		return new ResponseEntity(new ApiResponse("Employee Deleted Successfully", true), HttpStatus.OK);
		
	// GET-  get Employee
}
	@GetMapping("/")
	public ResponseEntity <List<EmployeeDto>> getAllEmployees(){
		return ResponseEntity.ok(this.employeeService.getAllEmployees());
		
	}
	@GetMapping("/{userId}")
	public ResponseEntity <EmployeeDto> getSingleEmployees(@PathVariable Integer userId){
		return ResponseEntity.ok(this.employeeService.getEmployeeById(userId));
		
	}

}