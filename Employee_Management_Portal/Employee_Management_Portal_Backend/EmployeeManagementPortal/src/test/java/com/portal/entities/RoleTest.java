package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoleTest {

	 @Test
	    public void testEnumValues() {
	        assertEquals(Role.ADMIN, Role.valueOf("ADMIN"));
	        assertEquals(Role.MANAGER, Role.valueOf("MANAGER"));
	        assertEquals(Role.EMPLOYEE, Role.valueOf("EMPLOYEE"));
	    }

	    @Test
	    public void testEnumEquality() {
	        assertEquals(Role.ADMIN, Role.ADMIN);
	        assertNotEquals(Role.ADMIN, Role.MANAGER);
	    }

	    @Test
	    public void testEnumToString() {
	        assertEquals("ADMIN", Role.ADMIN.toString());
	        assertEquals("MANAGER", Role.MANAGER.toString());
	        assertEquals("EMPLOYEE", Role.EMPLOYEE.toString());
	    }

	    @Test
	    public void testEnumOrdinal() {
	        assertEquals(0, Role.ADMIN.ordinal());
	        assertEquals(1, Role.MANAGER.ordinal());
	        assertEquals(2, Role.EMPLOYEE.ordinal());
	    }

	    @Test
	    public void testEnumValuesCount() {
	        assertEquals(3, Role.values().length);
	    }

}
