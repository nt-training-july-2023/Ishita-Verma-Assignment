package com.portal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.DTO.EmployeeInDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.LoginInDTO;
import com.portal.DTO.LoginOutDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.entities.Designation;
import com.portal.entities.Location;
import com.portal.entities.Role;
import com.portal.exceptions.DuplicateEntryException;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.service.AdminService;
import com.portal.validation.Validation;

@WebMvcTest(AdminController.class)
class AdminControllerTest {
    @Autowired
    private MockMvc mockMvc;
  
    @MockBean
    private AdminService adminService;

    @MockBean
    private Validation validate;

    @InjectMocks
    private AdminController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
    List<String> skills = new ArrayList<>();
    @Test
    public void testLogin() throws Exception {
        LoginInDTO loginDto = new LoginInDTO();
        loginDto.setEmail("ankita.sharma@nucleusteq.com");
        loginDto.setPassword("Admin123@");
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(loginDto);
        LoginOutDTO response = new LoginOutDTO();
        response.setMessage("Login Successful");
        response.setName("Ankita Sharma");
        response.setRole(Role.ADMIN);
        response.setId(1L);
        doNothing().when(validate).checkLogin(loginDto);
        when(adminService.login(Mockito.any())).thenReturn(response);

        MvcResult mvcResult = this.mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testLoginEmailException() throws Exception {
        LoginInDTO loginDto = new LoginInDTO();
        loginDto.setEmail("ankita@nucleusteq.com");
        loginDto.setPassword("admin123");
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(loginDto);
        doThrow(ResourceNotFoundException.class).when(validate)
                .checkLogin(loginDto);
        MvcResult mvcResult = this.mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);

    }
    @Test
    public void testAddAdmin()throws Exception{
        EmployeeInDTO empDto =  new EmployeeInDTO();
        skills.add("React");
        skills.add("Java");
        empDto.setEmpId("N0001");
        empDto.setName("Ankita Sharma");
        empDto.setEmail("ankita.sharma@nucleusteq.com");
        empDto.setDob("1998-08-10");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.Raipur);
        empDto.setDesignation(Designation.Engineer);
        empDto.setContactNumber("1234567890");
        empDto.setPassword("admin123");
        empDto.setRole(Role.ADMIN);
        empDto.setProjectId(0L);
        empDto.setSkills(skills);
        empDto.setManagerId(1L);
        
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(empDto);
        ResponseDTO response = new ResponseDTO();
        response.setMessage("Admin added succesfully");
        doNothing().when(validate).checkAdmin(empDto);
        when(adminService.registerAdmin(Mockito.any())).thenReturn(response);

        MvcResult mvcResult = this.mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        
    }
    @Test
    public void testAdminEmailException() throws Exception{
        EmployeeInDTO empDto =  new EmployeeInDTO();
        skills.add("React");
        skills.add("Java");
        empDto.setEmpId("N0001");
        empDto.setName("Ankita Sharma");
        empDto.setEmail("ankita.sharma@nucleusteq.com");
        empDto.setDob("1998-08-10");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.Raipur);
        empDto.setDesignation(Designation.Engineer);
        empDto.setContactNumber("1234567890");
        empDto.setPassword("admin123");
        empDto.setRole(Role.ADMIN);
        empDto.setProjectId(0L);
        empDto.setSkills(skills);
        empDto.setManagerId(1L);
        
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(empDto);
        doThrow(DuplicateEntryException.class).when(validate)
                .checkAdmin(empDto);
        MvcResult mvcResult = this.mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(409, status);
    }

    @Test
    public void testAdminEmpIdException() throws Exception{
        EmployeeInDTO empDto =  new EmployeeInDTO();
        skills.add("React");
        skills.add("Java");
        empDto.setEmpId("N0001");
        empDto.setName("Ankita Sharma");
        empDto.setEmail("ankita.sharma@nucleusteq.com");
        empDto.setDob("1998-08-10");
        empDto.setDoj("2019-11-21");
        empDto.setLocation(Location.Raipur);
        empDto.setDesignation(Designation.Engineer);
        empDto.setContactNumber("1234567890");
        empDto.setPassword("admin123");
        empDto.setRole(Role.ADMIN);
        empDto.setProjectId(0L);
        empDto.setSkills(skills);
        empDto.setManagerId(1L);
        
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(empDto);
        doThrow(DuplicateEntryException.class).when(validate)
                .checkAdmin(empDto);
        MvcResult mvcResult = this.mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(409, status);
    }
    
    @Test
    public void testGetAllAdmin() throws Exception {
        List<EmployeeOutDTO> adminList = new ArrayList<>();
        EmployeeOutDTO admin1 = new EmployeeOutDTO();
        admin1.setEmpId("N0001");
        admin1.setName("Admin1");
        admin1.setEmail("admin1@example.com");
        admin1.setRole(Role.ADMIN);
        adminList.add(admin1);
        when(adminService.getAllAdmin()).thenReturn(adminList);

        MvcResult mvcResult = this.mockMvc.perform(get("/getall")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<EmployeeOutDTO> responseList = objectMapper
                .readValue(content, new TypeReference<List<EmployeeOutDTO>>() {});
        assertEquals(adminList.size(), responseList.size());
        
    }
}
