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
        employee1 = new EmployeeOutDTO(1L, "N1111", "Ankita", "ankita.sharma@nucleusteq.com", "1990-01-01", "2020-01-01",
                Location.Raipur, Designation.Engineer, "1234567890", Role.ADMIN, 1001L,
                new ArrayList<>(), "Manager 1", 101L);

        employee2 = new EmployeeOutDTO(2L, "N2222", "Jane Smith", "jane@example.com", "1995-02-15", "2021-03-15",
                Location.Indore, Designation.Recruiter, "9876543210", Role.EMPLOYEE, null,
                List.of("Java", "Python"), "Manager 2", 102L);

        employee3 = new EmployeeOutDTO(3L, "N3333", "Bob Johnson", "bob@example.com", "1985-05-10", "2019-11-20",
                Location.Raipur, Designation.Engineer, "5555555555", Role.MANAGER, 1003L,
                List.of("C++", "JavaScript"), "Manager 3", 103L);
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
        EmployeeOutDTO employee1Copy = new EmployeeOutDTO(1L, "N1111", "Ankita", "ankita.sharma@nucleusteq.com", "1990-01-01",
                "2020-01-01", Location.Raipur, Designation.Engineer, "1234567890", Role.ADMIN, 1001L,
                new ArrayList<>(), "Manager 1", 101L);

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
