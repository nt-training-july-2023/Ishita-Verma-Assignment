package com.portal.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.EmployeeInDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;
import com.portal.service.EmployeeService;
import com.portal.validation.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(EmployeeController.class)

public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private Validation validate;

    @Autowired
    private ObjectMapper objectMapper;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveEmployee() throws Exception {
        // Create an example EmployeeInDTO
        EmployeeInDTO employeeDTO = new EmployeeInDTO();
        employeeDTO.setName("Ankita Sharma");
      employeeDTO.setEmail("ankita.sharma@nucleusteq.com");
      employeeDTO.setContactNumber("1234567890");
      employeeDTO.setDesignation(Designation.Engineer);
      employeeDTO.setDob("2001-02-26");
      employeeDTO.setDoj("2020-09-01");
      employeeDTO.setEmpId("N1111");
      employeeDTO.setId(1L);
      employeeDTO.setLocation(Location.Raipur);
      employeeDTO.setManager("Rashmi");
      employeeDTO.setManagerId(2L);
      employeeDTO.setPassword("Ankita123@");
      employeeDTO.setProject("Fyndr");
      employeeDTO.setProjectId(1L);
      employeeDTO.setRole(Role.ADMIN);
      List<String> skills = new ArrayList<>();
      skills.add("Skill1");
      skills.add("Skill2");
      employeeDTO.setSkills(skills);
       
        // Create a mock response from the service
        ApiResponseDTO response = new ApiResponseDTO();
        response.setMessage("Employee added successfully");

        // Mock the service behavior
        doNothing().when(validate).checkEmployee(employeeDTO);
        when(employeeService.addEmployee(employeeDTO)).thenReturn(response);

        // Perform the HTTP request and validate the response
        mockMvc.perform(post("/addEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employeeDTO)))
                .andExpect(status().isOk()); // Expect HTTP status 200
    }
    @Test
    void testGetEmployeesByRole() throws Exception {
        List<EmployeeOutDTO>  empDtoList = new ArrayList<>();
        List<String> skills = new ArrayList<>();
        skills.add("React");
        skills.add("Java");
        EmployeeOutDTO empDto = new EmployeeOutDTO();
        empDto.setEmpId("N0001");
        empDto.setName("Anjali Sharma");
        empDto.setEmail("anjali.sharma@nucleusteq.com");
        empDto.setDob("2001-09-07");
        empDto.setDoj("2023-07-17");
        empDto.setLocation(Location.Raipur);
        empDto.setDesignation(Designation.Engineer);
        empDto.setContactNumber("1234567890");
        empDto.setRole(Role.EMPLOYEE);
        empDto.setProjectId(0L);
        empDto.setSkills(skills);
        empDto.setManagerId(1L);
        empDto.setManager("Ankita Sharma");
        empDto.setProjectName("Fyndr");
        empDtoList.add(empDto);
        
        when(employeeService.getEmployeeByRole(Mockito.any(Role.class))).thenReturn(empDtoList);

        MvcResult mvcResult = this.mockMvc.perform(get("/all/EMPLOYEE")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    void testGetEmployeeById() throws Exception{
        List<String> skills = new ArrayList<>();
        skills.add("React");
        skills.add("Java");
        EmployeeOutDTO empDto = new EmployeeOutDTO();
        
        empDto.setEmpId("N0001");
        empDto.setName("Ankita Sharma");
        empDto.setEmail("ankita.sharma@nucleusteq.com");
        empDto.setDob("1998-08-10");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.Raipur);
        empDto.setDesignation(Designation.Engineer);
        empDto.setContactNumber("1234567890");
        empDto.setRole(Role.ADMIN);
        empDto.setProjectId(0L);
        empDto.setSkills(skills);
        empDto.setManagerId(1L);
        empDto.setManager("Ankita Sharma");
        empDto.setProjectName("Fyndr");
        empDto.setId(1L);
       
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(empDto);        
        when(employeeService.getEmployeeById(Mockito.any())).thenReturn(empDto);
        
        MvcResult mvcResult = this.mockMvc.perform(get("/all/employee/1")
                .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    public void testUpdateDetails() throws Exception {
        // Mocked input data
        Map<String, Long> updatedDetails = new HashMap<>();
        updatedDetails.put("projectId", 123L);
        updatedDetails.put("managerId", 456L);

        // Mock the service method
        ApiResponseDTO apiResponse = new ApiResponseDTO();
        apiResponse.setMessage("Updated successfully");
        when(employeeService.updatedProject(1L, 123L, 456L)).thenReturn(apiResponse);

        // Convert the input data to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(updatedDetails);

        // Perform the PUT request
        mockMvc.perform(put("/employee/assignProject/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
               
    }
    @Test
    public void testGetAllRequests() throws Exception {
        // Mocked request resources
        List<RequestResourceOutDTO> requestResources = new ArrayList<>();
        // Add some mock request resources to the list

        // Mock the service method
        when(employeeService.getAllRequests()).thenReturn(requestResources);

        // Perform the GET request
        mockMvc.perform(get("/all/request"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                
    }
    @Test
    public void testUnassignEmployee() throws Exception {
        // Employee ID for testing
        Long employeeId = 1L;

        // Mock the service method
//        doNothing().when(employeeService).unassignEmployee(employeeId);

        // Perform the POST request
        mockMvc.perform(post("/unassign/1", employeeId))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee unassigned successfully."));
    }
    
    List<String> skills = new ArrayList<>();
    
    @Test
    void testUpdateSkills() throws Exception{
        skills.add("React");
        skills.add("Java");
        ApiResponseDTO resp= new ApiResponseDTO();
        resp.setMessage("Skills Updated Successfully");
        
        EmployeeInDTO empDto = new EmployeeInDTO();
        empDto.setSkills(skills);
        
        Map<String,List<String>> map= new HashMap<String,List<String>>();
        map.put("skills",skills);
        
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(empDto);        
        when(employeeService.updateSkills(3L,skills)).thenReturn(resp);
        
        MvcResult mvcResult = this.mockMvc.perform(put("/employee/skills/1")
                .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
