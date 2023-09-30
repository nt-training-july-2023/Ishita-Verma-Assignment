package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ProjectTest {

	 @Test
	    public void testProjectEquality() {
	        Project project1 = new Project();
	        project1.setProjectId(1L);
	        project1.setName("Project A");
	        project1.setManagerId(101L);
	        project1.setStartDate("2023-09-20");
	        project1.setSkills(Arrays.asList("Java", "Spring"));
	        project1.setDescription("Description A");

	        Project project2 = new Project();
	        project2.setProjectId(2L);
	        project2.setName("Project B");
	        project2.setManagerId(102L);
	        project2.setStartDate("2023-09-21");
	        project2.setSkills(Arrays.asList("Java", "Spring"));
	        project2.setDescription("Description B");

	        Project project3 = new Project();
	        project3.setProjectId(1L);
	        project3.setName("Project A");
	        project3.setManagerId(101L);
	        project3.setStartDate("2023-09-20");
	        project3.setSkills(Arrays.asList("Java", "Spring"));
	        project3.setDescription("Description A");

	        // Test equality
	        assertEquals(project1, project3);
	        assertEquals(project3, project1);

	        // Test inequality
	        assertFalse(project1.equals(project2));
	        assertFalse(project2.equals(project1));
	        assertFalse(project2.equals(project3));
	        assertFalse(project3.equals(project2));
	    }

	    @Test
	    public void testProjectHashCode() {
	        Project project1 = new Project();
	        project1.setProjectId(1L);
	        project1.setName("Project A");
	        project1.setManagerId(101L);
	        project1.setStartDate("2023-09-20");
	        project1.setSkills(Arrays.asList("Java", "Spring"));
	        project1.setDescription("Description A");

	        Project project2 = new Project();
	        project2.setProjectId(2L);
	        project2.setName("Project B");
	        project2.setManagerId(102L);
	        project2.setStartDate("2023-09-21");
	        project2.setSkills(Arrays.asList("Java", "Spring"));
	        project2.setDescription("Description B");

	        Project project3 = new Project();
	        project3.setProjectId(1L);
	        project3.setName("Project A");
	        project3.setManagerId(101L);
	        project3.setStartDate("2023-09-20");
	        project3.setSkills(Arrays.asList("Java", "Spring"));
	        project3.setDescription("Description A");

	        // Test hashCode
	        assertEquals(project1.hashCode(), project3.hashCode());
	        assertFalse(project1.hashCode() == project2.hashCode());
	        assertFalse(project2.hashCode() == project3.hashCode());
	    }

	    @Test
	    public void testProjectToString() {
	        Project project1 = new Project();
	        project1.setProjectId(1L);
	        project1.setName("Project A");
	        project1.setManagerId(101L);
	        project1.setStartDate("2023-09-20");
	        project1.setSkills(Arrays.asList("Java", "Spring"));
	        project1.setDescription("Description A");

	        String expectedToString = "Project [projectId=1, name=Project A, managerId=101, startDate=2023-09-20, skills=[Java, Spring], description=Description A]";
	        assertEquals(expectedToString, project1.toString());
	    }

}
