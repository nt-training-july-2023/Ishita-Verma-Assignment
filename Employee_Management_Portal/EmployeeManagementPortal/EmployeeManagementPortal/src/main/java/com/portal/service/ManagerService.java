package com.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.RequestResourceDTO;
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
    @Autowired
    private ApiResponseDTO response;

//}
    /**
     * 
     */
    public ApiResponseDTO addRequestResource(final RequestResourceDTO requestDTO) {
        // TODO Auto-generated method stub
        RequestResource request = dtoToRequestResource(requestDTO);
        requestRepository.save(request);
        response.setMessage("Sucessfully Added");
        return response;
    }
    /**
     * dtoToRequestResource.
     */
    public final RequestResource dtoToRequestResource (final RequestResourceDTO requestDTO) {
        RequestResource request = new RequestResource();
        request.setEmployeeId(requestDTO.getEmployeeId());
        request.setComment(requestDTO.getComment());
        request.setManagerId(requestDTO.getManagerId());
        request.setProjectId(requestDTO.getProjectId());
        return request;
    }
    /***/
}
