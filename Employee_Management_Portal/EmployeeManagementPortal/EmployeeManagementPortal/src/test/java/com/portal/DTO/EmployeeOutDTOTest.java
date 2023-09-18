package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;

class EmployeeOutDTOTest {

	private EmployeeOutDTO employeeDTO;

    @BeforeEach
    void setUp() {
        // Initialize a sample EmployeeOutDTO object for testing
        employeeDTO = new EmployeeOutDTO(1, "N1111", "Ankita Sharma", "ankita.sharma@nucleusteq.com", "1990-01-01", "2020-01-01",
                Location.Raipur, Designation.Engineer, "1234567890", Role.MANAGER, "PRJ001", new ArrayList<>(),
                "Manager Name", "1L");
    }

    @Test
    void testGettersAndSetters() {
        // Test getters and setters for all fields
        assertEquals(1, employeeDTO.getId());
        assertEquals("N1111", employeeDTO.getEmpId());
        assertEquals("Ankita Sharma", employeeDTO.getName());
        assertEquals("ankita.sharma@nucleusteq.com", employeeDTO.getEmail());
        assertEquals("1990-01-01", employeeDTO.getDob());
        assertEquals("2020-01-01", employeeDTO.getDoj());
        assertEquals(Location.Raipur, employeeDTO.getLocation());
        assertEquals(Designation.Engineer, employeeDTO.getDesignation());
        assertEquals("1234567890", employeeDTO.getContactNumber());
        assertEquals(Role.MANAGER, employeeDTO.getRole());
        assertEquals("PRJ001", employeeDTO.getProjectId());
        assertEquals(new ArrayList<>(), employeeDTO.getSkills());
        assertEquals("Manager Name", employeeDTO.getManager());
        assertEquals("1L", employeeDTO.getManagerId());

        // Test setters for all fields
        employeeDTO.setId(2);
        employeeDTO.setEmpId("N1113");
        employeeDTO.setName("Pranjal Yadav");
        employeeDTO.setEmail("pranjal@nucleusteq.com");
        employeeDTO.setDob("1995-02-15");
        employeeDTO.setDoj("2021-03-10");
        employeeDTO.setLocation(Location.Indore);
        employeeDTO.setDesignation(Designation.Architect);
        employeeDTO.setContactNumber("9876543210");
        employeeDTO.setRole(Role.EMPLOYEE);
        employeeDTO.setProjectId("PRJ002");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Spring Boot");
        employeeDTO.setSkills(skills);
        employeeDTO.setManager("New Manager");
        employeeDTO.setManagerId("2L");

        assertEquals(2, employeeDTO.getId());
        assertEquals("N1113", employeeDTO.getEmpId());
        assertEquals("Pranjal Yadav", employeeDTO.getName());
        assertEquals("pranjal@nucleusteq.com", employeeDTO.getEmail());
        assertEquals("1995-02-15", employeeDTO.getDob());
        assertEquals("2021-03-10", employeeDTO.getDoj());
        assertEquals(Location.Indore, employeeDTO.getLocation());
        assertEquals(Designation.Architect, employeeDTO.getDesignation());
        assertEquals("9876543210", employeeDTO.getContactNumber());
        assertEquals(Role.EMPLOYEE, employeeDTO.getRole());
        assertEquals("PRJ002", employeeDTO.getProjectId());
        assertEquals(skills, employeeDTO.getSkills());
        assertEquals("New Manager", employeeDTO.getManager());
        assertEquals("2L", employeeDTO.getManagerId());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create a new EmployeeOutDTO object with the same values as the original
        EmployeeOutDTO sameEmployeeDTO = new EmployeeOutDTO(1, "N1111", "Ankita Sharma", "", "1990-01-01", "2020-01-01",
                null, null, "1234567890", null, "2L", null,
                "Manager Name", "2L");

        // Test equals method
        assertTrue(employeeDTO.equals(sameEmployeeDTO));
        assertTrue(sameEmployeeDTO.equals(employeeDTO));

        // Test hashCode method
        assertEquals(employeeDTO.hashCode(), sameEmployeeDTO.hashCode());
    }

    @Test
    void testNotEquals() {
        // Create a new EmployeeOutDTO object with different values
        EmployeeOutDTO differentEmployeeDTO = new EmployeeOutDTO(2, "N1112", "Pranjal Yadav", "pranjal@nucleusteq.com", "1995-02-15", "2021-03-10",
                Location.Raipur, Designation.Engineer, "9876543210", Role.EMPLOYEE, "1", new ArrayList<>(),
                "New Manager", "2L");

        // Test equals method
        assertFalse(employeeDTO.equals(differentEmployeeDTO));
        assertFalse(differentEmployeeDTO.equals(employeeDTO));

        // Test hashCode method (hash codes should be different)
        assertNotEquals(employeeDTO.hashCode(), differentEmployeeDTO.hashCode());
    }

    @Test
    void testToString() {
        String expectedToString = "EmployeeOutDTO [Id=1, empId=N1111, name=Ankita Sharma, email=null, dob=1990-01-01, doj=2020-01-01, location=null, designation=null, contactNumber=1234567890, role=null, projectId=1, skills=null, manager=null, managerId=null]";
        assertEquals(expectedToString, employeeDTO.toString());
    }


}
