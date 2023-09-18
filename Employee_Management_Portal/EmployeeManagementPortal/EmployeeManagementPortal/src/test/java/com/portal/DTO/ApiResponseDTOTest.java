package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApiResponseDTOTest {

	 @Test
	    public void testApiResponseDTOConstructorAndGetters() {
	        ApiResponseDTO apiResponseDTO = new ApiResponseDTO("Success");
	        assertEquals("Success", apiResponseDTO.getMessage());
	    }

	    @Test
	    public void testApiResponseDTOEqualsAndHashCode() {
	        ApiResponseDTO apiResponseDTO1 = new ApiResponseDTO("Success");
	        ApiResponseDTO apiResponseDTO2 = new ApiResponseDTO("Success");

	        assertEquals(apiResponseDTO1, apiResponseDTO2);
	        assertEquals(apiResponseDTO1.hashCode(), apiResponseDTO2.hashCode());
	    }

	    @Test
	    public void testApiResponseDTOToString() {
	        ApiResponseDTO apiResponseDTO = new ApiResponseDTO("Success");

	        String expectedToString = "ApiResponseDTO [message=Success]";
	        assertEquals(expectedToString, apiResponseDTO.toString());
	    }

}
