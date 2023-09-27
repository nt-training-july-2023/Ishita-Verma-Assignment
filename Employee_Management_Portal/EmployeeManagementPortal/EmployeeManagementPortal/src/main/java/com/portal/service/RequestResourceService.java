package com.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.DTO.RequestResourceOutDTO;
import com.portal.DTO.RequestedDTO;
//import com.portal.DTO.RequestedDTO;
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
            Employee emp = userRepository.findById(resource.getEmployeeId()).get();
            outList.setEmployeeName(emp.getName());
            Employee manager = userRepository.findById(resource.getManagerId()).get();
            outList.setManagerName(manager.getName());
            Project project = projectRepository.findById(resource.getProjectId())
                    .get();
            outList.setProjectName(project.getName());

            outDtoList.add(outList);
        }
        return outDtoList;
    }
    public ResponseDTO acceptRequest(Long id) {
        RequestResource request = requestRepository.findById(id).get();
        Employee employee =userRepository.findById(request.getEmployeeId()).get();
        employee.setProjectId(request.getProjectId());
        employee.setManagerId(request.getManagerId());
        this.userRepository.save(employee);
         rejectRequest(id);
         List<RequestResource> employeeRequests = requestRepository.findByEmployeeId(employee.getId());
//         if(employee.getProjectId()!=0L) {
//        	 System.out.println("Already has project");
//         }
         for (RequestResource req : employeeRequests) {
             rejectRequest(req.getResourceId());
         }
         return new ResponseDTO("Request Accepted","");
    }
    public final ResponseDTO rejectRequest(Long id) {
        RequestResource request = requestRepository.findById(id).get();
        this.requestRepository.delete(request);
        return new ResponseDTO("Request Deleted","");
    }
    public boolean isRequested(RequestedDTO reqDto) {
        Employee manager = userRepository.findByEmail(reqDto.getManagerEmail()).get();
        
        RequestResource req= requestRepository.findByEmployeeIdAndManagerId(reqDto.getEmployeeId(),manager.getId()).get();
        System.out.println(req.toString());
        if(req != null) {
            return true;
        }
        return false;  
    }
    public final List<RequestResourceOutDTO> requestOut(){

        List<RequestResource> reqList = requestRepository.findAll();
        //System.out.println(employees);
        List<RequestResourceOutDTO> reqOutList = new ArrayList<RequestResourceOutDTO>();
        for (RequestResource request : reqList) {
        	RequestResourceOutDTO reqDto = new RequestResourceOutDTO();
            reqDto.setComment(request.getComment());
            reqDto.setId(request.getResourceId());
            Employee emp = userRepository.findById(request.getEmployeeId()).get();
            reqDto.setEmployeeName(emp.getEmpId() + " - " + emp.getName());
            Employee manager = userRepository.findById(request.getManagerId()).get();
            reqDto.setManagerName(manager.getName());
            Project project = projectRepository.findById(request.getProjectId()).get();
            reqDto.setProjectName(project.getName());
            
             reqOutList.add(reqDto);
        }
        return reqOutList;
    }
}
