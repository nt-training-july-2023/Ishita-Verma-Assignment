//package com.portal.service;
//
//import com.portal.DTO.ProjectDTO;
//import com.portal.DTO.UserDTO;
//import com.portal.entities.Admin;
//import com.portal.entities.Project;
//import com.portal.exception.ResourceNotFoundException;
//import com.portal.repository.AdminRepository;
//import com.portal.repository.ProjectRepository;
//import com.portal.validations.Validation;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import org.modelmapper.ModelMapper;
//import org.modelmapper.convention.MatchingStrategies;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Service class for adding and managing projects.
// */
//@Service
//public class AddProjectService {
//
//    /**
//     * Repository for managing Project entities.
//     */
//    @Autowired
//    private ProjectRepository projectRepository;
//    /**
//     * Repository for managing Project entities.
//     */
//    @Autowired
//    private AdminRepository userRepository;
//
//    /**
//     * ModelMapper for mapping between DTOs and entities.
//     */
//    @Autowired
//    private ModelMapper modelMapper;
//
//    /**
//     * Validation utility for performing project data validation.
//     */
//    @Autowired
//    private Validation projectValidation;
//
//    /**
//     * Adds a new project based on the provided ProjectDTO.
//     *
//     * @param projectDTO The ProjectDTO containing project information.
//     * @return The name of the added project.
//     */
//    public String addProject(final ProjectDTO projectDTO) {
//        modelMapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.STRICT);
//        Project project = modelMapper.map(projectDTO, Project.class);
//        projectRepository.save(project);
//        return project.getName();
//    }
//
//    /**
//     * Retrieves the skills associated with a project by its name.
//     *
//     * @param name The name of the project.
//     * @return list of skills with the project, or empty list
//     *         if the project is not found.
//     */
//    final public List<String> getSkillsForProject(final String name) {
//        Project project = projectRepository.findByName(name);
//        if (project != null) {
//            String skillArray = project.getSkills();
//            return Arrays.asList(skillArray);
//        }
//        return Collections.emptyList(); // Project not found or no skills
//    }
//    /**
//     * Drop Down Manager ID and Name.
//     * @param empId Id of Manager
//     * @return employeeName
//     */
//    public final UserDTO getEmployeeByEmpId(final String empId) {
//        Optional<Admin> optionalEmployee = userRepository
//                .findByEmpId(empId);
//        System.out.println("Employee Id: " + empId);
//        Admin employee = optionalEmployee.orElseThrow(
//                () -> new ResourceNotFoundException("Employee Id does not exist"));
//        String employeeName = employee.getName();
//        System.out.println("Manger Id " + employeeName);
//        return new UserDTO(employeeName);
//    }
//    /**
//     * getProjectByProjectID.
//     * @param managerID managerID
//     * @return projectDetails
//     */
////    public final List<ProjectDTO> getProjectByManagerID(
////            final String managerId) {
////        List<Project> projectDetails = projectRepository
////                .findAllByManagerId(managerId);
////        List<ProjectDTO> projectList = new ArrayList<ProjectDTO>();
////        for (Project project : projectDetails) {
////            ProjectDTO projectOutDTO = new ProjectDTO();
////            projectOutDTO.setProjectId(project.getProjectId());
////            projectOutDTO.setName(project.getName());
////            projectOutDTO.setManagerId(project.getManagerId());
////            projectOutDTO.setSkills(project.getSkills());
////            projectList.add(projectOutDTO);
////        }
////        return projectList;
////    }
//}
