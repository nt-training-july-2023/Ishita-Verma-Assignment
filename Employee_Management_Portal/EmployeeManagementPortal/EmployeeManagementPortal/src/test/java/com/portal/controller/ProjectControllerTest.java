package com.portal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.ProjectDTO;
import com.portal.DTO.ProjectOutDTO;
import com.portal.entities.Designation;
import com.portal.entities.Employee;
import com.portal.entities.Location;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.repository.ProjectRepository;
import com.portal.service.ProjectService;

class ProjectControllerTest {

	@InjectMocks
	private ProjectController projectController;

	@Mock
	private ProjectRepository projectRepository;

	@Mock
	private ProjectService projectService;

	@BeforeEach
	public void setUp() {
	    MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveProject() {
		
	    ProjectDTO projectDTO = new ProjectDTO();
	    projectDTO.setName("Project A");
	    ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
	    apiResponseDTO.setMessage("Project added successfully");
	    when(projectService.addProject(any(ProjectDTO.class))).thenReturn(apiResponseDTO);

	    ApiResponseDTO result = projectController.saveProject(projectDTO);

	    assertEquals(apiResponseDTO.getMessage(), result.getMessage());
	}

	@Test
    void testGetProjects() {
        // Define a sample list of ProjectOutDTO
        List<ProjectOutDTO> projectsList = new ArrayList<>();
        ProjectOutDTO project1 = new ProjectOutDTO(/* Fill project details here */);
        ProjectOutDTO project2 = new ProjectOutDTO(/* Fill project details here */);
        projectsList.add(project1);
        projectsList.add(project2);

        // Mock the behavior of projectService.getProjects
        when(projectService.getProjects()).thenReturn(projectsList);

        // Call the controller method
        List<ProjectOutDTO> result = projectController.getProjects();

        // Assert the result
        assertEquals(projectsList, result);
    }

    @Test
    void testGetProjectByManagerId() {
        // Define a sample managerId
    	// Define a sample list of ProjectOutDTO
    	Long managerId = 123L;
    	List<ProjectOutDTO> projectsList = new ArrayList<>();

    	ProjectOutDTO project1 = new ProjectOutDTO();
    	project1.setProjectId(1L);
    	project1.setProjectName("Project A");
    	project1.setManager("Manager A");
    	project1.setManagerId(123L);
    	project1.setStartDate("2023-09-25");
    	project1.setSkills(Arrays.asList("Java", "Python"));
    	project1.setDescription("Project A Description");
    	project1.setTeams(Arrays.asList("Team 1", "Team 2"));

    	ProjectOutDTO project2 = new ProjectOutDTO();
    	project2.setProjectId(2L);
    	project2.setProjectName("Project B");
    	project2.setManager("Manager B");
    	project2.setManagerId(124L);
    	project2.setStartDate("2023-09-26");
    	project2.setSkills(Arrays.asList("C++", "JavaScript"));
    	project2.setDescription("Project B Description");
    	project2.setTeams(Arrays.asList("Team 3", "Team 4"));

    	projectsList.add(project1);
    	projectsList.add(project2);

    	// Mock the behavior of projectService.getProjectByManagerId
    	when(projectService.getProjectByManagerId(managerId)).thenReturn(projectsList);

    	// Call the controller method
    	List<ProjectOutDTO> result = projectController.getProjectByManagerId(managerId);

    	// Assert the result
    	assertEquals(projectsList, result);
    }

    @Test
    void testGetUnassignedEmployees() {
        // Define a sample list of Employee
        List<Employee> unassignedEmployeesList = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setEmpId("N1111");
        employee1.setName("Ankita");
        employee1.setEmail("ankita.sharma@nucleusteq.com");
        employee1.setDob("1990-01-15");
        employee1.setDoj("2020-03-10");
        employee1.setLocation(Location.Raipur);
        employee1.setDesignation(Designation.Engineer);
        employee1.setContactNumber("1234567890");
        employee1.setRole(Role.EMPLOYEE);
        employee1.setProjectId(0);
        employee1.setSkills(Arrays.asList("Java", "Python"));
        employee1.setManagerId(12L);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setEmpId("N2222");
        employee2.setName("Vanshika");
        employee2.setEmail("vanshika@nucleusteq.com");
        employee2.setDob("1995-02-15");
        employee2.setDoj("2021-03-15");
        employee2.setLocation(Location.Indore);
        employee2.setDesignation(Designation.Recruiter);
        employee2.setContactNumber("9876543210");
        employee2.setRole(Role.EMPLOYEE);
        employee2.setProjectId(0);
        employee2.setSkills(Arrays.asList("C++", "JavaScript"));
        employee2.setManagerId(11L);

        unassignedEmployeesList.add(employee1);
        unassignedEmployeesList.add(employee2);

        // Mock the behavior of projectService.getEmployeesWithUnassignedProjects
        when(projectService.getEmployeesWithUnassignedProjects()).thenReturn(unassignedEmployeesList);

        // Call the controller method
        List<Employee> result = projectController.getUnassignedEmployees();

        // Assert the result
        assertEquals(unassignedEmployeesList, result);
    }


	@Test
	void testGetSkillsForProject() {
	    String projectName = "Project A";
	    List<String> skillsList = new ArrayList<>();
	    when(projectService.getSkillsForProject(projectName)).thenReturn(skillsList);

	    List<String> result = projectController.getSkillsForProject(projectName);

	    assertEquals(skillsList, result);
	}

}
