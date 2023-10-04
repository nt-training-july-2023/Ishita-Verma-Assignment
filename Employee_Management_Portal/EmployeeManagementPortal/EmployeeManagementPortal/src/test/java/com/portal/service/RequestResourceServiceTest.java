package com.portal.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.RequestResourceInDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.DTO.RequestedDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.RequestResource;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.repository.RequestResourceRepository;

class RequestResourceServiceTest {
    @InjectMocks
    private RequestResourceService requestService;

    @Mock
    private RequestResourceRepository requestRepository;
    
    @Mock
    private ProjectRepository projectRepository;
    
    @Mock
    private AdminRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testAddRequestResource() {
        RequestResourceInDTO requestDTO = new RequestResourceInDTO();
        requestDTO.setComment("Test Comment");
        requestDTO.setEmployeeId(1L);
        requestDTO.setManagerId(2L);
        requestDTO.setProjectId(3L);

        when(requestRepository.save(any(RequestResource.class))).thenReturn(new RequestResource());
        ApiResponseDTO ResponseDTO = requestService.addRequestResource(requestDTO);

        assertNotNull(ResponseDTO);
        assertEquals("Resource added.", ResponseDTO.getMessage());
    }
    @Test
    public void testGetAllRequestResource() {
        // Create a sample request
        RequestResource request = new RequestResource();
        request.setComment("Test Comment");
        request.setEmployeeId(1L);
        request.setManagerId(2L);
        request.setProjectId(3L);

        // Create a list of requests
        List<RequestResource> requestList = new ArrayList<>();
        requestList.add(request);

        // Mock the behavior of your repositories
        when(requestRepository.findAll()).thenReturn(requestList);
        when(userRepository.findById(1L)).thenReturn(Optional.of(new Employee()));
        when(userRepository.findById(2L)).thenReturn(Optional.of(new Employee()));
        when(projectRepository.findById(3L)).thenReturn(Optional.of(new Project()));

        // Call the service method
        List<RequestResourceOutDTO> requestOutList = requestService.getAllRequests();

        // Assert the results
        assertNotNull(requestOutList);
        assertEquals(1, requestOutList.size());

        RequestResourceOutDTO resultDTO = requestOutList.get(0);
        assertEquals("Test Comment", resultDTO.getComment());
        assertEquals(1L, resultDTO.getEmpId());
    }
    @Test
    void testAcceptRequest() {
        // Create a response DTO for simulating the response
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setMessage("Request Deleted");

        // Create a RequestResource
        RequestResource req = new RequestResource();
        req.setResourceId(1L);
        req.setManagerId(1L);
        req.setProjectId(1L);
        req.setEmployeeId(1L);

        // Mock the behavior of your repositories as needed
        when(requestRepository.findById(req.getResourceId())).thenReturn(Optional.of(req));

        // Create an Employee for the request
        Employee emp = new Employee();
        emp.setId(1L);

        // Mock the behavior for retrieving the Employee
        when(userRepository.findById(req.getEmployeeId())).thenReturn(Optional.of(emp));

        // Set the Employee's project and manager IDs as needed
        emp.setProjectId(req.getProjectId());
        emp.setManagerId(req.getManagerId());

        // Mock the behavior when saving the Employee
        when(userRepository.save(emp)).thenReturn(emp);

        // First, reject the request (as you mentioned)
        assertDoesNotThrow(() -> requestService.rejectRequest(req.getResourceId()));

        // Now, attempt to accept the request
        ApiResponseDTO result = requestService.acceptRequest(req.getResourceId());

        // Assert that the response message is as expected
        assertEquals("Request Accepted", result.getMessage());
    }


    @Test
    void testRejectRequest() {
        ResponseDTO resp = new ResponseDTO();
        resp.setMessage("Request Deleted");
        
        RequestResource req = new RequestResource();
        req.setResourceId(1l);
        req.setEmployeeId(1l);
        req.setManagerId(1l);
        req.setProjectId(1l);
        req.setComment("Comments");
        when(requestRepository.findById(req.getResourceId())).thenReturn(Optional.of(req));
        assertDoesNotThrow(() -> requestService.rejectRequest(req.getResourceId()));
        ResponseDTO result = requestService.rejectRequest(req.getResourceId());
        assertEquals(resp.getMessage(), result.getMessage());
    }
    @Test
    void testRequestOut() {
        RequestResource req = new RequestResource();
        req.setResourceId(1l);
        req.setEmployeeId(1l);
        req.setManagerId(1l);
        req.setProjectId(1l);
        req.setComment("Comments");
        List<RequestResource> reqList = new ArrayList<>();
        reqList.add(req);
        when(requestRepository.findAll()).thenReturn(reqList);
        RequestResourceOutDTO reqOutDto = new RequestResourceOutDTO();
        reqOutDto.setId(req.getResourceId());
        reqOutDto.setComment(req.getComment());
        
        Employee emp= new Employee();
        emp.setName("Anjali Sharma");
        emp.setEmpId("N1001");
        emp.setId(1l);
        emp.setProjectId(1l);
        
        when(userRepository.findById(req.getResourceId())).thenReturn(Optional.of(emp));
        reqOutDto.setEmployeeName(emp.getEmpId() + "-" + emp.getName());
        
        Employee manager= new Employee();
        manager.setId(1l);
        manager.setName("Anjali Sharma");
        when(userRepository.findById(req.getManagerId())).thenReturn(Optional.of(manager));
        reqOutDto.setManagerName(manager.getName());
        
        Project project = new Project();
        project.setProjectId(1l);
        project.setManagerId(1l);
        project.setName("Fynder");
        when(projectRepository.findById(req.getProjectId())).thenReturn(Optional.of(project));
        reqOutDto.setProjectName(project.getName());
        
        List<RequestResourceOutDTO> reqOutList = new ArrayList<>();
        reqOutList.add(reqOutDto);
        
        List<RequestResourceOutDTO> result = requestService.requestOut();
        assertEquals(reqOutList.size(),result.size());
        
    }
    @Test
    void testIsRequested() {
        // Create a test RequestedDTO
        Long empId = 1L;
        Long managerId = 2L;

        // Create a test Employee
        Employee manager = new Employee();
        manager.setId(managerId);
        manager.setEmail("manager@example.com");

        // Mock userRepository.findByEmail to return the manager
        when(userRepository.findByEmail(manager.getEmail())).thenReturn(Optional.of(manager));

        // Create a test RequestResource
        RequestResource req = new RequestResource();
        req.setResourceId(1L);
        req.setEmployeeId(empId);
        req.setManagerId(managerId);

        // Mock requestRepository.findByEmployeeIdAndManagerId to return the request
        when(requestRepository.findByEmployeeIdAndManagerId(empId, managerId)).thenReturn(Optional.of(req));

        // Test when a request exists
        boolean result = requestService.isRequested(empId, managerId);
        assertEquals(true, result);

        // Mock requestRepository.findByEmployeeIdAndManagerId to return an empty optional
        when(requestRepository.findByEmployeeIdAndManagerId(empId, managerId)).thenReturn(Optional.empty());

        // Test when no request exists
        result = requestService.isRequested(empId, managerId);
        assertEquals(false, result);
    }
   
}
