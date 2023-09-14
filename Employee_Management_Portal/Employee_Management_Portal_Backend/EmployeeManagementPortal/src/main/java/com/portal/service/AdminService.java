package com.portal.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.LoginDTO;
import com.portal.entities.Admin;
import com.portal.entities.Role;
import com.portal.exception.DuplicateEntryException;
import com.portal.exception.ResourceNotFoundException;
import com.portal.repository.AdminRepository;

/**
 * Service class for managing admin-related operations.
 */
@Service
public class AdminService {
    /**
     * The repository for admin entities.
     */
    @Autowired
    private AdminRepository adminRepository;

    /**
     * The ModelMapper instance for mapping DTOs to entities and vice versa.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * The password encoder for encoding and decoding passwords.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Decodes Base64 encoded data.
     *
     * @param encodedData The encoded data to decode.
     * @return The decoded data as a string.
     */
    public static String decodeData(final String encodedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedData);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    /**
     * Registers a new admin.
     *
     * @param adminDTO The AdminDTO containing admin details.
     * @return The registered Admin as an AdminDTO.
     * @throws DuplicateEntryException if an admin with the same email already
     *                                 exists.
     */
    public final AdminDTO registerAdmin(final AdminDTO adminDTO) {
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
     * @return The authenticated Admin as an AdminDTO, or null if authentication
     *         fails.
     * @throws ResourceNotFoundException if the username is not found.
     */
    public final AdminDTO login(final LoginDTO loginUser) {
        Admin adminEntity = adminRepository
                .findByEmail(loginUser.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Email id does not exist"));

        if (adminEntity != null && passwordEncoder.matches(
                decodeData(loginUser.getPassword()),
                adminEntity.getPassword())) {
            // Map from Entity to DTO
            AdminDTO adminDTO = modelMapper.map(adminEntity,
                    AdminDTO.class);

            // Set the role in the DTO
            adminDTO.setRole(adminEntity.getRole());

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
        // Fetch all admins from the repository
        List<Admin> allAdmins = adminRepository.findAll();

        // Filter the admins to exclude "Ankita Sharma" and keep only "manager" and "employee"
        List<Admin> filteredAdmins = allAdmins.stream()
                .filter(admin -> !admin.getName().equals("Ankita Sharma"))
                .filter(admin -> admin.getRole().equals(Role.EMPLOYEE) || admin.getRole().equals(Role.MANAGER))
                .collect(Collectors.toList());

        return filteredAdmins;
    }

    /**
     * Retrieves the role of an admin by email.
     *
     * @param email The email of the admin.
     * @return The role of the admin as a string.
     * @throws ResourceNotFoundException if admin with the specified email is
     *                                   not found.
     */
    final public String getUserRoleByEmail(final String email) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with email: " + email));

        return admin.getRole().toString();
    }
}
