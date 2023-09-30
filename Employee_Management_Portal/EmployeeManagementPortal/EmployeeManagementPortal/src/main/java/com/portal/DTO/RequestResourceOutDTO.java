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
     * @param commentParam The comment to be set for this request resource.
     */
    public void setComment(final String commentParam) {
        this.comment = commentParam;
    }

    /**
     * @return The manager's unique identifier.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * @param managerIdParam The manager's unique identifier.
     */
    public void setManagerId(final Long managerIdParam) {
        this.managerId = managerIdParam;
    }

    /**
     * @return The employee's unique identifier.
     */
    public Long getEmpId() {
        return empId;
    }

    /**
     * @param empIdParam The employee's unique identifier.
     */
    public void setEmpId(final Long empIdParam) {
        this.empId = empIdParam;
    }

    /**
     * @return The project's unique identifier.
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * @param projectIdParam The project's unique identifier.
     */
    public void setProjectId(final Long projectIdParam) {
        this.projectId = projectIdParam;
    }

    /**
     * @return The name of the project.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectNameParam
     */
    public void setProjectName(final String projectNameParam) {
        this.projectName = projectNameParam;
    }

    /**
     * @return The name of the employee associated with this request resource.
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeNameParam
     */
    public void setEmployeeName(final String employeeNameParam) {
        this.employeeName = employeeNameParam;
    }

    /**
     * @return The name of the manager.
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * @param managerNameParam
     */
    public void setManagerName(final String managerNameParam) {
        this.managerName = managerNameParam;
    }

    /**
     * @return The employee's user ID.
     */
    public String getEmpUserId() {
        return empUserId;
    }

    /**
     * @param empUserIdParam
     */
    public void setEmpUserId(final String empUserIdParam) {
        this.empUserId = empUserIdParam;
    }

    /**
     * @return The manager's user ID.
     */
    public String getManagerUserId() {
        return managerUserId;
    }

    /**
     * @param managerUserIdParam
     */
    public void setManagerUserId(final String managerUserIdParam) {
        this.managerUserId = managerUserIdParam;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param idParam the id to set
     */
    public void setId(final Long idParam) {
        this.id = idParam;
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
