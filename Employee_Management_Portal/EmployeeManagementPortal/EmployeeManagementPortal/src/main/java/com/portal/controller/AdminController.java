package com.portal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.LoginDTO;
import com.portal.DTO.LoginResponseDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.entities.Employee;
import com.portal.exceptions.WrongCredentialsException;
import com.portal.service.AdminService;
import com.portal.validation.Validation;

import jakarta.validation.Valid;

/**
 * Controller class to handle Admin-related operations.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class AdminController {
    /**
     * Autowired for admin services.
     */
    @Autowired
    private AdminService adminService;
    
//    @Autowired
//    private Validation validate;
    
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmployeeController.class);
    /**
     * Registers a new admin.
     * @return A success message with the admin's ID.
     * @throws DuplicateEntryException If the admin already exists.
     * @param adminDTO admin
     */
     @PostMapping("/register")
     public final ResponseDTO registerAdmin(
            @Valid @RequestBody final AdminDTO adminDTO) {
//    	    validate.checkAdmin(adminDTO);
    	    LOGGER.info("Adding Admin");
            return adminService.registerAdmin(adminDTO);
        }
   
    /**
     * Retrieves a list of all admins.
     *
     * @return A ResponseEntity containing a list of admins.
     */
     @GetMapping("/getall")
    public List<EmployeeOutDTO> getAllAdmin() {
        List<EmployeeOutDTO> admins = adminService.getAllAdmin();
        LOGGER.info("Get all list of employees.");
        return admins;
    }
    /**
     * Handles admin login.
     *
     * @param loginDto The LoginDTO containing login credentials.
     * @return A ResponseEntity indicating login status.
     */
    final @PostMapping("/login") public LoginResponseDTO login(
            @Valid @RequestBody final LoginDTO loginDto) {
//        AdminDTO adminDTO = adminService.login(loginDto);
//        if (adminDTO == null) {
//            throw new WrongCredentialsException("Wrong credentials");
//        } else {
//            String userRole = adminService
//                    .getUserRoleByEmail(loginDto.getEmail());
//         
//            LoginResponseDTO ResponseDTO = new LoginResponseDTO("Login Successfully",
//                    userRole,adminDTO.getName());
//            LOGGER.info("Login User.");
//            return ResponseDTO;
//        }
//    	 validate.checkLogin(loginDto);
         LOGGER.info("Data is Valid");
         return adminService.login(loginDto);
    }
}

