package com.portal.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.entities.Employee;
import com.portal.repository.AdminRepository;
import com.portal.service.EmployeeService;

import jakarta.validation.Valid;

import com.portal.entities.Role;

/**
 * Controller class for managing employee-related operations.
 */
@CrossOrigin("*")
@RequestMapping("/api/admin")
@RestController
public class EmployeeController {

    /**
     * Repository for managing admin data.
     */
    @Autowired
    private AdminRepository userRepository;

    /**
     * Service for adding employees.
     */
    @Autowired
    private EmployeeService employeeService;
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmployeeController.class);
    /**
     * Adds a new employee.
     *
     * @param userDTO The AdminDTO containing employee details.
     * @return The added employee.
     */
    @PostMapping(path = "/addEmployee")
    public final ApiResponseDTO saveEmployee(
            @RequestBody @Valid final AdminDTO userDTO) {
    	 LOGGER.info("Adding Employee");
        return employeeService.addEmployee(userDTO);
    }

    /**
     * Retrieves a list of employees based on their role.
     *
     * @param roleName The role name for filtering employees.
     * @return A list of employees with the specified role.
     */
    final @GetMapping("all/{roleName}") public List<EmployeeOutDTO> getEmployeesByRole(
            @PathVariable final String roleName) {
       
//        List<Employee> employees = userRepository.findByRole(role);
        LOGGER.info("Getting employee as per the role.");
        return employeeService.getEmployeeByRole(roleName);
    }
    
    @GetMapping("/all/employee/{id}")
    public final Optional<Employee> getEmployeeById(
            @PathVariable final long id) {
    	 LOGGER.info("Getting Employee as per the primary Id.");
        return employeeService.getEmployeeById(id);
    }
    /**
     * Get an employee by their email.
     *
     * @param email The email of the employee to retrieve.
     * @return EmployeeOutDto containing the employee's details if found.
     */
    
    @GetMapping("employee/{email}")
    public final EmployeeOutDTO getEmployeeByEmail(@PathVariable String email){
        LOGGER.info("Getting employee by email");
        return employeeService.getEmployeeByEmail(email);
    }
    /**
     * Update employee details such as project assignment and manager.
     *
     * @param id             The ID of the employee to update.
     * @param updatedDetails Map containing updated project and manager IDs.
     * @return ApiResponse with the result of the operation.
     */
    @PutMapping("/employee/{id}/assignProject")
    public ApiResponseDTO updateDetails(@PathVariable long id,
            @RequestBody Map<String,Long> updatedDetails) {
        LOGGER.info("Updating project id and manager id");
        
        Long projectId = updatedDetails.get("projectId");
        Long managerId= updatedDetails.get("managerId");
        return employeeService.updatedProject(id, projectId, managerId);
    }
   /**
    * Update employee skills.
    *
    * @param id The ID of the employee to update.
    * @param updatedSkills Map containing updated skills.
    * @return ApiResponse with the result of the operation.
    */
   @PutMapping("/employee/{id}/skills")
   public final ApiResponseDTO updateSkills(final @PathVariable long id,
          final @RequestBody Map<String, List<String>> updatedSkills) {
      List<String> skills = updatedSkills.get("skills");
       return employeeService.updateSkills(id, skills);
   }
}
