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
    @Test
    public void testGettersAndSetters() {
        EmployeeOutDTO employee = new EmployeeOutDTO();

        employee.setId(1L);
        assertEquals(1L, employee.getId());

        employee.setEmpId("N1111");
        assertEquals("N1111", employee.getEmpId());

        employee.setName("Ankita");
        assertEquals("Ankita", employee.getName());

        employee.setEmail("ankita.sharma@nucleusteq.com");
        assertEquals("ankita.sharma@nucleusteq.com", employee.getEmail());

        employee.setDob("1990-01-01");
        assertEquals("1990-01-01", employee.getDob());

        employee.setDoj("2020-01-01");
        assertEquals("2020-01-01", employee.getDoj());

        employee.setLocation(Location.Raipur);
        assertEquals(Location.Raipur, employee.getLocation());

        employee.setDesignation(Designation.Engineer);
        assertEquals(Designation.Engineer, employee.getDesignation());

        employee.setContactNumber("1234567890");
        assertEquals("1234567890", employee.getContactNumber());

        employee.setRole(Role.ADMIN);
        assertEquals(Role.ADMIN, employee.getRole());

        employee.setProjectId(1001L);
        assertEquals(1001L, employee.getProjectId());

        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Python");
        employee.setSkills(skills);
        assertEquals(skills, employee.getSkills());

        employee.setManager("Manager 1");
        assertEquals("Manager 1", employee.getManager());

        employee.setManagerId(101L);
        assertEquals(101L, employee.getManagerId());
    }

    @Test
    public void testEqualsAndHashCode() {
        EmployeeOutDTO employee1 = new EmployeeOutDTO();
        EmployeeOutDTO employee2 = new EmployeeOutDTO();
        EmployeeOutDTO employee3 = new EmployeeOutDTO();

        // Set properties for employee1
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

        // Set properties for employee2 identical to employee1
        employee2.setId(1L);
        employee2.setEmpId("N1111");
        employee2.setName("Ankita");
        employee2.setEmail("ankita.sharma@nucleusteq.com");
        employee2.setDob("1990-01-01");
        employee2.setDoj("2020-01-01");
        employee2.setLocation(Location.Raipur);
        employee2.setDesignation(Designation.Engineer);
        employee2.setContactNumber("1234567890");
        employee2.setRole(Role.ADMIN);
        employee2.setProjectId(1001L);
        employee2.setSkills(new ArrayList<>());
        employee2.setManager("Manager 1");
        employee2.setManagerId(101L);

        // Set properties for employee3 different from employee1
        employee3.setId(2L);
        employee3.setEmpId("N2222");
        employee3.setName("Vanshika Sharma");
        employee3.setEmail("vanshika@nucleusteq.com");
        employee3.setDob("1995-02-15");
        employee3.setDoj("2021-03-15");
        employee3.setLocation(Location.Indore);
        employee3.setDesignation(Designation.Recruiter);
        employee3.setContactNumber("9876543210");
        employee3.setRole(Role.EMPLOYEE);
        employee3.setProjectId(null);
        List<String> skills3 = new ArrayList<>();
        skills3.add("Java");
        skills3.add("Python");
        employee3.setSkills(skills3);
        employee3.setManager("Manager 2");
        employee3.setManagerId(102L);

        assertTrue(employee1.equals(employee2));
        assertFalse(employee1.equals(employee3));
        assertTrue(employee1.hashCode() == employee2.hashCode());
        assertFalse(employee1.hashCode() == employee3.hashCode());
    }

    @Test
    public void testToString() {
        EmployeeOutDTO employee = new EmployeeOutDTO();

        employee.setId(1L);
        employee.setEmpId("N1111");
        employee.setName("Ankita");
        employee.setEmail("ankita.sharma@nucleusteq.com");
        employee.setDob("1990-01-01");
        employee.setDoj("2020-01-01");
        employee.setLocation(Location.Raipur);
        employee.setDesignation(Designation.Engineer);
        employee.setContactNumber("1234567890");
        employee.setRole(Role.ADMIN);
        employee.setProjectId(1001L);
        employee.setSkills(new ArrayList<>());
        employee.setManager("Manager 1");
        employee.setManagerId(101L);

        String expectedString = "EmployeeOutDTO [Id=1, empId=N1111, name=Ankita, email=ankita.sharma@nucleusteq.com, dob=1990-01-01, doj=2020-01-01, location=Raipur, designation=Engineer, contactNumber=1234567890, role=ADMIN, projectId=1001, skills=[], manager=Manager 1, managerId=101]";
        assertEquals(expectedString, employee.toString());
    }
}
