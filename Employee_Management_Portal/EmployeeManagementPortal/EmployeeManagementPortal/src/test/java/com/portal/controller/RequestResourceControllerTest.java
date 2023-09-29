package com.portal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
@WebMvcTest(RequestResourceController.class)
class RequestResourceControllerTest {
    @Autowired
    private MockMvc mockMvc;
  
    @MockBean
    private RequestResourceService requestService;

    @InjectMocks
    private RequestResourceController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    public void testGetAllRequests() throws Exception {
        // Prepare a list of RequestResourceOutDTO for testing
        List<RequestResourceOutDTO> requestList = new ArrayList<>();
        // Add request resource data to the list (you can add as many as needed for testing)
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

        // Mock the behavior of the requestService to return the list
        when(requestService.getAllRequests()).thenReturn(requestList);

        // Perform a GET request to the /requests endpoint
        MvcResult mvcResult = this.mockMvc.perform(get("/requests")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Verify the HTTP status code (200 OK)
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        // Verify the response content (JSON array containing request resource data)
        String content = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<RequestResourceOutDTO> responseList = objectMapper.readValue(content, new TypeReference<List<RequestResourceOutDTO>>() {});
        assertEquals(requestList.size(), responseList.size());
        // You can further validate individual request resource details if needed.
    }

    @Test
    public void testAddRequestResource() throws Exception {
        // Prepare a RequestResourceInDTO for testing
        RequestResourceInDTO requestDTO = new RequestResourceInDTO();
        requestDTO.setManagerId(1L);
        requestDTO.setComment("New Request");
        requestDTO.setEmployeeId(1l);
        requestDTO.setProjectId(2L);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(requestDTO);

        // Mock the behavior of the requestService to return a response DTO
        ApiResponseDTO responseDTO = new ApiResponseDTO();
        responseDTO.setMessage("Request added successfully");
        when(requestService.addRequestResource(requestDTO)).thenReturn(responseDTO);

        // Perform a POST request to the /request/resource endpoint
        MvcResult mvcResult = this.mockMvc.perform(post("/request/resource")
                .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();

        // Verify the HTTP status code (200 OK)
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        // Verify the response content (API response DTO)
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
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Request accepted successfully");

        when(requestService.acceptRequest(requestId)).thenReturn(responseDTO);

        MvcResult mvcResult = this.mockMvc.perform(post("/manager/request/{id}", requestId)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseDTO response = objectMapper.readValue(content, ResponseDTO.class);
        assertEquals("Request accepted successfully", response.getMessage());
    }
    @Test
    public void testIsRequested() throws Exception {
        RequestedDTO reqDto = new RequestedDTO();
        reqDto.setEmployeeId(1L);
        reqDto.setManagerEmail("rashmi@nucleusteq.com");
        ;

        when(requestService.isRequested(reqDto)).thenReturn(true);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(reqDto);

        MvcResult mvcResult = this.mockMvc.perform(post("/employee/isRequested")
                .contentType(MediaType.APPLICATION_JSON).content(inputJSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        boolean response = Boolean.parseBoolean(mvcResult.getResponse().getContentAsString());
        assertTrue(response);
    }
}
