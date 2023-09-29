package com.portal.DTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;

public class EmployeeOutDTOTest {

    private EmployeeOutDTO employee1;
    private EmployeeOutDTO employee2;
    private EmployeeOutDTO employee3;

    @BeforeEach
    public void setUp() {
        // Create sample EmployeeOutDTO objects for testing
        employee1 = new EmployeeOutDTO();
        employee1.setId(1L);
        employee1.setEmpId("N1111");
        employee1.setName("Ankita");
        employee1.setEmail("ankita.sharma@nucleusteq.com");
        employee1.setDob("1990-01-01");
        employee1.setDoj("2020-01-01");
        employee1.setLocation(Location.Raipur);
        employee1.setDesignation(Designation.Engineer);
        employee1.setContactNumber("1234567890");
        employee1.setRole(Role.ADMIN);
        employee1.setProjectId(1001L);
        employee1.setSkills(new ArrayList<>());
        employee1.setManager("Manager 1");
        employee1.setManagerId(101L);

        employee2 = new EmployeeOutDTO();
        employee2.setId(2L);
        employee2.setEmpId("N2222");
        employee2.setName("Vanshika Sharma");
        employee2.setEmail("vanshika@nucleusteq.com");
        employee2.setDob("1995-02-15");
        employee2.setDoj("2021-03-15");
        employee2.setLocation(Location.Indore);
        employee2.setDesignation(Designation.Recruiter);
        employee2.setContactNumber("9876543210");
        employee2.setRole(Role.EMPLOYEE);
        employee2.setProjectId(null);
        List<String> skills2 = new ArrayList<>();
        skills2.add("Java");
        skills2.add("Python");
        employee2.setSkills(skills2);
        employee2.setManager("Manager 2");
        employee2.setManagerId(102L);

        employee3 = new EmployeeOutDTO();
        employee3.setId(3L);
        employee3.setEmpId("N3333");
        employee3.setName("Anjali Sharma");
        employee3.setEmail("anjali@nucleusteq.com");
        employee3.setDob("1985-05-10");
        employee3.setDoj("2019-11-20");
        employee3.setLocation(Location.Raipur);
        employee3.setDesignation(Designation.Engineer);
        employee3.setContactNumber("5555555555");
        employee3.setRole(Role.MANAGER);
        employee3.setProjectId(1003L);
        List<String> skills3 = new ArrayList<>();
        skills3.add("C++");
        skills3.add("JavaScript");
        employee3.setSkills(skills3);
        employee3.setManager("Manager 3");
        employee3.setManagerId(103L);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1L, employee1.getId());
        assertEquals("N1111", employee1.getEmpId());
        assertEquals("Ankita", employee1.getName());
        assertEquals("ankita.sharma@nucleusteq.com", employee1.getEmail());
        assertEquals("1990-01-01", employee1.getDob());
        assertEquals("2020-01-01", employee1.getDoj());
        assertEquals(Location.Raipur, employee1.getLocation());
        assertEquals(Designation.Engineer, employee1.getDesignation());
        assertEquals("1234567890", employee1.getContactNumber());
        assertEquals(Role.ADMIN, employee1.getRole());
        assertEquals(1001L, employee1.getProjectId());
        assertTrue(employee1.getSkills().isEmpty());
        assertEquals("Manager 1", employee1.getManager());
        assertEquals(101L, employee1.getManagerId());

        // Test setters
        employee1.setId(4L);
        assertEquals(4L, employee1.getId());

        employee1.setEmpId("EMP004");
        assertEquals("EMP004", employee1.getEmpId());

        employee1.setName("New Name");
        assertEquals("New Name", employee1.getName());

        // Add more setters tests for other properties
    }

    @Test
    public void testEqualsAndHashCode() {
        // Test equality of two EmployeeOutDTO objects with the same properties
        EmployeeOutDTO employee1Copy = new EmployeeOutDTO();
        employee1Copy.setId(1L);
        employee1Copy.setEmpId("N1111");
        employee1Copy.setName("Ankita");
        employee1Copy.setEmail("ankita.sharma@nucleusteq.com");
        employee1Copy.setDob("1990-01-01");
        employee1Copy.setDoj("2020-01-01");
        employee1Copy.setLocation(Location.Raipur);
        employee1Copy.setDesignation(Designation.Engineer);
        employee1Copy.setContactNumber("1234567890");
        employee1Copy.setRole(Role.ADMIN);
        employee1Copy.setProjectId(1001L);
        employee1Copy.setSkills(new ArrayList<>());
        employee1Copy.setManager("Manager 1");
        employee1Copy.setManagerId(101L);

        assertTrue(employee1.equals(employee1Copy));
        assertTrue(employee1.hashCode() == employee1Copy.hashCode());

        // Test inequality of two EmployeeOutDTO objects with different properties
        assertFalse(employee1.equals(employee2));
        assertFalse(employee1.hashCode() == employee2.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "EmployeeOutDTO [Id=1, empId=N1111, name=Ankita, email=ankita.sharma@nucleusteq.com, dob=1990-01-01, " +
                "doj=2020-01-01, location=Raipur, designation=Engineer, contactNumber=1234567890, role=ADMIN, " +
                "projectId=1001, skills=[], manager=Manager 1, managerId=101]";
        assertEquals(expected, employee1.toString());
    }
}
