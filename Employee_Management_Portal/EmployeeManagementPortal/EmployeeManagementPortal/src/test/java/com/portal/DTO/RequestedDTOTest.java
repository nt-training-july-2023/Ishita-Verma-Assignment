package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequestedDTOTest {

    @Test
    public void getterAndSetter() {
        RequestedDTO requestedDTO = new RequestedDTO();
        requestedDTO.setEmployeeId(1L);
        requestedDTO.setManagerEmail("ankita.sharma@nucleusteq.com");
        assertEquals(1L,requestedDTO.getEmployeeId());
        assertEquals("ankita.sharma@nucleusteq.com",requestedDTO.getManagerEmail());
        }
   
    @Test
    public void testHashCode() {
        // Create two RequestedDTO objects with the same values
        RequestedDTO requestedDTO1 = new RequestedDTO();
        requestedDTO1.setEmployeeId(456L);
        requestedDTO1.setManagerEmail("manager@example.com");

        RequestedDTO requestedDTO2 = new RequestedDTO();
        requestedDTO2.setEmployeeId(456L);
        requestedDTO2.setManagerEmail("manager@example.com");

        // Test hashCode method
        assertEquals(requestedDTO1.hashCode(), requestedDTO2.hashCode());
    }

    @Test
    public void testEquals() {
        // Create two RequestedDTO objects with the same values
        RequestedDTO requestedDTO1 = new RequestedDTO();
        requestedDTO1.setEmployeeId(9L);
        requestedDTO1.setManagerEmail("manager@example.com");

        RequestedDTO requestedDTO2 = new RequestedDTO();
        requestedDTO2.setEmployeeId(9L);
        requestedDTO2.setManagerEmail("manager@example.com");

        // Test equals method
        assertTrue(requestedDTO1.equals(requestedDTO2));
        assertTrue(requestedDTO2.equals(requestedDTO1));
        assertEquals(requestedDTO1.hashCode(), requestedDTO2.hashCode());

        // Create two RequestedDTO objects with different employeeId values
        RequestedDTO requestedDTO3 = new RequestedDTO();
        requestedDTO3.setEmployeeId(123L);
        requestedDTO3.setManagerEmail("manager@example.com");

        // Test equals method for objects with different employeeId values
        assertFalse(requestedDTO1.equals(requestedDTO3));
        assertFalse(requestedDTO3.equals(requestedDTO1));
        assertNotEquals(requestedDTO1.hashCode(), requestedDTO3.hashCode());

        // Create two RequestedDTO objects with different managerEmail values
        RequestedDTO requestedDTO4 = new RequestedDTO();
        requestedDTO4.setEmployeeId(9L);
        requestedDTO4.setManagerEmail("anothermanager@example.com");

        // Test equals method for objects with different managerEmail values
        assertFalse(requestedDTO1.equals(requestedDTO4));
        assertFalse(requestedDTO4.equals(requestedDTO1));
        assertNotEquals(requestedDTO1.hashCode(), requestedDTO4.hashCode());

        // Test equals method for null and non-RequestDTO object
        assertFalse(requestedDTO1.equals(null));
//        assertFalse(requestedDTO1.equals("Not a RequestedDTO"));

        // Test equals method for comparing an object to itself
        assertTrue(requestedDTO1.equals(requestedDTO1));
    }

    @Test
    public void testToString() {
        // Create a RequestedDTO object
        RequestedDTO requestedDTO = new RequestedDTO();
        requestedDTO.setEmployeeId(987L);
        requestedDTO.setManagerEmail("manager@example.com");

        // Test toString method
        String expectedToString = "RequestedDTO [employeeId=987, managerEmail=manager@example.com]";
        assertEquals(expectedToString, requestedDTO.toString());
    }
}
