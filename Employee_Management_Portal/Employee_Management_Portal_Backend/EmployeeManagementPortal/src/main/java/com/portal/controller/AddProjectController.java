package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.DTO.AdminDTO;
import com.portal.DTO.ProjectDTO;
import com.portal.entities.Project;
import com.portal.repository.ProjectRepository;
import com.portal.service.AddEmployeeService;
import com.portal.service.AddProjectService;

@CrossOrigin("*")
@RequestMapping("/api/admin")
@RestController
public class AddProjectController {
	
	
	@Autowired
	private ProjectRepository projectRepository;
	/**
	 * Admin Service.
	 */
	@Autowired
	private AddProjectService addProjectService;
	
	@PostMapping(path = "/addProject")
	public final String saveProject(@RequestBody final ProjectDTO projectDTO) {
		{
			return addProjectService.addProject(projectDTO);
		}
	}
	
	 @GetMapping(path = "/projects")
	    public List<Project> getAllProjects() {
	        return projectRepository.findAll();
	 }
	

}
