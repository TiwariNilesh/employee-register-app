package com.app.registration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
