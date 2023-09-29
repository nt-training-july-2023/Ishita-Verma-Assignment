package com.portal.DTO;


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
     * Getter for message.
     */
    public String getMessage() {
        return message;
    }
    /**
     *  Setter for message.
     */
    public void setMessage(final String message) {
        this.message = message;
    }
    /**
     * Getter for role.
     */
    public String getRole() {
        return role;
    }
    /**
     * Setter for role.
     */
    public void setRole(final String role) {
        this.role = role;
    }
}
