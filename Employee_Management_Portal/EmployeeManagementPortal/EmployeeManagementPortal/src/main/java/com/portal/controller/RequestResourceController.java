package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.RequestResourceOutDTO;
import com.portal.DTO.RequestedDTO;
//import com.portal.DTO.RequestedDTO;
import com.portal.DTO.ResponseDTO;
import com.portal.service.RequestResourceService;


/**
 * Controller class to handle Admin-related operations.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class RequestResourceController {
	 /**
     * Instance for Service class of ResourceRequestService.
     */
    @Autowired
    private RequestResourceService requestService;
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
    @PostMapping("/employee/isRequested")
    public boolean isRequested(@RequestBody RequestedDTO reqDto) {
        return requestService.isRequested(reqDto);
    }
}
