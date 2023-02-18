package com.app.registration.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employees")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int id;
	
	@Column(name = "employee_name",nullable = false,length = 15)
	
	private String employeeName;
	private String email;
	private String password;
	private String about;
	private String companyName;
	private String experiance;
	

}
