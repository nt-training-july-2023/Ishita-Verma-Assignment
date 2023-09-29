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
    private Long ResourceId;

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
        return ResourceId;
    }

    /**
     * Sets the unique identifier for the resource request.
     *
     * @param resourceId The unique identifier for the resource request.
     */
    public void setResourceId(final Long resourceId) {
        ResourceId = resourceId;
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
     * @param comment The comment or additional information about the request.
     */
    public void setComment(final String comment) {
        this.comment = comment;
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
     * @param managerId The ID of the manager associated with the request.
     */
    public void setManagerId(final Long managerId) {
        this.managerId = managerId;
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
     * @param employeeId The ID of the employee associated with the request.
     */
    public void setEmployeeId(final Long employeeId) {
        this.employeeId = employeeId;
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
     * @param projectId The ID of the project associated with the request.
     */
    public void setProjectId(final Long projectId) {
        this.projectId = projectId;
    }

    /**
     * Returns a string representation of the RequestResource object.
     * @return A string containing the values of  properties.
     */
    @Override
    public String toString() {
        return "RequestResource [ResourceId=" + ResourceId
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
        return Objects.hash(ResourceId,
                comment, employeeId, managerId, projectId);
    }

    /**
     * Indicates whether some other object is "equal to" this RequestResource.
     * @param obj The reference object with which to compare.
     * @return  true if this RequestResource is the same as the obj argument.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj){
            return true;
            }
        if (obj == null || getClass() != obj.getClass()){
            return false;
            }
        RequestResource other = (RequestResource) obj;
        return Objects.equals(ResourceId, other.ResourceId) 
                && Objects.equals(comment, other.comment)
                && Objects.equals(employeeId, other.employeeId)
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(projectId, other.projectId);
    }
}
