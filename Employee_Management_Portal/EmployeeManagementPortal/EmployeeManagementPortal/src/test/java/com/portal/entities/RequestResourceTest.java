package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RequestResourceTest {

    @Test
    void testGettersAndSetters() {
        RequestResource requestResource = new RequestResource();
        
        // Set values using setters
        requestResource.setResourceId(1L);
        requestResource.setComment("Description");
        requestResource.setManagerId(2L);
        requestResource.setEmployeeId(1L);
        requestResource.setProjectId(1L);

        // Test getters
        assertEquals(1L, requestResource.getResourceId());
        assertEquals("Description", requestResource.getComment());
        assertEquals(2L, requestResource.getManagerId());
        assertEquals(1L, requestResource.getEmployeeId());
        assertEquals(1L, requestResource.getProjectId());
    }
    @Test
    void testToString() {
        RequestResource requestResource = new RequestResource();
        requestResource.setResourceId(1L);
        requestResource.setComment("Test comment");
        requestResource.setManagerId(2L);
        requestResource.setEmployeeId(3L);
        requestResource.setProjectId(4L);

        String expectedToString = "RequestResource [ResourceId=1, comment=Test comment, managerId=2, employeeId=3, projectId=4]";
        String resultString = requestResource.toString();

        assertEquals(expectedToString, resultString);
    }

    @Test
    void testHashCodeAndEquals() {
        RequestResource requestResource1 = new RequestResource();
        requestResource1.setResourceId(1L);
        requestResource1.setComment("Test comment");
        requestResource1.setManagerId(2L);
        requestResource1.setEmployeeId(3L);
        requestResource1.setProjectId(4L);

        RequestResource requestResource2 = new RequestResource();
        requestResource2.setResourceId(1L);
        requestResource2.setComment("Test comment");
        requestResource2.setManagerId(2L);
        requestResource2.setEmployeeId(3L);
        requestResource2.setProjectId(4L);

        RequestResource requestResource3 = new RequestResource();
        requestResource3.setResourceId(5L);
        requestResource3.setComment("Different comment");
        requestResource3.setManagerId(6L);
        requestResource3.setEmployeeId(7L);
        requestResource3.setProjectId(8L);

        assertEquals(requestResource1, requestResource2);
        assertNotEquals(requestResource1, requestResource3);
        assertNotEquals(requestResource2, requestResource3);

        assertEquals(requestResource1.hashCode(), requestResource2.hashCode());
        assertNotEquals(requestResource1.hashCode(), requestResource3.hashCode());
        assertNotEquals(requestResource2.hashCode(), requestResource3.hashCode());
    }

}
