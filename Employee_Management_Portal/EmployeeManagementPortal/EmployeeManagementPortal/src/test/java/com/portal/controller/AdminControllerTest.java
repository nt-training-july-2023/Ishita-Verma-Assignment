package com.portal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.DTO.LoginDTO;
import com.portal.entities.Employee;
import com.portal.exceptions.WrongCredentialsException;
import com.portal.service.AdminService;

class AdminControllerTest {

	@InjectMocks
    private AdminController adminController;

    @Mock
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterAdminSuccess() {
        // Prepare test data
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setName("admin");
        adminDTO.setPassword("password");

        // Mock the service method to return a successful response
        when(adminService.registerAdmin(any(AdminDTO.class))).thenReturn(adminDTO);

        // Perform the test
        ResponseDTO response = adminController.registerAdmin(adminDTO);

        // Assertions
        assertNotNull(response);
        assertEquals("Admin Added succesfully", response.getMessage());
        assertEquals("", response.getRole());
    }

    @Test
    void testRegisterAdminFailure() {
        // Prepare test data
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setName("admin");
        adminDTO.setPassword("password");

        // Mock the service method to return null (failure scenario)
        when(adminService.registerAdmin(any(AdminDTO.class))).thenReturn(null);

        // Perform the test
        ResponseDTO response = adminController.registerAdmin(adminDTO);

        // Assertions
        assertNotNull(response);
        assertEquals("Invalid Credentials", response.getMessage());
        assertEquals("", response.getRole());
    }

    @Test
    void testGetAllAdmin() {
        // Mock the service method to return a list of admins
        List<Employee> adminList = List.of(new Employee(), new Employee());
        when(adminService.getAllAdmin()).thenReturn(adminList);

        // Perform the test
        ResponseEntity<List<Employee>> responseEntity = adminController.getAllAdmin();

        // Assertions
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals(adminList, responseEntity.getBody());
    }

    @Test
    void testLoginSuccess() {
        // Prepare test data
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("admin@example.com");
        loginDTO.setPassword("password");

        // Mock the service method to return a successful response
        AdminDTO adminDTO = new AdminDTO();
        when(adminService.login(any(LoginDTO.class))).thenReturn(adminDTO);

        // Mock the service method to return a role
        when(adminService.getUserRoleByEmail("admin@example.com")).thenReturn("ADMIN");

        // Perform the test
        ResponseDTO response = adminController.login(loginDTO);

        // Assertions
        assertNotNull(response);
        assertEquals("Login Successfully", response.getMessage());
        assertEquals("ADMIN", response.getRole());
    }

    @Test
    void testLoginFailure() {
        // Prepare test data
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("admin@example.com");
        loginDTO.setPassword("password");

        // Mock the service method to return null (failure scenario)
        when(adminService.login(any(LoginDTO.class))).thenReturn(null);

        // Perform the test
        assertThrows(WrongCredentialsException.class, () -> adminController.login(loginDTO));
    }

}
