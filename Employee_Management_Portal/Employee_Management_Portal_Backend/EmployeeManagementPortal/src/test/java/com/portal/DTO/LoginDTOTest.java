package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginDTOTest {

	@Test
    public void testGetters() {
        LoginDTO loginDto = new LoginDTO();
        loginDto.setEmail("ankita.sharma@nucleusteq.com");
        loginDto.setPassword("Ankita123@");

        assertEquals("ankita.sharma@nucleusteq.com", loginDto.getEmail());
        assertEquals("Ankita123@", loginDto.getPassword());
    }

    @Test
    public void testSetters() {
        LoginDTO loginDto = new LoginDTO();
        loginDto.setEmail("ankita.sharma@nucleusteq.com");
        loginDto.setPassword("Ankita123@");

        assertEquals("ankita.sharma@nucleusteq.com", loginDto.getEmail());
        assertEquals("Ankita123@", loginDto.getPassword());
	
    }
    
    @Test
    public void testEmptyEmail() {
        LoginDTO loginDto = new LoginDTO();
        loginDto.setEmail("");
        loginDto.setPassword("Ankita123@");

        assertEquals("", loginDto.getEmail());
        assertEquals("Ankita123@", loginDto.getPassword());
    }

    @Test
    public void testNullEmail() {
        LoginDTO loginDto = new LoginDTO();
        loginDto.setEmail(null);
        loginDto.setPassword("Ankita123@");

        assertNull(loginDto.getEmail());
        assertEquals("Ankita123@", loginDto.getPassword());
    }

    @Test
    public void testPasswordWithSpecialCharacters() {
        LoginDTO loginDto = new LoginDTO();
        loginDto.setEmail("ankita.sharma@nucleusteq.com");
        loginDto.setPassword("Password@123");

        assertEquals("ankita.sharma@nucleusteq.com", loginDto.getEmail());
        assertEquals("Password@123", loginDto.getPassword());
    }

    @Test
    public void testLongPassword() {
        LoginDTO loginDto = new LoginDTO();
        loginDto.setEmail("ankita.sharma@nucleusteq.com");
        loginDto.setPassword("LongPassword1234567890@");

        assertEquals("ankita.sharma@nucleusteq.com", loginDto.getEmail());
        assertEquals("LongPassword1234567890@", loginDto.getPassword());
    }
    
    @Test
    public void testPasswordWithNoSpecialCharacters() {
        LoginDTO loginDto = new LoginDTO();
        loginDto.setEmail("user@example.com");
        loginDto.setPassword("Password123");

        assertEquals("user@example.com", loginDto.getEmail());
        assertEquals("Password123", loginDto.getPassword());
    }

    @Test
    public void testEmailWithUpperCaseCharacters() {
        LoginDTO loginDto = new LoginDTO();
        loginDto.setEmail("USER@EXAMPLE.COM");
        loginDto.setPassword("Password@123");

        assertEquals("USER@EXAMPLE.COM", loginDto.getEmail());
        assertEquals("Password@123", loginDto.getPassword());
    }
}
