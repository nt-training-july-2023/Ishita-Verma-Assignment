package com.portal.service;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.LoginDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.exceptions.DuplicateEntryException;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;

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
     * The repository for project entities.
     */
    @Autowired
    private ProjectRepository projectRepository;

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
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AdminService.class);
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
        	LOGGER.error("Email already exists");
            throw new DuplicateEntryException("Email already exists");
        }
        // Map from DTO to Entity
        Employee adminEntity = modelMapper.map(adminDTO, Employee.class);
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
    	LOGGER.error("Email does not exists");
        Employee adminEntity = adminRepository
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
    public final List<EmployeeOutDTO> getAllAdmin() {
    	 List<Employee> allEmployee = adminRepository.findAll();
         List<Employee> filteredEmployees = allEmployee.stream().filter(
                 employee -> employee.getRole().equals(Role.EMPLOYEE)
                         || employee.getRole().equals(Role.MANAGER))
                 .collect(Collectors.toList());
         List<EmployeeOutDTO> employeeDTOList = new ArrayList<EmployeeOutDTO>();
         for (Employee employee : filteredEmployees) {
             EmployeeOutDTO empDto = new EmployeeOutDTO();
             empDto.setId(employee.getId());
             empDto.setName(employee.getName());
             empDto.setEmail(employee.getEmail());
             empDto.setEmpId(employee.getEmpId());
             empDto.setDesignation(employee.getDesignation());
             empDto.setContactNumber(employee.getContactNumber());
             empDto.setDob(employee.getDob());
             empDto.setDoj(employee.getDoj());
             empDto.setLocation(employee.getLocation());
             if (employee.getProjectId() == 0) {
                 empDto.setProjectId(null);
             } else {
                 Project project = projectRepository
                         .findById(employee.getProjectId()).get();
                 empDto.setProjectId(project.getName());
             }
             Employee manager = adminRepository
                     .findById(employee.getManagerId()).get();
             empDto.setManager(manager.getName());
             empDto.setManagerId(employee.getManagerId());
             empDto.setSkills(employee.getSkills());
             employeeDTOList.add(empDto);
         }
         return employeeDTOList;
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
    	LOGGER.error("Employee not found with email");
        Employee admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with email: " + email));

        return admin.getRole().toString();
    }
}
