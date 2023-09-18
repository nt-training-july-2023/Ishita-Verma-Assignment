package com.portal.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProjectTest {

	@Test
    public void testProjectEquality() {
        List<String> skills1 = Arrays.asList("Java", "Spring");
        List<String> skills2 = Arrays.asList("Java", "Spring");

        Project project1 = new Project(1L, "Project A", 101L, "2023-09-20", skills1, "Description A");
        Project project2 = new Project(2L, "Project B", 102L, "2023-09-21", skills2, "Description B");
        Project project3 = new Project(1L, "Project A", 101L, "2023-09-20", skills1, "Description A");

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
        List<String> skills1 = Arrays.asList("Java", "Spring");
        List<String> skills2 = Arrays.asList("Java", "Spring");

        Project project1 = new Project(1L, "Project A", 101L, "2023-09-20", skills1, "Description A");
        Project project2 = new Project(2L, "Project B", 102L, "2023-09-21", skills2, "Description B");
        Project project3 = new Project(1L, "Project A", 101L, "2023-09-20", skills1, "Description A");

        // Test hashCode
        assertEquals(project1.hashCode(), project3.hashCode());
        assertFalse(project1.hashCode() == project2.hashCode());
        assertFalse(project2.hashCode() == project3.hashCode());
    }

    @Test
    public void testProjectToString() {
        List<String> skills1 = Arrays.asList("Java", "Spring");

        Project project1 = new Project(1L, "Project A", 101L, "2023-09-20", skills1, "Description A");

        String expectedToString = "Project [projectId=1, name=Project A, managerId=101, startDate=2023-09-20, skills=[Java, Spring], description=Description A]";
        assertEquals(expectedToString, project1.toString());
    }

}
