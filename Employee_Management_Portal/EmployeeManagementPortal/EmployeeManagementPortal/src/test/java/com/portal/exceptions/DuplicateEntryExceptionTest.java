package com.portal.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DuplicateEntryExceptionTest {

	@Test
    void testResourceAlreadyExistsException() {
		DuplicateEntryException obj= new DuplicateEntryException("Resource already exists");
        assertEquals("Resource already exists",obj.getMessage());
    }
}
