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
    @Test
    void testEquals() {
        // Create two RequestResource objects with the same properties
        RequestResource request1 = new RequestResource();
        request1.setResourceId(1L);
        request1.setComment("Test comment");
        request1.setManagerId(2L);
        request1.setEmployeeId(3L);
        request1.setProjectId(4L);

        RequestResource request2 = new RequestResource();
        request2.setResourceId(1L);
        request2.setComment("Test comment");
        request2.setManagerId(2L);
        request2.setEmployeeId(3L);
        request2.setProjectId(4L);

        // Create another RequestResource object with different properties
        RequestResource request3 = new RequestResource();
        request3.setResourceId(5L);
        request3.setComment("Different comment");
        request3.setManagerId(6L);
        request3.setEmployeeId(7L);
        request3.setProjectId(8L);

        // Test for equality between request1 and request2
        assertTrue(request1.equals(request2));
        assertTrue(request2.equals(request1));

        // Test for inequality between request1 and request3
        assertFalse(request1.equals(request3));
        assertFalse(request3.equals(request1));

        // Test for inequality between request2 and request3
        assertFalse(request2.equals(request3));
        assertFalse(request3.equals(request2));

        // Test for equality between the same object
        assertTrue(request1.equals(request1));

        // Test for inequality when comparing to null
        assertFalse(request1.equals(null));

        // Test for inequality when comparing to an object of a different class
//        assertFalse(request1.equals("Not a RequestResource"));
    }
}
