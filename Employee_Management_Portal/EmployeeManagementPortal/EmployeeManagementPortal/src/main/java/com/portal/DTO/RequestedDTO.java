package com.portal.DTO;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * This is Requested Dto class.
 */
public class RequestedDTO {
	 /**
     * Employee id
     */
    @NotNull(message="Employee id is required")
    private Long employeeId;
    /**
     * Email of manager
     */
    @NotBlank(message="Manager email os required")
    private String managerEmail;
    /**
     * @return the employeeId
     */
    public Long getEmployeeId() {
        return employeeId;
    }
    /**
     * @param employeeID the employeeId to set
     */
    public void setEmployeeId(Long employeeID) {
        this.employeeId = employeeID;
    }
    /**
     * @return the managerEmail
     */
    public String getManagerEmail() {
        return managerEmail;
    }
    /**
     * @param managerEmails the managerEmail to set
     */
    public void setManagerEmail(String managerEmails) {
        this.managerEmail = managerEmails;
    }
    /**
     * Returns a string representation of this RequestedDTO.
     *
     * @return A string containing the employeeId and managerEmail of this RequestedDTO.
     */
    @Override
    public String toString() {
        return "RequestedDto [employeeId=" + employeeId + ", managerEmail=" + managerEmail + "]";
    }

    /**
     * Calculates the hash code value for this RequestedDTO object.
     *
     * @return The hash code value based on the employeeId and managerEmail.
     */
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, managerEmail);
    }

    /**
     * Indicates whether some other object is "equal to" this RequestedDTO.
     *
     * @param obj The reference object with which to compare.
     * @return {@code true} if this RequestedDTO is the same as the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RequestedDTO other = (RequestedDTO) obj;
        return employeeId == other.employeeId && Objects.equals(managerEmail, other.managerEmail);
    }

}
