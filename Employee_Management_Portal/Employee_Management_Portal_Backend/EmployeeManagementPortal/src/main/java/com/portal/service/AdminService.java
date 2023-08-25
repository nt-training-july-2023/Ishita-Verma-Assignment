package com.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.LoginDTO;
import com.portal.entities.Admin;
import com.portal.exception.ResourceNotFoundException;
import com.portal.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Admin registerAdmin(AdminDTO adminDTO) {
		Admin admin = new Admin();
		admin.setEmpId(adminDTO.getEmpId());
		admin.setName(adminDTO.getName());
		admin.setEmail(adminDTO.getEmail());
		admin.setDob(adminDTO.getDob());
		admin.setDoj(adminDTO.getDoj());
		admin.setLocation(adminDTO.getLocation());
		admin.setDesignation(adminDTO.getDesignation());
		admin.setContactNumber(adminDTO.getContactNumber());
		admin.setPassword(adminDTO.getPassword());
		admin.setConfirmPassword(adminDTO.getConfirmPassword());

		return adminRepository.save(admin);
	}

		
	public Admin login(LoginDTO loginUser) {
		Admin registeredUser = adminRepository.findByEmail(loginUser.getEmail()).orElseThrow(()-> new ResourceNotFoundException("Username not found"));
	    if(registeredUser!=null && passwordEncoder.matches(loginUser.getPassword(), registeredUser.getPassword())) {
	    	return registeredUser;
		}
		return null;
	}


	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}
}
