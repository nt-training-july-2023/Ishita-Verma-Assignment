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
    public void testHashCode() {
        LoginOutDTO loginDTO1 = new LoginOutDTO();
        loginDTO1.setId(1L);
        loginDTO1.setMessage("Welcome!");
        loginDTO1.setName("Ankita");
        loginDTO1.setRole(Role.ADMIN);

        LoginOutDTO loginDTO2 = new LoginOutDTO();
        loginDTO2.setId(1L);
        loginDTO2.setMessage("Welcome!");
        loginDTO2.setName("Ankita");
        loginDTO2.setRole(Role.ADMIN);

        assertEquals(loginDTO1.hashCode(), loginDTO2.hashCode());
    }

    @Test
    public void testEquals() {
        LoginOutDTO loginDTO1 = new LoginOutDTO();
        loginDTO1.setId(1L);
        loginDTO1.setMessage("Welcome!");
        loginDTO1.setName("Ankita");
        loginDTO1.setRole(Role.ADMIN);

        LoginOutDTO loginDTO2 = new LoginOutDTO();
        loginDTO2.setId(1L);
        loginDTO2.setMessage("Welcome!");
        loginDTO2.setName("Ankita");
        loginDTO2.setRole(Role.ADMIN);

        assertTrue(loginDTO1.equals(loginDTO2));
        assertTrue(loginDTO2.equals(loginDTO1));

        loginDTO2.setRole(Role.EMPLOYEE);

        assertFalse(loginDTO1.equals(loginDTO2));
        assertFalse(loginDTO2.equals(loginDTO1));
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
