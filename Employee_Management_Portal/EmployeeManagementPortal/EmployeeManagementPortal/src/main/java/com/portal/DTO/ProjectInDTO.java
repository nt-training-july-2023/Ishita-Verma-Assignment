package com.portal.DTO;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
/**
 * Data Transfer Object (DTO) representing project information.
 */
public class ProjectInDTO {
    /**
     * The unique ID of the project.
     */
    private Long projectId;

    /**
     * The name of the project.
     */
    @NotBlank(message = "Name should not be empty")
    private String name;

    /**
     * The description of the project.
     */
    @NotBlank(message = "Decription cannot be null")
    private String description;

    /**
     * The manager ID of the project.
     */
    @NotNull(message = "Manager ID should not be empty")
    private Long managerId;

    /**
     * The list of skills required for the project.
     */
    @NotEmpty(message= "Project Skill Required")
    private List<@NotBlank String> skills;
    /**.
     * start date of project
     */
    @NotBlank(message ="Start date is mandatory")
    private String startDate;

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
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
	 * Calculates the hash code value for this ProjectInDTO object.
	 *
	 * @return The hash code value based on the description, managerId, name, projectId, skills, and startDate.
	 */
	@Override
	public int hashCode() {
	    return Objects.hash(description, managerId, name, projectId, skills, startDate);
	}

	/**
	 * Indicates whether some other object is "equal to" this ProjectInDTO.
	 *
	 * @param obj The reference object with which to compare.
	 * @return {@code true} if this ProjectInDTO is the same as the obj argument; {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    ProjectInDTO other = (ProjectInDTO) obj;
	    return Objects.equals(description, other.description) && Objects.equals(managerId, other.managerId)
	            && Objects.equals(name, other.name) && projectId == other.projectId
	            && Objects.equals(skills, other.skills) && Objects.equals(startDate, other.startDate);
	}

	/**
	 * Returns a string representation of this ProjectInDTO.
	 *
	 * @return A string containing the projectId, name, description, managerId, skills, and startDate of this ProjectInDTO.
	 */
	@Override
	public String toString() {
	    return "ProjectDTO [projectId=" + projectId + ", name=" + name + ", description=" + description + ", managerId="
	            + managerId + ", skills=" + skills + ", startDate=" + startDate + "]";
	}
}
