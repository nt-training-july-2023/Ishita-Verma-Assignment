package com.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.RequestResourceInDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.RequestResource;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.repository.RequestResourceRepository;

@Service
public class RequestResourceService {
     /**
     * Autowired for request resource repository..
     */
    @Autowired
    private RequestResourceRepository requestRepository;
    /**
     * Autowired for admin repository.
     */
    @Autowired
    private AdminRepository userRepository;
    /**
     * Autowired for project repository.
     */
    @Autowired
    private ProjectRepository projectRepository;
     /**
     * Retrieves all resource requests and maps them to DTOs for output.
     * @return A list of RequestResourceOutDto objects representing resource
     *         requests.
     */
    public final List<RequestResourceOutDTO> getAllRequests() {
        List<RequestResource> resourceList = requestRepository.findAll();
        List<RequestResourceOutDTO> outDtoList =
                new ArrayList<RequestResourceOutDTO>();

        for (RequestResource resource : resourceList) {
        RequestResourceOutDTO outList = new RequestResourceOutDTO();
            outList.setComment(resource.getComment());
            outList.setEmpId(resource.getEmployeeId());
            outList.setId(resource.getResourceId());
            outList.setManagerId(resource.getManagerId());
            //System.out.println(resource.getEmpId());
            Employee emp = userRepository
                    .findById(resource.getEmployeeId()).get();
            outList.setEmployeeName(emp.getName());
            Employee manager = userRepository
                    .findById(resource.getManagerId()).get();
            outList.setManagerName(manager.getName());
            Project project = projectRepository
                    .findById(resource.getProjectId())
                    .get();
            outList.setProjectName(project.getName());

            outDtoList.add(outList);
        }
        return outDtoList;
    }
    /**
     * Accepts a resource request by updating
     * the employee's project and manager ID,
     * and rejects all other requests from the same employee.
     * @param id The ID of the request to be accepted.
     * @return A ResponseDTO indicating the result of the request acceptance.
     */
    public ResponseDTO acceptRequest(final Long id) {
        RequestResource request =
                requestRepository.findById(id).get();
        Employee employee = userRepository
                .findById(request.getEmployeeId()).get();
        employee.setProjectId(request.getProjectId());
        employee.setManagerId(request.getManagerId());
        this.userRepository.save(employee);
         rejectRequest(id);
         List<RequestResource> employeeRequests =
                 requestRepository.findByEmployeeId(employee.getId());
//         if(employee.getProjectId()!=0L) {
//         System.out.println("Already has project");
//         }
         for (RequestResource req : employeeRequests) {
             rejectRequest(req.getResourceId());
         }
         ResponseDTO response = new ResponseDTO();
         response.setMessage("Request Accepted");
         return response;
    }
    /**
     * Rejects a resource request by deleting it from the repository.
     * @param id The ID of the request to be rejected.
     * @return A ResponseDTO indicating the result of the request rejection.
     */
    public final ResponseDTO rejectRequest(final Long id) {
        RequestResource request = requestRepository.findById(id).get();
        this.requestRepository.delete(request);
        ResponseDTO response = new ResponseDTO();
        response.setMessage("Request Deleted");
        return response;
    }
    /**
     * Checks if a resource request exists for a given employee and manager.
     * @param empId
     * @param managerId
     * @return `true` if a request exists, `false` otherwise.
     */
    public boolean isRequested(final Long empId, final Long managerId) {
        Optional<RequestResource> req = requestRepository
                .findByEmployeeIdAndManagerId(empId, managerId);
        if (req.isEmpty()) {
            return false;
        }
        return true;
    }
    /**
     * Retrieves a list of resource requests and
     *  converts them into a list of {@link RequestResourceOutDTO}.
     * @return A list of RequestResourceOutDTO objects representing
     * the resource requests.
     */
    public final List<RequestResourceOutDTO> requestOut() {

        List<RequestResource> reqList = requestRepository.findAll();
        //System.out.println(employees);
        List<RequestResourceOutDTO> reqOutList =
                new ArrayList<RequestResourceOutDTO>();
        for (RequestResource request : reqList) {
        RequestResourceOutDTO reqDto = new RequestResourceOutDTO();
            reqDto.setComment(request.getComment());
            reqDto.setId(request.getResourceId());
            Employee emp = userRepository
                    .findById(request.getEmployeeId()).get();
            reqDto.setEmployeeName(emp.getEmpId() + " - " + emp.getName());
            Employee manager = userRepository
                    .findById(request.getManagerId()).get();
            reqDto.setManagerName(manager.getName());
            Project project = projectRepository
                    .findById(request.getProjectId()).get();
            reqDto.setProjectName(project.getName());
             reqOutList.add(reqDto);
        }
        return reqOutList;
    }
    /**
     * Adds a new resource request based on the provided RequestResourceInDTO.
     * @param requestDTO The RequestResourceInDTO
     * containing the request information.
     * @return an ApiResponseDTO
     */
    public ApiResponseDTO addRequestResource(final
            RequestResourceInDTO requestDTO) {
        // TODO Auto-generated method stub
        RequestResource request = dtoToRequestResource(requestDTO);
        requestRepository.save(request);
        ApiResponseDTO response = new ApiResponseDTO();
            response.setMessage("Sucessfully Added");
            return response;
    }
    /**
     * dtoToRequestResource.
     * @param requestDTO
     * @return request
     */
    public final RequestResource dtoToRequestResource(final
            RequestResourceInDTO requestDTO) {
        RequestResource request = new RequestResource();
        request.setEmployeeId(requestDTO.getEmployeeId());
        request.setComment(requestDTO.getComment());
        request.setManagerId(requestDTO.getManagerId());
        request.setProjectId(requestDTO.getProjectId());
        return request;
    }
}
