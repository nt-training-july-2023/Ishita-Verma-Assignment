package com.portal.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.ProjectInDTO;
import com.portal.DTO.ProjectOutDTO;
import com.portal.entities.Employee;
import com.portal.service.ProjectService;
import com.portal.validation.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
@WebMvcTest(ProjectController.class)
@ActiveProfiles("test")
public class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProjectService projectService;

    @MockBean
    private Validation validation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveProject() throws Exception {
        ProjectInDTO projectDTO = new ProjectInDTO();
        projectDTO.setName("Fyndr");
        projectDTO.setDescription("Fyndr Description");
        projectDTO.setManagerId(1L);
        projectDTO.setProjectId(2L);
        List<String> skills = new ArrayList<>();
        skills.add("Skill1");
        skills.add("Skill2");
        projectDTO.setSkills(skills);
        projectDTO.setStartDate("2001-02-11");
        ApiResponseDTO response = new ApiResponseDTO();
        response.setMessage("Project added successfully");
        
        doNothing().when(validation).checkProject(projectDTO);
        when(projectService.addProject(projectDTO)).thenReturn(response);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/addProject")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(projectDTO)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(response)))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testGetProjects() throws Exception {
        ProjectOutDTO project1 = new ProjectOutDTO();
        project1.setProjectName("Fyndr");
        project1.setDescription("Fyndr Description");
        project1.setManager("Rashmi");
        project1.setManagerId(1L);
        project1.setProjectId(1L);
        project1.setStartDate("2009-02-11");
        List<String> skills = new ArrayList<>();
        skills.add("Skill1");
        skills.add("Skill2");
        project1.setSkills(skills);
        List<String> teams = new ArrayList<>();
        teams.add("Member 1");
        teams.add("Member 2");
        project1.setTeams(teams);
        ProjectOutDTO project2 = new ProjectOutDTO();
        project2.setProjectName("AAA");
        project2.setDescription("AAA Description");
        project2.setManager("Shreya");
        project2.setManagerId(3L);
        project2.setProjectId(3L);
        project2.setStartDate("2009-02-11");
        List<String> skills2 = new ArrayList<>();
        skills2.add("Skill1");
        skills2.add("Skill2");
        project2.setSkills(skills2);
        List<String> teams2 = new ArrayList<>();
        teams2.add("Member 1");
        teams2.add("Member 2");
        project2.setTeams(teams2);
        List<ProjectOutDTO> projects = Arrays.asList(project1, project2);

        when(projectService.getProjects()).thenReturn(projects);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/projects"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(projects)))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testGetProjectByManagerId() throws Exception {
        Long managerId = 1L;
        ProjectOutDTO project1 = new ProjectOutDTO();
        project1.setProjectName("Fyndr");
        project1.setDescription("Fyndr Description");
        project1.setManager("Rashmi");
        project1.setManagerId(1L);
        project1.setProjectId(2L);
        project1.setStartDate("2009-02-11");
        List<String> skills = new ArrayList<>();
        skills.add("Skill1");
        skills.add("Skill2");
        project1.setSkills(skills);
        List<String> teams = new ArrayList<>();
        teams.add("Member 1");
        teams.add("Member 2");
        project1.setTeams(teams);
        ProjectOutDTO project2 = new ProjectOutDTO();
        project2.setProjectName("AAA");
        project2.setDescription("AAA Description");
        project2.setManager("Shreya");
        project2.setManagerId(3L);
        project2.setProjectId(3L);
        project2.setStartDate("2009-02-11");
        List<String> skills2 = new ArrayList<>();
        skills2.add("Skill1");
        skills2.add("Skill2");
        project2.setSkills(skills2);
        List<String> teams2 = new ArrayList<>();
        teams2.add("Member 1");
        teams2.add("Member 2");
        project2.setTeams(teams2);
        List<ProjectOutDTO> projects = Arrays.asList(project1, project2);

        when(projectService.getProjectByManagerId(managerId)).thenReturn(projects);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/projects/{managerId}", managerId))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(projects)))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testGetSkillsForProject() throws Exception {
        String projectName = "Project Name";
        List<String> skills = Arrays.asList("Skill 1", "Skill 2");

        when(projectService.getSkillsForProject(projectName)).thenReturn(skills);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/project/skills")
                .param("name", projectName))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(skills)))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testGetUnassignedEmployees() throws Exception {
        Employee employee1 = new Employee();
        employee1.setName("Employee 1");
        Employee employee2 = new Employee();
        employee2.setName("Employee 2");
        List<Employee> employees = Arrays.asList(employee1, employee2);

        when(projectService.getEmployeesWithUnassignedProjects()).thenReturn(employees);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/unassigned"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(employees)))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
