package com.portal.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjectDTOTest {

	private ProjectDTO projectDTO1;
    private ProjectDTO projectDTO2;
    private ProjectDTO projectDTO3;

    @BeforeEach
    void setUp() {
        projectDTO1 = new ProjectDTO();
        projectDTO1.setProjectId(1);
        projectDTO1.setName(null);
        projectDTO1.setDescription(null);
        projectDTO1.setManagerId(null);
        projectDTO1.setSkills(new ArrayList<>());
        projectDTO1.setStartDate(null);

        projectDTO2 = new ProjectDTO(2, "Project Name", "Project Description", 3L, List.of("Skill1", "Skill2"), "2023-09-16");

        projectDTO3 = new ProjectDTO();
        projectDTO3.setProjectId(1);
        projectDTO3.setName(null);
        projectDTO3.setDescription(null);
        projectDTO3.setManagerId(null);
        projectDTO3.setSkills(new ArrayList<>());
        projectDTO3.setStartDate(null);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(1, projectDTO1.getProjectId());
        assertNull(projectDTO1.getName());
        assertNull(projectDTO1.getDescription());
        assertNull(projectDTO1.getManagerId());
        assertEquals(new ArrayList<>(), projectDTO1.getSkills());
        assertNull(projectDTO1.getStartDate());

        assertEquals(2, projectDTO2.getProjectId());
        assertEquals("Project Name", projectDTO2.getName());
        assertEquals("Project Description", projectDTO2.getDescription());
        assertEquals(3L, projectDTO2.getManagerId());
        assertEquals(List.of("Skill1", "Skill2"), projectDTO2.getSkills());
        assertEquals("2023-09-16", projectDTO2.getStartDate());

        assertEquals(1, projectDTO3.getProjectId());
        assertNull(projectDTO3.getName());
        assertNull(projectDTO3.getDescription());
        assertNull(projectDTO3.getManagerId());
        assertEquals(new ArrayList<>(), projectDTO3.getSkills());
        assertNull(projectDTO3.getStartDate());
    }

    @Test
    void testEqualsAndHashCode() {
        assertEquals(projectDTO1, projectDTO3);
        assertEquals(projectDTO3, projectDTO1);

        assertEquals(projectDTO1.hashCode(), projectDTO3.hashCode());

        // Test inequality with different project IDs
        ProjectDTO differentDTO = new ProjectDTO(4, "Different Project", "Different Description", 5L, List.of("Skill3"), "2023-09-17");

        assertNotEquals(projectDTO1, differentDTO);
        assertNotEquals(differentDTO, projectDTO1);

        assertNotEquals(projectDTO1.hashCode(), differentDTO.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("ProjectDTO [projectId=1, name=null, description=null, managerId=null, skills=[], startDate=null]", projectDTO1.toString());
        assertEquals("ProjectDTO [projectId=2, name=Project Name, description=Project Description, managerId=3, skills=[Skill1, Skill2], startDate=2023-09-16]", projectDTO2.toString());
        assertEquals("ProjectDTO [projectId=1, name=null, description=null, managerId=null, skills=[], startDate=null]", projectDTO3.toString());
    }

}
