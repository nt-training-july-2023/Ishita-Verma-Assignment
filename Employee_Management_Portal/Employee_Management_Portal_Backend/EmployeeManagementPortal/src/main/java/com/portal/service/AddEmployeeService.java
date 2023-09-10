package com.portal.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.DTO.AdminDTO;
import com.portal.entities.Admin;
import com.portal.exception.DuplicateEntryException;
import com.portal.repository.AdminRepository;
import com.portal.validations.Validation;
	
@Service
public class AddEmployeeService {

    @Autowired
    private AdminRepository userRepository;
 
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private Validation validation;

    public final String addEmployee(final AdminDTO userDTO) {
//        Validation validation = new Validation();
//        
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new DuplicateEntryException("Email already exists");
        }
        if (userRepository.existsByEmpId(userDTO.getEmpId())) {
            throw new DuplicateEntryException("Employee Id already exists");
        }

        if (validation.validEmptyData(userDTO.getName())) {
            throw new IllegalArgumentException("Name should not be empty");
        } else if (!validation.validCharacter(userDTO.getName())) {
            throw new IllegalArgumentException("Name should not contain numbers");
        }

        // Validation for Email
        if (validation.validEmptyData(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email cannot be empty");
        } else if (!validation.validEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email should end with @nucleusteq.com");
        }

        // Validation for EmpID
        if (validation.validEmptyData(userDTO.getEmpId())) {
            throw new IllegalArgumentException("EmpID cannot be empty");
        } else if (!validation.validEmpId(userDTO.getEmpId())) {
            throw new IllegalArgumentException("EmpID should be in the format NXXXX");
        }

        // Validation for DOB
        if (validation.validEmptyData(userDTO.getDob())) {
            throw new IllegalArgumentException("DOB cannot be empty");
        } else if (!validation.validDate(userDTO.getDob())) {
            throw new IllegalArgumentException("DOB should be in the format DD-MM-YYYY");
        }

        // Validation for DOJ
        if (validation.validEmptyData(userDTO.getDoj())) {
            throw new IllegalArgumentException("DOJ cannot be empty");
        } else if (!validation.validDate(userDTO.getDoj())) {
            throw new IllegalArgumentException("DOJ should be in the format DD-MM-YYYY");
        }

        // Validation for Phone Number
        if (validation.validEmptyData(userDTO.getContactNumber())) {
            throw new IllegalArgumentException("Phone No cannot be empty");
        } else if (!validation.validContactNumber(userDTO.getContactNumber())) {
            throw new IllegalArgumentException("Phone No must be of length 10");
        }

        // Assign manager
        if (userDTO.getManagerId() == null && !userDTO.getEmail().equals("ankita.sharma@nucleusteq.com")) {
            userDTO.setManagerId("N0001");
        }

        if (userDTO.getManager() == null && !userDTO.getEmail().equals("ankita.sharma@nucleusteq.com")) {
            userDTO.setManager("Ankita Sharma");
        }
        Admin user = this.modelMapper.map(userDTO, Admin.class);
        userRepository.save(user);
        return user.getName();
    }
}
