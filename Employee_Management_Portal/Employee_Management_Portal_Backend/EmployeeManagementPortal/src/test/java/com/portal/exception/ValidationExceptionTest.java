package com.portal.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationExceptionTest {

	@Test
    public void testValidationExceptionConstructor() {
        // Create a ValidationException with a custom message
        ValidationException exception = new ValidationException("Validation failed");

        // Check that the exception message is as expected
        assertEquals("Validation failed", exception.getMessage());
    }

    @Test
    public void testValidationExceptionDefaultMessage() {
        // Create a ValidationException without a custom message
        ValidationException exception = new ValidationException("Failed");

        // Check that the exception message is the default message
        assertNotEquals("ValidationException occurred.", exception.getMessage());
    }

}
