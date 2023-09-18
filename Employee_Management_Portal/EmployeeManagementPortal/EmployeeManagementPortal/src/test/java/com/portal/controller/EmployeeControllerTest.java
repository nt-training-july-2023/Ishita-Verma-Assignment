package com.portal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.EmployeeOutDTO;
import com.portal.entities.Employee;
import com.portal.entities.Role;
import com.portal.repository.AdminRepository;
import com.portal.service.EmployeeService;

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

	@Test
	void testSaveEmployee() {
	    // Create a mock AdminDTO and ApiResponseDTO
	    AdminDTO adminDTO = new AdminDTO();
	    adminDTO.setName("John Doe");
	    ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
	    apiResponseDTO.setMessage("Employee added successfully");

	    // Mock the behavior of the EmployeeService
	    when(employeeService.addEmployee(any(AdminDTO.class))).thenReturn(apiResponseDTO);

	    // Perform the controller action
	    ApiResponseDTO result = employeeController.saveEmployee(adminDTO);

	    // Verify the result
	    assertEquals(apiResponseDTO.getMessage(), result.getMessage());
	}

	@Test
	void testGetEmployeesByRole() {
	    // Create a mock Role and list of employees
	    String roleName = "MANAGER";
	    Role role = Role.MANAGER;
	    List<Employee> employeeList = new ArrayList<>();
	    // Add some employees to the list...

	    // Mock the behavior of the AdminRepository
	    when(adminRepository.findByRole(role)).thenReturn(employeeList);

	    // Perform the controller action
	    List<Employee> result = employeeController.getEmployeesByRole(roleName);

	    // Verify the result
	    assertEquals(employeeList, result);
	}

	@Test
	void testGetEmployeeById() {
	    // Create a mock Employee and its ID
	    long employeeId = 1L;
	    Employee employee = new Employee();
	    employee.setId(employeeId);

	    // Mock the behavior of the EmployeeService
	    when(employeeService.getEmployeeById(employeeId)).thenReturn(Optional.of(employee));

	    // Perform the controller action
	    Optional<Employee> result = employeeController.getEmployeeById(employeeId);

	    // Verify the result
	    assertTrue(result.isPresent());
	    assertEquals(employeeId, result.get().getId());
	}

	@Test
	void testGetEmployeeByEmail() {
	    // Create a mock email and EmployeeOutDTO
	    String email = "john.doe@example.com";
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

}
