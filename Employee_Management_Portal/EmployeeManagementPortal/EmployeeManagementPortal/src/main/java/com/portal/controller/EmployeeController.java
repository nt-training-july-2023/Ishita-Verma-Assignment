package com.portal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.RequestResourceDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.service.EmployeeService;
import com.portal.validation.Validation;

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
     * Repository for managing admin data.
     */
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private Validation validate;
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
    	  validate.checkEmployee(userDTO);
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
     * @return EmployeeOutDTO containing the employee's details if found.
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
        System.out.println(updatedDetails);
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
//   @PostMapping(path = "/request/resource")
//   public final ApiResponseDTO requestResource(@RequestBody final RequestResourceDTO requestResourceDto){
//       return employeeService.requestResource(requestResourceDto);
//   }
   @GetMapping(path = "/all/request")
   public final List<RequestResourceOutDTO> getAllRequests(){
       return employeeService.getAllRequests();
   }
   @PostMapping("/unassign/{employeeId}")
   public String unassignEmployee(@PathVariable Long employeeId) {
       employeeService.unassignEmployee(employeeId);
       return "Employee unassigned successfully.";
   }
   @GetMapping("all/employees/skills")
   public List<EmployeeOutDTO> empOutList(@RequestParam List<String> skills,@RequestParam boolean isCheck){
       System.out.println(skills );
       System.out.println(isCheck);
       return employeeService.searchBySkills(skills,isCheck);
   }
}
