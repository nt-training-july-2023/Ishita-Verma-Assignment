package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginInDTOTest {
    
	 @Test
	    void testGetSetEmail() {
	        // Create a LoginInDTO object
	        LoginInDTO loginDTO = new LoginInDTO();
            loginDTO.setEmail("ankita.sharma@nucleusteq.com");
            loginDTO.setPassword("admin123");
	        assertEquals("ankita.sharma@nucleusteq.com", loginDTO.getEmail());
	        assertEquals("admin123",loginDTO.getPassword());
	    }

	 @Test
	    void testValidHashCodeAndEquals() {
	        LoginInDTO loginDto1 = new LoginInDTO();
	        loginDto1.setEmail("hemant@nucleusteq.com");
	        loginDto1.setPassword("password123");
	        
	        LoginInDTO loginDto2 = new LoginInDTO();
	        loginDto2.setEmail("hemant@nucleusteq.com");
	        loginDto2.setPassword("password123");
	        
	        assertTrue(loginDto1.equals(loginDto1));
	        assertFalse(loginDto1.equals(null));
	        assertFalse(loginDto1.equals(""));
	        
	        assertEquals(loginDto2, loginDto1);
	        assertEquals(loginDto2.hashCode(), loginDto1.hashCode());
	        
	        loginDto2.setEmail("praveen@nucleusteq.com");
	        assertFalse(loginDto1.equals(loginDto2));
	        assertNotEquals(loginDto1.hashCode(), loginDto2.hashCode());
	        
	        loginDto2.setEmail("hemant@nucleusteq.com");
	        loginDto2.setPassword("password456");
	        assertFalse(loginDto1.equals(loginDto2));
	        assertNotEquals(loginDto1.hashCode(), loginDto2.hashCode());
	    }

    @Test
    void testToString() {
        LoginInDTO loginDTO1 = new LoginInDTO();
        loginDTO1.setEmail(null);
        loginDTO1.setPassword(null);

        LoginInDTO loginDTO2 = new LoginInDTO();
        loginDTO2.setEmail("user@example.com");
        loginDTO2.setPassword("password123");

        LoginInDTO loginDTO3 = new LoginInDTO();
        loginDTO3.setEmail(null);
        loginDTO3.setPassword(null);

            assertEquals("LoginInDTO [email=null, password=null]", loginDTO1.toString());
            assertEquals("LoginInDTO [email=user@example.com, password=password123]", loginDTO2.toString());
            assertEquals("LoginInDTO [email=null, password=null]", loginDTO3.toString());
        }
}
