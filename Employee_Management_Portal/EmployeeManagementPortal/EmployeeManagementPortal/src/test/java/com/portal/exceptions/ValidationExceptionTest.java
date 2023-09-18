package com.portal.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationExceptionTest {

	@Test
    void testValidationException() {
		ValidationException obj= new ValidationException("Validation Exception");
        assertEquals("Validation Exception",obj.getMessage());
    }

}
