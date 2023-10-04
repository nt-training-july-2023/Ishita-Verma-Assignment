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
import org.modelmapper.ModelMapper;

import com.portal.DTO.ApiResponseDTO;
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
    @Mock
    private ModelMapper modelMapper;

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
        when(modelMapper.map(project, ProjectInDTO.class))
                .thenReturn(projectDto);
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

    @Test
    public void testGetProjectByManagerId() {
        Long managerID = 1L;
        List<Project> mockProjects = new ArrayList<>();
        
        Employee employee= new Employee();
        employee.setId(1L);
        employee.setEmpId("N1111");
        employee.setName("Ankita Sharma");
        employee.setEmail("ankita.sharma@nucleusteq.com");
        employee.setDob("1990-01-01");
        employee.setDoj("2021-01-01");
        employee.setLocation(Location.Raipur);
        employee.setDesignation(Designation.Engineer);
        employee.setContactNumber("1234567890");
        employee.setRole(Role.EMPLOYEE);
        employee.setProjectId(10L);
        employee.setPassword("password");
        
        Project project = new Project();
        project.setDescription("DEscription");
        project.setManagerId(1L);
        project.setName("Ishita");
        project.setProjectId(1L);
        project.setSkills(skills);
        project.setStartDate("20-05-2001");
        ProjectOutDTO project1 = new ProjectOutDTO();
        project1.setProjectId(101L);
        project1.setProjectName("Project A");
        project1.setManagerId(managerID);
        project1.setSkills(Arrays.asList("Java", "Spring", "Hibernate"));
        project1.setDescription("Description");
        project1.setStartDate("20-05-2001");
        project1.setManager(employee.getName());
        project1.setTeams(teams);
        
        mockProjects.add(project);
        // Mock the projectRepository.findByManagerID method
        when(projectRepository.findByManagerId(managerID))
                .thenReturn(mockProjects);
        List<ProjectOutDTO> projectList = projectService
                .getProjectByManagerId(managerID);
        // Assert that the list is not empty
        assertFalse(projectList.isEmpty());
        // Assert that the first project in the list has the expected properties
        ProjectOutDTO firstProject = projectList.get(0);
        assertEquals(101L, firstProject.getProjectId());
        assertEquals("Project A", firstProject.getProjectName());
        assertEquals(managerID, firstProject.getManagerId());
        assertEquals(Arrays.asList("Java", "Spring", "Hibernate"),
                firstProject.getSkills());
        // Verify that findByManagerID was called once
        verify(projectRepository, times(1)).findByManagerId(managerID);
    }

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
