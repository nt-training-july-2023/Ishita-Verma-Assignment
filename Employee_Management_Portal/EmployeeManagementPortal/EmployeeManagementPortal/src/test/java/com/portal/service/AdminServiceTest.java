package com.portal.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.LoginDTO;
import com.portal.DTO.LoginResponseDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.exceptions.DuplicateEntryException;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.exceptions.WrongCredentialsException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;

class AdminServiceTest {


//    private AdminService adminService;
    private AdminRepository adminRepository;
    private ProjectRepository projectRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AdminService adminService;

    @BeforeEach
    public void setUp() {
        adminRepository = mock(AdminRepository.class);
        projectRepository = mock(ProjectRepository.class);
        modelMapper = mock(ModelMapper.class);
        passwordEncoder = mock(PasswordEncoder.class);
//        adminService = new AdminService();
//        adminService.adminRepository = adminRepository;
//        adminService.projectRepository = projectRepository;
//        adminService.modelMapper = modelMapper;
//        adminService.passwordEncoder = passwordEncoder;
    }

    @Test
    public void testRegisterAdmin_ValidAdmin() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setName("Ankita Sharma");
        adminDTO.setEmail("ankita.sharma@nucleusteq.com");
        adminDTO.setEmpId("N1111");
        Employee adminEntity = new Employee();
        adminEntity.setEmail(adminDTO.getEmail());

        when(adminRepository.existsByEmail(adminDTO.getEmail())).thenReturn(false);
        when(modelMapper.map(adminDTO, Employee.class)).thenReturn(adminEntity);

        ResponseDTO responseDTO = adminService.registerAdmin(adminDTO);
        assertEquals("Admin added succesfully", responseDTO.getMessage());
    }

    @Test
    public void testRegisterAdmin_DuplicateEmail() {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setName("Ankita Sharma");
        adminDTO.setEmail("ankita.sharma@nucleusteq.com");
        adminDTO.setEmpId("N1111");

        when(adminRepository.existsByEmail(adminDTO.getEmail())).thenReturn(true);

        assertThrows(DuplicateEntryException.class, () -> adminService.registerAdmin(adminDTO));
    }

    @Test
    public void testLogin_ValidCredentials() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("john@example.com");
        loginDTO.setPassword("password123");
        Employee adminEntity = new Employee();
        adminEntity.setEmail(loginDTO.getEmail());
        adminEntity.setPassword("hashed_password");
        adminEntity.setRole(Role.ADMIN);

        when(adminRepository.findByEmail(loginDTO.getEmail())).thenReturn(Optional.of(adminEntity));
        when(passwordEncoder.matches(loginDTO.getPassword(), adminEntity.getPassword())).thenReturn(true);

        LoginResponseDTO responseDTO = adminService.login(loginDTO);

        assertNotNull(responseDTO);
        assertEquals("Login successful", responseDTO.getMessage());
        assertEquals(Role.ADMIN, responseDTO.getRole());
    }

    @Test
    public void testLogin_InvalidEmail() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("invalid_email");
        loginDTO.setPassword("password123");

        when(adminRepository.findByEmail(loginDTO.getEmail())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> adminService.login(loginDTO));
    }

    @Test
    public void testLogin_InvalidPassword() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("john@example.com");
        loginDTO.setPassword("wrong_password");
        Employee adminEntity = new Employee();
        adminEntity.setEmail(loginDTO.getEmail());
        adminEntity.setPassword("hashed_password");

        when(adminRepository.findByEmail(loginDTO.getEmail())).thenReturn(Optional.of(adminEntity));
        when(passwordEncoder.matches(loginDTO.getPassword(), adminEntity.getPassword())).thenReturn(false);

        assertThrows(WrongCredentialsException.class, () -> adminService.login(loginDTO));
    }

    @Test
    public void testGetAllAdmin() {
        List<Employee> allEmployees = new ArrayList<>();
        Employee admin1 = new Employee();
        admin1.setRole(Role.ADMIN);
        Employee admin2 = new Employee();
        admin2.setRole(Role.MANAGER);
        Employee employee1 = new Employee();
        employee1.setRole(Role.EMPLOYEE);
        Employee employee2 = new Employee();
        employee2.setRole(Role.EMPLOYEE);
        allEmployees.add(admin1);
        allEmployees.add(admin2);
        allEmployees.add(employee1);
        allEmployees.add(employee2);

        when(adminRepository.findAll()).thenReturn(allEmployees);
        when(projectRepository.findById(anyLong())).thenReturn(Optional.of(new Project()));
        when(adminRepository.findById(anyLong())).thenReturn(Optional.of(new Employee()));

        List<EmployeeOutDTO> employeeDTOList = adminService.getAllAdmin();

        assertNotNull(employeeDTOList);
        assertEquals(2, employeeDTOList.size());
    }
}
