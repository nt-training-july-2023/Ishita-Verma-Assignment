//package com.portal.validation;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import com.portal.DTO.AdminDTO;
//import com.portal.DTO.LoginDTO;
//import com.portal.entities.Designation;
//import com.portal.entities.Employee;
//import com.portal.entities.Location;
//import com.portal.entities.Role;
//import com.portal.exceptions.DuplicateEntryException;
//import com.portal.exceptions.ResourceNotFoundException;
//import com.portal.exceptions.WrongCredentialsException;
//import com.portal.repository.AdminRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//
//public class ValidationTest {
//
//    private Validation validation;
//    private AdminRepository userRepository;
//    private Logger logger;
//
//    @BeforeEach
//    public void setUp() {
//        userRepository = mock(AdminRepository.class);
//        logger = mock(Logger.class);
//        validation = new Validation();
//    }
//
//    @Test
//    public void testCheckName_ValidName() {
//        assertTrue(validation.checkName("Ankita Sharma"));
//    }
//
//    @Test
//    public void testCheckName_InvalidName() {
//        assertFalse(validation.checkName("565as"));
//    }
//
//    @Test
//    public void testCheckEmail_ValidEmail() {
//        assertTrue(validation.checkEmail("ankita.sharma@nucleusteq.com"));
//    }
//
//    @Test
//    public void testCheckEmail_InvalidEmail() {
//        assertFalse(validation.checkEmail("invalid_email"));
//    }
//
//    @Test
//    public void testCheckempId_ValidEmpId() {
//        assertTrue(validation.checkempId("N1234"));
//    }
//
//    @Test
//    public void testCheckempId_InvalidEmpId() {
//        assertFalse(validation.checkempId("N12"));
//    }
//
//    @Test
//    public void testCheckUser_ValidUser() {
//        AdminDTO userDto = new AdminDTO(1L, "N1234", "Ankita", "ankita.sharma@nucleusteq.com",
//                "1990-01-01", "2023-01-01", null, null, "1234567890",
//                "password", Role.ADMIN, "Manager Name", 2L, 1L, "Project Name", 
//                Arrays.asList("Skill1", "Skill2"));
//        assertTrue(validation.checkUser(userDto));
//    }
//
//    @Test
//    public void testCheckUser_InvalidName() {
//        AdminDTO userDto = new AdminDTO(1L, "N1234", "Ankita123", "ankita.sharma@nucleusteq.com",
//                "1990-01-01", "2023-01-01", null, null, "1234567890",
//                "password", Role.ADMIN, "Manager Name", 2L, 1L, "Project Name", 
//                Arrays.asList("Skill1", "Skill2"));
//        assertThrows(WrongCredentialsException.class, () -> validation.checkUser(userDto));
//    }
//
//    @Test
//    public void testCheckUser_InvalidEmail() {
//        AdminDTO userDto = new AdminDTO(1L, "N1234", "Ankita", "ankita.sharma",
//                "1990-01-01", "2023-01-01", null, null, "1234567890",
//                "password", Role.ADMIN, "Manager Name", 2L, 1L, "Project Name", 
//                Arrays.asList("Skill1", "Skill2"));
//        assertThrows(WrongCredentialsException.class, () -> validation.checkUser(userDto));
//    }
//
//    @Test
//    public void testCheckUser_InvalidEmpId() {
//        AdminDTO userDto = new AdminDTO(1L, "NXXXX", "Ankita", "ankita.sharma@nucleusteq.com",
//                "1990-01-01", "2023-01-01", null, null, "1234567890",
//                "password", Role.ADMIN, "Manager Name", 2L, 1L, "Project Name", 
//                Arrays.asList("Skill1", "Skill2"));
//        assertThrows(WrongCredentialsException.class, () -> validation.checkUser(userDto));
//    }
//
//    @Test
//    public void testCheckLoginDto_ValidLoginDto() {
//        LoginDTO loginDto = new LoginDTO("ankita.sharma@nucleusteq.com","password");
//        assertTrue(validation.checkLoginDto(loginDto));
//    }
//    
//    @Test
//    public void testCheckLoginDto_InvalidEmail() {
//        LoginDTO loginDto = new LoginDTO("invalid_email");
//        assertThrows(WrongCredentialsException.class, () -> validation.checkLoginDto(loginDto));
//    }
//
//    @Test
//    public void testCheckEmailPresent_EmailExists() {
//        when(userRepository.findByEmail("john@example.com")).thenReturn(Optional.of(new Employee()));
//        assertThrows(DuplicateEntryException.class, () -> validation.checkEmailPresent("john@example.com"));
//    }
//
//    @Test
//    public void testCheckEmailPresent_EmailDoesNotExist() {
//        when(userRepository.findByEmail("john@example.com")).thenReturn(Optional.empty());
//        validation.checkEmailPresent("john@example.com");
//    }
//
//    @Test
//    public void testCheckEmpId_EmpIdExists() {
//        when(userRepository.findByEmpId("N1234")).thenReturn(Optional.of(new Employee()));
//        assertThrows(DuplicateEntryException.class, () -> validation.checkEmpId("N1234"));
//    }
//
//    @Test
//    public void testCheckEmpId_EmpIdDoesNotExist() {
//        when(userRepository.findByEmpId("N1234")).thenReturn(Optional.empty());
//        validation.checkEmpId("N1235");
//    }
//
//    @Test
//    public void testCheckAdmin_ValidAdmin() {
//        AdminDTO adminDTO = new AdminDTO(1L, "N1234", "Ankita", "ankita.sharma@nucleusteq.com",
//                "1990-01-01", "2023-01-01", null, null, "1234567890",
//                "password", Role.ADMIN, "Manager Name", 2L, 1L, "Project Name", 
//                Arrays.asList("Skill1", "Skill2"));
//        when(userRepository.findByEmail("ankita.sharma@nucleusteq.com")).thenReturn(Optional.empty());
//        when(userRepository.findByEmpId("N1234")).thenReturn(Optional.empty());
//        validation.checkAdmin(adminDTO);
//    }
//
//    @Test
//    public void testCheckAdmin_DuplicateEmail() {
//        AdminDTO adminDTO = new AdminDTO(1L, "N1234", "Ankita", "ankita.sharma@nucleusteq.com",
//                "1990-01-01", "2023-01-01", null, null, "1234567890",
//                "password", Role.ADMIN, "Manager Name", 2L, 1L, "Project Name", 
//                Arrays.asList("Skill1", "Skill2"));
//        when(userRepository.findByEmail("ankita.sharma@nucleusteq.com")).thenReturn(Optional.of(new Employee()));
//        assertThrows(DuplicateEntryException.class, () -> validation.checkAdmin(adminDTO));
//    }
//
//    @Test
//    public void testCheckAdmin_DuplicateEmpId() {
//        AdminDTO adminDTO = new AdminDTO(1L, "N1234", "Ankita", "ankita.sharma@nucleusteq.com",
//                "1990-01-01", "2023-01-01", null, null, "1234567890",
//                "password", Role.ADMIN, "Manager Name", 2L, 1L, "Project Name", 
//                Arrays.asList("Skill1", "Skill2"));
//        
//        when(userRepository.findByEmail("john@example.com")).thenReturn(Optional.empty());
//        when(userRepository.findByEmpId("N1234")).thenReturn(Optional.of(new Employee()));
//        
//        assertThrows(DuplicateEntryException.class, () -> validation.checkAdmin(adminDTO));
//    }
//
//    @Test
//    public void testCheckEmailEmpty_EmailExists() {
//        when(userRepository.findByEmail("john@example.com")).thenReturn(Optional.of(new Employee()));
//        validation.checkEmailEmpty("john@example.com");
//    }
//
//    @Test
//    public void testCheckEmailEmpty_EmailDoesNotExist() {
//        when(userRepository.findByEmail("ankita.sharma@nucleusteq.com")).thenReturn(Optional.empty());
//        assertThrows(ResourceNotFoundException.class, () -> validation.checkEmailEmpty("ankita.sharma@nucleusteq.com"));
//    }
//}
