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
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.EmployeeInDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.RequestResourceInDTO;
import com.portal.DTO.RequestResourceOutDTO;
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
    void testUnassignEmployee_Successful() {
        // Create a sample employee who is currently assigned to a project
        Employee sampleEmployee = new Employee();
        sampleEmployee.setId(1L);
        sampleEmployee.setProjectId(2L); // Assuming the employee is assigned to a project

        // Mock the userRepository.findById method to return the sample employee
        when(userRepository.findById(1L)).thenReturn(Optional.of(sampleEmployee));

        // Call the unassignEmployee method
        assertDoesNotThrow(() -> employeeService.unassignEmployee(1L));

        // Verify that the employee's project ID was set to 0 and userRepository.save was called
        assertEquals(0L, sampleEmployee.getProjectId());
        verify(userRepository, times(1)).save(sampleEmployee);
    }

    @Test
    void testUnassignEmployee_NotAssignedToProject() {
        // Create a sample employee who is not assigned to any project
        Employee sampleEmployee = new Employee();
        sampleEmployee.setId(1L);
        sampleEmployee.setProjectId(0L); // Employee is not assigned to any project

        // Mock the userRepository.findById method to return the sample employee
        when(userRepository.findById(1L)).thenReturn(Optional.of(sampleEmployee));

        // Call the unassignEmployee method and expect an IllegalStateException
        assertThrows(IllegalStateException.class, () -> employeeService.unassignEmployee(1L));

        // Verify that userRepository.save was not called
        verify(userRepository, never()).save(sampleEmployee);
    }

    @Test
    void testUnassignEmployee_EmployeeNotFound() {
        // Mock the userRepository.findById method to return an empty Optional (employee not found)
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Call the unassignEmployee method and expect a ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> employeeService.unassignEmployee(1L));

        // Verify that userRepository.save was not called
        verify(userRepository, never()).save(any(Employee.class));
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
    
 }
