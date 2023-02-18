package com.app.registration.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 3,message = "Employee name Must be in 3 characters")
	private String employeeName;
	@Email (message = "Email address is not valid!!")
	private String email;
	@NotEmpty
	@Size(min = 8,max = 10,message = "password must be name Must be in 8 characters")
	private String password;
	@NotEmpty
	private String about;
	@NotEmpty
	private String companyName;
	@NotEmpty
	private String experiance;

}
