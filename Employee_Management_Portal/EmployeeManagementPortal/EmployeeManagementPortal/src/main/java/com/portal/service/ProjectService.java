package com.portal.service;

import com.portal.DTO.ApiResponseDTO;
import com.portal.DTO.ProjectDTO;
import com.portal.DTO.UserDTO;
import com.portal.entities.Employee;
import com.portal.entities.Project;
import com.portal.exceptions.ResourceNotFoundException;
import com.portal.repository.AdminRepository;
import com.portal.repository.ProjectRepository;
import com.portal.validation.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
	private AdminRepository userRepository;

	/**
	 * ModelMapper for mapping between DTOs and entities.
	 */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Validation utility for performing project data validation.
	 */
	@Autowired
	private Validation projectValidation;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);

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
		return new ApiResponseDTO("Project added successfully");
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
	public final List<ProjectDTO> getProjectByManagerId(final long managerId) {
		List<Project> projectList = projectRepository.findAllByManagerId(managerId);
		List<ProjectDTO> projectOutList = new ArrayList<ProjectDTO>();
		for (Project project : projectList) {
			ProjectDTO projectOutDto = new ProjectDTO();
			projectOutDto.setProjectId(project.getProjectId());
			projectOutDto.setName(project.getName());
			projectOutDto.setManagerId(project.getManagerId());
			projectOutDto.setSkills(project.getSkills());
			projectOutList.add(projectOutDto);
		}
		return projectOutList;
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
