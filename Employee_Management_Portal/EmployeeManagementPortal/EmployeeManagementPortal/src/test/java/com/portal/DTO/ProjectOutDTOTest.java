package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjectOutDTOTest {
    
    @Test
    void testGettersAndSetters() {

        ProjectOutDTO projectDTO1 = new ProjectOutDTO();
        projectDTO1.setProjectId(1L);
        projectDTO1.setProjectName("Project 1");
        projectDTO1.setManager("Manager 1");
        projectDTO1.setManagerId(101L);
        projectDTO1.setStartDate("2023-09-16");
        projectDTO1.setDescription("Description 1");
        projectDTO1.setSkills(List.of("Java", "Python"));
        projectDTO1.setTeams(List.of("Team 1", "Team 2"));

        ProjectOutDTO projectDTO2 = new ProjectOutDTO();
        projectDTO2.setProjectId(2L);
        projectDTO2.setProjectName("Project 2");
        projectDTO2.setManager("Manager 2");
        projectDTO2.setManagerId(102L);
        projectDTO2.setStartDate("2023-09-17");
        projectDTO2.setDescription("Description 2");
        projectDTO2.setSkills(List.of("C++", "JavaScript"));
        projectDTO2.setTeams(List.of("Team 3", "Team 4"));

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

        ProjectOutDTO projectDTO1 = new ProjectOutDTO();
        projectDTO1.setProjectId(1L);
        projectDTO1.setProjectName("Project 1");
        projectDTO1.setManager("Manager 1");
        projectDTO1.setManagerId(101L);
        projectDTO1.setStartDate("2023-09-16");
        projectDTO1.setDescription("Description 1");
        projectDTO1.setSkills(List.of("Java", "Python"));
        projectDTO1.setTeams(List.of("Team 1", "Team 2"));

        ProjectOutDTO projectDTO2 = new ProjectOutDTO();
        projectDTO2.setProjectId(2L);
        projectDTO2.setProjectName("Project 2");
        projectDTO2.setManager("Manager 2");
        projectDTO2.setManagerId(102L);
        projectDTO2.setStartDate("2023-09-17");
        projectDTO2.setDescription("Description 2");
        projectDTO2.setSkills(List.of("C++", "JavaScript"));
        projectDTO2.setTeams(List.of("Team 3", "Team 4"));

        assertEquals(projectDTO1.hashCode(), projectDTO1.hashCode());
        assertNotEquals(projectDTO1.hashCode(), projectDTO2.hashCode());
       
        projectDTO1.setSkills(null);
        projectDTO1.setTeams(null);

        assertEquals(projectDTO1.hashCode(), projectDTO1.hashCode());
    }

    @Test
    void testEquals() {

        ProjectOutDTO projectDTO1 = new ProjectOutDTO();
        projectDTO1.setProjectId(1L);
        projectDTO1.setProjectName("Project 1");
        projectDTO1.setManager("Manager 1");
        projectDTO1.setManagerId(101L);
        projectDTO1.setStartDate("2023-09-16");
        projectDTO1.setDescription("Description 1");
        projectDTO1.setSkills(List.of("Java", "Python"));
        projectDTO1.setTeams(List.of("Team 1", "Team 2"));

        ProjectOutDTO projectDTO2 = new ProjectOutDTO();
        projectDTO2.setProjectId(2L);
        projectDTO2.setProjectName("Project 2");
        projectDTO2.setManager("Manager 2");
        projectDTO2.setManagerId(102L);
        projectDTO2.setStartDate("2023-09-17");
        projectDTO2.setDescription("Description 2");
        projectDTO2.setSkills(List.of("C++", "JavaScript"));
        projectDTO2.setTeams(List.of("Team 3", "Team 4"));

        assertTrue(projectDTO1.equals(projectDTO1));
        assertFalse(projectDTO1.equals(null));
        assertFalse(projectDTO1.equals("String"));
        assertFalse(projectDTO1.equals(projectDTO2));

        ProjectOutDTO projectDTO3 = new ProjectOutDTO();
        projectDTO3.setProjectId(1L);
        projectDTO3.setProjectName("Project 1");
        projectDTO3.setManager("Manager 1");
        projectDTO3.setManagerId(101L);
        projectDTO3.setStartDate("2023-09-16");
        projectDTO3.setDescription("Description 1");
        projectDTO3.setSkills(List.of("Java", "Python"));
        projectDTO3.setTeams(List.of("Team 1", "Team 2"));

        assertTrue(projectDTO1.equals(projectDTO3));
        assertTrue(projectDTO3.equals(projectDTO1));

        ProjectOutDTO projectDTO4 = new ProjectOutDTO();
        projectDTO4.setProjectId(3L);
        projectDTO4.setProjectName("Project 3");
        projectDTO4.setManager("Manager 3");
        projectDTO4.setManagerId(103L);
        projectDTO4.setStartDate("2023-09-18");
        projectDTO4.setDescription("Description 3");
        projectDTO4.setSkills(List.of("Java", "Python"));
        projectDTO4.setTeams(List.of("Team 1", "Team 2"));

        assertFalse(projectDTO1.equals(projectDTO4));
        assertFalse(projectDTO4.equals(projectDTO1));
        
        projectDTO1.setSkills(null);
        projectDTO1.setTeams(null);

        assertTrue(projectDTO1.equals(projectDTO1));
    }
    @Test
    void testToString() {
        ProjectOutDTO projectDTO = new ProjectOutDTO();
        projectDTO.setProjectId(1L); 
        projectDTO.setProjectName("Project 1");
        projectDTO.setManager("Manager 1");
        projectDTO.setManagerId(101L);
        projectDTO.setStartDate("2023-09-16");
        projectDTO.setDescription("Description 1");
        projectDTO.setSkills(List.of("Java", "Python"));
        projectDTO.setTeams(List.of("Team 1", "Team 2"));

        String expectedToString = "ProjectOutDTO [projectId=1, projectName=Project 1, manager=Manager 1, managerId=101, startDate=2023-09-16, skills=[Java, Python], description=Description 1, teams=[Team 1, Team 2]]";

        assertEquals(expectedToString, projectDTO.toString());
    }
}
