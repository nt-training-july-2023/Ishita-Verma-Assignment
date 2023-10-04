package com.portal.validation;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portal.DTO.EmployeeInDTO;
import com.portal.DTO.LoginInDTO;
import com.portal.DTO.ProjectInDTO;
import com.portal.constants.ErrorConstants;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.exceptions.DuplicateEntryException;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.exceptions.WrongCredentialsException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;


import jakarta.validation.Valid;

/**
 * This class provides validation methods for various data inputs.
 */
@Component
public class Validation {
    /**
     * instance for employee repository.
     */
    @Autowired
    private AdminRepository userRepository;
    /**
     * instance for project repository.
     */
    @Autowired
    private ProjectRepository projectRepository;

    /**
     * the logger for this class.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(Validation.class);

    /**
     * Checks if the provided name is valid.
     * @param name The name to be validated.
     * @return true if the name is valid, false otherwise.
     */
    public final boolean checkName(final String name) {
        if (!name.isEmpty() && name.matches("^[A-Za-z ]+$")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the provided email is valid.
     * @param email The email to be validated.
     * @return true if the email is valid, false otherwise.
     */
    public final boolean checkEmail(final String email) {
        if (!email.isEmpty() && email.matches(".*@nucleusteq\\.com$")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the provided employee ID (empId) is valid.
     * @param empId The employee ID (empId) to be validated.
     * @return true if the employee ID (empId) is valid, false otherwise.
     */
    public final boolean checkempId(final String empId) {
        if (!empId.isEmpty() && empId.matches("N\\d{4}$")) {
            return true;
        }
        return false;
    }

    /**
     * Validates a user's registration information.
     * @param userDto The AdminDTO containing user registration details.
     * @return true if the user registration information is valid.
     * @throws WrongCredentialsException if any details are invalid.
     */
    public final boolean checkUser(final EmployeeInDTO userDto) {
        if (!checkName(userDto.getName())) {
            throw new WrongCredentialsException(
                    ErrorConstants.WRONG_NAME);
        }
        if (!checkEmail(userDto.getEmail())) {
            throw new WrongCredentialsException(
                    ErrorConstants.WRONG_EMAIL);
        }
        if (!checkempId(userDto.getEmpId())) {
            throw new WrongCredentialsException(
                    ErrorConstants.WRONG_ID);
        }
        return true;
    }

    /**
     * Validates a user's login credentials.
     * @param loginDto The LoginDTO containing login credentials.
     * @return true if the login credentials are valid.
     * @throws WrongCredentialsException if the provided email is invalid.
     */
    public final boolean checkLoginDto(final LoginInDTO loginDto) {
        if (!checkName(loginDto.getEmail())) {
            throw new WrongCredentialsException(
                    ErrorConstants.WRONG_EMAIL);
        }
        return true;
    }

    /**
     * check if email is already present.
     * @param email employee email.
     * @throws Resource already exists exception.
     */
    public void checkEmailPresent(final String email) {
        Optional<Employee> emp = userRepository.findByEmail(email);
        if (emp.isPresent()) {
            LOGGER.error("Email id already exists");
            throw new DuplicateEntryException(ErrorConstants.EMAIL_EXISTS);
        }
    }

    /**
     * check if employee id is already present.
     * @param empId employee id.
     * @throws Resource already exists exception.
     */
    public void checkEmpId(final String empId) {
        Optional<Employee> emp = userRepository.findByEmpId(empId);
        if (emp.isPresent()) {
            LOGGER.error("Employee id already exists");
            throw new DuplicateEntryException(
                    ErrorConstants.ID_EXISTS);
        }
    }

    /**
     * check to perform admin operation.
     * @param adminDTO Employee dto containing admin informations.
     */
    public void checkAdmin(@Valid final EmployeeInDTO adminDTO) {
        checkEmailPresent(adminDTO.getEmail());
        checkEmpId(adminDTO.getEmpId());
    }

    /**
     * check if email is not present.
     * @param email employee email.
     * @throws Resource not found exception.
     */
    public void checkEmailEmpty(final String email) {
        Optional<Employee> emp = userRepository.findByEmail(email);
        if (emp.isEmpty()) {
            LOGGER.error("Invalid user");
            throw new ResourceNotFoundException(ErrorConstants.INAVALID_USER);
        }
    }

    /**
     * check to perform login operation.
     * @param loginDTO login dto containing login informations.
     */
    public void checkLogin(@Valid final LoginInDTO loginDTO) {
        checkEmailEmpty(loginDTO.getEmail());
    }

    /**
     * check to perform employee operation.
     * @param empDto employee dto containing employee informations.
     */
    public void checkEmployee(@Valid final EmployeeInDTO empDto) {
        // TODO Auto-generated method stub
        checkEmailPresent(empDto.getEmail());
        checkEmpId(empDto.getEmpId());
    }

    /**
     * check if project name is already present.
     * @throws Resource already exists exception.
     * @param name
     */
    public void checkProjectName(final String name) {
        Project project = projectRepository.findByName(name);
        if (project != null) {
        LOGGER.error("Already Exists");
            throw new DuplicateEntryException(
                    ErrorConstants.NAME_EXISTS);
        }
    }
    /**
     * Check if a project exists by ID.
     * @param id The ID of the project to check.
     * @throws UserNotFound If the project does
     * not exist, throw this exception.
     */
    public final void checkProjectExists(final Long id) {
       Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            LOGGER.error(ErrorConstants.PROJECT_NOT_FOUND);
            throw new ResourceNotFoundException(ErrorConstants.PROJECT_NOT_FOUND);
        }
    }
    /**
     * Check if a manager exists by ID.
     * @param id The ID of the manager to check.
     * @throws UserNotFound If the manager does not
     * exist, throw this exception.
     */
    public final void checkManagerExists(final Long id) {
        Employee employee = userRepository.findById(id).orElse(null);
        if (employee == null) {
            LOGGER.error(ErrorConstants.EMPLOYEE_NOT_FOUND);
            throw new ResourceNotFoundException(ErrorConstants.EMPLOYEE_NOT_FOUND);
        } else if (employee.getRole() != Role.MANAGER) {
            LOGGER.error(ErrorConstants.MANAGER_NOT_FOUND);
            throw new ResourceNotFoundException(ErrorConstants.MANAGER_NOT_FOUND);
        }
    }
    /**
     * check to perform project operation.
     * @param projectDto project dto containing project informations.
     */
    public void checkProject(@Valid final ProjectInDTO projectDto) {
        checkProjectName(projectDto.getName());
    }

}
