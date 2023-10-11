package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.portal.entities.Role;

class LoginOutDTOTest {

    @Test
    public void testGetSetId() {
        LoginOutDTO loginDTO = new LoginOutDTO();
        loginDTO.setId(1L);
        loginDTO.setMessage("Welcome!");
        loginDTO.setRole(Role.ADMIN);
        loginDTO.setName("Ankita");
        
        assertEquals(1L, loginDTO.getId());
        assertEquals("Welcome!", loginDTO.getMessage());
        assertEquals(Role.ADMIN, loginDTO.getRole());
        assertEquals("Ankita", loginDTO.getName());
    }


    @Test
    void testHashCodeAndEquals() {
        LoginOutDTO loginOutDto1 = new LoginOutDTO();
        loginOutDto1.setName("Employee");
        loginOutDto1.setMessage("Success");
        loginOutDto1.setRole(Role.ADMIN);
        
        LoginOutDTO loginOutDto2 = new LoginOutDTO();
        loginOutDto2.setName("Employee");
        loginOutDto2.setMessage("Success");
        loginOutDto2.setRole(Role.ADMIN);
        
        assertTrue(loginOutDto1.equals(loginOutDto1));
        assertFalse(loginOutDto1.equals(null));
        assertFalse(loginOutDto1.equals(""));
        
        assertEquals(loginOutDto1.hashCode(),loginOutDto2.hashCode());
        assertTrue(loginOutDto1.equals(loginOutDto2));
        
        loginOutDto2.setName("Praveen");
        assertFalse(loginOutDto1.equals(loginOutDto2));
        assertNotEquals(loginOutDto1.hashCode(),loginOutDto2.hashCode());
        
        loginOutDto2.setName("Hemant");
        loginOutDto2.setMessage("Fail");
        assertFalse(loginOutDto1.equals(loginOutDto2));
        assertNotEquals(loginOutDto1.hashCode(),loginOutDto2.hashCode());
        
        loginOutDto2.setMessage("Success");
        loginOutDto2.setRole(Role.EMPLOYEE);
        assertFalse(loginOutDto1.equals(loginOutDto2));
        assertNotEquals(loginOutDto1.hashCode(),loginOutDto2.hashCode());
        
    }

    @Test
    public void testToString() {
        LoginOutDTO loginDTO = new LoginOutDTO();
        loginDTO.setId(1L);
        loginDTO.setMessage("Welcome!");
        loginDTO.setName("Ankita");
        loginDTO.setRole(Role.ADMIN);

        String expected = "LoginOutDTO [message=Welcome!, role=ADMIN, name=Ankita, id=1]";
        assertEquals(expected, loginDTO.toString());
    }

}
