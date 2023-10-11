package com.portal.validation;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.portal.DTO.EmployeeInDTO;
import com.portal.DTO.LoginInDTO;
import com.portal.DTO.ProjectInDTO;
import com.portal.constants.ErrorConstants;
import com.portal.entities.Designation;
import com.portal.entities.Employee;
import com.portal.entities.Location;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.exceptions.DuplicateEntryException;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.exceptions.ValidationException;
import com.portal.exceptions.WrongCredentialsException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

public class ValidationTest {

    @Mock
    private AdminRepository userRepository;

    @Mock
    private ProjectRepository projectRepository;
    
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private Validation validation;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    List<String> skills = new ArrayList<>();
    
    @Test
    void testCheckAdminNoException() {
        EmployeeInDTO empDto= new EmployeeInDTO();
        empDto.setEmpId("N0001");
        empDto.setName("Ankita Sharma");
        empDto.setEmail("ankita.sharma@nucleusteq.com");
        empDto.setDob("1998-08-10");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.Bangalore);
        empDto.setDesignation(Designation.Recruiter);
        empDto.setContactNumber("1234567890");
        empDto.setPassword("admin123");
        empDto.setRole(Role.ADMIN);
        empDto.setProjectId(0L);
        empDto.setManagerId(1L);
        empDto.setSkills(skills);
        when(userRepository.findByEmail(empDto.getEmail())).thenReturn(Optional.empty());
        when(userRepository.findByEmpId(empDto.getEmpId())).thenReturn(Optional.empty());
        
