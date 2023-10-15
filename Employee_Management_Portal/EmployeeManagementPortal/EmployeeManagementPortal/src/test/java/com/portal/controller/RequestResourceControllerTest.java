package com.portal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.RequestResourceInDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.DTO.RequestedDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.service.RequestResourceService;
import com.portal.validation.RequestResourceValidation;
@WebMvcTest(RequestResourceController.class)
class RequestResourceControllerTest {
    @Autowired
    private MockMvc mockMvc;
  
    @MockBean
    private RequestResourceService requestService;
    
    @MockBean
    private RequestResourceValidation validate;

    @InjectMocks
    private RequestResourceController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    public void testGetAllRequests() throws Exception {
        List<RequestResourceOutDTO> requestList = new ArrayList<>();
        RequestResourceOutDTO request1 = new RequestResourceOutDTO();
        request1.setId(1L);
        request1.setComment("Request 1");
        request1.setEmpId(1L);
        request1.setEmployeeName("Ankita");
        request1.setEmpUserId("N1111");
        request1.setManagerId(2L);
        request1.setManagerName("Rashmi");
        request1.setManagerUserId("N1112");
        request1.setProjectId(3L);
        request1.setProjectName("Fyndr");
        requestList.add(request1);

        when(requestService.getAllRequests()).thenReturn(requestList);


        MvcResult mvcResult = this.mockMvc.perform(get("/requests")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

      
        String content = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<RequestResourceOutDTO> responseList = objectMapper.readValue(content, new TypeReference<List<RequestResourceOutDTO>>() {});
        assertEquals(requestList.size(), responseList.size());
      
    }

    @Test
    public void testAddRequestResource() throws Exception {
        RequestResourceInDTO requestDTO = new RequestResourceInDTO();
        requestDTO.setManagerId(1L);
        requestDTO.setComment("New Request");
        requestDTO.setEmployeeId(1l);
        requestDTO.setProjectId(2L);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(requestDTO);

        ApiResponseDTO responseDTO = new ApiResponseDTO();
        responseDTO.setMessage("Request added successfully");
        when(requestService.addRequestResource(requestDTO)).thenReturn(responseDTO);

        MvcResult mvcResult = this.mockMvc.perform(post("/request/resource")
                .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        ApiResponseDTO response = objectMapper.readValue(content, ApiResponseDTO.class);
        assertEquals("Request added successfully", response.getMessage());
    }
    @Test
    public void testRejectRequest() throws Exception {
        Long requestId = 1L;
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Request rejected successfully");

        when(requestService.rejectRequest(requestId)).thenReturn(responseDTO);

        MvcResult mvcResult = this.mockMvc.perform(delete("/manager/request/delete/{id}", requestId)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseDTO response = objectMapper.readValue(content, ResponseDTO.class);
        assertEquals("Request rejected successfully", response.getMessage());
    }
    @Test
    public void testAcceptRequest() throws Exception {
        Long requestId = 1L;
        ApiResponseDTO responseDTO = new ApiResponseDTO();
        responseDTO.setMessage("Request accepted successfully");

        when(requestService.acceptRequest(requestId)).thenReturn(responseDTO);

        MvcResult mvcResult = this.mockMvc.perform(post("/manager/request/{id}", requestId)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponseDTO response = objectMapper.readValue(content, ApiResponseDTO.class);
        assertEquals("Request accepted successfully", response.getMessage());
    }
    @Test
    public void testIsRequested() throws Exception {
        Long empId = 1L;
        Long managerId = 2L;
        
        when(requestService.isRequested(empId, managerId)).thenReturn(true);
        mockMvc.perform(get("/employee/isRequested")
                .param("empId", empId.toString())
                .param("managerId", managerId.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
