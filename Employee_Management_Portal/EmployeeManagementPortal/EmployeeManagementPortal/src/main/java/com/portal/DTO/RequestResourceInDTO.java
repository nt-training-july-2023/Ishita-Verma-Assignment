package com.portal.DTO;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
/**
 * Data Transfer Object (DTO) representing a request for a resource.
 */
public class RequestResourceInDTO {
    /**
     * The comment associated with the request.
     */
    @NotBlank(message = "Comment Required")
    private String comment;
    /**
     * The manager's identifier associated with the request.
     */
    @NotNull(message = "Manager Id Required")
    private Long managerId;
    /**
     * The employee's identifier associated with the request.
     */
    @NotNull(message = "Employee Id Required")
    private Long employeeId;
    /**
     * The project's identifier associated with the request.
     */
    @NotNull(message = "Project Id Required")
    private Long projectId;

    /**
     * Get the comment associated with the request.
     *
     * @return The comment.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the comment associated with the request.
     *
     * @param commentParam The comment to set.
     */
    public void setComment(final String commentParam) {
        this.comment = commentParam;
    }

    /**
     * Get the manager's identifier associated with the request.
     *
     * @return The manager's identifier.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * Set the manager's identifier associated with the request.
     *
     * @param managerIdParam The manager's identifier to set.
     */
    public void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * Get the employee's identifier associated with the request.
     *
     * @return The employee's identifier.
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * Set the employee's identifier associated with the request.
     *
     * @param employeeIdParam The employee's identifier to set.
     */
    public void setEmployeeId(final Long employeeIdParam) {
        this.employeeId = employeeIdParam;
    }

    /**
     * Get the project's identifier associated with the request.
     *
     * @return The project's identifier.
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * Set the project's identifier associated with the request.
     *
     * @param projectIdParam The project's identifier to set.
     */
    public void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * Calculate the hash code value for this RequestResourceInDTO object.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(comment, employeeId, managerId, projectId);
    }

    /**
     * @param obj The object to compare to.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RequestResourceInDTO other = (RequestResourceInDTO) obj;
        return Objects.equals(comment, other.comment)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(managerId, other.managerId)
            && Objects.equals(projectId, other.projectId);
    }

    /**
     * Generate a string representation of this RequestResourceInDTO.
     *
     * @return A string of comment, managerId, employeeId, and projectId.
     */
    @Override
    public String toString() {
        return "RequestResourceDTO [comment=" + comment
                + ", managerId=" + managerId + ", employeeId=" + employeeId
            + ", projectId=" + projectId + "]";
    }
}
