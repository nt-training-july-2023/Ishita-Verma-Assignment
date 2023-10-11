package com.portal.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.portal.DTO.*;
import com.portal.entities.Designation;
import com.portal.entities.Employee;
import com.portal.entities.Location;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.exceptions.WrongCredentialsException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AdminServiceTest {
    @InjectMocks
    private AdminService adminService;
    
    @Mock
    private AdminRepository userRepository;
    
    @Mock
    private ModelMapper modelMapper;
    
    @Mock
    private ProjectRepository projectRepository;
    
    @Mock
    private PasswordEncoder passwordEncoder;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    List<String> skills= new ArrayList<>();
    List<String> teams=new ArrayList<>();
    
    @Test
    public void testAddEmployee() {
        EmployeeInDTO empDTO = new EmployeeInDTO();
        skills.add("React");
        skills.add("Java");
        empDTO.setId(1l);
        empDTO.setEmpId("N0001");
        empDTO.setName("Ankita Sharma");
        empDTO.setEmail("ankita.sharma@nucleusteq.com");
        empDTO.setDob("1998-08-10");
        empDTO.setDoj("2019-11-21");
        empDTO.setLocation(Location.Raipur);
        empDTO.setDesignation(Designation.Engineer);
        empDTO.setContactNumber("1234567890");
        empDTO.setPassword("admin123");
        empDTO.setRole(Role.ADMIN);
        empDTO.setProjectId(0L);
        empDTO.setSkills(skills);
       // empDTO.setManagerID(1);
        
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setEmpId("N0001");
        emp.setName("Ankita Sharma");
        emp.setEmail("ankita.sharma@nucleusteq.com");
        emp.setDob("1998-08-10");
        emp.setDoj("2019-11-21");
        emp.setLocation(Location.Raipur);
        emp.setDesignation(Designation.Engineer);
        emp.setContactNumber("1234567890");
        emp.setPassword("admin123");
        emp.setRole(Role.ADMIN);
        emp.setProjectId(0L);
        emp.setManagerId((long)1);
        emp.setSkills(skills);
        
        when(userRepository.findByEmail(emp.getEmail())).thenReturn(Optional.of(emp));
        empDTO.setManagerId(emp.getId());
        
        when(userRepository.save(emp)).thenReturn(emp);
        
        ApiResponseDTO admin = adminService.registerAdmin(empDTO);
        assertEquals("Admin added successfully",admin.getMessage());
    }
    @Test
    public void testLoginValidUser() {
        // Arrange
        LoginInDTO loginDTO = new LoginInDTO();
        loginDTO.setEmail("user@nucleusteq.com");
        loginDTO.setPassword("password"); 

        Employee mockUser = new Employee();
        mockUser.setEmail("user@nucleusteq.com");
        mockUser.setPassword("encoded_password");
        mockUser.setName("Ankita");
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(mockUser));
        when(passwordEncoder.matches(any(), any())).thenReturn(true);

        // Act
        LoginOutDTO result = adminService.login(loginDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Login Successful", result.getMessage());
    }

    @Test
    public void testLoginInvalidUser() {
        // Arrange
        LoginInDTO loginDTO = new LoginInDTO();
        loginDTO.setEmail("nonexistent@nucleusteq.com");
        loginDTO.setPassword("password");
        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());

        assertThrows(WrongCredentialsException.class, () -> adminService.login(loginDTO));
    }
