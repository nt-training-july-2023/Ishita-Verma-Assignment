package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProjectTest {

    @Test
    void testGettersAndSetters() {
        Project project = new Project();
        project.setProjectId(1L);
        project.setName("Test Project");
        project.setManagerId(2L);
        project.setStartDate("2023-09-18");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        project.setSkills(skills);
        project.setDescription("Test Description");

        assertEquals(1L, project.getProjectId());
        assertEquals("Test Project", project.getName());
        assertEquals(2L, project.getManagerId());
        assertEquals("2023-09-18", project.getStartDate());
        assertEquals(skills, project.getSkills());
        assertEquals("Test Description", project.getDescription());
    }

    @Test
    void testHashCode() {
        Project project1 = new Project();
        project1.setProjectId(1L);
        project1.setName("Test Project");
        project1.setManagerId(2L);
        project1.setStartDate("2023-09-18");
        List<String> skills1 = new ArrayList<>();
        skills1.add("Java");
        skills1.add("React");
        project1.setSkills(skills1);
        project1.setDescription("Test Description");

        Project project2 = new Project();
        project2.setProjectId(1L);
        project2.setName("Test Project");
        project2.setManagerId(2L);
        project2.setStartDate("2023-09-18");
        List<String> skills2 = new ArrayList<>();
        skills2.add("Java");
        skills2.add("React");
        project2.setSkills(skills2);
        project2.setDescription("Test Description");

        assertEquals(project1.hashCode(), project2.hashCode());
    }

    @Test
    void testEquals() {
        Project project1 = new Project();
        project1.setProjectId(1L);
        project1.setName("Test Project");
        project1.setManagerId(2L);
        project1.setStartDate("2023-09-18");
        List<String> skills1 = new ArrayList<>();
        skills1.add("Java");
        skills1.add("React");
        project1.setSkills(skills1);
        project1.setDescription("Test Description");

        Project project2 = new Project();
        project2.setProjectId(1L);
        project2.setName("Test Project");
        project2.setManagerId(2L);
        project2.setStartDate("2023-09-18");
        List<String> skills2 = new ArrayList<>();
        skills2.add("Java");
        skills2.add("React");
        project2.setSkills(skills2);
        project2.setDescription("Test Description");

        assertEquals(project1, project1);
        assertEquals(project1, project2);
        assertEquals(project1.getDescription(),project2.getDescription());
        assertEquals(project1.getManagerId(),project2.getManagerId());
        assertEquals(project1.getName(),project2.getName());
        assertEquals(project1.getProjectId(),project2.getProjectId());
        assertEquals(project1.getSkills(), project2.getSkills());
        assertEquals(project1.getStartDate(), project2.getStartDate());
        
            Project project3 = new Project();
            project1.setProjectId(1L);
            project1.setName("Test Project");
            project1.setManagerId(2L);
            project1.setStartDate("2023-09-18");
            List<String> skills3 = new ArrayList<>();
            skills1.add("Java");
            skills1.add("React");
            project1.setSkills(skills3);
            project1.setDescription("Test Description");

            Project project4 = null; // Initialize project2 as null

            assertNotEquals(project3, project4); // project1 should not be equal to null
        }

    @Test
    void testToString() {
        Project project = new Project();
        project.setProjectId(1L);
        project.setName("Test Project");
        project.setManagerId(2L);
        project.setStartDate("2023-09-18");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        project.setSkills(skills);
        project.setDescription("Test Description");

        String expectedToString = "Project [projectId=1, name=Test Project, managerId=2, startDate=2023-09-18, skills=[Java, React], description=Test Description]";
        assertEquals(expectedToString, project.toString());
    }

}
