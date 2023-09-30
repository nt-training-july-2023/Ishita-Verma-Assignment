package com.portal.validation;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import com.portal.DTO.EmployeeInDTO;
import com.portal.DTO.LoginInDTO;
import com.portal.DTO.ProjectInDTO;
import com.portal.entities.Designation;
import com.portal.entities.Employee;
import com.portal.entities.Location;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.exceptions.DuplicateEntryException;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.exceptions.WrongCredentialsException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

public class ValidationTest {

    @Mock
    private AdminRepository userRepository;

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private Validation validation;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCheckName_ValidName() {
        assertTrue(validation.checkName("Ankita"));
    }

    @Test
    void testCheckName_InvalidName() {
        assertFalse(validation.checkName("12345")); // Name should contain only alphabetic characters and spaces
    }

    @Test
    void testCheckEmail_ValidEmail() {
        assertTrue(validation.checkEmail("ankita.sharma@nucleusteq.com"));
    }

    @Test
    void testCheckEmail_InvalidEmail() {
        assertFalse(validation.checkEmail("invalid-email")); // Invalid email format
    }

    @Test
    void testCheckempId_ValidEmpId() {
        assertTrue(validation.checkempId("N1234"));
    }

    @Test
    void testCheckempId_InvalidEmpId() {
        assertFalse(validation.checkempId("EMP123")); // Invalid empId format
    }

    @Test
    void testCheckUser_ValidUser() {
        EmployeeInDTO userDto = new EmployeeInDTO();
        userDto.setName("Ankita");
        userDto.setEmail("ankita.sharma@nucleusteq.com");
        userDto.setEmpId("N1234");
        assertTrue(validation.checkUser(userDto));
    }

    @Test
    void testCheckUser_InvalidName() {
        EmployeeInDTO userDto = new EmployeeInDTO();
        userDto.setName("12345"); // Invalid name
        assertThrows(WrongCredentialsException.class, () -> validation.checkUser(userDto));
    }

    @Test
    void testCheckUser_InvalidEmail() {
        EmployeeInDTO userDto = new EmployeeInDTO();
        userDto.setName("John Doe");
        userDto.setEmail("invalid-email"); // Invalid email
        assertThrows(WrongCredentialsException.class, () -> validation.checkUser(userDto));
    }

    @Test
    void testCheckUser_InvalidEmpId() {
        EmployeeInDTO userDto = new EmployeeInDTO();
        userDto.setName("Anjali");
        userDto.setEmail("anjali@gmail.com");
        userDto.setEmpId("EMP123"); // Invalid empId
        assertThrows(WrongCredentialsException.class, () -> validation.checkUser(userDto));
    }

 

    @Test
    void testCheckLoginDto_InvalidEmail() {
        LoginInDTO loginDto = new LoginInDTO();
        loginDto.setEmail("invalid-email"); // Invalid email
        assertThrows(WrongCredentialsException.class, () -> validation.checkLoginDto(loginDto));
    }

    @Test
    void testCheckEmailPresent_EmailExists() {
        Mockito.when(userRepository.findByEmail("ankita.sharma@nucleusteq.com")).thenReturn(Optional.of(new Employee()));
        assertThrows(DuplicateEntryException.class, () -> validation.checkEmailPresent("ankita.sharma@nucleusteq.com"));
    }

    @Test
    void testCheckEmailPresent_EmailDoesNotExist() {
        Mockito.when(userRepository.findByEmail("ankita.sharma@nucleusteq.com")).thenReturn(Optional.empty());
        assertDoesNotThrow(() -> validation.checkEmailPresent("john@example.com"));
    }

    @Test
    void testCheckEmpId_EmpIdExists() {
        Mockito.when(userRepository.findByEmpId("N1234")).thenReturn(Optional.of(new Employee()));
        assertThrows(DuplicateEntryException.class, () -> validation.checkEmpId("N1234"));
    }

    @Test
    void testCheckEmpId_EmpIdDoesNotExist() {
        Mockito.when(userRepository.findByEmpId("N1234")).thenReturn(Optional.empty());
        assertDoesNotThrow(() -> validation.checkEmpId("N1234"));
    }

    @Test
    void testCheckEmailEmpty_EmailExists() {
        Mockito.when(userRepository.findByEmail("ankita.sharma@nucleusteq.com")).thenReturn(Optional.of(new Employee()));
        assertDoesNotThrow(() -> validation.checkEmailEmpty("ankita.sharma@nucleusteq.com"));
    }

