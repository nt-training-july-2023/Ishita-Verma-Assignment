package com.portal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.ProjectDTO;
import com.portal.entities.Project;
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
	void testGetAllProjects() {
	    List<Project> projectList = new ArrayList<>();
	    
	    when(projectRepository.findAll()).thenReturn(projectList);

	    List<Project> result = projectController.getAllProjects();

	    assertEquals(projectList, result);
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
