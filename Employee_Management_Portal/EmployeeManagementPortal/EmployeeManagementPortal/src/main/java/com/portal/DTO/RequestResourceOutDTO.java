package com.portal.DTO;

import java.util.Objects;

public class RequestResourceOutDTO {
    /**
     * Unique Identifier.
     */
    private Long id;

    /**
     * Comment associated with the request resource.
     */
    private String comment;

    /**
     * The unique identifier of the manager.
     */
    private Long managerId;

    /**
     * The unique identifier of the employee.
     */
    private Long empId;

    /**
     * The unique identifier of the project.
     */
    private Long projectId;

    /**
     * The name of the project.
     */
    private String projectName;

    /**
     * The name of the employee.
     */
    private String employeeName;

    /**
     * The name of the manager.
     */
    private String managerName;

    /**
     * The user ID of the employee.
     */
    private String empUserId;

    /**
     * The user ID of the manager.
     */
    private String managerUserId;

    /**
     * @return The comment associated with this request resource.
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment The comment to be set for this request resource.
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * @return The manager's unique identifier associated with this request resource.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * @param managerId The manager's unique identifier to be set for this request resource.
     */
    public void setManagerId(final Long managerId) {
        this.managerId = managerId;
    }

    /**
     * @return The employee's unique identifier associated with this request resource.
     */
    public Long getEmpId() {
        return empId;
    }

    /**
     * @param empId The employee's unique identifier to be set for this request resource.
     */
    public void setEmpId(final Long empId) {
        this.empId = empId;
    }

    /**
     * @return The project's unique identifier associated with this request resource.
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * @param projectId The project's unique identifier to be set for this request resource.
     */
    public void setProjectId(final Long projectId) {
        this.projectId = projectId;
    }

    /**
     * @return The name of the project associated with this request resource.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName The name of the project to be set for this request resource.
     */
    public void setProjectName(final String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return The name of the employee associated with this request resource.
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName The name of the employee to be set for this request resource.
     */
    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return The name of the manager associated with this request resource.
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * @param managerName The name of the manager to be set for this request resource.
     */
    public void setManagerName(final String managerName) {
        this.managerName = managerName;
    }

    /**
     * @return The employee's user ID associated with this request resource.
     */
    public String getEmpUserId() {
        return empUserId;
    }

    /**
     * @param empUserId The employee's user ID to be set for this request resource.
     */
    public void setEmpUserId(final String empUserId) {
        this.empUserId = empUserId;
    }

    /**
     * @return The manager's user ID associated with this request resource.
     */
    public String getManagerUserId() {
        return managerUserId;
    }

    /**
     * @param managerUserId The manager's user ID to be set for this request resource.
     */
    public void setManagerUserId(final String managerUserId) {
        this.managerUserId = managerUserId;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Calculates and returns the hash code value for this request resource.
     * @return The hash code value based on the fields
     */
    @Override
    public int hashCode() {
        return Objects.hash(comment, empId, empUserId, employeeName, id,
                managerId, managerName, managerUserId, projectId,
                projectName);
    }

    /**
     * @param obj The reference object with which to compare.
     * @return  true if this request resource is the same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RequestResourceOutDTO other = (RequestResourceOutDTO) obj;
        return Objects.equals(comment, other.comment)
                && Objects.equals(empId, other.empId)
                && Objects.equals(empUserId, other.empUserId)
                && Objects.equals(employeeName, other.employeeName)
                && Objects.equals(id, other.id)
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(managerName, other.managerName)
                && Objects.equals(managerUserId, other.managerUserId)
                && Objects.equals(projectId, other.projectId)
                && Objects.equals(projectName, other.projectName);
    }

    /**
     * Returns a string representation of this request resource.
     * @return A string representation containing the values of all fields.
     */
    @Override
    public String toString() {
        return "RequestResourceOutDTO [id=" + id + ", comment=" + comment
                + ", managerId=" + managerId + ", empId=" + empId
                + ", projectId=" + projectId + ", projectName="
                + projectName + ", employeeName=" + employeeName
                + ", managerName=" + managerName + ", empUserId="
                + empUserId + ", managerUserId=" + managerUserId + "]";
    }
}