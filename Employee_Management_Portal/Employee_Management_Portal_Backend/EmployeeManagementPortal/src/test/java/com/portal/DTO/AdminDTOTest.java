package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdminDTOTest {
	 @Test
	    public void testGetters() {
	        AdminDTO adminDto = new AdminDTO(1,"N001","Ankita Sharma" ,"ankita.sharma@nucleusteq.com", "20-06-1998", "02-01-2023", "Raipur", "Head", 987654321, "Ankita@123", "Ankita@123");
	        assertEquals(1, adminDto.getAdminId());
	        assertEquals("Ankita Sharma", adminDto.getName());
	        assertEquals("ankita.sharma@nucleusteq.com", adminDto.getEmail());
	        assertEquals("N001", adminDto.getEmpId());
	        assertEquals("20-06-1998", adminDto.getDob());
	        assertEquals("02-01-2023", adminDto.getDoj());
	        assertEquals("Raipur", adminDto.getLocation());
	        assertEquals("Head", adminDto.getDesignation());
	        assertEquals(987654321, adminDto.getContactNumber());
	        assertEquals("Ankita@123", adminDto.getPassword());
	        assertEquals("Ankita@123", adminDto.getConfirmPassword());
	    }
	    @Test
	    public void testSetters() {
	    	AdminDTO adminDTO = new AdminDTO(1,"N001","Ankita sharma" ,"ankita.sharma@nucleusteq.com", "20-06-1998", "02-01-2023", "Raipur", "Head", 987654321, "Ankita@123", "Ankita@123");
	        adminDTO.setName("Ankita Sharma");
	        adminDTO.setEmail("ankita.sharma@nucleusteq.com");
	        adminDTO.setEmpId("N001");
	        adminDTO.setDob("20-06-1998");
	        adminDTO.setDoj("02-01-2023");
	        adminDTO.setLocation("Raipur");
	        adminDTO.setDesignation("Head");
	        adminDTO.setContactNumber(987654321);
	        adminDTO.setPassword("Ankita@123");
	        adminDTO.setConfirmPassword("Ankita@123");
	        assertEquals("Ankita Sharma", adminDTO.getName());
	        assertEquals("ankita.sharma@nucleusteq.com", adminDTO.getEmail());
	        assertEquals("N001", adminDTO.getEmpId());
	        assertEquals("20-06-1998", adminDTO.getDob());
	        assertEquals("02-01-2023", adminDTO.getDoj());
	        assertEquals("Raipur", adminDTO.getLocation());
	        assertEquals("Head", adminDTO.getDesignation());
	        assertEquals(987654321, adminDTO.getContactNumber());
	        assertEquals("Ankita@123", adminDTO.getPassword());
	        assertEquals("Ankita@123", adminDTO.getConfirmPassword());
	    }
	}