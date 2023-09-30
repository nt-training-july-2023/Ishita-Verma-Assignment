package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RequestResourceInDTOTest {

    @Test
    public void testGetterAndSetterMethods() {
        RequestResourceInDTO requestResource = new RequestResourceInDTO();

        requestResource.setComment("Test Comment");
        requestResource.setManagerId(1L);
        requestResource.setEmployeeId(2L);
        requestResource.setProjectId(3L);

        assertEquals("Test Comment", requestResource.getComment());
        assertEquals(1L, requestResource.getManagerId());
        assertEquals(2L, requestResource.getEmployeeId());
        assertEquals(3L, requestResource.getProjectId());
    }

    @Test
    public void testHashCodeMethod() {
        RequestResourceInDTO requestResource1 = new RequestResourceInDTO();
        requestResource1.setComment("Comment1");
        requestResource1.setManagerId(1L);
        requestResource1.setEmployeeId(2L);
        requestResource1.setProjectId(3L);

        RequestResourceInDTO requestResource2 = new RequestResourceInDTO();
        requestResource2.setComment("Comment1");
        requestResource2.setManagerId(1L);
        requestResource2.setEmployeeId(2L);
        requestResource2.setProjectId(3L);

        assertEquals(requestResource1.hashCode(), requestResource2.hashCode());
    }

    @Test
    public void testEqualsMethod() {
        RequestResourceInDTO requestResource1 = new RequestResourceInDTO();
        requestResource1.setComment("Comment1");
        requestResource1.setManagerId(1L);
        requestResource1.setEmployeeId(2L);
        requestResource1.setProjectId(3L);

        RequestResourceInDTO requestResource2 = new RequestResourceInDTO();
        requestResource2.setComment("Comment1");
        requestResource2.setManagerId(1L);
        requestResource2.setEmployeeId(2L);
        requestResource2.setProjectId(3L);

        assertTrue(requestResource1.equals(requestResource2));
    }

    @Test
    public void testToStringMethod() {
        RequestResourceInDTO requestResource = new RequestResourceInDTO();
        requestResource.setComment("Test Comment");
        requestResource.setManagerId(1L);
        requestResource.setEmployeeId(2L);
        requestResource.setProjectId(3L);

        assertEquals("RequestResourceDTO [comment=Test Comment, managerId=1, employeeId=2, projectId=3]", requestResource.toString());
    }
}
