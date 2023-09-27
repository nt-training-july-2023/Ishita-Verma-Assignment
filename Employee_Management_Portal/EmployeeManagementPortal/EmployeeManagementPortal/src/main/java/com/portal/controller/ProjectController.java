package com.portal.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.ProjectDTO;
import com.portal.DTO.ProjectOutDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.repository.ProjectRepository;
import com.portal.service.AdminService;
import com.portal.service.EmployeeService;
import com.portal.service.ProjectService;
import com.portal.validation.Validation;

import jakarta.persistence.Tuple;
import jakarta.validation.Valid;

/**
 * Controller class for managing projects.
 */
@CrossOrigin("*")
@RequestMapping("/api/admin")
@RestController
public class ProjectController {
    /**
     * Autowired for ProjectService.
     */
    @Autowired
    private ProjectService projectService;
   
    @Autowired
    private Validation validate;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProjectController.class);
    /**
     * Endpoint for adding a new project.
     *
     * @param projectDTO The ProjectDTO containing project details.
     * @return A string indicating the result of the operation.
     */
    @PostMapping(path = "/addProject")
    public final ApiResponseDTO saveProject(
            @RequestBody @Valid final ProjectDTO projectDTO) {
    	LOGGER.info("Adding project.");
//    	 validate.checkProject(projectDTO);
        return projectService.addProject(projectDTO);
    }

    /**
     * Endpoint for retrieving all projects.
     * @return A list of Project entities.
     */
     @GetMapping(path = "/projects")
    public final List<ProjectOutDTO> getProjects() {
        LOGGER.info("Getting Projects");
        List<ProjectOutDTO> list = projectService.getProjects();
        return list;
    }
    /**
     * Endpoint for retrieving all projects.
     * @return A list of Project entities.
     */
    @GetMapping(path = "/projects/{managerId}")
    public final List<ProjectOutDTO> getProjectByManagerId(@PathVariable Long managerId) {
        LOGGER.info("Getting Projects for managerId: " + managerId);
        System.out.println("Received managerId: " + managerId);
        List<ProjectOutDTO> list = projectService.getProjectByManagerId(managerId);
        return list;
    }

    /**
     * Endpoint for retrieving skills associated with a project by name.
     * @param name The name of the project.
     * @return A list of skills associated with the project.
     */
    final @GetMapping(path = "/project/skills")
    public List<String> getSkillsForProject(@RequestParam final String name) {
    	LOGGER.info("Getting projects as per the skills.");
    	List<String> list = projectService.getSkillsForProject(name);
        return list;
    }
    /**
     * Retrieves a list of unassigned employees.
     *
     * @return A list of unassigned employees represented as ProjectOutDTOs.
     */
    @GetMapping("/unassigned")
    public final List<Employee> getUnassignedEmployees() {
        List<Employee> unassignedEmployees = projectService.getEmployeesWithUnassignedProjects(); 
        return unassignedEmployees;
    }
   

    
    
}
