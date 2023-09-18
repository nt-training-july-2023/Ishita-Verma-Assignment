package com.portal.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.portal.DTO.ResponseDTO;

class GlobalCustomExceptionTest {

	@Test
    void testHandleResourceNotFoundException() {
        GlobalCustomException exceptionHandler = new GlobalCustomException();
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        ResponseDTO response = exceptionHandler.handleResourceNotFoundException(exception);
        assertEquals("Resource not found", response.getMessage());
        assertEquals(" ", response.getRole());
    }

    @Test
    void testHandleWrongCredentialException() {
        GlobalCustomException exceptionHandler = new GlobalCustomException();
        WrongCredentialsException exception = new WrongCredentialsException("Wrong credentials");
        ResponseDTO response = exceptionHandler.handleWrongCredentialException(exception);
        assertEquals("Wrong credentials", response.getMessage());
        assertEquals("", response.getRole());
    }

    @Test
    void testHandleIllegalArgumentException() {
        GlobalCustomException exceptionHandler = new GlobalCustomException();
        ValidationException exception = new ValidationException("Invalid argument");
        ResponseDTO response = exceptionHandler.handleIllegalArgumentException(exception);
        assertEquals("Invalid argument", response.getMessage());
        assertEquals("", response.getRole());
    }

    @Test
    void testHandleResourceAlreadyExistsException() {
        GlobalCustomException exceptionHandler = new GlobalCustomException();
        DuplicateEntryException exception = new DuplicateEntryException("Resource already exists");
        ResponseDTO response = exceptionHandler.handleResourceAlreadyExistsException(exception);
        assertEquals("Resource already exists", response.getMessage());
        assertEquals("", response.getRole());
    }

}
