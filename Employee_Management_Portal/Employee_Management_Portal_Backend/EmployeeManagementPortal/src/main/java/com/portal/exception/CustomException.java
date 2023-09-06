package com.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.portal.DTO.ResponseDTO;

@RestControllerAdvice
public class CustomException{

	@ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseDTO handleResourceNotFoundException(ResourceNotFoundException exception) {
        String message=exception.getMessage();
        return new ResponseDTO(message);
    }

	
	  @ExceptionHandler(WrongCredentialsException.class)
	    @ResponseStatus(HttpStatus.UNAUTHORIZED)
	    public ResponseDTO handleWrongCredentialException(WrongCredentialsException exception) {
	        String message=exception.getMessage();
	        return new ResponseDTO(message);
	    }
	
	 @ExceptionHandler(ValidationException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ResponseDTO handleIllegalArgumentException(ValidationException exception) {
	        String message =exception.getMessage();
	        return new ResponseDTO(message);
	    }
	 
	 @ExceptionHandler(DuplicateEntryException.class)
	    @ResponseStatus(HttpStatus.CONFLICT)
	    public ResponseDTO handleResourceAlreadyExistsException(DuplicateEntryException exception) {
	        String message = exception.getMessage();
	        return new ResponseDTO(message);
	    }
}
