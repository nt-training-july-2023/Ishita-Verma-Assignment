package com.portal.exception;

import com.portal.exception.*;
import com.portal.DTO.ResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

public class CustomExceptionTest {

    @Test
    public void testHandleResourceNotFoundException() {
        // Create a ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");

        // Create the CustomException instance
        CustomException customException = new CustomException();

        // Call the handleResourceNotFoundException method
        ResponseDTO responseDTO = customException.handleResourceNotFoundException(exception);

        // Check that the response message and HTTP status code are as expected
        assertEquals("Resource not found", responseDTO.getMessage());
        
    }

    @Test
    public void testHandleWrongCredentialException() {
        // Create a WrongCredentialsException
        WrongCredentialsException exception = new WrongCredentialsException("Invalid credentials");

        // Create the CustomException instance
        CustomException customException = new CustomException();

        // Call the handleWrongCredentialException method
        ResponseDTO responseDTO = customException.handleWrongCredentialException(exception);

        // Check that the response message and HTTP status code are as expected
        assertNotEquals("Invalid credentials", responseDTO.getMessage());
   
    }

    @Test
    public void testHandleIllegalArgumentException() {
        // Create a ValidationException
        ValidationException exception = new ValidationException("Validation failed");

        // Create the CustomException instance
        CustomException customException = new CustomException();

        // Call the handleIllegalArgumentException method
        ResponseDTO responseDTO = customException.handleIllegalArgumentException(exception);

        // Check that the response message and HTTP status code are as expected
        assertEquals("Validation failed", responseDTO.getMessage());
       
    }

    @Test
    public void testHandleResourceAlreadyExistsException() {
        // Create a DuplicateEntryException
        DuplicateEntryException exception = new DuplicateEntryException("Resource already exists");

        // Create the CustomException instance
        CustomException customException = new CustomException();

        // Call the handleResourceAlreadyExistsException method
        ResponseDTO responseDTO = customException.handleResourceAlreadyExistsException(exception);

        // Check that the response message and HTTP status code are as expected
        assertEquals("Resource already exists", responseDTO.getMessage());
       
    }
}