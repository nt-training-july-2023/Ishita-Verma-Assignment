package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ProjectDTOTest {

	  @Test
	    public void testEquals_SameObject() {
	        // Arrange
	        ProjectDTO projectDTO1 = new ProjectDTO();
	        projectDTO1.setProjectId(1);
	        projectDTO1.setName("Project 1");
	        projectDTO1.setDescription("Description 1");
	        projectDTO1.setManagerId("N1234");
	        projectDTO1.setSkills(List.of("Java", "Spring"));
	        projectDTO1.setStartDate("2023-09-07");

	        // Act and Assert
	        assertTrue(projectDTO1.equals(projectDTO1));
	    }

	    @Test
	    public void testEquals_SameAttributes() {
	        // Arrange
	        ProjectDTO projectDTO1 = new ProjectDTO();
	        projectDTO1.setProjectId(1);
	        projectDTO1.setName("Project 1");
	        projectDTO1.setDescription("Description 1");
	        projectDTO1.setManagerId("N1234");
	        projectDTO1.setSkills(List.of("Java", "Spring"));
	        projectDTO1.setStartDate("2023-09-07");

	        ProjectDTO projectDTO2 = new ProjectDTO();
	        projectDTO2.setProjectId(1);
	        projectDTO2.setName("Project 1");
	        projectDTO2.setDescription("Description 1");
	        projectDTO2.setManagerId("N1234");
	        projectDTO2.setSkills(List.of("Java", "Spring"));
	        projectDTO2.setStartDate("2023-09-07");

	        // Act and Assert
	        assertTrue(projectDTO1.equals(projectDTO2));
	    }

	    @Test
	    public void testEquals_DifferentAttributes() {
	        // Arrange
	        ProjectDTO projectDTO1 = new ProjectDTO();
	        projectDTO1.setProjectId(1);
	        projectDTO1.setName("Project 1");
	        projectDTO1.setDescription("Description 1");
	        projectDTO1.setManagerId("N1234");
	        projectDTO1.setSkills(List.of("Java", "Spring"));
	        projectDTO1.setStartDate("2023-09-07");

	        ProjectDTO projectDTO2 = new ProjectDTO();
	        projectDTO2.setProjectId(2); 
	        projectDTO2.setName("Project 2"); 
	        projectDTO2.setDescription("Description 2");
	        projectDTO2.setManagerId("N5678"); 
	        projectDTO2.setSkills(List.of("Python", "Django"));
	        projectDTO2.setStartDate("2023-09-08"); 

	        // Act and Assert
	        assertFalse(projectDTO1.equals(projectDTO2));
	    }

}
