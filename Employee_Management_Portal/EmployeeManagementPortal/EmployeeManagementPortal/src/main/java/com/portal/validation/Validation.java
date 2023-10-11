package com.portal.validation;

import java.util.List;
import java.util.Map;
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
import com.portal.exceptions.ValidationException;
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
            throw new DuplicateEntryException(ErrorConstants.ID_EXISTS);
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
            throw new ResourceNotFoundException(
                    ErrorConstants.INAVALID_USER);
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
            LOGGER.error("Project with this name already Exists");
            throw new DuplicateEntryException(ErrorConstants.NAME_EXISTS);
        }
    }

    /**
     * Check if a project exists by ID.
     * @param id The ID of the project to check.
     * @throws UserNotFound If the project does not exist, throw this exception.
     */
    public final void checkProjectExists(final Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            LOGGER.error(ErrorConstants.PROJECT_NOT_FOUND);
            throw new ResourceNotFoundException(
                    ErrorConstants.PROJECT_NOT_FOUND);
        }
    }

    /**
     * Check if a manager exists by ID.
     * @param id The ID of the manager to check.
     * @throws UserNotFound If the manager does not exist, throw this exception.
     */
    public final void checkManagerExists(final Long id) {
        Employee employee = userRepository.findById(id).orElse(null);
        if (employee == null) {
            LOGGER.error(ErrorConstants.EMPLOYEE_NOT_FOUND);
            throw new ResourceNotFoundException(
                    ErrorConstants.EMPLOYEE_NOT_FOUND);
        } else if (employee.getRole() != Role.MANAGER) {
            LOGGER.error(ErrorConstants.MANAGER_NOT_FOUND);
            throw new ResourceNotFoundException(
                    ErrorConstants.MANAGER_NOT_FOUND);
        }
    }

    /**
     * check to perform project operation.
     * @param projectDto project dto containing project informations.
     */
    public void checkProject(@Valid final ProjectInDTO projectDto) {
        checkProjectName(projectDto.getName());
    }
    /**
     * checking employee exists.
     * @param id id of employee.
     * @throws ResourceNotFoundException
     */
    public void checkEmployeeExists(final Long id) {
        Optional<Employee> employee = userRepository.findById(id);
        if (employee.isEmpty()
                || employee.get().getRole() != Role.EMPLOYEE) {
            LOGGER.error(ErrorConstants.EMPLOYEE_NOT_FOUND);
            throw new ResourceNotFoundException(
                    ErrorConstants.EMPLOYEE_NOT_FOUND);
        }
    }
    /**.
     * check to perform update skills operation.
     * @param id
     * @param updatedSkills
     */
    public void checkUpdateSkills(final Long id,
            final Map<String, List<String>> updatedSkills) {
        checkEmployeeExists(id);
        List<String> skills = updatedSkills.get("skills");
        checkSkills(skills);
    }
    /**
     * checking skills list.
     * @param skills list of skills
     * @throws ValidationException
     */
    public void checkSkills(final List<String> skills) {
        if (skills.size() == 0) {
            throw new ValidationException(ErrorConstants.SKILLS_REQUIRED);
        }
    }
}
