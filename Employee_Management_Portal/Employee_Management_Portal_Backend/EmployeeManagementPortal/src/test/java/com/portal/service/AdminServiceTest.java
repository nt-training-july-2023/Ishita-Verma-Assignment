package com.portal.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.LoginDTO;
import com.portal.entities.Admin;
import com.portal.exception.DuplicateEntryException;
import com.portal.exception.ResourceNotFoundException;
import com.portal.repository.AdminRepository;

class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterAdminSuccess() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmail("test@example.com");

        Admin admin = new Admin();
        when(adminRepository.existsByEmail(adminDTO.getEmail())).thenReturn(false);
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        Admin result = adminService.registerAdmin(adminDTO);

        assertNotNull(result);
        assertEquals(admin, result);
    }

    @Test
    void testRegisterAdminDuplicateEmail() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmail("test@example.com");

        when(adminRepository.existsByEmail(adminDTO.getEmail())).thenReturn(true);

        assertThrows(DuplicateEntryException.class, () -> adminService.registerAdmin(adminDTO));
    }

    @Test
    void testLoginSuccess() {
        LoginDTO loginUser = new LoginDTO();
        loginUser.setEmail("test@example.com");
        loginUser.setPassword("password123");

        Admin admin = new Admin();
        admin.setPassword("password123");
        when(adminRepository.findByEmail(loginUser.getEmail())).thenReturn(Optional.of(admin));

        Admin result = adminService.login(loginUser);

        assertNotNull(result);
        assertEquals(admin, result);
    }

    @Test
    void testLoginUserNotFound() {
        LoginDTO loginUser = new LoginDTO();
        loginUser.setEmail("test@example.com");

        when(adminRepository.findByEmail(loginUser.getEmail())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> adminService.login(loginUser));
    }

    @Test
    void testGetAllAdmin() {
        List<Admin> adminList = new ArrayList<>();
        adminList.add(new Admin());
        when(adminRepository.findAll()).thenReturn(adminList);

        List<Admin> result = adminService.getAllAdmin();

        assertNotNull(result);
        assertEquals(adminList, result);
    }
    
    @Test
    void testLogin_UserNotFound() {
        // Create a mock LoginDTO
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("test@example.com");
        loginDTO.setPassword("Password123");

        // Mock behavior
        when(adminRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        // Test and assert the expected exception
        assertThrows(ResourceNotFoundException.class, () -> adminService.login(loginDTO));
    }
    
    @Test
    void testLogin_Success() {
        // Create a mock LoginDTO
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("test@example.com");
        loginDTO.setPassword("Password123");

        // Create a mock Admin
        Admin mockAdmin = new Admin();
        mockAdmin.setEmail("test@example.com");
        mockAdmin.setPassword("EncodedPassword");
        // Mock behavior
        when(adminRepository.findByEmail(anyString())).thenReturn(Optional.of(mockAdmin));
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);

       
        Admin result = adminService.login(loginDTO);
        assertNull(result);
        
    }

}

