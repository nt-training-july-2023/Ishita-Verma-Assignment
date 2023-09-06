
package com.portal.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResourceNotFoundExceptionTest {

	 @Test
	    public void testExceptionMessage() {
	        String message = "Resource not found";
	        ResourceNotFoundException exception = new ResourceNotFoundException(message);
	        assertEquals(message, exception.getMessage());
	    }

	    @Test
	    public void testExceptionWithNullMessage() {
	        ResourceNotFoundException exception = new ResourceNotFoundException(null);
	        assertNull(exception.getMessage());
	    }

	    @Test
	    public void testExceptionWithEmptyMessage() {
	        ResourceNotFoundException exception = new ResourceNotFoundException("");
	        assertEquals("", exception.getMessage());
	    }

	    @Test
	    public void testExceptionWithWhitespaceMessage() {
	        ResourceNotFoundException exception = new ResourceNotFoundException("   ");
	        assertEquals("   ", exception.getMessage());
	    }

}
