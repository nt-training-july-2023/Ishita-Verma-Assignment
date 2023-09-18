package com.portal.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WrongCredentialsExceptionTest {

	@Test
    void testResourceAlreadyExistsException() {
		WrongCredentialsException obj= new WrongCredentialsException("Wrong Credentials");
        assertEquals("Wrong Credentials",obj.getMessage());
    }

}
