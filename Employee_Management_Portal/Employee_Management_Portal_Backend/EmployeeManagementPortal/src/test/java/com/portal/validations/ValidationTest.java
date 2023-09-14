//package com.portal.validations;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//class ValidationTest {
//	
//	@Autowired
//	private Validation validation;
//	
//	@BeforeEach
//    public void setUp() {
//        validation = new Validation();
//    }
//
//	@Test
//    public void testValidEmptyData_NullString() {
//        assertTrue(validation.validEmptyData(null));
//    }
//
//    @Test
//    public void testValidEmptyData_EmptyString() {
//        assertTrue(validation.validEmptyData(""));
//    }
//
//    @Test
//    public void testValidEmptyData_NonEmptyString() {
//        assertFalse(validation.validEmptyData("Hello"));
//    }
//
//
//    @Test
//    public void testValidCharacter_InvalidString() {
//        assertFalse(validation.validCharacter("John123"));
//    }
//
//    @Test
//    public void testValidEmpId_ValidFormat() {
//        assertTrue(validation.validEmpId("N1234"));
//    }
//
//    @Test
//    public void testValidEmpId_InvalidFormat() {
//        assertFalse(validation.validEmpId("12345"));
//    }
//
//    @Test
//    public void testValidEmail_ValidFormat() {
//        assertTrue(validation.validEmail("john.doe@nucleusteq.com"));
//    }
//
//    @Test
//    public void testValidEmail_InvalidFormat() {
//        assertFalse(validation.validEmail("john.doe@gmail.com"));
//    }
//
//    @Test
//    public void testValidDate_ValidFormat() {
//        assertTrue(validation.validDate("2023-09-07"));
//    }
//
//    @Test
//    public void testValidDate_InvalidFormat() {
//        assertFalse(validation.validDate("07-09-2023"));
//    }
//
//    @Test
//    public void testValidContactNumber_ValidNumber() {
//        assertTrue(validation.validContactNumber("1234567890"));
//    }
//
//    @Test
//    public void testValidContactNumber_InvalidNumber() {
//        assertFalse(validation.validContactNumber("12345"));
//    }
//
//
//    @Test
//    public void testValidPassword_InvalidFormat() {
//        assertFalse(validation.validPassword("Pass"));
//    }
//
//    @Test
//    public void testValidConfirmPassword_Match() {
//        assertTrue(validation.validConfirmPassword("Password1", "Password1"));
//    }
//
//    @Test
//    public void testValidConfirmPassword_NotMatch() {
//        assertFalse(validation.validConfirmPassword("Password1", "Password2"));
//    }
//
//    @Test
//    public void testValidEmptySkills_NullList() {
//        assertTrue(validation.validEmptySkills(null));
//    }
//
//    @Test
//    public void testValidEmptySkills_EmptyList() {
//        assertTrue(validation.validEmptySkills(List.of()));
//    }
//
//    @Test
//    public void testValidEmptySkills_NonEmptyList() {
//        assertFalse(validation.validEmptySkills(List.of("Java", "Spring")));
//    }
//
//}
