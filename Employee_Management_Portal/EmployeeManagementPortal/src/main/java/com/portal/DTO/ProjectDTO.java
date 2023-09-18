package com.portal.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
/**
 * Data Transfer Object (DTO) representing project information.
 */
public class ProjectDTO {
    /**
     * The unique ID of the project.
     */
    private long projectId;

    /**
     * The name of the project.
     */
    @NotBlank(message = "Name should not be empty")
    private String name;

    /**
     * The description of the project.
     */
    private String description;

    /**
     * The manager ID of the project.
     */
    @NotBlank(message = "Manager ID should not be empty")
    private Long managerId;

    /**
     * The list of skills required for the project.
     */
    private List<String> skills;
    /**.
     * start date of project
     */
    @Column
    private String startDate;

	/**
	 * @return the projectId
	 */
	public long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the managerId
	 */
	public Long getManagerId() {
		return managerId;
	}

	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	/**
	 * @return the skills
	 */
	public List<String> getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
    
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @param projectId
	 * @param name
	 * @param description
	 * @param managerId
	 * @param skills
	 * @param startDate
	 */
	public ProjectDTO(long projectId, @NotBlank(message = "Name should not be empty") String name, String description,
			@NotBlank(message = "Manager ID should not be empty") Long managerId, List<String> skills, String startDate) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.description = description;
		this.managerId = managerId;
		this.skills = skills;
		this.startDate = startDate;
	}

	/**
	 * 
	 */
	public ProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, managerId, name, projectId, skills, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectDTO other = (ProjectDTO) obj;
		return Objects.equals(description, other.description) && Objects.equals(managerId, other.managerId)
				&& Objects.equals(name, other.name) && projectId == other.projectId
				&& Objects.equals(skills, other.skills) && Objects.equals(startDate, other.startDate);
	}

	@Override
	public String toString() {
		return "ProjectDTO [projectId=" + projectId + ", name=" + name + ", description=" + description + ", managerId="
				+ managerId + ", skills=" + skills + ", startDate=" + startDate + "]";
	}

	
    
}
