package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
