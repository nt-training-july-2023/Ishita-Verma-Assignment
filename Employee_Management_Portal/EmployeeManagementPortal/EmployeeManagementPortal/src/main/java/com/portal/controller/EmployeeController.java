package com.portal.controller;

import java.util.List;
import java.util.Map;

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

import com.portal.DTO.EmployeeInDTO;
import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.entities.Role;
import com.portal.service.EmployeeService;
import com.portal.validation.Validation;

import jakarta.validation.Valid;

/**
 * Controller class for managing employee-related operations.
 */
@CrossOrigin("*")
@RequestMapping("/")
@RestController
public class EmployeeController {
	/**
     * Autowired for Validation class.
     */
    @Autowired
    private Validation validate;
    /**
     * Service for adding employees.
     */
    @Autowired
    private EmployeeService employeeService;
    /**
     * Logger instance for logging purposes.
     */
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
            @RequestBody @Valid final EmployeeInDTO userDTO) {
    	LOGGER.info("Adding Employee");
    	  validate.checkEmployee(userDTO);
    	 LOGGER.info("Valid user : " + userDTO.toString());
    	 ApiResponseDTO response = employeeService.addEmployee(userDTO);
        return response;
    }
    /**
     * Retrieves a list of employees based on their role.
     *
     * @param roleName The role name for filtering employees.
     * @return A list of employees with the specified role.
     */
     @GetMapping("all/{roleName}") 
     public final List<EmployeeOutDTO> getEmployeesByRole(@Valid
            @PathVariable final Role roleName) {
//        List<Employee> employees = userRepository.findByRole(role);
        LOGGER.info("Getting employee as per the role.");
        List<EmployeeOutDTO> list = employeeService.getEmployeeByRole(roleName);
        return list;
    }
     /**
      * Retrieves an employee by their unique ID.
      *
      * @param id The unique ID of the employee to retrieve.
      * @return An EmployeeOutDTO representing the employee with the specified ID.
      */
     @GetMapping("/all/employee/{id}")
     public final EmployeeOutDTO getEmployeeByID(@PathVariable final Long id) {
         LOGGER.info("Get Employee by Id:" + id);
         EmployeeOutDTO emp = employeeService.getEmployeeById(id);
         return emp;
     }

    /**
     * Get an employee by their email.
     *
     * @param email The email of the employee to retrieve.
     * @return EmployeeOutDTO containing the employee's details if found.
     */
    
    @GetMapping("employee/{email}")
    public final EmployeeOutDTO getEmployeeByEmail(@Valid @PathVariable final String email){
        LOGGER.info("Getting employee by email");
        EmployeeOutDTO employeeOutDto = employeeService.getEmployeeByEmail(email);
        return employeeOutDto;
    }
    /**
     * Update employee details such as project assignment and manager.
     *
     * @param id             The ID of the employee to update.
     * @param updatedDetails Map containing updated project and manager IDs.
     * @return ApiResponse with the result of the operation.
     */
    @PutMapping("/employee/{id}/assignProject")
    public final ApiResponseDTO updateDetails(@Valid @PathVariable final Long id,
            @RequestBody Map<String,Long> updatedDetails) {
        LOGGER.info("Updating project id and manager id");
        Long projectId = updatedDetails.get("projectId");
        Long managerId= updatedDetails.get("managerId");
        ApiResponseDTO response = employeeService.updatedProject(id, projectId, managerId);
        return response;
    }
   /**
    * Update employee skills.
    *
    * @param id The ID of the employee to update.
    * @param updatedSkills Map containing updated skills.
    * @return ApiResponse with the result of the operation.
    */
   @PutMapping("/employee/{id}/skills")
   public final ApiResponseDTO updateSkills(final @Valid @PathVariable Long id,
          final @RequestBody Map<String, List<String>> updatedSkills) {
	   LOGGER.info("updating skills");
      List<String> skills = updatedSkills.get("skills");
	   ApiResponseDTO response = employeeService.updateSkills(id, skills);
       return response;
   }
   /**
    * Retrieves a list of all requests.
    * @return A list of RequestResourceOutDTO representing all requests.
    */
   @GetMapping(path = "/all/request")
   public final List<RequestResourceOutDTO> getAllRequests(){
       LOGGER.info("Getting all requests");
       List<RequestResourceOutDTO> list = employeeService.getAllRequests();
       return list;
   }

   /**
    * Unassigns a project from an employee.
    * @param employeeId The ID of the employee to unassign a project from.
    * @return A message indicating the success of the unassignment.
    */
   @PostMapping("/unassign/{employeeId}")
   public final String unassignEmployee(@Valid @PathVariable final Long employeeId) {
       LOGGER.info("Unassign project to employee");
       employeeService.unassignEmployee(employeeId);
       return "Employee unassigned successfully.";
   }

   /**
    * Retrieves a list of employees with specific skills.
    * @param skills   A list of skills to filter employees by.
    * @param isCheck  A boolean flag indicating whether to include unassigned employees.
    * @return A list of EmployeeOutDTO representing employees with the given skills.
    */
   @GetMapping("all/employees/skills")
   public final List<EmployeeOutDTO> empOutList(@Valid @RequestParam final List<String> skills, @RequestParam boolean isCheck){
       LOGGER.info("Getting employees with given skills");
       List<EmployeeOutDTO> list = employeeService.skillsAndUnassign(skills, isCheck);
       return list;
   }
}
