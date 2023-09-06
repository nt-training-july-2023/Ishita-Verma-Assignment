package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdminTest {

	@Test
    public void testAdminEntity() {
        long adminId = 1L;
        String empId = "N001";
        String name = "Ankita Sharma";
        String email = "ankita.sharma@example.com";
        String dob = "1990-01-01";
        String doj = "2023-01-01";
        Location location = Location.Raipur;
        Designation designation = Designation.Recruiter;
        long contactNumber = 9876543210L;
        Role role = Role.ADMIN;
        String password = "password123";
        String confirmPassword = "password123";

        Admin admin = new Admin();
        admin.setAdminId(adminId);
        admin.setEmpId(empId);
        admin.setName(name);
        admin.setEmail(email);
        admin.setDob(dob);
        admin.setDoj(doj);
        admin.setLocation(location);
        admin.setDesignation(designation);
        admin.setContactNumber(contactNumber);
        admin.setRole(role);
        admin.setPassword(password);
        admin.setConfirmPassword(confirmPassword);

        assertEquals(adminId, admin.getAdminId());
        assertEquals(empId, admin.getEmpId());
        assertEquals(name, admin.getName());
        assertEquals(email, admin.getEmail());
        assertEquals(dob, admin.getDob());
        assertEquals(doj, admin.getDoj());
        assertEquals(location, admin.getLocation());
        assertEquals(designation, admin.getDesignation());
        assertEquals(contactNumber, admin.getContactNumber());
        assertEquals(role, admin.getRole());
        assertEquals(password, admin.getPassword());
        assertEquals(confirmPassword, admin.getConfirmPassword());
    }
	
	 @Test
	    public void testAdminId() {
	        Admin admin = new Admin();
	        admin.setAdminId(2L);
	        assertEquals(2L, admin.getAdminId());
	    }

	    @Test
	    public void testEmpId() {
	        Admin admin = new Admin();
	        admin.setEmpId("N002");
	        assertEquals("N002", admin.getEmpId());
	    }

	    @Test
	    public void testName() {
	        Admin admin = new Admin();
	        admin.setName("John Doe");
	        assertEquals("John Doe", admin.getName());
	    }

	    @Test
	    public void testEmail() {
	        Admin admin = new Admin();
	        admin.setEmail("john.doe@example.com");
	        assertEquals("john.doe@example.com", admin.getEmail());
	    }

	    @Test
	    public void testLocation() {
	        Admin admin = new Admin();
	        admin.setLocation(Location.Bangalore);
	        assertEquals(Location.Bangalore, admin.getLocation());
	    }

	    
	    @Test
	    public void testDesignation() {
	        Admin admin = new Admin();
	        admin.setDesignation(Designation.Engineer);
	        assertEquals(Designation.Engineer, admin.getDesignation());
	    }

	    
	    @Test
	    public void testRole() {
	        Admin admin = new Admin();
	        admin.setRole(Role.USER);
	        assertEquals(Role.USER, admin.getRole());
	    }

	   
	    @Test
	    public void testContactNumber() {
	        Admin admin = new Admin();
	        admin.setContactNumber(1234567890L);
	        assertEquals(1234567890L, admin.getContactNumber());
	    }
	    
	    @Test
	    public void testDob() {
	        Admin admin = new Admin();
	        admin.setDob("1995-06-15");
	        assertEquals("1995-06-15", admin.getDob());
	    }

	   
	    @Test
	    public void testDoj() {
	        Admin admin = new Admin();
	        admin.setDoj("2022-03-01");
	        assertEquals("2022-03-01", admin.getDoj());
	    }

	    @Test
	    public void testPassword() {
	        Admin admin = new Admin();
	        admin.setPassword("securePassword");
	        assertEquals("securePassword", admin.getPassword());
	    }

	    @Test
	    public void testConfirmPassword() {
	        Admin admin = new Admin();
	        admin.setConfirmPassword("securePassword");
	        assertEquals("securePassword", admin.getConfirmPassword());
	    }

	   

	    

}