        assertDoesNotThrow(()->validation.checkAdmin(empDto));
        
    }

    @Test
    void testCheckAdminException() {
        EmployeeInDTO empDto= new EmployeeInDTO();
        empDto.setEmpId("N0001");
        empDto.setName("Ankita Sharma");
        empDto.setEmail("ankita.sharma@nucleusteq.com");
        empDto.setDob("1998-08-10");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.Bangalore);
        empDto.setDesignation(Designation.Recruiter);
        empDto.setContactNumber("1234567890");
        empDto.setPassword("admin123");
        empDto.setRole(Role.ADMIN);
        empDto.setProjectId(0L);
        empDto.setManagerId(1L);
        empDto.setSkills(skills);
        when(userRepository.findByEmail(empDto.getEmail())).thenReturn(Optional.of(new Employee()));
        when(userRepository.findByEmpId(empDto.getEmpId())).thenReturn(Optional.of(new Employee()));
        assertThrows(DuplicateEntryException.class, ()->{
            validation.checkAdmin(empDto);
        });
    }
    @Test
    void testCheckLogin_EmailFound() {
        LoginInDTO LoginDTO = new LoginInDTO();
        LoginDTO.setEmail("ankita@nucleusteq.com");
        LoginDTO.setPassword("admin123");
        
        Employee emp = new Employee();
        emp.setEmail(LoginDTO.getEmail());
        emp.setPassword(LoginDTO.getPassword());
        
        when(userRepository.findByEmail(emp.getEmail())).thenReturn(Optional.of(emp));
        
        assertDoesNotThrow(() -> validation.checkLogin(LoginDTO));
    }

    @Test
    void testCheckLogin_EmailNotFound() {
        LoginInDTO LoginDTO = new LoginInDTO();
        LoginDTO.setEmail("ankita@nucleusteq.com");
        LoginDTO.setPassword("admin123");
        
        when(userRepository.findByEmail(LoginDTO.getEmail())).thenReturn(Optional.empty());
        
        assertThrows(ResourceNotFoundException.class, () -> {
            validation.checkLogin(LoginDTO);
        });
    }
    @Test
    void testCheckEmployeeNoException() {
        EmployeeInDTO empDto= new EmployeeInDTO();
        empDto.setEmpId("N0001");
        empDto.setName("Anjali Sharma");
        empDto.setEmail("anjali@nucleusteq.com");
        empDto.setDob("1998-08-10");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.Bangalore);
        empDto.setDesignation(Designation.Recruiter);
        empDto.setContactNumber("1234567890");
        empDto.setPassword("admin123");
        empDto.setRole(Role.EMPLOYEE);
        empDto.setProjectId(0L);
        empDto.setManagerId(1L);
        empDto.setSkills(skills);
        when(userRepository.findByEmail(empDto.getEmail())).thenReturn(Optional.empty());
        when(userRepository.findByEmpId(empDto.getEmpId())).thenReturn(Optional.empty());

        assertDoesNotThrow(() ->validation.checkEmployee(empDto));

    }
    @Test
    void testCheckEmployeeException() {
        EmployeeInDTO empDto= new EmployeeInDTO();
        empDto.setEmpId("N0001");
        empDto.setName("Anjali Sharma");
        empDto.setEmail("anjali@nucleusteq.com");
        empDto.setDob("1998-08-10");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.Bangalore);
        empDto.setDesignation(Designation.Recruiter);
        empDto.setContactNumber("1234567890");
        empDto.setPassword("admin123");
        empDto.setRole(Role.EMPLOYEE);
        empDto.setProjectId(0L);
        empDto.setManagerId(1L);
        empDto.setSkills(skills);
        when(userRepository.findByEmail(empDto.getEmail())).thenReturn(Optional.of(new Employee()));
        
        when(userRepository.findByEmpId(empDto.getEmpId())).thenReturn(Optional.of(new Employee()));
        assertThrows(DuplicateEntryException.class, ()->{

            validation.checkEmpId(empDto.getEmpId());
            });
    }
    @Test
    void testCheckProject() {
        skills.add("React");
        skills.add("Java");
    Project project = new Project();
    project.setProjectId(1L);
    project.setManagerId(1L);
    project.setName("Fyndr");
    project.setDescription("Description");
    project.setStartDate("2023-06-07");
    project.setSkills(skills);
    
    ProjectInDTO prjDto = new ProjectInDTO();
    prjDto.setName("Fyndr");
    prjDto.setManagerId(1L);
    prjDto.setStartDate("2023-06-07");
    prjDto.setSkills(skills);
    prjDto.setDescription("Description");
    Optional<Project> optionalProject = Optional.of(project);
    when(projectRepository.findByName(project.getName())).thenReturn(project);
    assertThrows(DuplicateEntryException.class, ()->{
        validation.checkProject(prjDto);
    });
    }
    @Test
    void testCheckManagerExists() {
        Employee employee= new Employee();
        employee.setId(1L);
        employee.setEmpId("N1111");
        employee.setName("Ankita Sharma");
        employee.setEmail("ankita.sharma@nucleusteq.com");
        employee.setDob("1990-01-01");
        employee.setDoj("2021-01-01");
        employee.setLocation(Location.Raipur);
        employee.setDesignation(Designation.Engineer);
        employee.setContactNumber("1234567890");
        employee.setRole(Role.EMPLOYEE);
        employee.setProjectId(10L);
        employee.setPassword("password");
        when(userRepository.findById(employee.getId())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, ()->{
            validation.checkManagerExists(employee.getId());
        });
        Employee manager = new Employee();
        manager.setId(1L);
        manager.setEmpId("N1111");
        manager.setName("Ankita Sharma");
        manager.setEmail("ankita.sharma@nucleusteq.com");
        manager.setDob("1990-01-01");
        manager.setDoj("2021-01-01");
        manager.setLocation(Location.Raipur);
        manager.setDesignation(Designation.Engineer);
        manager.setContactNumber("1234567890");
        manager.setRole(Role.ADMIN);
        manager.setProjectId(10L);
        manager.setPassword("password");
        when(userRepository.findById(employee.getId())).thenReturn(Optional.of(manager));
        assertThrows(ResourceNotFoundException.class, ()->{
            validation.checkManagerExists(manager.getId());
        });
        
    }
    
    @Test
    void testCheckProjectExists() {
        skills.add("React");
        skills.add("Java");
    Project project = new Project();
    project.setProjectId(1L);
    project.setManagerId(1L);
    project.setName("Fyndr");
    project.setDescription("Description");
    project.setStartDate("2023-06-07");
    project.setSkills(skills);
    when(projectRepository.findById(project.getProjectId())).thenReturn(Optional.empty());
    assertThrows(ResourceNotFoundException.class, ()->{
        validation.checkProjectExists(project.getProjectId());
    });
    }
    @Test
    void checkUpdateSkillsEmployeeException() {
        Employee emp = new Employee();
       
        emp.setId(1L);
        emp.setEmpId("N0001");
        emp.setName("Ankita Sharma");
        emp.setEmail("ankita.sharma@nucleusteq.com");
        emp.setDob("1998-08-10");
        emp.setDoj("2019-11-21");
        emp.setLocation(Location.Bangalore);
        emp.setDesignation(Designation.Recruiter);
        emp.setContactNumber("1234567890");
        emp.setPassword("admin123");
        emp.setRole(Role.ADMIN);
        emp.setProjectId(1L);
        emp.setManagerId(2L);
        emp.setSkills(skills);
        Map<String,List<String>> map = new HashMap<>();
        map.put("skills", skills);
        
        when(userRepository.findById(emp.getId())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class,()->{
            validation.checkUpdateSkills(emp.getId(), map);
        });

    }
    @Test
    void checkUpdateSkillsException() {
        Employee emp = new Employee();
       
        emp.setId(1L);
        emp.setEmpId("N0001");
        emp.setName("Ankita Sharma");
        emp.setEmail("ankita.sharma@nucleusteq.com");
        emp.setDob("1998-08-10");
        emp.setDoj("2019-11-21");
        emp.setLocation(Location.Bangalore);
        emp.setDesignation(Designation.Recruiter);
        emp.setContactNumber("1234567890");
        emp.setPassword("admin123");
        emp.setRole(Role.EMPLOYEE);
        emp.setProjectId(1L);
        emp.setManagerId(2L);
        emp.setSkills(skills);
        Map<String,List<String>> map = new HashMap<>();
        map.put("skills", skills);
        when(userRepository.findById(emp.getId())).thenReturn(Optional.of(emp));
        assertThrows(ValidationException.class,()->{
            validation.checkUpdateSkills(emp.getId(), map);
        });
    }
}
