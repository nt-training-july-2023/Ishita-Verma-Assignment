package com.portal.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.LoginDTO;
import com.portal.configuration.DecryptPassword;
import com.portal.entities.Admin;
import com.portal.exception.DuplicateEntryException;
import com.portal.exception.ResourceNotFoundException;
import com.portal.exception.ValidationException;
import com.portal.repository.AdminRepository;
import com.portal.validations.Validation;
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
     * instance for model mapper class.
     */

    @Autowired
    private ModelMapper modelMapper; 

    /**
     * This is for passwordencoder.
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
    public final AdminDTO registerAdmin( AdminDTO adminDTO) {
    	 Validation valid = new Validation();
    	//e_id
         if (valid.validEmptyData(adminDTO.getEmpId())) {
             throw new ValidationException(
                     "Employee id should not be empty");
         } else if (!valid.validEmpId(adminDTO.getEmpId())) {
             throw new ValidationException(
                     "Employee Id should be in format of 'NXXXX'");
         } else if(!adminRepository.findByEmpId(adminDTO.getEmpId()).isEmpty()) {
             throw new DuplicateEntryException("Employee id already exists");
         }else {
             adminDTO.setEmpId(adminDTO.getEmpId());
         }
         
         //name
      
         if (valid.validEmptyData(adminDTO.getName())) {
             throw new ValidationException("Name should not be empty");
         } else if (!valid.validCharacter(adminDTO.getName())) {
             throw new ValidationException(
                     "Name should contain only letters");
         }else {
             adminDTO.setName(adminDTO.getName());
         }
         
         //email
         
         if (valid.validEmptyData(adminDTO.getEmail())) {
             throw new ValidationException("Email Id should not be empty");
         } else if (!valid.validEmail(adminDTO.getEmail())) {
             throw new ValidationException(
                     "Email Id should ends with @nucleusteq.com");
         } else if (!adminRepository.findByEmail(adminDTO.getEmail()).isEmpty()) {
             throw new DuplicateEntryException(adminDTO.getEmail() + " Already Exists");
         }else{
            adminDTO.setEmail(adminDTO.getEmail());
         }
         
         //dob
         
         if (valid.validEmptyData(adminDTO.getDob())) {
             throw new ValidationException(
                     "Date of Birth should not be empty");
         }else {
             adminDTO.setDob(adminDTO.getDob());
         }
         
         //doj
         
         if (valid.validEmptyData(adminDTO.getDoj())) {
             throw new ValidationException(
                     "Date of Joining should not be empty");
         }else {
             adminDTO.setDoj(adminDTO.getDoj());
         }
         
         // contact no
         
         if (!valid.validContactNumber(adminDTO.getContactNumber())) {
             throw new ValidationException(
                     "Phone number must be of 10 digits only");
         }
         else {
             adminDTO.setContactNumber(adminDTO.getContactNumber());
         }
         
         //password
         
         if (valid.validEmptyData(adminDTO.getPassword())) {
             throw new ValidationException("Password cannot be empty");
         } 
         else {
             adminDTO.setPassword(adminDTO.getPassword());
         }
         
         //confirm password
         if (valid.validEmptyData(adminDTO.getConfirmPassword())) {
             throw new ValidationException(
                     "confirm password cannot be empty");
         } else if (!valid.validConfirmPassword(adminDTO.getConfirmPassword(),
                 adminDTO.getPassword())) {
             throw new ValidationException(
                     "Confirm password should match with passowrd");
         }else {
             adminDTO.setConfirmPassword(adminDTO.getConfirmPassword());
         }
      // Map from DTO to Entity
         Admin adminEntity = modelMapper.map(adminDTO, Admin.class);
         
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
        public final AdminDTO login(final LoginDTO loginUser) {
        	Validation valid = new Validation();
        	
            // email validation
        	
            if (valid.validEmptyData(loginUser.getEmail())) {
                throw new ValidationException("Email Id should not be empty");
            } else if (!valid.validEmail(loginUser.getEmail())) {
                throw new ValidationException(
                        "Email Id should ends with @nucleusteq.com");
            }
            
           //password validation
            
            if (valid.validEmptyData(loginUser.getPassword())) {
                throw new ValidationException("Password should not be empty");
            }
            Admin adminEntity = adminRepository.findByEmail(loginUser.getEmail())
                    .orElseThrow(() -> new ResourceNotFoundException("Email id does not exist"));

            if (adminEntity != null && passwordEncoder.matches(decodeData(loginUser.getPassword()), adminEntity.getPassword())) {
                // Map from Entity to DTO
                return modelMapper.map(adminEntity, AdminDTO.class);
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
