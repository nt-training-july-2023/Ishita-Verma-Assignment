package com.portal.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.portal.DTO.ProjectDTO;
import com.portal.entities.Project;

/**
 * Repository interface for managing Project entities.
 */
//@EnableJpaRepositories
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    /**
     * Find projects by both project ID and manager ID.
     * @param projectId The project ID to search for.
     * @param managerId The manager ID to search for.
     * @return A list of projects matching the given project ID and manager ID.
     */
    List<Project> findByProjectIdAndManagerId(Long projectId,
    		Long managerId);

    /**
     * Find a project by its name.
     * @param projectName The name of the project to search for.
     * @return The project with the specified name, if found.
     */
     Project findByName(String name);

    /**
     * Display project as per the manager.
     * @param projectName The name of the project to search for.
     * @return The project with the specified name, if found.
     */
    List<Project> findAllByManagerId(Long managerId);
}

