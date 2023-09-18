package com.portal.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResourceNotFoundExceptionTest {

	 void testWrongCredentialsException() {
		 ResourceNotFoundException obj = new ResourceNotFoundException("Resource not found.");
	        assertEquals("Resource not found.", obj.getMessage());
	    }

}
