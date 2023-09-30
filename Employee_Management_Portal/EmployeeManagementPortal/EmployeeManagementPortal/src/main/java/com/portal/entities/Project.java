package com.portal.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

    /**
     * . project id auto generated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    /**
     * . project name
     */
    @Column(unique = true)
    private String name;
    /**
     * . project's manager id
     */
    @Column(nullable = false)
    private Long managerId;
    /**
     * . start date of project
     */
    @Column(nullable = false)
    private String startDate;
    /**
     * . list of skills required for project
     */
    @Column(nullable = false)
    private List<String> skills;
    /**
     * . project description
     */
    @Column
    private String description;

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
     * @return the skills
     */
    public List<String> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    /**
     * @param skillsParam the skills to set
     */
    public void setSkills(final List<String> skillsParam) {
        if (skillsParam != null) {
            this.skills = new ArrayList<>(skillsParam);
        } else {
            this.skills = null;
        }
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
     * Returns a string representation of the Project object.
     * @return A string containing the values of the Project's properties.
     */
    @Override
    public String toString() {
        return "Project [projectId=" + projectId + ", name=" + name
                + ", managerId=" + managerId + ", startDate=" + startDate
                + ", skills=" + skills + ", description=" + description
                + "]";
    }

    /**
     * Computes and returns a hash code value for the Project object.
     * @return A hash code value based on the Project's properties.
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, managerId, name, projectId,
                skills, startDate);
    }
    /**
     * Indicates whether some other object is "equal to" this Project.
     * @param obj The reference object with which to compare.
     * @return {@code true} if this Project is the same as the obj argument;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Project other = (Project) obj;
        return Objects.equals(description, other.description)
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(name, other.name)
                && Objects.equals(projectId, other.projectId)
                && Objects.equals(skills, other.skills)
                && Objects.equals(startDate, other.startDate);
    }
}
