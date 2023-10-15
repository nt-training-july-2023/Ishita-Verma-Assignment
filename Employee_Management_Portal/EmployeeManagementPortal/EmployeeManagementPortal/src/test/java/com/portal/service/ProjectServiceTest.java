package com.portal.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.ProjectInDTO;
import com.portal.DTO.ProjectOutDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.entities.Designation;
import com.portal.entities.Employee;
import com.portal.entities.Location;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;

class ProjectServiceTest {

    @InjectMocks
    private ProjectService projectService;
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private AdminRepository userRepository;
  

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    List<String> skills = new ArrayList<>();
    List<String> teams = new ArrayList<>();

    @Test
    void testAddProject() {
        ProjectInDTO projectDto = new ProjectInDTO();
        skills.add("React");
        skills.add("Java");
        projectDto.setProjectId(1L);
        projectDto.setName("Fynder");
        projectDto.setManagerId(1L);
        projectDto.setStartDate("2023-09-07");
        projectDto.setDescription("Description");
        projectDto.setSkills(skills);

        Project project = new Project();
        skills.add("React");
        skills.add("Java");
        project.setProjectId(1L);
        project.setName("Exam Portal");
        project.setManagerId(1L);
        project.setStartDate("2023-09-07");
        project.setDescription("Description");
        project.setSkills(skills);

        when(projectRepository.findByName(project.getName()))
                .thenReturn(project);
       
        when(projectRepository.save(project)).thenReturn(project);

        ApiResponseDTO result = projectService.addProject(projectDto);
        assertEquals("Project added successfully", result.getMessage());

    }

    @Test
    void testGetSkillsForProject() {
        // Define the project name for testing
        String projectName = "Test Project";

        // Create a test project
        Project project = new Project();
        project.setName(projectName);
        List<String> expectedSkills = Arrays.asList("Java", "React",
                "SQL");
        project.setSkills(expectedSkills);

        // Mock projectRepository.findByName to return the test project
        when(projectRepository.findByName(projectName))
                .thenReturn(project);

        // Test when the project is found
        List<String> resultSkills = projectService
                .getSkillsForProject(projectName);
        assertEquals(expectedSkills, resultSkills);

        // Mock projectRepository.findByName to return an empty optional
        when(projectRepository.findByName(projectName)).thenReturn(null);

        // Test when the project is not found
        List<String> emptyResultSkills = projectService
                .getSkillsForProject(projectName);
        assertEquals(Collections.emptyList(), emptyResultSkills);
    }

//    @Test
//    void testGetProjectByManagerId() {
//        EmployeeOutDTO empDto= new EmployeeOutDTO();
//        
//        empDto.setManagerId(2L);
//        empDto.setManager("Vanshika Sharma");
//        
//        Project prj = new Project();
//        skills.add("React");
//        skills.add("Java");
//        prj.setName("Exam Portal");
//        prj.setManagerId(1L);
//        prj.setStartDate("2023-09-07");
//        prj.setDescription("Description");
//        prj.setSkills(skills);
//        List<Project> prjList = new ArrayList<Project>();
//       prjList.add(prj);
//       
//       ProjectOutDTO prjDto = new ProjectOutDTO();
//       prjDto.setProjectName("Exam Portal");
//       prjDto.setManagerId(1L);
//       prjDto.setStartDate("2023-09-07");
//       prjDto.setDescription("Description");
//       prjDto.setSkills(skills);
//       prjDto.setManager("Vanshika Sharma");
//       prjDto.setTeams(teams);
//       List<ProjectOutDTO> prjDtoList = new ArrayList<ProjectOutDTO>();
//      
//       when(projectRepository.findByManagerId(empDto.getManagerId())).thenReturn(prjList);
//       prjDtoList.add(prjDto);
//       
//       Employee manager = new Employee();
//       manager.setId(2L);
//       manager.setEmpId("N1001");
//       manager.setName("Anjali Sharma");
//       manager.setEmail("anjali.sharma@nucleusteq.com");
//       manager.setDob("2001-09-07");
//       manager.setDoj("2023-07-17");
//       manager.setLocation(Location.Raipur);
//       manager.setDesignation(Designation.Engineer);
//       manager.setContactNumber("1234567800");
//       manager.setRole(Role.MANAGER);
//       manager.setSkills(skills);
//       manager.setManagerId(3L);
//       manager.setPassword("admin123");
//       manager.setProjectId(0L);
//       when(userRepository.findById(prjDto.getManagerId())).thenReturn(Optional.of(manager));
//       
//       Employee emp = new Employee();
//       emp.setId(1L);
//       emp.setEmpId("N1001");
//       emp.setName("Anjali Sharma");
//       emp.setEmail("anjali.sharma@nucleusteq.com");
//       emp.setDob("2001-09-07");
//       emp.setDoj("2023-07-17");
//       emp.setLocation(Location.Raipur);
//       emp.setDesignation(Designation.Engineer);
//       emp.setContactNumber("1234567800");
//       emp.setRole(Role.EMPLOYEE);
//       emp.setSkills(skills);
//       emp.setManagerId(2L);
//       emp.setPassword("admin123");
//       emp.setProjectId(0L);
//       
//       List<Employee> empList = new ArrayList<Employee>();
//       empList.add(emp);
//       when(userRepository.findAllByProjectId(prjDto.getProjectId())).thenReturn(empList);
////       when(empRepo.findAllByProjectId(prjDto.getProjectId())).thenReturn(empList);
//       List<String> teams1 = new ArrayList<>();
//       teams1.add(emp.getName());
//       prjDto.setManager(emp.getName());
//       // Verify that the 'teams' list contains the names of employees
//       assertEquals(1, teams1.size());
//       assertEquals("Anjali Sharma", teams1.get(0));
//       List<String> teams2 = new ArrayList<>();
//       teams2.add("N/A");
//      
//       assertEquals(1, teams2.size()); 
//       
//       assertEquals("N/A", teams2.get(0));
//       List<ProjectOutDTO> result = projectService.getProjectByManagerId(manager.getId());
//       assertEquals(1, result.size());
//        
//    }
    @Test
    public void testGetProjectByManagerIdEmptyEmpList() {
        long managerID = 1L;
        // Mock an empty list of projects
        when(projectRepository.findByManagerId(managerID))
                .thenReturn(new ArrayList<>());
        // Mock an empty list of employees
        when(userRepository.findByManagerId(managerID))
                .thenReturn(Optional.empty());

        List<ProjectOutDTO> projectList = projectService
                .getProjectByManagerId(managerID);
        // Assert that the list is empty
        assertEquals(0, projectList.size());
        // Verify that findByManagerId was called once
        verify(projectRepository, times(1)).findByManagerId(managerID);
    }

