package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;

class EmployeeInDTOTest {

    @Test
    public void testAdminDTOProperties() {
        EmployeeInDTO adminDTO = new EmployeeInDTO();
        adminDTO.setId(1L);
        adminDTO.setEmpId("N1111");
        adminDTO.setName("Ankita Sharma");
        adminDTO.setEmail("ankita.sharma@nucleusteq.com");
        adminDTO.setDob("1990-01-01");
        adminDTO.setDoj("2021-01-01");
        adminDTO.setLocation(Location.Indore);
        adminDTO.setDesignation(Designation.Engineer);
        adminDTO.setContactNumber("1234567890");
        adminDTO.setPassword("password");
        adminDTO.setRole(Role.ADMIN);
        adminDTO.setManager("Manager Name");
        adminDTO.setManagerId(2L);
        adminDTO.setProjectId(3L);
        adminDTO.setProject("Project Name");

        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Spring");
        adminDTO.setSkills(skills);

        assertEquals(1L, adminDTO.getId());
        assertEquals("N1111", adminDTO.getEmpId());
        assertEquals("Ankita Sharma", adminDTO.getName());
        assertEquals("ankita.sharma@nucleusteq.com", adminDTO.getEmail());
        assertEquals("1990-01-01", adminDTO.getDob());
        assertEquals("2021-01-01", adminDTO.getDoj());
        assertEquals(Location.Indore, adminDTO.getLocation());
        assertEquals(Designation.Engineer, adminDTO.getDesignation());
        assertEquals("1234567890", adminDTO.getContactNumber());
        assertEquals("password", adminDTO.getPassword());
        assertEquals(Role.ADMIN, adminDTO.getRole());
        assertEquals("Manager Name", adminDTO.getManager());
        assertEquals(2L, adminDTO.getManagerId());
        assertEquals(3L, adminDTO.getProjectId());
        assertEquals("Project Name", adminDTO.getProject());
        assertEquals(skills, adminDTO.getSkills());

        adminDTO.setSkills(null);
    }
    @Test
    void testHashCode() {
        EmployeeInDTO employee1 = new EmployeeInDTO();
        employee1.setId(1L);
        employee1.setEmpId("N0001");
        employee1.setName("Ankita");
        employee1.setEmail("ankita.sharma@nucleusteq.com"); 
        employee1.setDob("1990-01-01");
        employee1.setDoj("2021-03-15");
        employee1.setLocation(Location.Raipur);
        employee1.setDesignation(Designation.Engineer);
        employee1.setContactNumber("1234567890");
        employee1.setPassword("password123");
        employee1.setRole(Role.ADMIN);
        employee1.setManager("Manager1");
        employee1.setManagerId(2L);
        employee1.setProjectId(3L);
        employee1.setProject("ProjectA");
        employee1.setSkills(List.of("Java", "Python"));

        EmployeeInDTO employee2 = new EmployeeInDTO();
        employee2.setId(1L);
        employee2.setEmpId("N0001");
        employee2.setName("Ankita");
        employee2.setEmail("ankita.sharma@nucleusteq.com");
        employee2.setDob("1990-01-01");
        employee2.setDoj("2021-03-15");
        employee2.setLocation(Location.Raipur);
        employee2.setDesignation(Designation.Engineer);
        employee2.setContactNumber("1234567890");
        employee2.setPassword("password123");
        employee2.setRole(Role.ADMIN);
        employee2.setManager("Manager1");
        employee2.setManagerId(2L);
        employee2.setProjectId(3L);
        employee2.setProject("ProjectA");
        employee2.setSkills(List.of("Java", "Python"));

        EmployeeInDTO employee3 = new EmployeeInDTO();
        employee3.setId(2L);
        employee3.setEmpId("N0002");
        employee3.setName("Anjali");
        employee3.setEmail("anjali@nucleusteq.com");
        employee3.setDob("1995-05-15");
        employee3.setDoj("2022-02-20");
        employee3.setLocation(Location.Raipur);
        employee3.setDesignation(Designation.Engineer);
        employee3.setContactNumber("9876543210");
        employee3.setPassword("pass123");
        employee3.setRole(Role.EMPLOYEE);
        employee3.setManager("Manager2");
        employee3.setManagerId(3L);
        employee3.setProjectId(4L);
        employee3.setProject("ProjectB");
        employee3.setSkills(List.of("React", "JavaScript"));

        assertEquals(employee1.hashCode(), employee2.hashCode());
        assertNotEquals(employee1.hashCode(), employee3.hashCode());
    }

