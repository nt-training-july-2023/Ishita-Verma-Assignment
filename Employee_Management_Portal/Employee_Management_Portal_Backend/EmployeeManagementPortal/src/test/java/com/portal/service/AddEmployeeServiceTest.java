//package com.portal.service;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import com.portal.DTO.AdminDTO;
//import com.portal.entities.Admin;
//import com.portal.exception.DuplicateEntryException;
//import com.portal.repository.AdminRepository;
//import com.portal.validations.Validation;
//
//@ExtendWith(MockitoExtension.class) // Use MockitoExtension for JUnit 5
//public class AddEmployeeServiceTest {
//
//    @InjectMocks
//    private AddEmployeeService addEmployeeService;
//
//    @Mock
//    private AdminRepository userRepository;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    @Mock
//    private Validation validation;
//
//    @BeforeEach
//    public void setUp() {
//        // No need for MockitoAnnotations.initMocks(this) in JUnit 5
//        // Dependencies will be automatically injected
//    }
//
//    @Test
//    public void testAddEmployee_DuplicateEmail() {
//        // Arrange
//        AdminDTO adminDTO = new AdminDTO();
//        adminDTO.setEmail("john.doe@nucleusteq.com");
//
//        when(userRepository.existsByEmail(adminDTO.getEmail())).thenReturn(true);
//
//        // Act and Assert
//        assertThrows(DuplicateEntryException.class, () -> addEmployeeService.addEmployee(adminDTO));
//    }
//
//    @Test
//    public void testAddEmployee_EmptyName() {
//        // Arrange
//        AdminDTO adminDTO = new AdminDTO();
//        adminDTO.setName("");
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> addEmployeeService.addEmployee(adminDTO));
//    }
//
//    @Test
//    public void testAddEmployee_InvalidEmail() {
//        // Arrange
//        AdminDTO adminDTO = new AdminDTO();
//        adminDTO.setEmail("john.doe@gmail.com");
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> addEmployeeService.addEmployee(adminDTO));
//    }
//
//    @Test
//    public void testAddEmployee_EmptyEmpId() {
//        // Arrange
//        AdminDTO adminDTO = new AdminDTO();
//        adminDTO.setEmpId("");
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> addEmployeeService.addEmployee(adminDTO));
//    }
//
//    @Test
//    public void testAddEmployee_InvalidEmpIdFormat() {
//        // Arrange
//        AdminDTO adminDTO = new AdminDTO();
//        adminDTO.setEmpId("N12345"); // Invalid format
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> addEmployeeService.addEmployee(adminDTO));
//    }
//
//    @Test
//    public void testAddEmployee_EmptyDOB() {
//        // Arrange
//        AdminDTO adminDTO = new AdminDTO();
//        adminDTO.setDob("");
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> addEmployeeService.addEmployee(adminDTO));
//    }
//
//    @Test
//    public void testAddEmployee_InvalidDOBFormat() {
//        // Arrange
//        AdminDTO adminDTO = new AdminDTO();
//        adminDTO.setDob("2023-01-01"); // Invalid format
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> addEmployeeService.addEmployee(adminDTO));
//    }
//}
