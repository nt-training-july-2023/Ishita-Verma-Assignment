//package com.portal.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.portal.DTO.AdminDTO;
//import com.portal.DTO.LoginDTO;
//import com.portal.entities.Admin;
//import com.portal.exception.DuplicateEntryException;
//import com.portal.exception.ResourceNotFoundException;
//import com.portal.repository.AdminRepository;
//
//class AdminServiceTest {
//	 @InjectMocks
//	    private AdminService adminService;
//
//	    @Mock
//	    private AdminRepository adminRepository;
//
//	    @Mock
//	    private PasswordEncoder passwordEncoder;
//
//	    @BeforeEach
//	    void setUp() {
//	        MockitoAnnotations.openMocks(this);
//	    }
//
//	    @Test
//	    void testRegisterAdminSuccess() {
//	        // Create a sample AdminDTO
//	        AdminDTO adminDTO = new AdminDTO();
//	        adminDTO.setEmail("test@example.com");
//
//	        // Create a sample Admin entity
//	        Admin adminEntity = new Admin();
//	        adminEntity.setEmail("test@example.com");
//
//	        // Mock the repository's behavior when checking if email exists and saving the admin
//	        when(adminRepository.existsByEmail("test@example.com")).thenReturn(false);
//	        when(adminRepository.save(any(Admin.class))).thenReturn(adminEntity);
//
//	        // Call the service method
//	        AdminDTO result = adminService.registerAdmin(adminDTO);
//
//	        // Verify that the repository methods were called
//	        verify(adminRepository, times(1)).existsByEmail("test@example.com");
//	        verify(adminRepository, times(1)).save(any(Admin.class));
//
//	        // Verify the result
//	        assertNotNull(result);
//	        assertEquals("test@example.com", result.getEmail());
//	    }
//
//
//}
//
