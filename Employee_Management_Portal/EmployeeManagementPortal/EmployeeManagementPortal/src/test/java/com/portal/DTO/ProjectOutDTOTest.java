package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjectOutDTOTest {

    private ProjectOutDTO projectDTO1;
    private ProjectOutDTO projectDTO2;

    @BeforeEach
    void setUp() {
        projectDTO1 = new ProjectOutDTO();
        projectDTO1.setProjectId(1L);
        projectDTO1.setProjectName("Project 1");
        projectDTO1.setManager("Manager 1");
        projectDTO1.setManagerId(101L);
        projectDTO1.setStartDate("2023-09-16");
        projectDTO1.setDescription("Description 1");
        projectDTO1.setSkills(List.of("Java", "Python"));
        projectDTO1.setTeams(List.of("Team 1", "Team 2"));

        projectDTO2 = new ProjectOutDTO();
        projectDTO2.setProjectId(2L);
        projectDTO2.setProjectName("Project 2");
        projectDTO2.setManager("Manager 2");
        projectDTO2.setManagerId(102L);
        projectDTO2.setStartDate("2023-09-17");
        projectDTO2.setDescription("Description 2");
        projectDTO2.setSkills(List.of("C++", "JavaScript"));
        projectDTO2.setTeams(List.of("Team 3", "Team 4"));
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(1L, projectDTO1.getProjectId());
        assertEquals("Project 1", projectDTO1.getProjectName());
        assertEquals("Manager 1", projectDTO1.getManager());
        assertEquals(101L, projectDTO1.getManagerId());
        assertEquals("2023-09-16", projectDTO1.getStartDate());
        assertEquals("Description 1", projectDTO1.getDescription());
        assertEquals(List.of("Java", "Python"), projectDTO1.getSkills());
        assertEquals(List.of("Team 1", "Team 2"), projectDTO1.getTeams());

        assertEquals(2L, projectDTO2.getProjectId());
        assertEquals("Project 2", projectDTO2.getProjectName());
        assertEquals("Manager 2", projectDTO2.getManager());
        assertEquals(102L, projectDTO2.getManagerId());
        assertEquals("2023-09-17", projectDTO2.getStartDate());
        assertEquals("Description 2", projectDTO2.getDescription());
        assertEquals(List.of("C++", "JavaScript"), projectDTO2.getSkills());
        assertEquals(List.of("Team 3", "Team 4"), projectDTO2.getTeams());
    }

    @Test
    void testHashCode() {
        assertEquals(projectDTO1.hashCode(), projectDTO1.hashCode());

        assertNotEquals(projectDTO1.hashCode(), projectDTO2.hashCode());
    }

    @Test
    void testEquals() {
        assertEquals(projectDTO1, projectDTO1);

        assertNotEquals(projectDTO1, null);
        assertNotEquals(projectDTO1, "String");

        assertNotEquals(projectDTO1, projectDTO2);
    }
}
