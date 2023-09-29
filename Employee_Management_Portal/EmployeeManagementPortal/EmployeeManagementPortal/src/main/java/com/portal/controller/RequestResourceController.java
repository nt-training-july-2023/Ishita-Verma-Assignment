package com.portal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.RequestResourceInDTO;
import com.portal.DTO.RequestResourceOutDTO;
import com.portal.DTO.RequestedDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.service.RequestResourceService;

import jakarta.validation.Valid;
/**
 * Controller class to handle Admin-related operations.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class RequestResourceController {
	 /**
     * Instance for Service class of ResourceRequestService.
     */
    @Autowired
    private RequestResourceService requestService;
    /**
     * Logger instance for logging purposes.
     */
    private static final Logger LOGGER = LoggerFactory
    		.getLogger(EmployeeController.class);
    /**
     * Retrieves all resource requests.
     * @return A list of RequestResourceOutDto objects representing resource
     *         requests.
     */
    @GetMapping("/requests")
    public final List<RequestResourceOutDTO> getAllRequests() {
        return requestService.getAllRequests();
    }
    /**
     * addRequestResource.
     * @param requestDTO rsequest
     * @return response
     */
    @PostMapping("/request/resource")
    public final ApiResponseDTO addRequestResource(@RequestBody @Valid final RequestResourceInDTO requestDTO) {
//       LOGGER.info("add request started:");
       System.out.println("manager" + requestDTO.getManagerId());
       final ApiResponseDTO response = requestService.addRequestResource(requestDTO );
       LOGGER.info("Successfully added Request Resource");
       return response;
    }
    /**
     * Rejecting requests
     * @param id request id
     * @return api response of the operation.
     */
    @DeleteMapping("manager/request/delete/{id}")
    public final ResponseDTO rejectRequest(@PathVariable Long id) {
        return requestService.rejectRequest(id);
    }
    /**
     * Accepting Requests
     * @param id request id
     * @return api response of the operation.
     */
    @PostMapping("manager/request/{id}")
    public final ResponseDTO acceptRequest(@PathVariable Long id) {
        return requestService.acceptRequest(id);
    }
    /**
     * Employee is requested or not 
     * @param reqDto request dto
     * @return boolean value
     */
//    @PostMapping("/employee/isRequested")
//    public boolean isRequested(@RequestBody RequestedDTO reqDto) {
//        return requestService.isRequested(reqDto);
//    }
    @GetMapping("/employee/isRequested")
    public boolean isRequested(@RequestParam Long empId,@RequestParam Long managerId) {
        return requestService.isRequested(empId,managerId);
    }
}
