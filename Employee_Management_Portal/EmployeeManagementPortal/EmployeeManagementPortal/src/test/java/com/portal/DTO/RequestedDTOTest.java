//package com.portal.DTO;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class RequestedDTOTest {
//
//
//    private RequestedDTO dto1;
//    private RequestedDTO dto2;
//    private RequestedDTO dto;
//
//    @BeforeEach
//    void setUp() {
//        dto1 = new RequestedDTO();
//        dto1.setEmployeeId(1L);
//        dto1.setManagerEmail("manager1@example.com");
//
//        dto2 = new RequestedDTO();
//        dto2.setEmployeeId(2L);
//        dto2.setManagerEmail("manager2@example.com");
//    }
//
//    @Test
//    void testGetEmployeeId() {
//        assertNull(dto.getEmployeeId());
//        Long employeeId = 1L;
//        dto.setEmployeeId(employeeId);
//        assertEquals(employeeId, dto.getEmployeeId());
//    }
//
//    @Test
//    void testSetEmployeeId() {
//        assertNull(dto.getEmployeeId());
//        Long employeeId = 1L;
//        dto.setEmployeeId(employeeId);
//        assertEquals(employeeId, dto.getEmployeeId());
//    }
//
//    @Test
//    void testGetManagerEmail() {
//        assertNull(dto.getManagerEmail());
//        String managerEmail = "manager@example.com";
//        dto.setManagerEmail(managerEmail);
//        assertEquals(managerEmail, dto.getManagerEmail());
//    }
//
//    @Test
//    void testSetManagerEmail() {
//        assertNull(dto.getManagerEmail());
//        String managerEmail = "manager@example.com";
//        dto.setManagerEmail(managerEmail);
//        assertEquals(managerEmail, dto.getManagerEmail());
//    }
//   
//    @Test
//    void testHashCode() {
//        assertEquals(dto1.hashCode(), dto1.hashCode());
//
//        assertNotEquals(dto1.hashCode(), dto2.hashCode());
//    }
//
//    @Test
//    void testEquals() {
//        assertEquals(dto1, dto1);
//
//        assertNotEquals(dto1, null);
//        assertNotEquals(dto1, "String");
//
//        assertNotEquals(dto1, dto2);
//    }
//}