//    @Test
//    public void testGetAll() {
//        Employee emp1 = new Employee();
//        emp1.setId(1L);
//        emp1.setName("Anjali");
//        emp1.setEmail("anjlai@nucleusteq.com");
//        emp1.setEmpId("N1234");
//        emp1.setDob("05/12/2000");
//        emp1.setDoj("17/07/2023");
//        emp1.setLocation(Location.Bangalore);
//        emp1.setDesignation(Designation.Engineer);
//        emp1.setContactNumber("758783866");
//        emp1.setPassword("Anjali122");
//        emp1.setRole(Role.EMPLOYEE);
////        emp1.setManager("Vanshika");
//        emp1.setProjectId(1L);
//
//        Employee emp2 = new Employee();
//        emp2.setId(2L);
//        emp2.setName("Vanshika");
//        emp2.setEmail("vanshika@nucleusteq.com");
//        emp2.setEmpId("N1212");
//        emp2.setDob("05/12/2002");
//        emp2.setDoj("17/07/2023");
//        emp2.setLocation(Location.Raipur);
//        emp2.setDesignation(Designation.Engineer);
//        emp2.setContactNumber("758783866");
//        emp2.setPassword("Vanshika1212");
//        emp2.setRole(Role.MANAGER);
////        emp2.setManager("Ankita");
//
//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(emp1);
//        employeeList.add(emp2);
//
//        when(userRepository.findAll()).thenReturn(employeeList);
//        List<EmployeeOutDTO> result = adminService.getAllAdmin();
//        System.out.println("Result : " + result.toString());
//        assertEquals(2L, result.size());
//        assertEquals("Anjali", result.get(0).getName());
//        assertEquals("anjlai@nucleusteq.com",
//                result.get(0).getEmail());
//        assertEquals("N1234", result.get(0).getEmpId());
//        assertEquals("05/12/2000", result.get(0).getDob());
//        assertEquals("17/07/2023", result.get(0).getDoj());
//        assertEquals(Location.Bangalore, result.get(0).getLocation());
//        assertEquals(Designation.Engineer, result.get(0).getDesignation());
//        assertEquals("758783866", result.get(0).getContactNumber());
//        assertEquals("Vanshika", result.get(0).getManager());
//
//        assertEquals("Vanshika", result.get(1).getName());
//        assertEquals("vanshika@nucleusteq.com",
//                result.get(1).getEmail());
//        assertEquals("N1212", result.get(1).getEmpId());
//        assertEquals("05/12/2002", result.get(1).getDob());
//        assertEquals("17/07/2023", result.get(1).getDoj());
//        assertEquals(Location.Raipur, result.get(1).getLocation());
//        assertEquals(Designation.Engineer, result.get(1).getDesignation());
//        assertEquals("758783866", result.get(1).getContactNumber());
//        assertEquals("Ankita", result.get(1).getManager());
//    }
//    @Test
//    public void testGetAllAdmin() {
//        // Mock the data to be returned by adminRepository.findAll()
//        Employee employee1 = new Employee();
//        Employee employee2 = new Employee();
//        List<String> skills1= new ArrayList<>();
//        List<String> skills2= new ArrayList<>();
//        skills1.add("React");
//        skills1.add("Java");
//        employee1.setName("Employee1");
//        employee1.setContactNumber("1234567890");
//        employee1.setDesignation(Designation.Engineer);
//        employee1.setDob("2001-02-12");
//        employee1.setDoj("2020-09-11");
//        employee1.setEmail("employee1@nucleusteq.com");
//        employee1.setEmpId("N1111");
//        employee1.setId(1L);
//        employee1.setLocation(Location.Raipur);
//        employee1.setManagerId(1L);
//        employee1.setPassword("Emp123@");
//        employee1.setProjectId(1L);
//        employee1.setRole(Role.EMPLOYEE);
//        employee1.setSkills(skills1);
//        
//        skills2.add("React");
//        skills2.add("Java");
//        employee2.setName("Employee2");
//        employee2.setContactNumber("1234567890");
//        employee2.setDesignation(Designation.Engineer);
//        employee2.setDob("2001-02-12");
//        employee2.setDoj("2020-09-11");
//        employee2.setEmail("employee2@nucleusteq.com");
//        employee2.setEmpId("N1112");
//        employee2.setId(2L);
//        employee2.setLocation(Location.Raipur);
//        employee2.setManagerId(2L);
//        employee2.setPassword("Emp1234@");
//        employee2.setProjectId(2L);
//        employee2.setRole(Role.EMPLOYEE);
//        employee2.setSkills(skills2);
//        List<Employee> mockEmployees = Arrays.asList(employee1, employee2);
//
//        // Mock the behavior of adminRepository.findAll()
//        when(userRepository.findAll()).thenReturn(mockEmployees);
//
//        // Mock the behavior of projectRepository.findById()
//        Project project = new Project();
//        project.setName("Fyndr");
//        project.setDescription("Comment");
//        project.setManagerId(1L);
//        project.setProjectId(1L);
//        project.setStartDate("2020-02-11");
//        project.setSkills(skills1);
//        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
//
//        // Execute the method to be tested
//        List<EmployeeOutDTO> result = adminService.getAllAdmin();
//
//        // Assertions
//        assertThat(result).isNotEmpty();
//        assertThat(result).hasSize(2);
//       
//    }
}

