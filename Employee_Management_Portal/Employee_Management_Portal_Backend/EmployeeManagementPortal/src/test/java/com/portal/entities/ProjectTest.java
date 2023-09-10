package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProjectTest {

	 @Test
	    public void testCreateProject() {
	        // Arrange
	        Project project = new Project();
	        project.setName("Sample Project");
	        project.setManagerId("Manager123");
	        project.setStartDate("2023-09-07");
	        project.setSkills("Java, Spring");
	        project.setDescription("Sample project description");

	        // Act
	        long projectId = project.getProjectId();
	        String projectName = project.getName();
	        String managerId = project.getManagerId();
	        String startDate = project.getStartDate();
	        String skills = project.getSkills();
	        String description = project.getDescription();

	        // Assert
	        assertEquals(0, projectId); // Assuming 0 is the default value for project ID
	        assertEquals("Sample Project", projectName);
	        assertEquals("Manager123", managerId);
	        assertEquals("2023-09-07", startDate);
	        assertEquals("Java, Spring", skills);
	        assertEquals("Sample project description", description);
	    }

	    @Test
	    public void testProjectToString() {
	        // Arrange
	        Project project = new Project();
	        project.setName("Sample Project");

	        // Act
	        String projectString = project.toString();

	        // Assert
	        assertFalse(projectString.contains("Sample Project"));
	    }

}
