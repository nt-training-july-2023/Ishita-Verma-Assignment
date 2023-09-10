package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.LoginDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.entities.Admin;
import com.portal.exception.DuplicateEntryException;
import com.portal.exception.WrongCredentialsException;
import com.portal.service.AdminService;

/**
 * Controller class to handle Admin-related operations.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class AdminController { /**
     * Autowired for admin services.
     */
    @Autowired
    private AdminService adminService;
    /** 
     * Autowired for password encoder.
     */
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new admin.
     *
     * @param admin The AdminDTO containing admin details.
     * @return A success message with the admin's ID.
     * @throws DuplicateEntryException If the admin already exists.
     */
    final @PostMapping("/register")
    public ResponseDTO registerAdmin(@Valid @RequestBody final AdminDTO adminDTO) {
        AdminDTO createUser = adminService.registerAdmin(adminDTO);
        if(createUser != null) {
        ResponseDTO response = new ResponseDTO("Admin Added succesfully","");
        return response;
        }
        else {
        	ResponseDTO response = new ResponseDTO("Invalid Credentials","");
            return response;
        }
    }

    /**
     * Retrieves a list of all admins.
     *
     * @return A ResponseEntity containing a list of admins.
     */
    final @GetMapping("/getall")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> admins = adminService.getAllAdmin();
        return ResponseEntity.ok(admins);
    }

    /**
     * Handles admin login.
     *
     * @param loginDto The LoginDTO containing login credentials.
     * @return A ResponseEntity indicating login status.
     */
//  final @PostMapping("/login")
//  public Map<String, String> login(@RequestBody final LoginDTO loginDto) {
////  	 if (adminService.login(loginDto) == null) {
////           throw new WrongCredentialsException("Wrong credentials");
////       } else {
////           return new ResponseDTO("Login Succesfully");
////       }
//	  return adminService.login(loginDto);
//  }


    final @PostMapping("/login")
    public ResponseDTO login(@Valid @RequestBody final LoginDTO loginDto) {
        AdminDTO adminDTO = adminService.login(loginDto);
 
        if (adminDTO == null) {
            throw new WrongCredentialsException("Wrong credentials");
        } else {
            // Fetch the user's role based on their email or identifier
            String userRole = adminService.getUserRoleByEmail(loginDto.getEmail());

            // Create a new ResponseDTO that includes the role
            ResponseDTO ResponseDTO = new ResponseDTO("Login Successfully", userRole);

            return ResponseDTO;
        }
    }
   
}
