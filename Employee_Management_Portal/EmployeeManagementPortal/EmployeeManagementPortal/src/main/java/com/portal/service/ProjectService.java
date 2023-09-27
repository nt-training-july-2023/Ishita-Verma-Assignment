package com.portal.service;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.ProjectDTO;
import com.portal.DTO.ProjectOutDTO;
import com.portal.DTO.UserDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.entities.Role;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.validation.Validation;

import jakarta.persistence.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for adding and managing projects.
 */
@Service
public class ProjectService {
	/**
	 * Repository for managing Project entities.
	 */
	@Autowired
	private ProjectRepository projectRepository;
	/**
	 * Repository for managing Project entities.
	 */
	@Autowired
	private AdminRepository adminRepository;

	/**
	 * ModelMapper for mapping between DTOs and entities.
	 */
	@Autowired
	private ModelMapper modelMapper;
	
	 @Autowired
	    private ApiResponseDTO response;
	/**
	 * Adds a new project based on the provided projectDTO.
	 *
	 * @param projectDTO The projectDTO containing project information.
	 * @return The name of the added project.
	 */
	public ApiResponseDTO addProject(final ProjectDTO projectDTO) {

		projectDTO.setName(projectDTO.getName());
		projectDTO.setProjectId(projectDTO.getProjectId());
		projectDTO.setManagerId(projectDTO.getManagerId());
		projectDTO.setStartDate(projectDTO.getStartDate());
		projectDTO.setSkills(projectDTO.getSkills());
		projectDTO.setDescription(projectDTO.getDescription());
		Project project = this.dtotoEntity(projectDTO);
		this.projectRepository.save(project);
		response.setMessage("Project added successfully");
		return response;
	}

	/**
	 * Retrieves the skills associated with a project by its name.
	 *
	 * @param name The name of the project.
	 * @return list of skills with the project, or empty list if the project is not
	 *         found.
	 */
	final public List<String> getSkillsForProject(final String name) {
		Project project = projectRepository.findByName(name);
		if (project != null) {
			List<String> skillArray = project.getSkills();
			return (skillArray);
		}
		return Collections.emptyList(); // Project not found or no skills
	}

	/**
	 * @param managerId manager id of employee
	 * @return list of projects
	 */
	public final List<ProjectOutDTO> getProjectByManagerId(final Long managerId) {

		List<Project> projectList = projectRepository.findByManagerId((managerId));
		List<ProjectOutDTO> projectOutList = new ArrayList<ProjectOutDTO>();
		for (Project project : projectList) {
			ProjectOutDTO projectOutDto = new ProjectOutDTO();
			projectOutDto.setProjectId(project.getProjectId());
			projectOutDto.setProjectName(project.getName());

			projectOutDto.setManagerId(project.getManagerId());
			projectOutDto.setSkills(project.getSkills());
			List<Employee> empList = adminRepository.findAllByProjectId(project.getProjectId());

			List<String> teams = new ArrayList<String>();
			if (empList.size() != 0) {
				for (Employee emp : empList) {
					teams.add(emp.getName());
				}
			} else {
				teams.add("N/A");
			}
			projectOutDto.setTeams(teams);
			projectOutList.add(projectOutDto);
		}
		return projectOutList;
	}

	/**
	 * Get a list of all projects.
	 * 
	 * @return a list of project DTOs
	 */
	public final List<ProjectOutDTO> getProjects() {
		List<Project> projectList = projectRepository.findAll();
		List<ProjectOutDTO> projectOutList = new ArrayList<>();
//		System.out.println(projectList);
		for (Project project : projectList) {
			ProjectOutDTO projectOutDto = new ProjectOutDTO();
			projectOutDto.setProjectId(project.getProjectId());
			projectOutDto.setProjectName(project.getName());
			Employee manager = adminRepository.findById(project.getManagerId()).get();
			projectOutDto.setManager(manager.getName());
			projectOutDto.setManagerId(project.getManagerId());
			projectOutDto.setDescription(project.getDescription());
			projectOutDto.setStartDate(project.getStartDate());
			projectOutDto.setSkills(project.getSkills());
			System.out.println(projectOutDto);
			List<Employee> empList = adminRepository.findAllByProjectId(project.getProjectId());
			List<String> teams = new ArrayList<String>();

			if (empList.size() != 0) {
				for (Employee emp : empList) {
					teams.add(emp.getName());
				}
			} else {
				teams.add("N/A");
			}
			projectOutDto.setTeams(teams);

			projectOutList.add(projectOutDto);
		}

		return projectOutList;
	}

	/**
	 * Get a list of all unassigned projects.
	 *
	 * @return a list of project DTOs for unassigned projects.
	 */
	public List<Employee> getEmployeesWithUnassignedProjects() {
		List<Employee> allEmployees = adminRepository.findAll();

		// Use Java streams to filter employees with unassigned projects
		List<Employee> employeesWithUnassignedProjects = allEmployees.stream()
				.filter(employee -> employee.getProject() == 0 && employee.getRole() == Role.EMPLOYEE)
				.collect(Collectors.toList());

		return employeesWithUnassignedProjects;
	}

	// dto to entity
	/**
	 * @param projectDto project dto
	 * @return project entity
	 */
	private Project dtotoEntity(final ProjectDTO projectDto) {
		// AdminEntity adminEntity = new AdminEntity();
		return this.modelMapper.map(projectDto, Project.class);
	}

//entity to dto
	/**
	 * @param projectEntity project
	 * @return project dto
	 */
	private ProjectDTO entitytoDto(final Project projectEntity) {
		// AdminDTO adminDto = new AdminDTO();
		return this.modelMapper.map(projectEntity, ProjectDTO.class);
	}
}
