package com.portal.DTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiResponseDTOTest {

    @Test
    public void testApiResponseDTOGetters() {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setMessage("Success");
        assertEquals("Success", apiResponseDTO.getMessage());
    }

    @Test
    void testHashCode() {
        ApiResponseDTO apiResponseDTO1 = new ApiResponseDTO();
        ApiResponseDTO apiResponseDTO2 = new ApiResponseDTO();

        // Both objects have the same message
        apiResponseDTO1.setMessage("Success");
        apiResponseDTO2.setMessage("Success");

        assertEquals(apiResponseDTO1.hashCode(), apiResponseDTO2.hashCode());

        // Change message in the second object
        apiResponseDTO2.setMessage("Failure");

        assertNotEquals(apiResponseDTO1.hashCode(), apiResponseDTO2.hashCode());
    }

    @Test
    void testEquals() {
        ApiResponseDTO apiResponseDTO1 = new ApiResponseDTO();
        ApiResponseDTO apiResponseDTO2 = new ApiResponseDTO();
        ApiResponseDTO apiResponseDTO3 = new ApiResponseDTO();

        // Both objects have the same message
        apiResponseDTO1.setMessage("Success");
        apiResponseDTO2.setMessage("Success");

        assertTrue(apiResponseDTO1.equals(apiResponseDTO2));
        assertTrue(apiResponseDTO2.equals(apiResponseDTO1));

        // Change message in the second object
        apiResponseDTO2.setMessage("Failure");

        assertFalse(apiResponseDTO1.equals(apiResponseDTO2));
        assertFalse(apiResponseDTO2.equals(apiResponseDTO1));

        // Both objects have null messages
        apiResponseDTO1.setMessage(null);
        apiResponseDTO2.setMessage(null);

        assertTrue(apiResponseDTO1.equals(apiResponseDTO2));
        assertTrue(apiResponseDTO2.equals(apiResponseDTO1));

        // One object has a null message and the other has a non-null message
        apiResponseDTO2.setMessage("Non-null message");

        assertFalse(apiResponseDTO1.equals(apiResponseDTO2));
        assertFalse(apiResponseDTO2.equals(apiResponseDTO1));

        // Both objects have different non-null messages
        apiResponseDTO1.setMessage("Message 1");
        apiResponseDTO2.setMessage("Message 2");

        assertFalse(apiResponseDTO1.equals(apiResponseDTO2));
        assertFalse(apiResponseDTO2.equals(apiResponseDTO1));

        // Comparing with a different object type (should return false)
        assertFalse(apiResponseDTO1.equals("String"));

        // Comparing with null (should return false)
        assertFalse(apiResponseDTO1.equals(null));

        // Explicitly test this == obj
        assertTrue(apiResponseDTO1.equals(apiResponseDTO1));
    }

    @Test
    public void testApiResponseDTOToString() {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setMessage("Success");

        String expectedToString = "ApiResponseDTO [message=Success]";
        assertEquals(expectedToString, apiResponseDTO.toString());
    }
}
