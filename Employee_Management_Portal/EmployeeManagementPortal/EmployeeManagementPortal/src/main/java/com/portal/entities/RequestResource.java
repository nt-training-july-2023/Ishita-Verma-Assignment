package com.portal.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * Represents a request for allocating a resource in the system.
 */
@Table
@Entity
public class RequestResource {
    /**
     * The unique identifier for the resource request.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    /**
     * The comment or additional information about the request.
     */
    @Column
    private String comment;

    /**
     * The ID of the manager associated with the request.
     */
    @Column(nullable = false)
    private Long managerId;

    /**
     * The ID of the employee associated with the request.
     */
    @Column(nullable = false)
    private Long employeeId;

    /**
     * The ID of the project associated with the request.
     */
    @Column(nullable = false)
    private Long projectId;

    /**
     * Gets the unique identifier for the resource request.
     *
     * @return The unique identifier for the resource request.
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * Sets the unique identifier for the resource request.
     *
     * @param resourceIdParam The unique identifier for the resource request.
     */
    public void  setResourceId(final Long resourceIdParam) {
        this.resourceId = resourceIdParam;
    }

    /**
     * Gets the comment or additional information about the request.
     *
     * @return The comment or additional information about the request.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment or additional information about the request.
     *
     * @param commentParam
     */
    public void setComment(final String commentParam) {
        this.comment = commentParam;
    }

    /**
     * Gets the ID of the manager associated with the request.
     *
     * @return The ID of the manager associated with the request.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * Sets the ID of the manager associated with the request.
     *
     * @param managerIdParam The ID of the manager associated with the request.
     */
    public void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * Gets the ID of the employee associated with the request.
     *
     * @return The ID of the employee associated with the request.
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the ID of the employee associated with the request.
     *
     * @param employeeIdParam The ID of the employee.
     */
    public void setEmployeeId(final Long employeeIdParam) {
        this.employeeId = employeeIdParam;
    }

    /**
     * Gets the ID of the project associated with the request.
     *
     * @return The ID of the project associated with the request.
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * Sets the ID of the project associated with the request.
     *
     * @param projectIdParam The ID of the project associated with the request.
     */
    public void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * Returns a string representation of the RequestResource object.
     * @return A string containing the values of  properties.
     */
    @Override
    public String toString() {
        return "RequestResource [ResourceId=" + resourceId
                + ", comment=" + comment + ", managerId=" + managerId
                + ", employeeId=" + employeeId
                + ", projectId=" + projectId + "]";
    }

    /**
     * Computes and returns a hash code value for the RequestResource object.
     *
     * @return A hash code value based on the RequestResource's properties.
     */
    @Override
    public int hashCode() {
        return Objects.hash(resourceId,
                comment, employeeId, managerId, projectId);
    }

    /**
     * Indicates whether some other object is "equal to" this RequestResource.
     * @param obj The reference object with which to compare.
     * @return  true if this RequestResource is the same as the obj argument.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
            }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
            }
        RequestResource other = (RequestResource) obj;
        return Objects.equals(resourceId, other.resourceId)
                && Objects.equals(comment, other.comment)
                && Objects.equals(employeeId, other.employeeId)
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(projectId, other.projectId);
    }
}