    @Test
    public void testGetProjects() {
        List<Project> mockProjects = new ArrayList<>();
        Project project1 = new Project();
        project1.setProjectId(101L);
        project1.setName("Project A");
        project1.setManagerId(1L);
        project1.setDescription("Description A");
        project1.setStartDate("2023-01-01");
        project1.setSkills(Arrays.asList("Java", "Spring", "Hibernate"));
        mockProjects.add(project1);

        // Create mock employee list for the project
        List<Employee> mockEmployees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("Employee 1");
        mockEmployees.add(employee1);

        // Mock the repository calls
        when(projectRepository.findAll()).thenReturn(mockProjects);
        when(userRepository.findAllByProjectId(project1.getProjectId()))
                .thenReturn(mockEmployees);
        when(userRepository.findById(project1.getManagerId()))
                .thenReturn(Optional.of(employee1));

        // Call the method to test
        List<ProjectOutDTO> projectList = projectService.getProjects();

        // Assertions
        assertEquals(1, projectList.size());

        ProjectOutDTO firstProject = projectList.get(0);
        assertEquals(101L, firstProject.getProjectId());
        assertEquals("Project A", firstProject.getProjectName());
        assertEquals("Employee 1", firstProject.getManager());
        assertEquals(1L, firstProject.getManagerId());
        assertEquals("Description A", firstProject.getDescription());
        assertEquals("2023-01-01", firstProject.getStartDate());
        assertEquals(Arrays.asList("Java", "Spring", "Hibernate"),
                firstProject.getSkills());
        assertEquals(Arrays.asList("Employee 1"), firstProject.getTeams());
    }

    
}
