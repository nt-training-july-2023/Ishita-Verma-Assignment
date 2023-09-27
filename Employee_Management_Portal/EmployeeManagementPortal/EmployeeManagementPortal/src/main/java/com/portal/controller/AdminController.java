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
    
    @Autowired
    private Validation validate;
    
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
    	    validate.checkAdmin(adminDTO);
    	    LOGGER.info("Adding Admin");
    	    ResponseDTO responseDto = adminService.registerAdmin(adminDTO);
            return responseDto;
        }
   
    /**
     * Retrieves a list of all admins.
     *
     * @return A ResponseEntity containing a list of admins.
     */
     @GetMapping("/getall")
    public final List<EmployeeOutDTO> getAllAdmin() {
    	 LOGGER.info("Get all list of employees.");
        List<EmployeeOutDTO> admins = adminService.getAllAdmin();
        return admins;
    }
    /**
     * Handles admin login.
     *
     * @param loginDto The LoginDTO containing login credentials.
     * @return A ResponseEntity indicating login status.
     */
     @PostMapping("/login")
     public final LoginResponseDTO login(
            @Valid @RequestBody final LoginDTO loginDto) {
         LOGGER.info("Loggin in user");
         validate.checkLogin(loginDto);
         LOGGER.info("Valid login dto: " + loginDto.toString());
         LoginResponseDTO loginResponse = adminService.login(loginDto);
         return loginResponse;
    }
}

