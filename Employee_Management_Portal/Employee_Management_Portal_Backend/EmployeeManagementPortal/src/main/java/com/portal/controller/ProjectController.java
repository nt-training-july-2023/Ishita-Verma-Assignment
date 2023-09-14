//package com.portal.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.portal.DTO.ProjectDTO;
//import com.portal.entities.Project;
//import com.portal.repository.ProjectRepository;
//import com.portal.service.AddProjectService;
//
///**
// * Controller class for managing projects.
// */
//@CrossOrigin("*")
//@RequestMapping("/api/admin")
//@RestController
//public class ProjectController {
//    /**
//     * Autowire for ProjectRepository.
//     */
//    @Autowired
//    private ProjectRepository projectRepository;
//    /**
//     * Create objects of AddProjectService.
//     */
//    @Autowired
//    private AddProjectService addProjectService;
//
//    /**
//     * Endpoint for adding a new project.
//     *
//     * @param projectDTO The ProjectDTO containing project details.
//     * @return A string indicating the result of the operation.
//     */
//    @PostMapping(path = "/addProject")
//    public final String saveProject(
//            @RequestBody final ProjectDTO projectDTO) {
//        return addProjectService.addProject(projectDTO);
//    }
//
//    /**
//     * Endpoint for retrieving all projects.
//     * @return A list of Project entities.
//     */
//    final @GetMapping(path = "/projects")
//    public List<Project> getAllProjects() {
//        return projectRepository.findAll();
//    }
//
//    /**
//     * Endpoint for retrieving skills associated with a project by name.
//     * @param name The name of the project.
//     * @return A list of skills associated with the project.
//     */
//    final @GetMapping(path = "/project/skills")
//    public List<String> getSkillsForProject(@RequestParam final String name) {
//        return addProjectService.getSkillsForProject(name);
//    }
//    /**
//     * get Employe by EmpId.
//     * @param empId employee Id
//     * @return empId
//     */
//    @GetMapping("/employee/{empId}")
//    public final Object getEmployeeByEmpId(
//            @PathVariable final String empId) {
//        return addProjectService.getEmployeeByEmpId(empId);
//    }
//    
//}
