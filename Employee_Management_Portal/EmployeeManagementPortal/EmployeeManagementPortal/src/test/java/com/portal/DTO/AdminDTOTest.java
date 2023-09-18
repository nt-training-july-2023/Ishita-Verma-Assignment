package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;

class AdminDTOTest {

	private AdminDTO adminDTO;

    @BeforeEach
    public void setUp() {
        adminDTO = new AdminDTO();
    }

    @Test
    public void testAdminDTOProperties() {
        adminDTO.setId(1);
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

        assertEquals(1, adminDTO.getId());
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
    }

    

}
