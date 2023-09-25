package com.portal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.entities.Designation;
import com.portal.entities.Employee;
import com.portal.entities.Location;
import com.portal.entities.Role;
import com.portal.repository.AdminRepository;
import com.portal.service.EmployeeService;
import com.portal.validation.Validation;

class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmployeeService employeeService;

	@Mock
	private AdminRepository adminRepository;

	@BeforeEach
	public void setUp() {
	    MockitoAnnotations.openMocks(this);
	}
	@Autowired
    private Validation validate;

	@Test
	void testGetEmployeeByEmail() {
	    // Create a mock email and EmployeeOutDTO
	    String email = "ankita.sharma@nucleusteq.com";
	    EmployeeOutDTO employeeOutDTO = new EmployeeOutDTO();
	    employeeOutDTO.setEmail(email);

	    // Mock the behavior of the EmployeeService
	    when(employeeService.getEmployeeByEmail(email)).thenReturn(employeeOutDTO);

	    // Perform the controller action
	    EmployeeOutDTO result = employeeController.getEmployeeByEmail(email);

	    // Verify the result
	    assertEquals(email, result.getEmail());
	}

	@Test
	void testUpdateDetails() {
	    // Create a mock employee ID, project ID, and manager ID
	    long employeeId = 1L;
	    long projectId = 2L;
	    long managerId = 3L;
	    Map<String, Long> updatedDetails = new HashMap<>();
	    updatedDetails.put("projectId", projectId);
	    updatedDetails.put("managerId", managerId);
	    ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
	    apiResponseDTO.setMessage("Details updated successfully");

	    // Mock the behavior of the EmployeeService
	    when(employeeService.updatedProject(employeeId, projectId, managerId)).thenReturn(apiResponseDTO);

	    // Perform the controller action
	    ApiResponseDTO result = employeeController.updateDetails(employeeId, updatedDetails);

	    // Verify the result
	    assertEquals(apiResponseDTO.getMessage(), result.getMessage());
	}
	
