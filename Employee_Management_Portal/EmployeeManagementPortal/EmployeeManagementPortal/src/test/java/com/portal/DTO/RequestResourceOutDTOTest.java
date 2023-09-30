package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequestResourceDTOTest {

	    @Test
	    void testGetterSetter() {
	        RequestResourceInDTO dto = new RequestResourceInDTO();
	        dto.setComment("This is a comment.");
	        dto.setManagerId(1L);
	        dto.setEmployeeId(2L);
	        dto.setProjectId(3L);
	        
	        assertEquals("This is a comment.", dto.getComment());
	        assertEquals(1L, dto.getManagerId());
	        assertEquals(2L, dto.getEmployeeId());
	        assertEquals(3L, dto.getProjectId());
	    }

	    @Test
	    void testHashCode() {
	        RequestResourceInDTO dto1 = new RequestResourceInDTO();
	        RequestResourceInDTO dto2 = new RequestResourceInDTO();

	        assertEquals(dto1.hashCode(), dto2.hashCode());

	        dto1.setComment("Comment1");
	        dto2.setComment("Comment1");
	        dto1.setEmployeeId(1L);
	        dto2.setEmployeeId(1L);
	        dto1.setManagerId(2L);
	        dto2.setManagerId(2L);
	        dto1.setProjectId(3L);
	        dto2.setProjectId(3L);

	        assertEquals(dto1.hashCode(), dto2.hashCode());

	        dto2.setProjectId(4L);

	        assertNotEquals(dto1.hashCode(), dto2.hashCode());
	    }

	    @Test
	    void testEquals() {
	        RequestResourceInDTO dto1 = new RequestResourceInDTO();
	        RequestResourceInDTO dto2 = new RequestResourceInDTO();

	        assertEquals(dto1, dto2);
	        assertEquals(dto1, dto1);

	        dto1.setComment("Comment1");
	        dto2.setComment("Comment1");
	        dto1.setEmployeeId(1L);
	        dto2.setEmployeeId(1L);
	        dto1.setManagerId(2L);
	        dto2.setManagerId(2L);
	        dto1.setProjectId(3L);
	        dto2.setProjectId(3L);

	        assertEquals(dto1, dto2);

	        dto2.setProjectId(4L);

	        assertNotEquals(dto1, dto2);

	        assertNotEquals(dto1, null);
	        assertNotEquals(dto1, "NotADTOObject");
	    }
	}

