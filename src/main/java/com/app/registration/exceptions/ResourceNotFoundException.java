package com.app.registration.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldName;
	long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Integer employeeId) {
		super(String.format("%s not found with this %s : %l", resourceName,fieldName,employeeId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = employeeId;
	}

}
