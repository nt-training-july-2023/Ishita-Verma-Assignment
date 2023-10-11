package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequestResourceDTOTest {

    @Test
    public void testGettersAndSetters() {
        RequestResourceOutDTO requestResourceOutDto = new RequestResourceOutDTO();
        requestResourceOutDto.setId(1L);
        requestResourceOutDto.setEmpId(101L);
        requestResourceOutDto.setManagerId(201L);
        requestResourceOutDto.setProjectId(301L);
        requestResourceOutDto.setComment("This is a comment.");
        requestResourceOutDto.setEmployeeName("Hemant");
        requestResourceOutDto.setProjectName("EMS");
        requestResourceOutDto.setManagerName("Ankita");

        assertEquals(1L, requestResourceOutDto.getId());
        assertEquals(101L, requestResourceOutDto.getEmpId());
        assertEquals(201L, requestResourceOutDto.getManagerId());
        assertEquals(301L, requestResourceOutDto.getProjectId());
        assertEquals("This is a comment.", requestResourceOutDto.getComment());
        assertEquals("Hemant", requestResourceOutDto.getEmployeeName());
        assertEquals("EMS", requestResourceOutDto.getProjectName());
        assertEquals("Ankita", requestResourceOutDto.getManagerName());
    }

    @Test
    public void testEqualsAndHashcode() {
        RequestResourceOutDTO request1 = new RequestResourceOutDTO();
        request1.setId(1L);
        request1.setEmpId(101L);
        request1.setManagerId(201L);
        request1.setProjectId(301L);
        request1.setComment("This is a comment.");
        request1.setEmployeeName("Hemant");
        request1.setProjectName("NuoData");
        request1.setManagerName("Ankita");

        RequestResourceOutDTO request2 = new RequestResourceOutDTO();
        request2.setId(1L);
        request2.setEmpId(101L);
        request2.setManagerId(201L);
        request2.setProjectId(301L);
        request2.setComment("This is a comment.");
        request2.setEmployeeName("Hemant");
        request2.setProjectName("NuoData");
        request2.setManagerName("Ankita");

        assertTrue(request1.equals(request1));
        assertFalse(request1.equals(null));
        assertFalse(request1.equals(""));
        
        assertTrue(request1.equals(request2));
        assertEquals(request1.hashCode(),request2.hashCode());
        
        request2.setId(2L);
        assertFalse(request1.equals(request2));
        assertNotEquals(request1.hashCode(),request2.hashCode());
        
        request2.setId(1L);
        request2.setEmpId(201L);
        assertFalse(request1.equals(request2));
        assertNotEquals(request1.hashCode(),request2.hashCode());
        
        request2.setEmpId(101L);
        request2.setManagerId(101L);
        assertFalse(request1.equals(request2));
        assertNotEquals(request1.hashCode(),request2.hashCode());
        
        request2.setManagerId(201L);
        request2.setProjectId(201L);
        assertFalse(request1.equals(request2));
        assertNotEquals(request1.hashCode(),request2.hashCode());
        
        request2.setProjectId(301L);
        request2.setComment("This is not a comment.");
        assertFalse(request1.equals(request2));
        assertNotEquals(request1.hashCode(),request2.hashCode());
        
        request2.setComment("This is a comment.");
        request2.setEmployeeName("Praveen");
        assertFalse(request1.equals(request2));
        assertNotEquals(request1.hashCode(),request2.hashCode());
        
        request2.setEmployeeName("Hemant");
        request2.setProjectName("Pet Smart");
        assertFalse(request1.equals(request2));
        assertNotEquals(request1.hashCode(),request2.hashCode());
        
        request2.setProjectName("NuoData");
        request2.setManagerName("Prerna");
        assertFalse(request1.equals(request2));
        assertNotEquals(request1.hashCode(),request2.hashCode());
    }

    @Test
    public void testToString() {
        RequestResourceOutDTO request = new RequestResourceOutDTO();
        request.setId(1L);
        request.setEmpId(101L);
        request.setManagerId(201L);
        request.setProjectId(301L);
        request.setComment("This is a comment.");
        request.setEmployeeName("Hemant");
        request.setProjectName("NuoData");
        request.setManagerName("Ankita");

        String expectedToString = "RequestResourceOutDTO [id=1, comment=This is a comment., managerId=201, empId=101, projectId=301, projectName=NuoData, employeeName=Hemant, managerName=Ankita, empUserId=null, managerUserId=null]";

        assertEquals(expectedToString, request.toString());
    }
	}