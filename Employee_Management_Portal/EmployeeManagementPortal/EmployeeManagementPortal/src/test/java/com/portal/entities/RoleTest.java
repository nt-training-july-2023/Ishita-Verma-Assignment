package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoleTest {

	@Test
    public void testRoleEnumValues() {
        Role adminRole = Role.ADMIN;
        Role managerRole = Role.MANAGER;
        Role employeeRole = Role.EMPLOYEE;

        assertEquals("ADMIN", adminRole.name());
        assertEquals("MANAGER", managerRole.name());
        assertEquals("EMPLOYEE", employeeRole.name());

        assertEquals(Role.ADMIN, Role.valueOf("ADMIN"));
        assertEquals(Role.MANAGER, Role.valueOf("MANAGER"));
        assertEquals(Role.EMPLOYEE, Role.valueOf("EMPLOYEE"));
    }

    @Test
    public void testRoleToString() {
        Role adminRole = Role.ADMIN;
        Role managerRole = Role.MANAGER;
        Role employeeRole = Role.EMPLOYEE;

        assertEquals("ADMIN", adminRole.toString());
        assertEquals("MANAGER", managerRole.toString());
        assertEquals("EMPLOYEE", employeeRole.toString());
    }

}
