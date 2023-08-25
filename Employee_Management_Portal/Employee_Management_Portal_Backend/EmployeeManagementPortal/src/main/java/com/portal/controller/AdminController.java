package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.LoginDTO;
import com.portal.entities.Admin;
import com.portal.service.AdminService;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/admin")

public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public String registerAdmin(@RequestBody AdminDTO admin) {

		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		adminService.registerAdmin(admin);

		return "Admin registered with ID: " + admin.getAdminId();
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Admin>> getAllAdmin() {
		List<Admin> admins = adminService.getAllAdmin();
		return ResponseEntity.ok(admins);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDto) {
		if (adminService.login(loginDto) == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong credentials");
		}
		return ResponseEntity.status(HttpStatus.OK).body(" Successfully logged in");

	}

}
