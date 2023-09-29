//package com.portal.service;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//import com.portal.DTO.*;
//import com.portal.entities.Employee;
//import com.portal.entities.Role;
//import com.portal.exceptions.DuplicateEntryException;
//import com.portal.exceptions.ResourceNotFoundException;
//import com.portal.exceptions.WrongCredentialsException;
//import com.portal.repository.AdminRepository;
//import com.portal.repository.ProjectRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AdminServiceTest {
//
//    @Mock
//    private AdminRepository adminRepository;
//
//    @Mock
//    private ProjectRepository projectRepository;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private AdminService adminService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testRegisterAdmin_Success() {
//        // Create a mock AdminDTO
//        AdminDTO adminDTO = new AdminDTO();
//        adminDTO.setName("John Doe");
//        adminDTO.setEmail("johndoe@example.com");
//        adminDTO.setPassword("password");
//        adminDTO.setRole(Role.ADMIN);
//
//        // Create a mock Employee entity
//        Employee employeeEntity = new Employee();
//        employeeEntity.setId(1L);
//        employeeEntity.setName(adminDTO.getName());
//        employeeEntity.setEmail(adminDTO.getEmail());
//        employeeEntity.setPassword(adminDTO.getPassword());
//        employeeEntity.setRole(adminDTO.getRole());
//
//        // Mock the repository's save method to return the employee entity
//        when(adminRepository.save(any(Employee.class))).thenReturn(employeeEntity);
//
//        // Call the registerAdmin method
//        ResponseDTO responseDTO = adminService.registerAdmin(adminDTO);
//
//        // Verify that the response is successful
//        assertNotNull(responseDTO);
//        assertEquals("Admin added successfully", responseDTO.getMessage());
//        assertEquals("ADMIN", responseDTO.getRole());
//    }
//
//    @Test
//    public void testRegisterAdmin_DuplicateEntryException() {
//        // Create a mock AdminDTO
//        AdminDTO adminDTO = new AdminDTO();
//        adminDTO.setName("John Doe");
//        adminDTO.setEmail("johndoe@example.com");
//        adminDTO.setPassword("password");
//        adminDTO.setRole(Role.EMPLOYEE);
//        
//
//        // Mock the repository to return an existing employee with the same email
//        when(adminRepository.findByEmail(anyString())).thenReturn(Optional.of(new Employee()));
//
//        // Verify that a DuplicateEntryException is thrown
//        assertThrows(DuplicateEntryException.class, () -> adminService.registerAdmin(adminDTO));
//    }
//    @Autowired
//    private LoginResponseDTO response;
//
//    @Test
//    public void testLogin_Success() {
//        // Create a mock LoginDTO
//        LoginDTO loginDTO = new LoginDTO();
//        loginDTO.setEmail("ankita.sharma@nucleusteq.com");
//        loginDTO.setPassword("password");
//
//        // Create a mock Employee entity
//        Employee employeeEntity = new Employee();
//        employeeEntity.setId(1L);
//        employeeEntity.setName("Ankita Sharma");
//        employeeEntity.setEmail("ankita.sharma@nucleusteq.com");
//        employeeEntity.setPassword("encodedPassword");
//        employeeEntity.setRole(Role.ADMIN);
//        
//
//
//        // Mock the repository to return the employee entity
//        when(adminRepository.findByEmail(anyString())).thenReturn(Optional.of(employeeEntity));
//
//        // Mock passwordEncoder to return true when matching passwords
//        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
//
//        // Call the login method
//        LoginResponseDTO responseDTO = adminService.login(loginDTO);
//
//        // Verify that the response is successful
//        assertNotNull(responseDTO);
//        assertEquals("Login successful", responseDTO.getMessage());
//        assertEquals("ADMIN", responseDTO.getRole());
//        assertEquals("Ankita Sharma", responseDTO.getName());
//        assertEquals(1L, responseDTO.getId());
//    }
//
//    @Test
//    public void testLogin_WrongCredentialsException() {
//        // Create a mock LoginDTO
//        LoginDTO loginDTO = new LoginDTO();
//        loginDTO.setEmail("johndoe@example.com");
//        loginDTO.setPassword("password");
//
//        // Mock the repository to return null (user not found)
//        when(adminRepository.findByEmail(anyString())).thenReturn(Optional.empty());
//
//        // Verify that a WrongCredentialsException is thrown
//        assertThrows(WrongCredentialsException.class, () -> adminService.login(loginDTO));
//    }
//
//    @Test
//    public void testGetAllAdmin() {
//        // Create a list of mock Employee entities
//        List<Employee> employeeList = new ArrayList<>();
//        Employee employee1 = new Employee();
//        employee1.setId(1L);
//        employee1.setName("John Doe");
//        employee1.setEmail("johndoe@example.com");
//        employee1.setRole(Role.EMPLOYEE);
//        employeeList.add(employee1);
//
//        Employee employee2 = new Employee();
//        employee2.setId(2L);
//        employee2.setName("Jane Smith");
//        employee2.setEmail("janesmith@example.com");
//        employee2.setRole(Role.MANAGER); 
//        employeeList.add(employee2);
//
//        // Mock the repository to return the list of employees
//        when(adminRepository.findAll()).thenReturn(employeeList);
//
//        // Call the getAllAdmin method
//        List<EmployeeOutDTO> employeeDTOList = adminService.getAllAdmin();
//
//        // Verify that the returned list is not empty and contains two elements
//        assertNotNull(employeeDTOList);
//        assertEquals(2, employeeDTOList.size());
//    }
//
//    @Test
//    public void testGetUserRoleByEmail_Success() {
//        // Create a mock Employee entity
//        Employee employeeEntity = new Employee();
//        employeeEntity.setId(1L);
//        employeeEntity.setName("John Doe");
//        employeeEntity.setEmail("johndoe@example.com");
//        employeeEntity.setPassword("encodedPassword");
//        employeeEntity.setRole(Role.ADMIN);
//
//        // Mock the repository to return the employee entity
//        when(adminRepository.findByEmail(anyString())).thenReturn(Optional.of(employeeEntity));
//
//        // Call the getUserRoleByEmail method
//        String role = adminService.getUserRoleByEmail("johndoe@example.com");
//
//        // Verify that the role is correct
//        assertEquals("ADMIN", role);
//    }
//
//    @Test
//    public void testGetUserRoleByEmail_ResourceNotFoundException() {
//        // Mock the repository to return null (user not found)
//        when(adminRepository.findByEmail(anyString())).thenReturn(Optional.empty());
//
//        // Verify that a ResourceNotFoundException is thrown
//        assertThrows(ResourceNotFoundException.class, () -> adminService.getUserRoleByEmail("johndoe@example.com"));
//    }
//}
//
