package com.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.RequestResourceDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.DTO.ResponseAllRequestDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.RequestResource;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.repository.RequestResourceRepository;

@Service
public class ManagerService {
	  /**
     * User Repository.
     */
    @Autowired
    private AdminRepository userRepository;
    /**
     * User Repository.
     */
    @Autowired
    private ProjectRepository projectRepository;
    /***/
    @Autowired
    private RequestResourceRepository requestRepository;
    /**
     * Used to get all request present in the table.
     *
     * @return Return list of reqeuests.
     */
    

//}
    /**
     * 
     */
    public ApiResponseDTO addRequestResource(final RequestResourceDTO requestDTO) {
        // TODO Auto-generated method stub
        RequestResource request = dtoToRequestResource(requestDTO);
        requestRepository.save(request);
        ApiResponseDTO response = new ApiResponseDTO(
                "Sucessfully Added");
        return response;
    }
    /**
     * dtoToRequestResource.
     */
    public final RequestResource dtoToRequestResource (final RequestResourceDTO requestDTO) {
        RequestResource request = new RequestResource();
        request.setComment(requestDTO.getComment());
        request.setEmpId(requestDTO.getEmpId());
        request.setManagerId(requestDTO.getManagerId());
        request.setProjectId(requestDTO.getProjectId());
        return request;
    }
    /***/
}