//	@Test
//    void testSaveEmployee() {
//        // Create a sample AdminDTO object
//        AdminDTO adminDTO = new AdminDTO(/* Fill adminDTO details here */);
//        
//        // Mock the behavior of employeeService.addEmployee
//        when(employeeService.addEmployee(adminDTO)).thenReturn(new ApiResponseDTO("Employee added successfully"));
//
//        // Call the controller method
//        ApiResponseDTO result = employeeController.saveEmployee(adminDTO);
//
//        // Assert the result message
//        assertEquals("Employee added successfully", result.getMessage());
//    }
	 @Test
	    void testGetEmployeesByRole() {
	        // Define a sample role name
	        String roleName = "ROLE_USER";

	        // Define a sample list of EmployeeOutDTO
	        List<String> skills = new ArrayList<>();
	        skills.add("Java");
	        skills.add("Python");
	        
	        EmployeeOutDTO employee1 = new EmployeeOutDTO(1L, "N1111", "Vanshika", "vanshika@nucleusteq.com", "1990-01-01",
	                "2020-01-01", Location.Raipur, Designation.Engineer, "1234567890", Role.ADMIN, 1001L, skills,
	                "Manager 1", 101L);

	        EmployeeOutDTO employee2 = new EmployeeOutDTO(2L, "N2222", "Pranjal", "pranjal@nucleusteq.com", "1995-02-15",
	                "2021-03-15",  Location.Raipur, Designation.Recruiter, "9876543210", Role.MANAGER, null,
	                null, "Manager 2", 102L);

	        List<EmployeeOutDTO> employeesList = new ArrayList<>();
	        employeesList.add(employee1);
	        employeesList.add(employee2);

	        // Mock the behavior of employeeService.getEmployeeByRole
	        when(employeeService.getEmployeeByRole(roleName)).thenReturn(employeesList);

	        // Call the controller method
	        List<EmployeeOutDTO> result = employeeController.getEmployeesByRole(roleName);

	        // Assert the result
	        assertEquals(employeesList, result);
	    }
	 @Test
	    void testGetEmployeeById() {
	        // Define a sample employee ID
	        long employeeId = 1L;

	        // Define a sample Employee entity
	        Employee sampleEmployee = new Employee();
	        sampleEmployee.setId(employeeId);
	        sampleEmployee.setEmpId("N1111");
	        sampleEmployee.setName("Ankita");
	        sampleEmployee.setEmail("ankita.sharma@nucleusteq.com");
	        
	        // Mock the behavior of employeeService.getEmployeeById
	        when(employeeService.getEmployeeById(employeeId)).thenReturn(Optional.of(sampleEmployee));

	        // Call the controller method
	        Optional<Employee> result = employeeController.getEmployeeById(employeeId);

	        // Assert the result
	        assertTrue(result.isPresent());
	        assertEquals(sampleEmployee, result.get());
	    }
	 @Test
	    void testUpdateSkills() {
	        // Define a sample employee ID
	        long employeeId = 1L;

	        // Define sample updated skills
	        List<String> updatedSkills = List.of("Java", "Python", "SQL");

	        // Create a sample request body
	        Map<String, List<String>> requestBody = new HashMap<>();
	        requestBody.put("skills", updatedSkills);

	        // Define a sample ApiResponseDTO
	        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
	        apiResponseDTO.setMessage("Skills updated successfully");

	        // Mock the behavior of employeeService.updateSkills
	        when(employeeService.updateSkills(employeeId, updatedSkills)).thenReturn(apiResponseDTO);

	        // Call the controller method
	        ApiResponseDTO result = employeeController.updateSkills(employeeId, requestBody);

	        // Assert the result
	        assertEquals(apiResponseDTO.getMessage(), result.getMessage());
	    }	
	 @Test
	    void testGetAllRequests() {
	        // Define a sample list of RequestResourceOutDTO
	        List<RequestResourceOutDTO> requestsList = new ArrayList<>();
	        RequestResourceOutDTO request1 = new RequestResourceOutDTO(/* Fill request details here */);
	        RequestResourceOutDTO request2 = new RequestResourceOutDTO(/* Fill request details here */);
	        requestsList.add(request1);
	        requestsList.add(request2);

	        // Mock the behavior of employeeService.getAllRequests
	        when(employeeService.getAllRequests()).thenReturn(requestsList);

	        // Call the controller method
	        List<RequestResourceOutDTO> result = employeeController.getAllRequests();

	        // Assert the result
	        assertEquals(requestsList, result);
	    }

	    @Test
	    void testUnassignEmployee() {
	        // Define a sample employee ID
	        Long employeeId = 1L;

	        // Call the controller method
	        String result = employeeController.unassignEmployee(employeeId);

	        // Assert the result
	        assertEquals("Employee unassigned successfully.", result);

	        // Verify that the employeeService.unassignEmployee method was called once with the correct argument
	        verify(employeeService, times(1)).unassignEmployee(employeeId);
	    }

	    @Test
	    void testEmpOutList() {
	        // Define sample skills and isCheck value
	        List<String> skills = Arrays.asList("Java", "Python");
	        boolean isCheck = true;

	        // Define a sample list of EmployeeOutDTO
	        List<EmployeeOutDTO> employeesList = new ArrayList<>();
	        EmployeeOutDTO employee1 = new EmployeeOutDTO(/* Fill employee details here */);
	        EmployeeOutDTO employee2 = new EmployeeOutDTO(/* Fill employee details here */);
	        employeesList.add(employee1);
	        employeesList.add(employee2);

	        // Mock the behavior of employeeService.searchBySkills
	        when(employeeService.searchBySkills(skills, isCheck)).thenReturn(employeesList);

	        // Call the controller method
	        List<EmployeeOutDTO> result = employeeController.empOutList(skills, isCheck);

	        // Assert the result
	        assertEquals(employeesList, result);
	    }
}
