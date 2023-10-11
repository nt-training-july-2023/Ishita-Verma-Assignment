package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {
	    List<String> skills = new ArrayList<String>(); 

	    @Test
	    public void testGettersAndSetters() {
	        Employee employee= new Employee();
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
//	        Employee empDto = new Employee();
//	        empDto.setId(1L);
//	        empDto.setEmpId("N0001");
//	        empDto.setName("Ankita Sharma");
//	        empDto.setEmail("ankita.sharma@nucleusteq.com");
//	        empDto.setDob("1998-08-10");
//	        empDto.setDoj("2019-11-21");
//	        empDto.setLocation(Location.Raipur);
//	        empDto.setDesignation(Designation.Recruiter);
//	        empDto.setContactNumber("1234567890");
//	        empDto.setPassword("admin123");
//	        empDto.setRole(Role.ADMIN);
//	        empDto.setProjectId(0L);
//	        empDto.setSkills(Arrays.asList("React", "Java"));
//	        empDto.setManagerId(1L);
//
//	        String expectedToString = "Employee [id=1, empId=N0001, name=Ankita Sharma, email=ankita.sharma@nucleusteq.com, dob=1998-08-10, doj=2019-11-21, location=Raipur, designation=Recruiter, contactNumber=1234567890, role=ADMIN, projectId=0, skills=[React, Java], password=admin123, managerId=1]";
//
//	        String resultString = empDto.toString();
//	        assertEquals(expectedToString, resultString);
//	    }

	    
	    @Test
	    public void testEqualsAndHashCode() {
	        Employee employee1 = new Employee();
	        employee1.setId(1L);
	        employee1.setName("Ankita");
	        employee1.setEmail("ankita@nucleusteq.com");
	        employee1.setEmpId("N1234");
	        employee1.setDob("1990-01-01");
	        employee1.setDoj("2020-01-01");
	        employee1.setLocation(Location.Raipur);
	        employee1.setDesignation(Designation.Engineer);
	        employee1.setContactNumber("1234567890");
	        employee1.setPassword("password123");
	        employee1.setRole(Role.ADMIN);
	        employee1.setManagerId(1L);
	        employee1.setProjectId(1L);

	        Employee employee2 = new Employee();
	        employee2.setId(1L);
	        employee2.setName("Ankita");
	        employee2.setEmail("ankita@nucleusteq.com");
	        employee2.setEmpId("N1234");
	        employee2.setDob("1990-01-01");
	        employee2.setDoj("2020-01-01");
	        employee2.setLocation(Location.Raipur);
	        employee2.setDesignation(Designation.Engineer);
	        employee2.setContactNumber("1234567890");
	        employee2.setPassword("password123");
	        employee2.setRole(Role.ADMIN);
	        employee2.setManagerId(1L);
	        employee2.setProjectId(1L);
	        
	        assertTrue(employee1.equals(employee1));
	        assertFalse(employee1.equals(null));
	        assertFalse(employee1.equals(""));

	        assertTrue(employee1.equals(employee2));
	        assertEquals(employee1.hashCode(), employee2.hashCode());
	        
	        employee2.setName("Vanshika Sharma");
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setName("Ankita");
	        employee2.setEmail("vanshika.nucleusteq.com");
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setEmail("ankita@nucleusteq.com");
	        employee2.setEmpId("N4321");
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setEmpId("N1234");
	        employee2.setDob("1999-06-26");
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setDob("1990-01-01");
	        employee2.setDoj("2023-09-28");
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setDoj("2020-01-01");
	        employee2.setLocation(Location.Canada);
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setLocation(Location.Raipur);
	        employee2.setDesignation(Designation.Architect);
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setDesignation(Designation.Engineer);
	        employee2.setContactNumber("9087654321");
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setContactNumber("1234567890");
	        employee2.setPassword("pass123456");
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setPassword("password123");
	        employee2.setRole(Role.EMPLOYEE);
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setRole(Role.ADMIN);
	        employee2.setManagerId(2L);
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setManagerId(1L);
	        employee2.setProjectId(2L);
	        assertNotEquals(employee1.hashCode(), employee2.hashCode());
	        assertFalse(employee1.equals(employee2));
	        
	        employee2.setProjectId(1L);
	    }
	    @Test
	    void testToString() {
	        Employee employee = new Employee();
	        employee.setId(1L);
	        employee.setEmpId("N1111");
	        employee.setName("John Doe");
	        employee.setEmail("ankita.sharma@nucleusteq.com");
	        employee.setDob("1990-01-01");
	        employee.setDoj("2023-09-18");
	        employee.setLocation(Location.Raipur);
	        employee.setDesignation(Designation.Engineer);
	        employee.setContactNumber("1234567890");
	        employee.setRole(Role.EMPLOYEE);
	        employee.setProjectId(2L);
	        employee.setPassword("password123");
	        List<String> skills = Arrays.asList("Java", "React");
	        employee.setSkills(skills);
	        employee.setManagerId(3L);

	        String expected = "Employee [Id=1, empId=N1111,name=John Doe,"
	                +"email=ankita.sharma@nucleusteq.com, dob=1990-01-01, "
	                + "doj=2023-09-18, location=Raipur, designation=Engineer, "
	                + "contactNumber=1234567890, role=EMPLOYEE, projectId=2, "
	                + "password=password123, skills=[Java, React], managerId=3]";
	        
	        assertEquals(expected, employee.toString());
	    }
}