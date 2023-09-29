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
	    List<String> skills = new ArrayList<String>(); 

	    @Test
	    public void testGettersAndSetters() {
	        employee.setId(1L);
	        employee.setEmpId("N1111");
	        employee.setName("Ankita Sharma");
	        employee.setEmail("ankita.sharma@nucleusteq.com");
	        employee.setDob("1990-01-01");
	        employee.setDoj("2021-01-01");
	        employee.setLocation(Location.Raipur);
	        employee.setDesignation(Designation.Engineer);
	        employee.setContactNumber("1234567890");
	        employee.setRole(Role.EMPLOYEE);
	        employee.setProjectId(10L);
	        employee.setPassword("password");
	        
	        List<String> skills = new ArrayList<>();
	        skills.add("Java");
	        skills.add("Spring Boot");
	        employee.setSkills(skills);
	        
	        employee.setManagerId(201L);

	        assertEquals(1L, employee.getId());
	        assertEquals("N1111", employee.getEmpId());
	        assertEquals("Ankita Sharma", employee.getName());
	        assertEquals("ankita.sharma@nucleusteq.com", employee.getEmail());
	        assertEquals("1990-01-01", employee.getDob());
	        assertEquals("2021-01-01", employee.getDoj());
	        assertEquals(Location.Raipur, employee.getLocation());
	        assertEquals(Designation.Engineer, employee.getDesignation());
	        assertEquals("1234567890", employee.getContactNumber());
	        assertEquals(Role.EMPLOYEE, employee.getRole());
	        assertEquals(10L, employee.getProjectId());
	        assertEquals("password", employee.getPassword());
	        assertNotNull(employee.getSkills());
	        assertEquals(2, employee.getSkills().size());
	        assertEquals("Java", employee.getSkills().get(0));
	        assertEquals("Spring Boot", employee.getSkills().get(1));
	        assertEquals(201L, employee.getManagerId());
	    }
//	    @Test
//	    void testToString() {
//	        Employee emp = new Employee();
//	        skills.add("React");
//	        skills.add("Java");
//	        emp.setId(1);
//	        emp.setEmpId("N0001");
//	        emp.setName("Ankita Sharma");
//	        emp.setEmail("ankita.sharma@nucleusteq.com");
//	        emp.setDob("1998-08-10");
//	        emp.setDoj("2019-11-21");
//	        emp.setLocation(Location.Indore);
//	        emp.setDesignation(Designation.Engineer);
//	        emp.setContactNumber("1234567890");
//	        emp.setPassword("admin123");
//	        emp.setRole(Role.ADMIN);
//	        emp.setProjectId(0L);
//	        emp.setSkills(skills);
//	        emp.setManagerId(1L);
//	        
//	        String expectedToString = "Employee [id=1, empId=N0001, name=Ankita Sharma, email=ankita.sharma@nucleusteq.com, dob=1998-08-10, doj=2019-11-21, location=Indore, designation=Engineer, contactNumber=1234567890, project=0, password=admin123, role=ADMIN, skills=[React, Java], managerId=1]";
//	      String resultString= emp.toString();
//	        assertEquals(expectedToString, resultString);
//	    }

}