    @Test
    void testCheckEmailEmpty_EmailDoesNotExist() {
        Mockito.when(userRepository.findByEmail("ankita.sharma@nucleusteq.com")).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> validation.checkEmailEmpty("ankita.sharma@nucleusteq.com"));
    }

    @Test
    void testCheckProjectName_ProjectNameExists() {
        Mockito.when(projectRepository.findByName("Project1")).thenReturn(new Project());
        assertThrows(DuplicateEntryException.class, () -> validation.checkProjectName("Project1"));
    }

    @Test
    void testCheckProjectName_ProjectNameDoesNotExist() {
        Mockito.when(projectRepository.findByName("Project1")).thenReturn(null);
        assertDoesNotThrow(() -> validation.checkProjectName("Project1"));
    }
    @Test
    void testCheckProject_ProjectNameExists() {
        // Arrange
        String projectName = "ExistingProjectName";
        ProjectInDTO projectDto = new ProjectInDTO();
        projectDto.setName(projectName);
        
        // Mock the behavior of projectRepository to return a project with the same name
        when(projectRepository.findByName(projectName)).thenReturn(new Project());

        // Act and Assert
        DuplicateEntryException exception = assertThrows(DuplicateEntryException.class, () -> {
            validation.checkProject(projectDto);
        });

        assertEquals("Project Name already exists", exception.getMessage());
    }

    @Test
    void testCheckProject_ProjectNameDoesNotExist() {
        // Arrange
        String projectName = "NewProjectName";
        ProjectInDTO projectDto = new ProjectInDTO();
        projectDto.setName(projectName);

        // Mock the behavior of projectRepository to return null (indicating the project name doesn't exist)
        when(projectRepository.findByName(projectName)).thenReturn(null);

        // Act
        validation.checkProject(projectDto);

        // Assert: No exception should be thrown

        // Verify that the projectRepository.findByName method was called once with the provided name
        verify(projectRepository, times(1)).findByName(projectName);
    }
    @Test
    void testCheckLogin_EmailExists() {
        // Arrange
        String email = "existing@example.com";
        LoginInDTO loginDTO = new LoginInDTO();
        loginDTO.setEmail(email);

        // Mock the behavior of userRepository to return an employee with the same email
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(new Employee()));

        // Act and Assert
        assertDoesNotThrow(() -> {
            validation.checkLogin(loginDTO);
        });

        // Verify that userRepository.findByEmail was called once with the provided email
        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    void testCheckLogin_EmailDoesNotExist() {
        // Arrange
        String email = "nonexistent@example.com";
        LoginInDTO loginDTO = new LoginInDTO();
        loginDTO.setEmail(email);

        // Mock the behavior of userRepository to return an empty Optional (indicating that email doesn't exist)
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Act
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            validation.checkLogin(loginDTO);
        });

        assertEquals("Invalid user", exception.getMessage());

        // Verify that userRepository.findByEmail was called once with the provided email
        verify(userRepository, times(1)).findByEmail(email);
    }

//    @Test
//    void testCheckEmployee_EmailAndEmpIdExist() {
//        // Arrange
//        String email = "existing@example.com";
//        String empId = "N1234";
//        EmployeeInDTO empDto = new EmployeeInDTO();
//        empDto.setEmail(email);
//        empDto.setEmpId(empId);
//
//        // Mock the behavior of userRepository to return an employee with the same email and empId
//        when(userRepository.findByEmail(email)).thenReturn(Optional.of(new Employee()));
//        when(userRepository.findByEmpId(empId)).thenReturn(Optional.of(new Employee()));
//
//        // Act and Assert
//        DuplicateEntryException exception = assertThrows(DuplicateEntryException.class, () -> {
//            validation.checkEmployee(empDto);
//        });
//
//        assertEquals("Email id already exists", exception.getMessage());
//
//        // Verify that userRepository.findByEmail and userRepository.findByEmpId were called once with the provided email and empId
//        verify(userRepository, times(1)).findByEmail(email);
//        verify(userRepository, times(1)).findByEmpId(empId);
//    }

    @Test
    void testCheckEmployee_EmailAndEmpIdDoNotExist() {
        // Arrange
        String email = "new@example.com";
        String empId = "N5678";
        EmployeeInDTO empDto = new EmployeeInDTO();
        empDto.setEmail(email);
        empDto.setEmpId(empId);

        // Mock the behavior of userRepository to return empty Optionals (indicating that email and empId don't exist)
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        when(userRepository.findByEmpId(empId)).thenReturn(Optional.empty());

        // Act
        validation.checkEmployee(empDto);

        // Assert: No exception should be thrown

        // Verify that userRepository.findByEmail and userRepository.findByEmpId were called once with the provided email and empId
        verify(userRepository, times(1)).findByEmail(email);
        verify(userRepository, times(1)).findByEmpId(empId);
    }
}
