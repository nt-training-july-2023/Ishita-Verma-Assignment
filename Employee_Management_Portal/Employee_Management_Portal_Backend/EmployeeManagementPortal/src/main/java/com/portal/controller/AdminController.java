package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> registerAdmin(@RequestBody @Valid AdminDTO admin) {
        try {
            admin.setPassword(admin.getPassword());
            adminService.registerAdmin(admin, null);
            return ResponseEntity.ok("Admin registered with ID: " + admin.getAdminId());
        } catch (DuplicateEntryException e) {
            return ResponseEntity.badRequest().body("An admin with this email already exists.");
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
    final @PostMapping("/login")
    public ResponseDTO login(@RequestBody final LoginDTO loginDto) {
//     try {
             if (adminService.login(loginDto) == null) {
                 ResponseDTO response = new ResponseDTO("Wrong credentials",
                         null, HttpStatus.BAD_REQUEST.value());
                 return response;
             } else {
                 ResponseDTO response = new ResponseDTO("Login successful",
                         loginDto, HttpStatus.OK.value());
                 return response;
             }
//         } catch (Exception e) {
//             ResponseDTO response = new ResponseDTO(e.getMessage(),
//                     null, HttpStatus.BAD_REQUEST.value());
//             return response;
//         }
    }
}
