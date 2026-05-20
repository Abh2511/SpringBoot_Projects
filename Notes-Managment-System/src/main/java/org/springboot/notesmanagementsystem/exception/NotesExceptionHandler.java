package org.springboot.notesmanagementsystem.exception;

import org.springboot.notesmanagementsystem.entity.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotesExceptionHandler 
{
	@ExceptionHandler(NotesNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handle1NNFE( NotesNotFoundException exception)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(exception.getMessage());   
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NO_CONTENT);
		
	}
	 
}
