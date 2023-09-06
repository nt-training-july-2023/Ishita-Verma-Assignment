package com.portal.service;

import com.portal.DTO.ProjectDTO;
import com.portal.entities.Project;
import com.portal.repository.ProjectRepository;
import com.portal.validations.Validation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Validation projectValidation;

    public String addProject(final ProjectDTO projectDTO) {
        if (projectValidation.validEmptyData(projectDTO.getDescription())) {
            throw new IllegalArgumentException("Description should not be empty");
        }

        if (projectValidation.validEmptyData(projectDTO.getManagerId())) {
            throw new IllegalArgumentException("Manager ID should not be empty");
        }

        if (projectValidation.validEmptySkills(projectDTO.getSkills())) {
            throw new IllegalArgumentException("Skills should not be empty");
        }

        if (!projectValidation.validDate(projectDTO.getStartDate())) {
            throw new IllegalArgumentException("Invalid Start Date. Should be in the format DD-MM-YYYY");
        }

        Project project = modelMapper.map(projectDTO, Project.class);
        projectRepository.save(project);
        return project.getName();
    }
}