    @Test
    void testEqualsAndHashcode() {

        EmployeeInDTO employeeDto1 = new EmployeeInDTO();
        employeeDto1.setName("Praveen");
        employeeDto1.setEmail("admin@nucleusteq.com");
        employeeDto1.setEmpId("N1234");
        employeeDto1.setDob("05/12/2000");
        employeeDto1.setDoj("17/07/2023");
        employeeDto1.setLocation(Location.Bangalore);
        employeeDto1.setDesignation(Designation.Engineer);
        employeeDto1.setContactNumber("758783866");
        employeeDto1.setPassword("Praveen123");
        employeeDto1.setRole(Role.ADMIN);
        employeeDto1.setManager("Ankita");

        EmployeeInDTO employeeDto2 = new EmployeeInDTO();
        employeeDto2.setName("Praveen");
        employeeDto2.setEmail("admin@nucleusteq.com");
        employeeDto2.setEmpId("N1234");
        employeeDto2.setDob("05/12/2000");
        employeeDto2.setDoj("17/07/2023");
        employeeDto2.setLocation(Location.Bangalore);
        employeeDto2.setDesignation(Designation.Engineer);
        employeeDto2.setContactNumber("758783866");
        employeeDto2.setPassword("Praveen123");
        employeeDto2.setRole(Role.ADMIN);
        employeeDto2.setManager("Ankita");

        assertTrue(employeeDto1.equals(employeeDto1));
        assertFalse(employeeDto1.equals(null));
        assertFalse(employeeDto1.equals(""));
        
        assertTrue(employeeDto1.equals(employeeDto2));
        assertEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        
        employeeDto2.setName("Hemant");
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
        
        employeeDto2.setName("Praveen");
        employeeDto2.setEmail("hemant@nucleusteq.com");
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
        
        employeeDto2.setEmail("admin@nucleusteq.com");
        employeeDto2.setEmpId("N4321");
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
        
        employeeDto2.setEmpId("N1234");
        employeeDto2.setDob("15/02/2000");
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
        
        employeeDto2.setDob("05/12/2000");
        employeeDto2.setDoj("07/07/2023");
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
        
        employeeDto2.setDob("17/07/2023");
        employeeDto2.setLocation(Location.Canada);
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
        
        employeeDto2.setLocation(Location.Bangalore);
        employeeDto2.setDesignation(Designation.Operation_Analyst);
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
        
        employeeDto2.setDesignation(Designation.Engineer);
        employeeDto2.setContactNumber("754729356");
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
        
        employeeDto2.setContactNumber("758783866");
        employeeDto2.setPassword("Hemant123");
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
        
        employeeDto2.setPassword("Praveen123");
        employeeDto2.setRole(Role.EMPLOYEE);
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
        
        employeeDto2.setRole(Role.ADMIN);
        employeeDto2.setManager("Prerna");
        assertNotEquals(employeeDto1.hashCode(), employeeDto2.hashCode());
        assertFalse(employeeDto1.equals(employeeDto2));
    }
    @Test
    public void testToString() {
        EmployeeInDTO employeeDTO = new EmployeeInDTO();
        List<String> skills= new ArrayList<>();
        skills.add("Java");
        skills.add("Python");
        employeeDTO.setId(1L);
        employeeDTO.setEmpId("N1111");
        employeeDTO.setName("John Doe");
        employeeDTO.setEmail("john.doe@example.com");
        employeeDTO.setDob("1990-01-01");
        employeeDTO.setDoj("2020-01-01");
        employeeDTO.setLocation(Location.Raipur);
        employeeDTO.setDesignation(Designation.Engineer);
        employeeDTO.setContactNumber("1234567890");
        employeeDTO.setPassword("secret");
        employeeDTO.setRole(Role.EMPLOYEE);
        employeeDTO.setManager("Manager 1");
        employeeDTO.setManagerId(101L);
        employeeDTO.setProjectId(1001L);
        employeeDTO.setProject("Project ABC");
        employeeDTO.setSkills(skills);

        String expectedString = "EmployeeInDTO [Id=1, empId=N1111, name=John Doe, email=john.doe@example.com, dob=1990-01-01, doj=2020-01-01, location=Raipur, designation=Engineer, contactNumber=1234567890, password=secret, role=EMPLOYEE, manager=Manager 1, managerId=101, projectId=1001, project=Project ABC, skills=[Java, Python]]";
        String actualString = employeeDTO.toString();

        assertEquals(expectedString, actualString);
    }
}
