package com.portal.service;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
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
import com.portal.DTO.LoginResponseDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.exceptions.DuplicateEntryException;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.exceptions.WrongCredentialsException;
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
    
    @Autowired
    private LoginResponseDTO response;

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
    public final ResponseDTO registerAdmin(final AdminDTO adminDTO) {
        Employee adminEntity = new Employee();
        
        adminEntity.setRole(Role.ADMIN);
        adminEntity.setManagerId(0L);
        
        adminEntity.setName(adminDTO.getName());
        adminEntity.setEmail(adminDTO.getEmail());
        adminEntity.setEmpId(adminDTO.getEmpId());
        adminEntity.setDesignation(adminDTO.getDesignation());
        adminEntity.setContactNumber(adminDTO.getContactNumber());
        adminEntity.setDob(adminDTO.getDob());
        adminEntity.setDoj(adminDTO.getDoj());
        adminEntity.setLocation(adminDTO.getLocation());
        adminEntity.setPassword(adminDTO.getPassword());
        adminEntity.setManagerId(adminDTO.getManagerId());
        adminEntity.setRole(adminDTO.getRole());
        
        this.adminRepository.save(adminEntity);
        return new ResponseDTO("Admin added successfully", "ADMIN");
    }


    /**
     * Handles admin login.
     *
     * @param loginUser The LoginDTO containing login credentials.
     * @return The authenticated Admin as an AdminDTO, or null if authentication
     *         fails.
     * @throws ResourceNotFoundException if the username is not found.
     */
    public final LoginResponseDTO login(final LoginDTO loginUser) {
        LOGGER.error("Email does not exist");
        Optional<Employee> employee = adminRepository.findByEmail(loginUser.getEmail());
        
        if (employee.isPresent() && passwordEncoder.matches(decodeData(loginUser.getPassword()), employee.get().getPassword())) {
            LOGGER.info("User Logged in");
            
            // Create a LoginResponseDTO object with the necessary parameters
            response.setMessage("Login successful");
            response.setName(employee.get().getName());
            response.setRole(employee.get().getRole());
            response.setMessage("Login Successful");
            response.setId(employee.get().getId());
//            LoginResponseDTO loginResponseDTO = new LoginResponseDTO("", employee.get().getRole(), employee.get().getName());
            
            return response;
        }
        
        LOGGER.error("Wrong Credentials");
        throw new WrongCredentialsException("Wrong Credentials");
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
                 empDto.setProjectName(project.getName());
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
