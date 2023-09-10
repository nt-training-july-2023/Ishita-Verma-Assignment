//package com.portal.controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.portal.DTO.AdminDTO;
//import com.portal.DTO.LoginDTO;
//import com.portal.DTO.ResponseDTO;
//import com.portal.entities.Admin;
//import com.portal.exception.WrongCredentialsException;
//import com.portal.service.AdminService;
//
//class AdminControllerTest {
//	 @InjectMocks
//	    private AdminController adminController;
//
//	    @Mock
//	    private AdminService adminService;
//
//	    @BeforeEach
//	    public void setUp() {
//	        MockitoAnnotations.openMocks(this);
//	    }
//
//	    @Test
//	    public void testRegisterAdminSuccess() {
//	        // Create a mock AdminDTO
//	        AdminDTO adminDTO = new AdminDTO();
//	        adminDTO.setName("testadmin");
//	        adminDTO.setPassword("password");
//
//	        // Mock the adminService to return a successful response
//	        when(adminService.registerAdmin(adminDTO)).thenReturn(adminDTO);
//
//	        // Call the registerAdmin method of the controller
//	        ResponseDTO responseDTO = adminController.registerAdmin(adminDTO);
//
//	        // Verify that the response is not null and contains the success message
//	        assertNotNull(responseDTO);
//	        assertEquals("Admin Added successfully", responseDTO.getMessage());
//	    }
//
//	    @Test
//	    public void testRegisterAdminFailure() {
//	        // Create a mock AdminDTO
//	        AdminDTO adminDTO = new AdminDTO();
//	        adminDTO.setName("testadmin");
//	        adminDTO.setPassword("password");
//
//	        // Mock the adminService to return null (indicating failure)
//	        when(adminService.registerAdmin(adminDTO)).thenReturn(null);
//
//	        // Call the registerAdmin method of the controller
//	        ResponseDTO responseDTO = adminController.registerAdmin(adminDTO);
//
//	        // Verify that the response is not null and contains an error message
//	        assertNotNull(responseDTO);
//	        assertEquals("Invalid Credentials", responseDTO.getMessage());
//	    }
//
//	    @Test
//	    public void testGetAllAdmin() {
//	        // Create a list of mock Admin entities
//	        List<Admin> admins = new ArrayList<>();
//	        Admin admin1 = new Admin();
//	        admin1.setName("admin1");
//	        Admin admin2 = new Admin();
//	        admin2.setName("admin2");
//	        admins.add(admin1);
//	        admins.add(admin2);
//
//	        // Mock the adminService to return the list of admins
//	        when(adminService.getAllAdmin()).thenReturn(admins);
//
//	        // Call the getAllAdmin method of the controller
//	        ResponseEntity<List<Admin>> responseEntity = adminController.getAllAdmin();
//
//	        // Verify that the response status code is OK and the list of admins is returned
//	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//	        assertEquals(admins, responseEntity.getBody());
//	    }
//
//	    
//	    @Test
//	    public void testLoginFailure() {
//	        // Create a mock LoginDTO
//	        LoginDTO loginDTO = new LoginDTO();
//	        loginDTO.setEmail("testuser");
//	        loginDTO.setPassword("testpassword");
//
//	        // Mock the adminService to throw a WrongCredentialsException (failure)
//	        when(adminService.login(loginDTO)).thenThrow(new WrongCredentialsException("Wrong credentials"));
//
//	        // Verify that calling the login method of the controller throws a WrongCredentialsException
//	        assertThrows(WrongCredentialsException.class, () -> adminController.login(loginDTO));
//	    }
//}
