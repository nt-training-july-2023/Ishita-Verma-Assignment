package com.portal.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portal.DTO.RequestResourceInDTO;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.repository.RequestResourceRepository;

/**
 * Request Resource Validation.
 */
@Component
public class RequestResourceValidation {
    /**
     * Request Resource repository.
     */
    @Autowired
    private RequestResourceRepository requestResourceRepository;
    /**
     * User Repository.
     */
    @Autowired
    private AdminRepository userRepository;
    /**
     * project Repository.
     */
    @Autowired
    private ProjectRepository projectRepository;
    /**
     * check request.
     * @param requestResourceDto request
     */
    public void checkRequest(final RequestResourceInDTO requestResourceDto) {
         userRepository
                .findById(requestResourceDto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "This employee does not exist"));
        userRepository
                .findById(requestResourceDto.getManagerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "This manager does not exist."));
        projectRepository
                .findByProjectId(requestResourceDto.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "This project does not exist."));
    }
    public void validateResourceIdExists(Long id) {
        if (!requestResourceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource with ID " + id + " not found.");
        }
    }
}