	package com.portal.exception;
	
	import static org.junit.jupiter.api.Assertions.*;
	
	import org.junit.jupiter.api.Test;
	
	class DuplicateEntryExceptionTest {
	
		@Test
	    public void testExceptionMessage() {
	        String message = "Duplicate entry exception";
	        DuplicateEntryException exception = new DuplicateEntryException(message);
	        assertEquals(message, exception.getMessage());
	    }

	    @Test
	    public void testExceptionWithNullMessage() {
	        DuplicateEntryException exception = new DuplicateEntryException(null);
	        assertNull(exception.getMessage());
	    }

	    @Test
	    public void testExceptionWithEmptyMessage() {
	        DuplicateEntryException exception = new DuplicateEntryException("");
	        assertEquals("", exception.getMessage());
	    }

	    @Test
	    public void testExceptionWithWhitespaceMessage() {
	        DuplicateEntryException exception = new DuplicateEntryException("   ");
	        assertEquals("   ", exception.getMessage());
	    }

	    @Test
	    public void testExceptionWithNullCause() {
	        DuplicateEntryException exception = new DuplicateEntryException(null);
	        assertNull(exception.getCause());
	    }
	   
	
	}
