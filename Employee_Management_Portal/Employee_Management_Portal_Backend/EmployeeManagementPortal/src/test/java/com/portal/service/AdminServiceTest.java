package com.portal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.portal.DTO.AdminDTO;
import com.portal.entities.Admin;
import com.portal.entities.Role;
import com.portal.exception.DuplicateEntryException;
import com.portal.exception.ResourceNotFoundException;
import com.portal.repository.AdminRepository;
import org.modelmapper.ModelMapper;

/**
 * Unit tests for the AdminService class.
 */
@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @InjectMocks
    private AdminService adminService;

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private ModelMapper modelMapper;

    /**
     * Test case for registering a new admin.
     */
    @Test
    public void testRegisterAdmin() {
        // Mock data
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmail("test@example.com");
        adminDTO.setPassword("password123");

        Admin adminEntity = new Admin();
        adminEntity.setEmail("test@example.com");
        adminEntity.setPassword("hashed_password");
        adminEntity.setRole(Role.ADMIN);

        when(adminRepository.existsByEmail(adminDTO.getEmail()))
                .thenReturn(false);
        when(modelMapper.map(adminDTO, Admin.class))
                .thenReturn(adminEntity);
        when(adminRepository.save(adminEntity)).thenReturn(adminEntity);
        when(modelMapper.map(adminEntity, AdminDTO.class))
                .thenReturn(adminDTO);

        // Test the service method
        AdminDTO registeredAdmin = adminService.registerAdmin(adminDTO);

        // Assertions
        assertEquals(adminDTO.getEmail(), registeredAdmin.getEmail());
        assertEquals(adminDTO.getPassword(),
                registeredAdmin.getPassword());
    }

    /**
     * Test case for registering a new admin with a duplicate email.
     */
    @Test
    public void testRegisterAdminWithDuplicateEmail() {
        // Mock data
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmail("test@example.com");
        adminDTO.setPassword("password123");

        when(adminRepository.existsByEmail(adminDTO.getEmail()))
                .thenReturn(true);

        // Test the service method and expect a DuplicateEntryException
        try {
            adminService.registerAdmin(adminDTO);
        } catch (DuplicateEntryException e) {
            assertEquals("Email already exists", e.getMessage());
        }
    }

    /**
     * Test case for retrieving all admin entities.
     */
//    @Test
//    public void testGetAllAdmin() {
//        // Mock data
//        List<Admin> adminList = new ArrayList<>();
//        adminList.add(new Admin());
//        adminList.add(new Admin());
//
//        when(adminRepository.findAll()).thenReturn(adminList);
//
//        // Test the service method
//        List<Admin> retrievedAdmins = adminService.getAllAdmin();
//
//        // Assertion
//        assertEquals(adminList.size(),retrievedAdmins.size());
//    }

    /**
     * Test case for retrieving the user role by email.
     */
    @Test
    public void testGetUserRoleByEmail() {
        // Mock data
        String email = "test@example.com";
        Admin adminEntity = new Admin();
        adminEntity.setEmail(email);
        adminEntity.setRole(Role.ADMIN);

        when(adminRepository.findByEmail(email))
                .thenReturn(Optional.of(adminEntity));

        // Test the service method
        String userRole = adminService.getUserRoleByEmail(email);

        // Assertion
        assertEquals(Role.ADMIN.toString(), userRole);
    }

    /**
     * Test case for retrieving the user role by an invalid email.
     */
    @Test
    public void testGetUserRoleByEmailWithInvalidEmail() {
        // Mock data
        String email = "nonexistent@example.com";

        when(adminRepository.findByEmail(email))
                .thenReturn(Optional.empty());

        // Test the service method and expect ResourceNotFoundException
        try {
            adminService.getUserRoleByEmail(email);
        } catch (ResourceNotFoundException e) {
            assertEquals("User not found with email: " + email,
                    e.getMessage());
        }
    }
}
