package com.portal.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.DTO.AdminDTO;
import com.portal.entities.Admin;
import com.portal.exception.DuplicateEntryException;
import com.portal.repository.AdminRepository;
import com.portal.validations.Validation;

/**
 * Service class for adding employees.
 */
@Service
public class AddEmployeeService {

    /**
     * Repository for managing Admin entities.
     */
    @Autowired
    private AdminRepository userRepository;

    /**
     * ModelMapper for mapping between DTOs and entities.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Validation utility for performing data validation.
     */
    @Autowired
    private Validation validation;

    /**
     * Adds an employee based on the provided AdminDTO.
     *
     * @param userDto The AdminDTO containing employee information.
     * @return The added Admin entity.
     * @throws DuplicateEntryException if same email alreadyexists.
     */
    public final Admin addEmployee(final AdminDTO userDto) {

        if (validation.checkUser(userDto)) {
            modelMapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.STRICT);
//             Assign manager
//            if (userDto.getManagerId() == null && !userDto.getEmail()
//                    .equals("ankita.sharma@nucleusteq.com")) {
//                userDto.setManagerId("N0001");
//            }

//            if (userDto.getManager() == null && !userDto.getEmail()
//                    .equals("ankita.sharma@nucleusteq.com")) {
//                userDto.setManager("Ankita Sharma");
//            }

            Admin user = this.modelMapper.map(userDto, Admin.class);
            if (userRepository.findByEmail(userDto.getEmail())
                    .isPresent()) {
                throw new DuplicateEntryException(
                        "Email id already exists");
            }
            userRepository.save(user);
            return user;
        } else {
            return null;
       }
    }
}
