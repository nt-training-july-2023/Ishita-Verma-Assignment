package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ResponseDTOTest {

    @Test
    public void testConstructorAndGetters() {
        String message = "Success";
        Object data = new Object();
        int status = 200;

        ResponseDTO responseDto = new ResponseDTO(message, data, status);

        assertEquals(message, responseDto.getMessage());
        assertEquals(data, responseDto.getData());
        assertEquals(status, responseDto.getStatus());
    }

    @Test
    public void testSetters() {
        ResponseDTO responseDto = new ResponseDTO();

        String message = "Error";
        Object data = null;
        int status = 404;

        responseDto.setMessage(message);
        responseDto.setData(data);
        responseDto.setStatus(status);

        assertEquals(message, responseDto.getMessage());
        assertEquals(data, responseDto.getData());
        assertEquals(status, responseDto.getStatus());
    }


    @Test
    public void testNotEquals() {
        ResponseDTO responseDto1 = new ResponseDTO("Success", null, 200);
        ResponseDTO responseDto2 = new ResponseDTO("Error", null, 404);

        assertNotEquals(responseDto1, responseDto2);
        assertNotEquals(responseDto1.hashCode(), responseDto2.hashCode());
    }

    @Test
    public void testToString() {
        ResponseDTO responseDto = new ResponseDTO("Success", null, 200);

        String expectedToString = "ResponseDTO(message=Success, data=null, status=200)";
        assertNotEquals(expectedToString, responseDto.toString());
    }

    @Test
    public void testMessageIsNull() {
        ResponseDTO responseDto = new ResponseDTO(null, "Some data", 200);

        assertNull(responseDto.getMessage());
        assertEquals("Some data", responseDto.getData());
        assertEquals(200, responseDto.getStatus());
    }

    @Test
    public void testDataIsNull() {
        ResponseDTO responseDto = new ResponseDTO("Success", null, 200);

        assertEquals("Success", responseDto.getMessage());
        assertNull(responseDto.getData());
        assertEquals(200, responseDto.getStatus());
    }

    

}
