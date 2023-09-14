//package com.portal.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.modelmapper.ModelMapper;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.portal.DTO.ProjectDTO;
//import com.portal.entities.Project;
//import com.portal.repository.ProjectRepository;
//import com.portal.validations.Validation;
//
//@SpringBootTest
//public class AddProjectServiceTest {
//
//    @Mock
//    private ProjectRepository projectRepository;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    @Mock
//    private Validation projectValidation;
//
//    @InjectMocks
//    private AddProjectService addProjectService;
//
//    @Test
//    public void testGetSkillsForProject_ProjectExists() {
//        // Arrange
//        String projectName = "Project A";
//        Project project = new Project();
//        project.setName(projectName);
//        project.setSkills("Skill1,Skill2");
//
//        when(projectRepository.findByName(projectName)).thenReturn(project);
//
//        // Act
//        List<String> skills = addProjectService.getSkillsForProject(projectName);
//
//        // Assert
//        assertEquals(Arrays.asList("Skill1", "Skill2"), skills);
//    }
//
//    @Test
//    public void testGetSkillsForProject_ProjectNotExists() {
//        // Arrange
//        String projectName = "NonExistentProject";
//
//        when(projectRepository.findByName(projectName)).thenReturn(null);
//
//        // Act
//        List<String> skills = addProjectService.getSkillsForProject(projectName);
//
//        // Assert
//        assertTrue(skills.isEmpty());
//    }
//}
