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
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public ResponseDTO(String message, String role) {
        super();
        this.message = message;
        this.role = role;
    }
    public ResponseDTO() {
        super();
    }
    
}
