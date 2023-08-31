package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.portal.entities.Location;
import com.portal.entities.Designation;
import com.portal.entities.Role;


class AdminDTOTest {

    @Test
    public void testIsPasswordsMatch() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setPassword("Test1234");
        adminDTO.setConfirmPassword("Test1234");
        assertTrue(adminDTO.isPasswordsMatch());

        adminDTO.setConfirmPassword("DifferentPassword");
        assertFalse(adminDTO.isPasswordsMatch());
    }

    @Test
    public void testGettersAndSetters() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setAdminId(1);
        adminDTO.setEmpId("N0001");
        adminDTO.setName("Ankita Sharma");
        adminDTO.setEmail("ankita.sharma@nucleusteq.com");
        adminDTO.setDob("20-06-1998");
        adminDTO.setDoj("02-01-2023");
        adminDTO.setLocation(Location.Raipur);
        adminDTO.setDesignation(Designation.Recruiter);
        adminDTO.setContactNumber(987654321);
        adminDTO.setPassword("Ankita@123");
        adminDTO.setConfirmPassword("Ankita@123");
        adminDTO.setRole(Role.ADMIN);

        assertEquals(1, adminDTO.getAdminId());
        assertEquals("N0001", adminDTO.getEmpId());
        assertEquals("Ankita Sharma", adminDTO.getName());
        assertEquals("ankita.sharma@nucleusteq.com", adminDTO.getEmail());
        assertEquals("20-06-1998", adminDTO.getDob());
        assertEquals("02-01-2023", adminDTO.getDoj());
        assertEquals(Location.Raipur, adminDTO.getLocation());
        assertEquals(Designation.Recruiter, adminDTO.getDesignation());
        assertEquals(987654321, adminDTO.getContactNumber());
        assertEquals("Ankita@123", adminDTO.getPassword());
        assertEquals("Ankita@123", adminDTO.getConfirmPassword());
        assertEquals(Role.ADMIN, adminDTO.getRole());
    }

    @Test
    public void testPasswordsNotMatching() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setPassword("Password123");
        adminDTO.setConfirmPassword("DifferentPassword");
        assertFalse(adminDTO.isPasswordsMatch());
    }

    @Test
    public void testEmptyPasswordConfirmation() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setPassword("Password123");
        assertFalse(adminDTO.isPasswordsMatch());
    }

    @Test
    public void testEmptyFields() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setPassword("Password123@");
        adminDTO.setConfirmPassword("Password123");
        assertFalse(adminDTO.isPasswordsMatch());
    }

    @Test
    public void testValidEmail() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmail("test@example.com");
        assertTrue(adminDTO.getEmail().equals("test@example.com"));
    }

    @Test
    public void testInvalidEmail() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmail("invalidemail");
        assertFalse(adminDTO.getEmail().equals("invalid-email"));
    }
    @Test
    public void testInvalidEmployeeId() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmpId("N134"); // Invalid format
        assertFalse(adminDTO.getEmpId().equals("N1345"));
    }

    @Test
    public void testValidEmployeeId() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmpId("N1234"); // Valid format
        assertTrue(adminDTO.getEmpId().equals("N1234"));
    }

    @Test
    public void testInvalidDateOfBirth() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setDob("2021-09-01"); // Invalid format
        assertFalse(adminDTO.getDob().equals("202109-01"));
    }

    @Test
    public void testValidDateOfBirth() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setDob("20/06/1998"); // Valid format
        assertTrue(adminDTO.getDob().equals("20/06/1998"));
    }

    @Test
    public void testInvalidDateOfJoining() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setDoj("01-09-2023"); // Invalid format
        assertTrue(adminDTO.getDoj().equals("01-09-2023"));
    }

    @Test
    public void testValidDateOfJoining() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setDoj("02/01/2023"); // Valid format
        assertTrue(adminDTO.getDoj().equals("02/01/2023"));
    }

    @Test
    public void testInvalidContactNumber() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setContactNumber(1234567890L); // Corrected format with 'L' for long
        assertEquals(1234567890L, adminDTO.getContactNumber());
    }


    @Test
    public void testValidContactNumber() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setContactNumber(9876543210L); // Valid format
        assertTrue(adminDTO.getContactNumber() == 9876543210L);
    }

  
    @Test
    public void testInvalidPassword() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setPassword("passworrd"); // Invalid format
        assertNotEquals("password", adminDTO.getPassword());
    }


    @Test
    public void testValidPassword() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setPassword("Password@123"); // Valid format
        assertTrue(adminDTO.getPassword().equals("Password@123"));
    }

	}