package com.portal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.DTO.LoginDTO;
import com.portal.DTO.LoginResponseDTO;
import com.portal.entities.Role;
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
    void testRegisterAdmin() {
        // Create a sample AdminDTO object
        AdminDTO adminDTO = new AdminDTO(/* Fill adminDTO details here */);

        // Mock the behavior of adminService.registerAdmin
        when(adminService.registerAdmin(adminDTO)).thenReturn(new ResponseDTO("Admin registered successfully",""));

        // Call the controller method
        ResponseDTO result = adminController.registerAdmin(adminDTO);

        // Assert the result message
        assertEquals("Admin registered successfully", result.getMessage());
    }

    @Test
    void testGetAllAdmin() {
        // Create a sample list of EmployeeOutDTO objects
        List<EmployeeOutDTO> adminList = new ArrayList<>();
        EmployeeOutDTO admin1 = new EmployeeOutDTO(/* Fill employee details here */);
        EmployeeOutDTO admin2 = new EmployeeOutDTO(/* Fill employee details here */);
        adminList.add(admin1);
        adminList.add(admin2);

        // Mock the behavior of adminService.getAllAdmin
        when(adminService.getAllAdmin()).thenReturn(adminList);

        // Call the controller method
        List<EmployeeOutDTO> result = adminController.getAllAdmin();

        // Assert the result
        assertEquals(adminList.size(), result.size());
        // Add more specific assertions if needed
    }

    @Test
    void testLogin() {
        // Create a sample LoginDTO object
        LoginDTO loginDTO = new LoginDTO(null);
        loginDTO.setEmail("ankita.sharma@nucleusteq.com"); 
        loginDTO.setPassword("Ankita123@");

        // Mock the behavior of adminService.login
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO("Login Successfully", Role.ADMIN, "Ankita");
        when(adminService.login(loginDTO)).thenReturn(loginResponseDTO);

        // Call the controller method
        LoginResponseDTO result = adminController.login(loginDTO);

        // Assert the result
        assertEquals("Login Successfully", result.getMessage());
        assertEquals(Role.ADMIN, result.getRole());
        assertEquals("Ankita", result.getName());
    }
}
