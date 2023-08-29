package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.LoginDTO;
import com.portal.entities.Admin;
import com.portal.exception.DuplicateEntryException;
import com.portal.exception.ResourceNotFoundException;
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
     * This is for passwordencoder.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new admin.
     *
     * @param adminDTO The AdminDTO containing admin details.
     * @return The registered Admin.
     * @throws DuplicateEntryException if an admin with
     * the same email already exists.
     */
    public final Admin registerAdmin(final AdminDTO adminDTO)
    throws DuplicateEntryException {
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

        if (adminRepository.existsByEmail(adminDTO.getEmail())) {
            throw new DuplicateEntryException("An admin with this "
            + "email already exists.");
        }
            return adminRepository.save(admin);
     }
    /**
     * Handles admin login.
     *
     * @param loginUser The LoginDTO containing login credentials.
     * @return The authenticated Admin.
     * @throws ResourceNotFoundException if the username is not found.
     */
    public final Admin login(final LoginDTO loginUser) {
        Admin registeredUser = adminRepository.findByEmail(loginUser.getEmail())
                .orElseThrow(() ->
                new ResourceNotFoundException("Username not found"));
        System.out.println(loginUser);

        if (registeredUser != null
        &&
        passwordEncoder.matches(loginUser.getPassword(),
          registeredUser.getPassword())) {
            return registeredUser;
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
}
