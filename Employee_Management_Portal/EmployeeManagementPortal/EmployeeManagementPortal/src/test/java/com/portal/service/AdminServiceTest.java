package com.portal.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.portal.DTO.*;
import com.portal.entities.Designation;
import com.portal.entities.Employee;
import com.portal.entities.Location;
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
import java.util.List;
import java.util.Optional;

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
        
        ResponseDTO admin = adminService.registerAdmin(empDTO);
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
    @Test
    public void testGetAllEmployees() {
        skills.add("Java");
        skills.add("React");
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setEmpId("N1001");
        emp.setName("Anjali Sharma");
        emp.setEmail("anjali.sharma@nucleusteq.com");
        emp.setDob("2001-09-07");
        emp.setDoj("2023-07-17");
        emp.setLocation(Location.Raipur);
        emp.setDesignation(Designation.Engineer);
        emp.setContactNumber("1234567800");
        emp.setRole(Role.EMPLOYEE);
        emp.setSkills(skills);
        emp.setManagerId((long)2);
        emp.setPassword("admin123");
        emp.setProjectId(0L);
        
        List<Employee> allEmpList = new ArrayList<Employee>();
        allEmpList.add(emp);
        when(userRepository.findByRole(Role.EMPLOYEE)).thenReturn(allEmpList);
        
        EmployeeOutDTO empDto= new EmployeeOutDTO();
        empDto.setId(1L);
        empDto.setEmpId("N1001");
        empDto.setName("Anjali Sharma");
        empDto.setEmail("anjali.sharma@nucleusteq.com");
        empDto.setDob("2001-09-07");
        empDto.setDoj("2023-07-17");
        empDto.setLocation(Location.Raipur);
        empDto.setDesignation(Designation.Engineer);
        empDto.setContactNumber("1234567800");
        empDto.setSkills(skills);
        empDto.setManagerId(2L);
        empDto.setManager("Vanshika Sharma");
        empDto.setProjectName("Fyndr");
        Employee manager= new Employee();
        manager.setId(2L);
        manager.setEmpId("N1002");
        manager.setName(" Vanshika Sharma");
        manager.setEmail("vanshika.sharma@nucleusteq.com");
        manager.setDob("2001-09-07");
        manager.setDoj("2023-07-17");
        manager.setLocation(Location.Raipur);
        manager.setDesignation(Designation.Engineer);
        manager.setContactNumber("1234567809");
        manager.setRole(Role.MANAGER);
        manager.setSkills(skills);
        manager.setManagerId((long)1);
        manager.setPassword("van12345");
        manager.setProjectId(1L);
        
        allEmpList.add(manager);
        when(userRepository.findByRole(Role.MANAGER)).thenReturn(allEmpList);
        
        List<Employee> filteredList = new ArrayList<>();
        filteredList.add(emp);
        filteredList.add(manager);    

        List<EmployeeOutDTO>empOutList = new ArrayList<EmployeeOutDTO>();
        empOutList.add(empDto);
        when(userRepository.findById(emp.getManagerId())).thenReturn(Optional.of(manager));
        empOutList.add(empDto);
        

    List<EmployeeOutDTO> result = adminService.getAllAdmin();

    }
}

