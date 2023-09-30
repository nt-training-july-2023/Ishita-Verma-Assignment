package com.portal.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @NotEmpty(message = "Project Skill Required")
    private List<@NotBlank String> skills;
    /**
     * . start date of project
     */
    @NotBlank(message = "Start date is mandatory")
    private String startDate;

    /**
     * @return the projectId
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * @param projectIdParam the projectId to set
     */
    public void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param nameParam the name to set
     */
    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param descriptionParam the description to set
     */
    public void setDescription(final String descriptionParam) {
        this.description = descriptionParam;
    }

    /**
     * @return the managerId
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * @param managerIdParam the managerId to set
     */
    public void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * Gets the list of skills possessed by the admin.
     * @return The list of skills.
     */
    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }


    /**
     * Sets the list of skills possessed by the admin.
     * @param skillsParam The list of skills.
     */
    public final void setSkills(final List<String> skillsParam) {
        if (skillsParam != null) {
            this.skills = new ArrayList<>(skillsParam);
        } else {
            this.skills = null;
        }
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDateParam the startDate to set
     */
    public void setStartDate(final String startDateParam) {
        this.startDate = startDateParam;
    }

    /**
     * Calculates the hash code value for this ProjectInDTO object.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, managerId, name, projectId,
                skills, startDate);
    }

    /**
     * Indicates whether some other object is "equal to" this ProjectInDTO.
     *
     * @param obj The reference object with which to compare.
     * @return {@code true} if this ProjectInDTO is same as obj argument;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ProjectInDTO other = (ProjectInDTO) obj;
        return Objects.equals(description, other.description)
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(name, other.name)
                && Objects.equals(projectId, other.projectId)
                && Objects.equals(skills, other.skills)
                && Objects.equals(startDate, other.startDate);
    }

    /**
     * Returns a string representation of this ProjectInDTO.
     *
     * @return A string.
     */
    @Override
    public String toString() {
        return "ProjectDTO [projectId=" + projectId + ",name=" + name
                + ", description=" + description + ", managerId="
                + managerId + ", skills=" + skills + ", startDate="
                + startDate + "]";
    }
}
