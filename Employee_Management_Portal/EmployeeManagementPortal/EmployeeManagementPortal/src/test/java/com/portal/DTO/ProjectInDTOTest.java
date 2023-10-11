package com.portal.DTO;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjectInDTOTest {


    @Test
    void testGettersAndSetters() {
        ProjectInDTO projectDTO1 = new ProjectInDTO();
        ProjectInDTO projectDTO2 = new ProjectInDTO();
        ProjectInDTO projectDTO3 = new ProjectInDTO();
        projectDTO1 = new ProjectInDTO();
        projectDTO1.setProjectId(1l);
        projectDTO1.setName(null);
        projectDTO1.setDescription(null);
        projectDTO1.setManagerId(null);
        projectDTO1.setSkills(new ArrayList<>());
        projectDTO1.setStartDate(null);

        projectDTO2 = new ProjectInDTO();
        projectDTO2.setProjectId(2l);
        projectDTO2.setName("Project Name");
        projectDTO2.setDescription("Project Description");
        projectDTO2.setManagerId(3L);
        projectDTO2.setSkills(List.of("Skill1", "Skill2"));
        projectDTO2.setStartDate("2023-09-16");

        projectDTO3 = new ProjectInDTO();
        projectDTO3.setProjectId(1l);
        projectDTO3.setName(null);
        projectDTO3.setDescription(null);
        projectDTO3.setManagerId(null);
        projectDTO3.setSkills(new ArrayList<>());
        projectDTO3.setStartDate(null);
        
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
        ProjectInDTO projectDTO1 = new ProjectInDTO();
        ProjectInDTO projectDTO2 = new ProjectInDTO();
        ProjectInDTO projectDTO3 = new ProjectInDTO();

        projectDTO1 = new ProjectInDTO();
        projectDTO1.setProjectId(1L);
        projectDTO1.setName(null);
        projectDTO1.setDescription(null);
        projectDTO1.setManagerId(null);
        projectDTO1.setSkills(new ArrayList<>());
        projectDTO1.setStartDate(null);

        projectDTO2 = new ProjectInDTO();
        projectDTO2.setProjectId(2L);
        projectDTO2.setName("Project Name");
        projectDTO2.setDescription("Project Description");
        projectDTO2.setManagerId(3L);
        projectDTO2.setSkills(List.of("Skill1", "Skill2"));
        projectDTO2.setStartDate("2023-09-16");

        projectDTO3 = new ProjectInDTO();
        projectDTO3.setProjectId(1L);
        projectDTO3.setName(null);
        projectDTO3.setDescription(null);
        projectDTO3.setManagerId(null);
        projectDTO3.setSkills(new ArrayList<>());
        projectDTO3.setStartDate(null);

        // Test equality with null values
        assertEquals(projectDTO1, projectDTO3);
        assertEquals(projectDTO3, projectDTO1);

        // Test equality with different types (should return false)
        assertFalse(projectDTO1.equals(null));
        assertFalse(projectDTO1.equals("String"));

        // Test equality with different project IDs
        ProjectInDTO differentDTO = new ProjectInDTO();
        differentDTO.setProjectId(4L);
        differentDTO.setName("Different Project");
        differentDTO.setDescription("Different Description");
        differentDTO.setManagerId(5L);
        differentDTO.setSkills(List.of("Skill3"));
        differentDTO.setStartDate("2023-09-17");

        assertNotEquals(projectDTO1, differentDTO);
        assertNotEquals(differentDTO, projectDTO1);

        assertNotEquals(projectDTO1.hashCode(), differentDTO.hashCode());

        // Test equality with the same object
        assertEquals(projectDTO1, projectDTO1);

        // Test equality with objects that have the same values
        ProjectInDTO projectDTO4 = new ProjectInDTO();
        projectDTO4.setProjectId(1L);
        projectDTO4.setName(null);
        projectDTO4.setDescription(null);
        projectDTO4.setManagerId(null);
        projectDTO4.setSkills(new ArrayList<>());
        projectDTO4.setStartDate(null);

        assertEquals(projectDTO1, projectDTO4);
        assertEquals(projectDTO4, projectDTO1);
        projectDTO1.setSkills(null);

        assertEquals(projectDTO1.hashCode(), projectDTO1.hashCode());
        assertTrue(projectDTO1.equals(projectDTO1));
    }


   @Test
    void testToString() {
        ProjectInDTO projectDTO = new ProjectInDTO();
        projectDTO.setProjectId(1L);
        projectDTO.setName("Project Name");
        projectDTO.setDescription("Project Description");
        projectDTO.setManagerId(101L);
        projectDTO.setSkills(List.of("Java", "Python"));
        projectDTO.setStartDate("2023-09-16");

        String expectedToString = "ProjectDTO [projectId=1,name=Project Name, description=Project Description, managerId=101, skills=[Java, Python], startDate=2023-09-16]";
        String actualToString = projectDTO.toString();

        assertEquals(expectedToString, actualToString);
    }
}
