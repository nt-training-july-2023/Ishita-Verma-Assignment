package com.portal.DTO;

import java.util.Objects;

/**
 * (DTO) class representing a response from the application.
 * This class encapsulates a message, associated data, and a status code to be
 * returned as a response from various operations in the application.
 */

public class ResponseDTO {
    /**
     * The message associated with the response.
     */
    private String message;
    /**
     * The role associated with the response.
     */
    private String role;
    /**
     * @return Getter for message.
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param messageParam Setter for message.
     */
    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }
    /**
     * @return Getter for role.
     */
    public String getRole() {
        return role;
    }
    /**
     * @param roleParam Setter for role.
     */
    public void setRole(final String roleParam) {
        this.role = roleParam;
    }
    /**
     * Calculates the hash code for this ResponseDTO
     * object based on its message and role.
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(message, role);
    }

    /**
     * Compares this ResponseDTO object to another object to check for equality.
     * @param obj The object to compare to.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
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
        ResponseDTO other = (ResponseDTO) obj;
        return Objects.equals(message, other.message)
                && Objects.equals(role, other.role);
    }

    /**
     * Generates a string representation of this ResponseDTO.
     * @return A string containing the message and role of the ResponseDTO.
     */
    @Override
    public String toString() {
        return "ResponseDTO [message=" + message + ", role=" + role + "]";
    }

}
