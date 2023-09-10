package com.portal.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.LoginDTO;
import com.portal.configuration.DecryptPassword;
import com.portal.entities.Admin;
import com.portal.entities.Role;
import com.portal.exception.DuplicateEntryException;
import com.portal.exception.ResourceNotFoundException;
import com.portal.exception.ValidationException;
import com.portal.repository.AdminRepository;

/**
 * This is a package for java docs for service.
 */
@Service
public class AdminService { 
    /**
     * This is for adminrepositories.
     */
    @Autowired
    private AdminRepository adminRepository;
    
    /**
     * Instance for model mapper class.
     */
    @Autowired
    private ModelMapper modelMapper; 

    /**
     * This is for password encoder.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public static String decodeData(String encodedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedData); 
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
    
    /**
     * Registers a new admin.
     *
     * @param adminDTO The AdminDTO containing admin details.
     * @return The registered Admin.
     * @throws DuplicateEntryException if an admin with
     * the same email already exists.
     */
    public final AdminDTO registerAdmin(AdminDTO adminDTO) {
    	if (adminRepository.existsByEmail(adminDTO.getEmail())) {
            throw new DuplicateEntryException("Email already exists");
        }
         // Map from DTO to Entity
         Admin adminEntity = modelMapper.map(adminDTO, Admin.class);
         adminEntity.setRole(Role.ADMIN);
         
         // Save the Entity in the repository
         adminEntity = adminRepository.save(adminEntity);

         // Map back from Entity to DTO
         return modelMapper.map(adminEntity, AdminDTO.class);
     }
    
    
    /**
     * Handles admin login.
     *
     * @param loginUser The LoginDTO containing login credentials.
     * @return The authenticated Admin.
     * @throws ResourceNotFoundException if the username is not found.
     */
    public final AdminDTO login(LoginDTO loginUser) {
        Admin adminEntity = adminRepository.findByEmail(loginUser.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Email id does not exist"));

        if (adminEntity != null && passwordEncoder.matches(decodeData(loginUser.getPassword()), adminEntity.getPassword())) {
            // Map from Entity to DTO
            AdminDTO adminDTO = modelMapper.map(adminEntity, AdminDTO.class);

            // Set the role in the DTO
            adminDTO.setRole(adminEntity.getRole()); // Assuming 'role' is a field in the Admin entity

            return adminDTO;
        }

        return null;
    }
    
    /**
     * Retrieves a list of all admins.
     *
     * @return A list containing all admins.
     */
    public final List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }
    
    public String getUserRoleByEmail(String email) {
        Admin admin = adminRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));

        return admin.getRole().toString(); 
    }

}
