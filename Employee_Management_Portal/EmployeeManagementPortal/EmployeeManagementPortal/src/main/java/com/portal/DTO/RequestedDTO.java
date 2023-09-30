package com.portal.DTO;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * This is Requested Dto class.
 */
public class RequestedDTO {
      /**
     * Employee id.
     */
    @NotNull(message = "Employee id is required")
    private Long employeeId;
    /**
     * Email of manager.
     */
    @NotBlank(message = "Manager email os required")
    private String managerEmail;
    /**
     * @return the employeeId.
     */
    public Long getEmployeeId() {
        return employeeId;
    }
    /**
     * @param employeeIDParam the employeeId to set.
     */
    public void setEmployeeId(final Long employeeIDParam) {
        this.employeeId = employeeIDParam;
    }
    /**
     * @return the managerEmail.
     */
    public String getManagerEmail() {
        return managerEmail;
    }
    /**
     * @param managerEmailsParam the managerEmail to set
     */
    public void setManagerEmail(final String managerEmailsParam) {
        this.managerEmail = managerEmailsParam;
    }
    /**
     * Returns a string representation of this RequestedDTO.
     *
     * @return A string of employeeId and managerEmail.
     */
    @Override
    public String toString() {
        return "RequestedDTO [employeeId=" + employeeId
                + ", managerEmail=" + managerEmail + "]";
    }
    /**
     * Calculates the hash code value for this RequestedDTO object.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, managerEmail);
    }

    /**
     * Indicates whether some other object is "equal to" this RequestedDTO.
     *
     * @param obj The reference object with which to compare.
     * @return {@code true} if this RequestedDTO is same as obj arg;
     * {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RequestedDTO other = (RequestedDTO) obj;
        return Objects.equals(employeeId, other.employeeId)
                && Objects.equals(managerEmail, other.managerEmail);
    }
}
