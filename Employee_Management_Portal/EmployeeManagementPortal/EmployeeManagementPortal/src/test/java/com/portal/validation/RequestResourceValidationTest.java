package com.portal.validation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.portal.DTO.RequestResourceInDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.RequestResource;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.repository.RequestResourceRepository;
import com.portal.validation.RequestResourceValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class RequestResourceValidationTest {

    @InjectMocks
    private RequestResourceValidation validation;
    
    @Mock
    private RequestResourceRepository requestRepository;
    
    @Mock
    private AdminRepository userRepository;
    
    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCheckRequestEmployeeId() {
        RequestResourceInDTO request = new RequestResourceInDTO();
        request.setEmployeeId(0L);
        request.setManagerId(1L);
        request.setProjectId(2L);
        request.setComment("Comments");

        when(userRepository.findById(request.getEmployeeId())).thenReturn(Optional.empty());
        when(userRepository.findById(request.getManagerId())).thenReturn(Optional.of(new Employee()));
        when(projectRepository.findByProjectId(request.getProjectId())).thenReturn(Optional.of(new Project()));

        assertThrows(ResourceNotFoundException.class, () -> {
            validation.checkRequest(request);
        });
    }

    @Test
    void testCheckRequestManagerId() {
        RequestResourceInDTO request = new RequestResourceInDTO();
        request.setEmployeeId(0L);
        request.setManagerId(1L);
        request.setProjectId(2L);
        request.setComment("Comments");

        when(userRepository.findById(request.getEmployeeId())).thenReturn(Optional.of(new Employee()));
        when(userRepository.findById(request.getManagerId())).thenReturn(Optional.empty());
        when(projectRepository.findByProjectId(request.getProjectId())).thenReturn(Optional.of(new Project()));

        assertThrows(ResourceNotFoundException.class, () -> {
            validation.checkRequest(request);
        });
    }

    @Test
    void testCheckRequestProjectId() {
        RequestResourceInDTO request = new RequestResourceInDTO();
        request.setEmployeeId(0L);
        request.setManagerId(1L);
        request.setProjectId(2L);
        request.setComment("Comments");

        when(userRepository.findById(request.getEmployeeId())).thenReturn(Optional.of(new Employee()));
        when(userRepository.findById(request.getManagerId())).thenReturn(Optional.of(new Employee()));
        when(projectRepository.findByProjectId(request.getProjectId())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            validation.checkRequest(request);
        });
    }
    @Test
    void testValidateResourceIdExists() {
        Long resourceId = 123L; // Replace with a valid resource ID

        when(requestRepository.existsById(resourceId)).thenReturn(true);

        assertDoesNotThrow(() -> {
            validation.validateResourceIdExists(resourceId);
        });

        // Verify that the existsById method was called with the correct ID
        verify(requestRepository).existsById(resourceId);
    }

    @Test
    void testValidateResourceIdDoesNotExist() {
        Long resourceId = 456L; // Replace with a non-existent resource ID

        when(requestRepository.existsById(resourceId)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            validation.validateResourceIdExists(resourceId);
        });

        // Verify that the existsById method was called with the correct ID
        verify(requestRepository).existsById(resourceId);
    }



}

