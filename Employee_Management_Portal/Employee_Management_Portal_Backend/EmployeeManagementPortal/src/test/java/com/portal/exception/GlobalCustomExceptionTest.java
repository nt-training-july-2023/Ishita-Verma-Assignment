package com.portal.exception;

import com.portal.DTO.ResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

public class GlobalCustomExceptionTest {

    @Test
    public void testHandleResourceNotFoundException() {
        // Create a ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");

        // Create the GlobalCustomException instance
        GlobalCustomException globalCustomException = new GlobalCustomException();

        // Call the handleResourceNotFoundException method
        ResponseDTO responseDTO = globalCustomException.handleResourceNotFoundException(exception);

        // Check that the response message and HTTP status code are as expected
        assertEquals("Resource not found", responseDTO.getMessage());
        
    }

    @Test
    public void testHandleWrongCredentialException() {
        // Create a WrongCredentialsException
        WrongCredentialsException exception = new WrongCredentialsException("Invalid credentials");

        // Create the GlobalCustomException instance
        GlobalCustomException globalCustomException = new GlobalCustomException();

        // Call the handleWrongCredentialException method
        ResponseDTO responseDTO = globalCustomException.handleWrongCredentialException(exception);

        // Check that the response message and HTTP status code are as expected
        assertNotEquals("Invalid credentials", responseDTO.getMessage());
   
    }

    @Test
    public void testHandleIllegalArgumentException() {
        // Create a ValidationException
        ValidationException exception = new ValidationException("Validation failed");

        // Create the GlobalCustomException instance
        GlobalCustomException globalCustomException = new GlobalCustomException();

        // Call the handleIllegalArgumentException method
        ResponseDTO responseDTO = globalCustomException.handleIllegalArgumentException(exception);

        // Check that the response message and HTTP status code are as expected
        assertEquals("Validation failed", responseDTO.getMessage());
       
    }

    @Test
    public void testHandleResourceAlreadyExistsException() {
        // Create a DuplicateEntryException
        DuplicateEntryException exception = new DuplicateEntryException("Resource already exists");

        // Create the GlobalCustomException instance
        GlobalCustomException globalCustomException = new GlobalCustomException();

        // Call the handleResourceAlreadyExistsException method
        ResponseDTO responseDTO = globalCustomException.handleResourceAlreadyExistsException(exception);

        // Check that the response message and HTTP status code are as expected
        assertEquals("Resource already exists", responseDTO.getMessage());
       
    }
}