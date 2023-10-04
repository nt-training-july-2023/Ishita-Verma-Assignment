package com.portal.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.EmployeeInDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.RequestResourceInDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.entities.Designation;
import com.portal.entities.Employee;
import com.portal.entities.Location;
import com.portal.entities.Project;
import com.portal.entities.RequestResource;
import com.portal.entities.Role;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.repository.RequestResourceRepository;

class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private AdminRepository userRepository;
    
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private RequestResourceRepository requestRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private RequestResourceService requestService;
    @Mock
    private ApiResponseDTO response;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddEmployee() {
        // Create a mock EmployeeInDTO
        EmployeeInDTO adminDTO = new EmployeeInDTO();
        adminDTO.setEmpId("E1001");
        adminDTO.setEmail("test@example.com");
        adminDTO.setName("Test Employee");

        // Initialize the skills property with a non-null List
        adminDTO.setSkills(Collections.emptyList()); // You can provide a list of skills here

        // Create a mock Employee entity
        Employee mockEmployee = new Employee();
        mockEmployee.setId(1L);

        // Mock the userRepository.findByEmail method to return the mock Employee
        when(userRepository.findByEmail("ankita.sharma@nucleusteq.com")).thenReturn(Optional.of(mockEmployee));

        // Mock the userRepository.save method to return the same entity
        when(userRepository.save(any(Employee.class))).thenReturn(mockEmployee);

        // Mock the ApiResponseDTO setMessage method
        doNothing().when(response).setMessage("Employee Added Successfully");

        // Call the method to test
        ApiResponseDTO result = employeeService.addEmployee(adminDTO);

        // Assertions
        assertEquals("Employee Added Successfully", result.getMessage());
        // Add more assertions as needed for other fields or behavior
    }    


    @Test
    void testRequestToOutDto() {
        // Create a sample RequestResource
        RequestResource requestResource = new RequestResource();
        requestResource.setComment("Sample comment");
        requestResource.setEmployeeId(1L);
        requestResource.setManagerId(2L);
        requestResource.setProjectId(3L);

        // Create sample Employee and Project objects
        Employee sampleEmployee = new Employee();
        sampleEmployee.setId(1L);
        sampleEmployee.setName("John Doe");
        sampleEmployee.setEmpId("EMP001");

        Employee sampleManager = new Employee();
        sampleManager.setId(2L);
        sampleManager.setName("Jane Smith");
        sampleManager.setEmpId("EMP002");

        Project sampleProject = new Project();
        sampleProject.setProjectId(3L);
        sampleProject.setName("Sample Project");

        // Mock userRepository.findById to return the sample Employee and Manager
        when(userRepository.findById(1L)).thenReturn(Optional.of(sampleEmployee));
        when(userRepository.findById(2L)).thenReturn(Optional.of(sampleManager));

        // Mock projectRepository.findById to return the sample Project
        when(projectRepository.findById(3L)).thenReturn(Optional.of(sampleProject));

        // Call the requestToOutDto method
        RequestResourceOutDTO result = employeeService.requestToOutDto(requestResource);

        // Verify that the result matches the expected RequestResourceOutDTO
        assertEquals("Sample comment", result.getComment());
        assertEquals(1L, result.getEmpId());
        assertEquals(2L, result.getManagerId());
        assertEquals(3L, result.getProjectId());
        assertEquals("John Doe", result.getEmployeeName());
        assertEquals("EMP001", result.getEmpUserId());
        assertEquals("Jane Smith", result.getManagerName());
        assertEquals("EMP002", result.getManagerUserId());
        assertEquals("Sample Project", result.getProjectName());
    }
   
    @Test
    public void testRequestResource() {
        // Create a sample input DTO
        RequestResourceInDTO requestResourceDto = new RequestResourceInDTO();
        requestResourceDto.setComment("Test Comment");
        requestResourceDto.setManagerId(1L);
        requestResourceDto.setEmployeeId(2L);
        requestResourceDto.setProjectId(3L);

        // Create a sample RequestResource entity
        RequestResource requestResource = new RequestResource();
        requestResource.setComment("Test Comment");
        requestResource.setManagerId(1L);
        requestResource.setEmployeeId(2L);
        requestResource.setProjectId(3L);

        // Mock the repository's save method to return the sample entity
        when(requestRepository.save(any(RequestResource.class))).thenReturn(requestResource);

        // Call the service method
        ApiResponseDTO response = employeeService.requestResource(requestResourceDto);

        // Verify that the repository's save method was called once with the correct entity
        verify(requestRepository, times(1)).save(any(RequestResource.class));

        // Verify the response message
        assertEquals("Resource added.", response.getMessage());
    }

    @Test
    public void testDtoToRequestResource() {
        // Create a sample input DTO
        RequestResourceInDTO requestResourceDto = new RequestResourceInDTO();
        requestResourceDto.setComment("Test Comment");
        requestResourceDto.setManagerId(1L);
        requestResourceDto.setEmployeeId(2L);
        requestResourceDto.setProjectId(3L);

        // Call the method to convert DTO to entity
        RequestResource requestResource = employeeService.dtoToRequestResource(requestResourceDto);

        // Verify that the entity fields match the DTO
        assertEquals("Test Comment", requestResource.getComment());
        assertEquals(1L, requestResource.getManagerId());
        assertEquals(2L, requestResource.getEmployeeId());
        assertEquals(3L, requestResource.getProjectId());
    }
    @Test
    public void testGetEmployeeById() {
        List<String> skills= new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setEmpId("N1001");
        employee.setName("Anjali Sharma");
        employee.setEmail("anjali.sharma@nucleusteq.com");
        employee.setDob("2001-09-07");
        employee.setDoj("2023-07-17");
        employee.setLocation(Location.Indore);
        employee.setDesignation(Designation.Engineer);
        employee.setContactNumber("1234567800");
        employee.setRole(Role.EMPLOYEE);
        employee.setSkills(skills);
        employee.setManagerId((long)2);
        employee.setPassword("admin123");
        employee.setProjectId(0L);
        
        EmployeeOutDTO empDTO= new EmployeeOutDTO();
        empDTO.setId(1L);
        empDTO.setEmpId("N1001");
        empDTO.setName("Anjali Sharma");
        empDTO.setEmail("anjali.sharma@nucleusteq.com");
        empDTO.setDob("2001-09-07");
        empDTO.setDoj("2023-07-17");
        empDTO.setLocation(Location.Indore);
        empDTO.setDesignation(Designation.Engineer);
        empDTO.setContactNumber("1234567800");
        empDTO.setRole(Role.EMPLOYEE);
        empDTO.setSkills(skills);
        empDTO.setManagerId(2L);
        empDTO.setManager("Vanshika Sharma");
        empDTO.setProjectName("Fyndr");
        empDTO.setProjectId(0L);
        
        when(userRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        when(modelMapper.map(employee, EmployeeOutDTO.class)).thenReturn(empDTO);
        
        Employee manager= new Employee();
        manager.setId(2L);
        manager.setEmpId("N1002");
        manager.setName("Vanshika Sharma");
        manager.setEmail("vanshika.sharma@nucleusteq.com");
        manager.setDob("2001-09-07");
        manager.setDoj("2023-07-17");
        manager.setLocation(Location.Canada);
        manager.setDesignation(Designation.Engineer);
        manager.setContactNumber("1234567809");
        manager.setRole(Role.MANAGER);
        manager.setSkills(skills);
        manager.setManagerId(1L);
        manager.setPassword("van12345");
        manager.setProjectId(1L);
        when(userRepository.findById(employee.getManagerId())).thenReturn(Optional.of(manager));
        
        
        Project project = new Project();
        skills.add("React");
        skills.add("Java");
        project.setProjectId(1L);
        

        when(projectRepository.findById(project.getProjectId())).thenReturn(Optional.of(project));
        project.setName("Fyndr");
        project.setManagerId(1L);
        project.setStartDate("2023-09-07");
        project.setDescription("Description");
        project.setSkills(skills);
        EmployeeOutDTO result = employeeService.getEmployeeById(project.getProjectId());
        assertEquals(empDTO, result);
        
        
     }
    @Test
    public void testListEmployeeByRole() {
        List<String> skills= new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setEmpId("N1001");
        employee.setName("Anjali Sharma");
        employee.setEmail("anjali.sharma@nucleusteq.com");
        employee.setDob("2001-09-07");
        employee.setDoj("2023-07-17");
        employee.setLocation(Location.Indore);
        employee.setDesignation(Designation.Engineer);
        employee.setContactNumber("1234567800");
        employee.setRole(Role.EMPLOYEE);
        employee.setSkills(skills);
        employee.setManagerId((long)2);
        employee.setPassword("admin123");
        employee.setProjectId(0L);
    List<Employee> empList = new ArrayList<Employee>();
    empList.add(employee);
    when(userRepository.findByRole(Role.EMPLOYEE)).thenReturn(empList);

    EmployeeOutDTO empDTO= new EmployeeOutDTO();
    empDTO.setId(1L);
    empDTO.setEmpId("N1001");
    empDTO.setName("Anjali Sharma");
    empDTO.setEmail("anjali.sharma@nucleusteq.com");
    empDTO.setDob("2001-09-07");
    empDTO.setDoj("2023-07-17");
    empDTO.setLocation(Location.Raipur);
    empDTO.setDesignation(Designation.Engineer);
    empDTO.setContactNumber("1234567800");
    empDTO.setRole(Role.EMPLOYEE);
    empDTO.setSkills(skills);
    empDTO.setManagerId(2L);
    empDTO.setManager("Vanshika Sharma");
    empDTO.setProjectName("Fyndr");
    empDTO.setProjectId(1L);

    List<EmployeeOutDTO>empOutList = new ArrayList<EmployeeOutDTO>();
    empOutList.add(empDTO);
    Project prj = new Project();
    skills.add("React");
    skills.add("Java");
    prj.setProjectId(1L);
    prj.setName("Fyndr");
    prj.setManagerId(1L);
    prj.setStartDate("2023-09-07");
    prj.setDescription("Description");
    prj.setSkills(skills);

    when(projectRepository.findById(prj.getProjectId())).thenReturn(Optional.of(prj));
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
    when(userRepository.findById(employee.getManagerId())).thenReturn(Optional.of(manager));
    empOutList.add(empDTO);

    List<EmployeeOutDTO> result = employeeService.getEmployeeByRole(Role.EMPLOYEE);
    assertEquals(1, result.size());

    List<Employee> list2 = new ArrayList<>();
    when(userRepository.findByRole(Role.EMPLOYEE)).thenReturn(list2);

    }
    @Test
    public void testAssignProject() {
        List<String> skills= new ArrayList<>();
        skills.add("Java");
        skills.add("React");
        Employee employee= new Employee();
        employee.setId(1L);
        employee.setEmpId("N1001");
        employee.setName("Anjali Sharma");
        employee.setEmail("anjali.sharma@nucleusteq.com");
        employee.setDob("2001-09-07");
        employee.setDoj("2023-07-17");
        employee.setLocation(Location.Raipur);
        employee.setDesignation(Designation.Engineer);
        employee.setContactNumber("1234567800");
        employee.setRole(Role.EMPLOYEE);
        employee.setSkills(skills);
        employee.setManagerId(1L);
        employee.setPassword("admin123");
        employee.setProjectId(1L);
        when(userRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        when(userRepository.save(employee)).thenReturn(employee);
        Map<String ,Long> map = new HashMap<>();
        map.put("projectId", employee.getProjectId());
        map.put("managerId", employee.getManagerId());
        
        RequestResource request = new RequestResource();
        request.setEmployeeId(1L);
        request.setComment("Comments");
        request.setResourceId(1L);
        request.setManagerId(1L);
        request.setProjectId(1L);
        
        List<RequestResource> reqList = new ArrayList<>();
        ResponseDTO response = new ResponseDTO();
        response.setMessage("Request Deleted");
        reqList.add(request);
        when(requestService.rejectRequest(request.getResourceId())).thenReturn(response);
        when(requestRepository.findByEmployeeId(employee.getId())).thenReturn(reqList);
        ApiResponseDTO result = employeeService.updatedProject(employee.getId(), employee.getProjectId(),employee.getManagerId());
        assertEquals("Updated Suceesfully",result.getMessage());
        
    }
    @Test
    public void testUpdateSkills() {
        List<String> skills= new ArrayList<>();
        skills.add("React");
        skills.add("Java");
        Employee emp= new Employee();
        emp.setId(1L);
       emp.setSkills(skills);
       when(userRepository.findById(emp.getId())).thenReturn(Optional.of(emp));
       when(userRepository.save(emp)).thenReturn(emp);
       
       ApiResponseDTO result = employeeService.updateSkills(emp.getId(), emp.getSkills());
       assertEquals("Updated Skills",result.getMessage());
    }
    @Test
    public void testGetAllRequests() {
        // Arrange
        List<RequestResource> mockRequestResourceList = new ArrayList<>();
        RequestResource request = new RequestResource();
        request.setComment("Comment1");
        request.setEmployeeId(1L);
        request.setManagerId(1L);
        request.setResourceId(1L);
        request.setProjectId(1L);
        mockRequestResourceList.add(request);
        // Add more mock RequestResource objects as needed

        // Mock the behavior of requestResourceRepository
        when(requestRepository.findAll()).thenReturn(mockRequestResourceList);
        // Act
        List<RequestResourceOutDTO> result = requestService.getAllRequests();

        // Assert
        assertEquals(mockRequestResourceList.size(), result.size());
        // You can add more specific assertions based on your actual requirements
    }
 }
