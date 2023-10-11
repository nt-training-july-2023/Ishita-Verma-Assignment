package com.portal.DTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
        
        employee.setProjectName("Fyndr");
        assertEquals("Fyndr", employee.getProjectName());
    }

    @Test
    void testHashCodeAndEquals() {
        List<String> skills = new ArrayList<>();
        skills.add("React");
        skills.add("Java");
        EmployeeOutDTO empDto1 = new EmployeeOutDTO();
        empDto1.setId(1L);
        empDto1.setEmpId("N1001");
        empDto1.setName("Anjali Sharma");
        empDto1.setEmail("anjali.sharma@nucleusteq.com");
        empDto1.setDob("1998-08-10");
        empDto1.setDoj("2019-11-21");
        empDto1.setLocation(Location.Raipur);
        empDto1.setDesignation(Designation.Engineer);
        empDto1.setContactNumber("1234567890");
        empDto1.setSkills(skills);
        empDto1.setManager("Ankita Sharma");
        empDto1.setProjectName("Fyndr");

        EmployeeOutDTO empDto2 = new EmployeeOutDTO();
        empDto2.setId(1L);
        empDto2.setId(1L);
        empDto2.setEmpId("N1001");
        empDto2.setName("Anjali Sharma");
        empDto2.setEmail("anjali.sharma@nucleusteq.com");
        empDto2.setDob("1998-08-10");
        empDto2.setDoj("2019-11-21");
        empDto2.setLocation(Location.Raipur);
        empDto2.setDesignation(Designation.Engineer);
        empDto2.setContactNumber("1234567890");
        empDto2.setSkills(skills);
        empDto2.setManager("Ankita Sharma");
        empDto2.setProjectName("Fyndr");

        assertTrue(empDto1.equals(empDto1));
        assertFalse(empDto1.equals(null));
        assertFalse(empDto1.equals(""));

        assertTrue(empDto1.equals(empDto2));
        assertEquals(empDto1.hashCode(), empDto2.hashCode());
        // Verify that the hash codes for empDto1 and empDto2 are equal
        assertEquals(empDto1.hashCode(), empDto2.hashCode());

        empDto2.setName("Vanshika Sharma");
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setName("Anjali Sharma");
        empDto2.setEmail("vanshika.sharma@nucleusteq.com");
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setEmail("anjali.sharma@nucleusteq.com");
        empDto2.setEmpId("N1002");
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setEmpId("N1001");
        empDto2.setDesignation(Designation.Architect);
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setDesignation(Designation.Engineer);
        empDto2.setDob("2001-09-07");
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setDob("1998-08-10");
        empDto2.setDoj("2022-09-07");
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setDoj("2019-11-21");
        empDto2.setLocation(Location.Indore);
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setLocation(Location.Raipur);
        empDto2.setManager("Anjali Sharma");
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setManager("Ankita Sharma");
        empDto2.setContactNumber("1234556789");
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setContactNumber("1234567890");
        List<String> skills3 = new ArrayList<>();
        skills3.add("Python");
        empDto2.setSkills(skills3);
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setSkills(skills);
        empDto2.setProjectName("AAA");
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

        empDto2.setProjectName("Fyndr");
        empDto2.setId(0L);
        assertNotEquals(empDto1.hashCode(), empDto2.hashCode());
        assertFalse(empDto1.equals(empDto2));

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
