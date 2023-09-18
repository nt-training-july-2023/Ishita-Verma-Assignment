package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResponseDTOTest {

	private ResponseDTO responseDTO1;
    private ResponseDTO responseDTO2;

    @BeforeEach
    void setUp() {
        responseDTO1 = new ResponseDTO();
        responseDTO1.setMessage("Success");
        responseDTO1.setRole("Admin");

        responseDTO2 = new ResponseDTO("Error", "User");
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("Success", responseDTO1.getMessage());
        assertEquals("Admin", responseDTO1.getRole());

        assertEquals("Error", responseDTO2.getMessage());
        assertEquals("User", responseDTO2.getRole());
    }

    @Test
    void testConstructors() {
        assertEquals("Success", responseDTO1.getMessage());
        assertEquals("Admin", responseDTO1.getRole());

        assertEquals("Error", responseDTO2.getMessage());
        assertEquals("User", responseDTO2.getRole());
    }

}
