package org.springboot.attendance.exception;

import org.springboot.attendance.entity.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AttendanceExceptionHandler {
	
	@ExceptionHandler(AttendanceNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleANFE(AttendanceNotFoundException attendanceNotFoundException)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		
		 structure.setMessage(attendanceNotFoundException.getMessage());
		  
		 structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 
		 structure.setData(null);
		 
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		 
	}
}
