//package com.portal.DTO;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class ResponseDTOTest {
//
//	private ResponseDTO responseDTO1;
//    private ResponseDTO responseDTO2;
//
////    @BeforeEach
////    void setUp() {
////        responseDTO1 = new ResponseDTO();
////        responseDTO1.setMessage("Success");
////        responseDTO1.setRole("ADMIN");
////
////        responseDTO2 = new ResponseDTO("Error", "User");
////    }
//
//    @Test
//    void testGettersAndSetters() {
//        assertEquals("Success", responseDTO1.getMessage());
//        assertEquals("ADMIN", responseDTO1.getRole());
//
//        assertEquals("Error", responseDTO2.getMessage());
//        assertEquals("User", responseDTO2.getRole());
//    }
//    @Test
//    void testHashCode() {
//        ResponseDTO responseDTO1Copy = new ResponseDTO();
//        responseDTO1Copy.setMessage("Success");
//        responseDTO1Copy.setRole("ADMIN");
//
//        assertNotEquals(responseDTO1.hashCode(), responseDTO1Copy.hashCode());
//    }
//
////    @Test
////    void testEquals() {
////        ResponseDTO responseDTO1Copy = new ResponseDTO();
////        responseDTO1Copy.setMessage("Success");
////        responseDTO1Copy.setRole("ADMIN");
////
////        assertNotEquals(responseDTO1, responseDTO1Copy);
////
////        ResponseDTO differentDTO = new ResponseDTO("Error", "User");
////        assertNotEquals(responseDTO1, differentDTO);
////    }
//
//   
//
//}
