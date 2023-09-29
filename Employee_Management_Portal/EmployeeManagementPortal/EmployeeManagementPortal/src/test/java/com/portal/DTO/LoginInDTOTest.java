package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginInDTOTest {

	private LoginInDTO loginDTO1;
    private LoginInDTO loginDTO2;
    private LoginInDTO loginDTO3;
	 @BeforeEach
	    void setUp() {
	        loginDTO1 = new LoginInDTO();
	        loginDTO1.setEmail(null);
	        loginDTO1.setPassword(null);

	        loginDTO2 = new LoginInDTO();
	        loginDTO2.setEmail("user@example.com");
	        loginDTO2.setPassword("password123");

	        loginDTO3 = new LoginInDTO();
	        loginDTO3.setEmail(null);
	        loginDTO3.setPassword(null);
	    }
	@Test
    void testGetSetEmail() {
        LoginInDTO loginDTO = new LoginInDTO();
        loginDTO.setEmail("ankita.sharma@nucleusteq.com");
        assertEquals("ankita.sharma@nucleusteq.com", loginDTO.getEmail());
    }

    @Test
    void testGetSetPassword() {
        LoginInDTO loginDTO = new LoginInDTO();
        loginDTO.setPassword("password");
        assertEquals("password", loginDTO.getPassword());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two LoginDTO objects with the same values
        LoginInDTO loginDTO1 = new LoginInDTO();
        loginDTO1.setEmail("pranjal@nucleusteq.com");
        loginDTO1.setPassword("password");

        LoginInDTO loginDTO2 = new LoginInDTO();
        loginDTO2.setEmail("pranjal@nucleusteq.com");
        loginDTO2.setPassword("password");

        // Test equals method
        assertEquals(loginDTO1, loginDTO2);
        assertEquals(loginDTO2, loginDTO1);

        // Test hashCode method
        assertEquals(loginDTO1.hashCode(), loginDTO2.hashCode());

        // Change one field to make them not equal
        loginDTO2.setEmail("vanshika@nucleusteq.com");
        assertNotEquals(loginDTO1, loginDTO2);
        assertNotEquals(loginDTO2, loginDTO1);

    }
    @Test
    void testToString() {
    	assertEquals("LoginDTO [email=null, password=null]", loginDTO1.toString());
    	assertEquals("LoginDTO [email=user@example.com, password=password123]", loginDTO2.toString());
    	assertEquals("LoginDTO [email=null, password=null]", loginDTO3.toString());
    }

}
