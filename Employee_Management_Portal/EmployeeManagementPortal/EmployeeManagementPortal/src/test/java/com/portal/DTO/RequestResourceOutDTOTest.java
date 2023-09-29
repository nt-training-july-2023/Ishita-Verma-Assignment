package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequestResourceDTOTest {

	    private RequestResourceInDTO dto;

	    @BeforeEach
	    void setUp() {
	        dto = new RequestResourceInDTO();
	    }

	    @Test
	    void testGetComment() {
	        assertNull(dto.getComment());
	        String comment = "This is a comment.";
	        dto.setComment(comment);
	        assertEquals(comment, dto.getComment());
	    }

	    @Test
	    void testSetComment() {
	        assertNull(dto.getComment());
	        String comment = "This is a comment.";
	        dto.setComment(comment);
	        assertEquals(comment, dto.getComment());
	    }

	    @Test
	    void testGetManagerId() {
	        assertNull(dto.getManagerId());
	        Long managerId = 1L;
	        dto.setManagerId(managerId);
	        assertEquals(managerId, dto.getManagerId());
	    }

	    @Test
	    void testSetManagerId() {
	        assertNull(dto.getManagerId());
	        Long managerId = 1L;
	        dto.setManagerId(managerId);
	        assertEquals(managerId, dto.getManagerId());
	    }

	    @Test
	    void testGetEmployeeId() {
	        assertNull(dto.getEmployeeId());
	        Long employeeId = 2L;
	        dto.setEmployeeId(employeeId);
	        assertEquals(employeeId, dto.getEmployeeId());
	    }

	    @Test
	    void testSetEmployeeId() {
	        assertNull(dto.getEmployeeId());
	        Long employeeId = 2L;
	        dto.setEmployeeId(employeeId);
	        assertEquals(employeeId, dto.getEmployeeId());
	    }

	    @Test
	    void testGetProjectId() {
	        assertNull(dto.getProjectId());
	        Long projectId = 3L;
	        dto.setProjectId(projectId);
	        assertEquals(projectId, dto.getProjectId());
	    }

	    @Test
	    void testSetProjectId() {
	        assertNull(dto.getProjectId());
	        Long projectId = 3L;
	        dto.setProjectId(projectId);
	        assertEquals(projectId, dto.getProjectId());
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

