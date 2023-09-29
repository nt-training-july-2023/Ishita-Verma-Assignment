//package com.portal.DTO;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class ResponseAllRequestDTOTest {
//
//    private ResponseAllRequestDTO dto1;
//    private ResponseAllRequestDTO dto2;
//
//    @BeforeEach
//    void setUp() {
//        dto1 = new ResponseAllRequestDTO();
//        dto2 = new ResponseAllRequestDTO();
//    }
//
//    @Test
//    void testGettersAndSetters() {
//        assertNull(dto1.getId());
//        assertNull(dto1.getManagerId());
//        assertNull(dto1.getEmployeeId());
//        assertNull(dto1.getComment());
//        assertNull(dto1.getProjectId());
//        assertNull(dto1.getEmpName());
//        assertNull(dto1.getManagerName());
//        assertNull(dto1.getProjectName());
//
//        dto1.setId(1L);
//        assertEquals(1L, dto1.getId());
//
//        dto1.setManagerId(2L);
//        assertEquals(2L, dto1.getManagerId());
//
//        dto1.setEmployeeId(3L);
//        assertEquals(3L, dto1.getEmployeeId());
//
//        dto1.setComment("Comment1");
//        assertEquals("Comment1", dto1.getComment());
//
//        dto1.setProjectId(4L);
//        assertEquals(4L, dto1.getProjectId());
//
//        dto1.setEmpName("Employee1");
//        assertEquals("Employee1", dto1.getEmpName());
//
//        dto1.setManagerName("Manager1");
//        assertEquals("Manager1", dto1.getManagerName());
//
//        dto1.setProjectName("Project1");
//        assertEquals("Project1", dto1.getProjectName());
//    }
//    @Test
//    void testToString() {
//        String expected = "ResponseAllRequestDto [id=null, managerId=null, employeeId=null, comment=null, projectId=null, empName=null, managerName=null, projectName=null]";
//        assertEquals(expected, dto1.toString());
//    }
//
//    @Test
//    void testHashCode() {
//        assertEquals(dto1.hashCode(), dto2.hashCode());
//
//        dto1.setId(1L);
//        dto2.setId(1L);
//        dto1.setManagerId(2L);
//        dto2.setManagerId(2L);
//        dto1.setEmployeeId(3L);
//        dto2.setEmployeeId(3L);
//        dto1.setComment("Comment1");
//        dto2.setComment("Comment1");
//        dto1.setProjectId(4L);
//        dto2.setProjectId(4L);
//        dto1.setEmpName("Employee1");
//        dto2.setEmpName("Employee1");
//        dto1.setManagerName("Manager1");
//        dto2.setManagerName("Manager1");
//        dto1.setProjectName("Project1");
//        dto2.setProjectName("Project1");
//
//        assertEquals(dto1.hashCode(), dto2.hashCode());
//
//        dto2.setProjectName("Project2");
//
//        assertNotEquals(dto1.hashCode(), dto2.hashCode());
//    }
//
//    @Test
//    void testEquals() {
//        assertEquals(dto1, dto2);
//        assertEquals(dto1, dto1);
//
//        dto1.setId(1L);
//        dto2.setId(1L);
//        dto1.setManagerId(2L);
//        dto2.setManagerId(2L);
//        dto1.setEmployeeId(3L);
//        dto2.setEmployeeId(3L);
//        dto1.setComment("Comment1");
//        dto2.setComment("Comment1");
//        dto1.setProjectId(4L);
//        dto2.setProjectId(4L);
//        dto1.setEmpName("Employee1");
//        dto2.setEmpName("Employee1");
//        dto1.setManagerName("Manager1");
//        dto2.setManagerName("Manager1");
//        dto1.setProjectName("Project1");
//        dto2.setProjectName("Project1");
//
//        assertEquals(dto1, dto2);
//
//        dto2.setProjectName("Project2");
//
//        assertNotEquals(dto1, dto2);
//
//        assertNotEquals(dto1, null);
//        assertNotEquals(dto1, "NotADTOObject");
//    }
//}
//
