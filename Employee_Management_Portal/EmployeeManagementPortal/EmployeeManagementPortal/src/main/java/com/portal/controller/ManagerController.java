package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.RequestResourceDTO;
import com.portal.service.ManagerService;

@CrossOrigin("*")
@RequestMapping("/api/admin")
@RestController
public class ManagerController {
	   /**
     * logger.
     */
//    public static final Logger LOGGER = LogManager
//            .getLogger(AdminController.class);
	 /**
     * Manager Service.
     */
    @Autowired
    private ManagerService managerService;
    /**
     * addRequestResource.
     * @param requestDTO request
     * @return response
     */
    @PostMapping("/request/resource")
    public final ApiResponseDTO addRequestResource(@RequestBody final RequestResourceDTO requestDTO) {
//       LOGGER.info("add request started:");
       System.out.println("manager" + requestDTO.getManagerId());
       final ApiResponseDTO response = managerService.addRequestResource(requestDTO );
//       LOGGER.info("Successfully added Request Resource");
       return response;
    }
}
