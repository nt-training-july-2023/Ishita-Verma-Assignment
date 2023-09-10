package com.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
List<Project> findByProjectIdAndManagerId(long projectId, String managerId);

Project findByName(String projectName);


}
