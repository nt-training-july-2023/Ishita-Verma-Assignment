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
        
        when(userRepository.save(emp)).thenReturn(emp);
        
        ApiResponseDTO admin = adminService.registerAdmin(empDTO);
        assertEquals("Admin added successfully",admin.getMessage());
    }
    @Test
    public void testLoginValidUser() {
        
        LoginInDTO loginDTO = new LoginInDTO();
        loginDTO.setEmail("user@nucleusteq.com");
        loginDTO.setPassword("password"); 

        Employee mockUser = new Employee();
        mockUser.setEmail("user@nucleusteq.com");
        mockUser.setPassword("encoded_password");
        mockUser.setName("Ankita");
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(mockUser));
        when(passwordEncoder.matches(any(), any())).thenReturn(true);

        LoginOutDTO result = adminService.login(loginDTO);

        assertNotNull(result);
        assertEquals("Login Successful", result.getMessage());
    }

    @Test
    public void testLoginInvalidUser() {
        LoginInDTO loginDTO = new LoginInDTO();
        loginDTO.setEmail("nonexistent@nucleusteq.com");
        loginDTO.setPassword("password");
        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());

        assertThrows(WrongCredentialsException.class, () -> adminService.login(loginDTO));
    }
    @Test
    public void testGetAllAdmin() {
        
        Employee emp1 = new Employee();
        emp1.setId(1L);
        emp1.setName("Anjali");
        emp1.setEmail("anjali@nucleusteq.com");
        emp1.setEmpId("N1234");
        emp1.setDob("05/12/2000");
        emp1.setDoj("17/07/2023");
        emp1.setLocation(Location.Bangalore);
        emp1.setDesignation(Designation.Engineer);
        emp1.setContactNumber("758783866");
        emp1.setPassword("Anjali122");
        emp1.setRole(Role.EMPLOYEE);
        emp1.setProjectId(0L);
        emp1.setManagerId(2L);
        emp1.setSkills(skills);
       
        List<Employee> allEmpList = new ArrayList<Employee>();
        allEmpList.add(emp1);
        when(userRepository.findAll()).thenReturn(allEmpList);
        Employee manager = new Employee();
        manager.setId(2L);
        manager.setEmpId("N1002");
        manager.setName(" Vanshika Sharma");
        manager.setEmail("vanshika@nucleusteq.com");
        manager.setDob("2001-09-07");
        manager.setDoj("2023-07-17");
        manager.setLocation(Location.Raipur);
        manager.setDesignation(Designation.Engineer);
        manager.setContactNumber("1234567809");
        manager.setRole(Role.MANAGER);
        manager.setSkills(skills);
        manager.setManagerId(1L);
        manager.setPassword("van12345");
        manager.setProjectId(0L);
        when(userRepository.findById(manager.getId()))
                .thenReturn(Optional.of(manager));
        List<EmployeeOutDTO> result = adminService.getAllAdmin();
        assertEquals(1, result.size());

    }
}
