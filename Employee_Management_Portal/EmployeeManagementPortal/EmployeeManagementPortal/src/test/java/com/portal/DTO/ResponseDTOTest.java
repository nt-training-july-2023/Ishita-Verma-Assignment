package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResponseDTOTest {
    @Test
    public void testGetterAndSetterMethods() {
        // Create a new ResponseDTO object
        ResponseDTO responseDTO = new ResponseDTO();

        // Set values using setter methods
        responseDTO.setMessage("Test Message");
        responseDTO.setRole("Test Role");

        // Use getter methods to retrieve values
        assertEquals("Test Message", responseDTO.getMessage());
        assertEquals("Test Role", responseDTO.getRole());
    }

    @Test
    public void testHashCodeMethod() {
        ResponseDTO responseDTO1 = new ResponseDTO();
        responseDTO1.setMessage("Message");
        responseDTO1.setRole("ADMIN");

        ResponseDTO responseDTO2 = new ResponseDTO();
        responseDTO2.setMessage("Message");
        responseDTO2.setRole("ADMIN");

        assertEquals(responseDTO1.hashCode(), responseDTO2.hashCode());
    }

    @Test
    public void testEqualsMethod() {
        ResponseDTO responseDTO1 = new ResponseDTO();
        responseDTO1.setMessage("Message1");
        responseDTO1.setRole("Role1");

        ResponseDTO responseDTO2 = new ResponseDTO();
        responseDTO2.setMessage("Message1");
        responseDTO2.setRole("Role1");

        assertTrue(responseDTO1.equals(responseDTO2));
    }

    @Test
    public void testToStringMethod() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Test Message");
        responseDTO.setRole("Test Role");

        assertEquals("ResponseDTO [message=Test Message, role=Test Role]", responseDTO.toString());
    }
}
