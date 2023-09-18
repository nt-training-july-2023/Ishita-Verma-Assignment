package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {
	 private Employee employee;

	    @BeforeEach
	    public void setUp() {
	        employee = new Employee();
	    }

	    @Test
	    public void testGettersAndSetters() {
	        employee.setId(1L);
	        employee.setEmpId("EMP001");
	        employee.setName("John Doe");
	        employee.setEmail("john.doe@example.com");
	        employee.setDob("1990-01-01");
	        employee.setDoj("2021-01-01");
	        employee.setLocation(Location.Raipur);
	        employee.setDesignation(Designation.Engineer);
	        employee.setContactNumber("1234567890");
	        employee.setRole(Role.EMPLOYEE);
	        employee.setProjectId(101L);
	        employee.setPassword("password");
	        
	        List<String> skills = new ArrayList<>();
	        skills.add("Java");
	        skills.add("Spring Boot");
	        employee.setSkills(skills);
	        
	        employee.setManagerId(201L);

	        assertEquals(1L, employee.getId());
	        assertEquals("EMP001", employee.getEmpId());
	        assertEquals("John Doe", employee.getName());
	        assertEquals("john.doe@example.com", employee.getEmail());
	        assertEquals("1990-01-01", employee.getDob());
	        assertEquals("2021-01-01", employee.getDoj());
	        assertEquals(Location.Raipur, employee.getLocation());
	        assertEquals(Designation.Engineer, employee.getDesignation());
	        assertEquals("1234567890", employee.getContactNumber());
	        assertEquals(Role.EMPLOYEE, employee.getRole());
	        assertEquals(101L, employee.getProjectId());
	        assertEquals("password", employee.getPassword());
	        assertNotNull(employee.getSkills());
	        assertEquals(2, employee.getSkills().size());
	        assertEquals("Java", employee.getSkills().get(0));
	        assertEquals("Spring Boot", employee.getSkills().get(1));
	        assertEquals(201L, employee.getManagerId());
	    }

	    @Test
	    public void testDefaultConstructor() {
	        assertNotNull(employee);
	        assertNotNull(employee.getId());
	        assertNull(employee.getEmpId());
	        assertNull(employee.getName());
	        assertNull(employee.getEmail());
	        assertNull(employee.getDob());
	        assertNull(employee.getDoj());
	        assertNull(employee.getLocation());
	        assertNull(employee.getDesignation());
	        assertNull(employee.getContactNumber());
	        assertNull(employee.getRole());
	        assertNotNull(employee.getProjectId());
	        assertNull(employee.getPassword());
	        assertNull(employee.getSkills());
	        assertNull(employee.getManagerId());
	    }

}
