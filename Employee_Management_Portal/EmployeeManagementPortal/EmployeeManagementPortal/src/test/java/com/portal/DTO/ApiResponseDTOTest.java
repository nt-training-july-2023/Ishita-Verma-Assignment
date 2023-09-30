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
    public void testApiResponseDTOEqualsAndHashCode() {
        ApiResponseDTO apiResponseDTO1 = new ApiResponseDTO();
        apiResponseDTO1.setMessage("Success");
        ApiResponseDTO apiResponseDTO2 = new ApiResponseDTO();
        apiResponseDTO2.setMessage("Success");

        assertEquals(apiResponseDTO1, apiResponseDTO2);
        assertEquals(apiResponseDTO1.hashCode(), apiResponseDTO2.hashCode());
    }

    @Test
    public void testApiResponseDTOToString() {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setMessage("Success");

        String expectedToString = "ApiResponseDTO [message=Success]";
        assertEquals(expectedToString, apiResponseDTO.toString());
    }
}
