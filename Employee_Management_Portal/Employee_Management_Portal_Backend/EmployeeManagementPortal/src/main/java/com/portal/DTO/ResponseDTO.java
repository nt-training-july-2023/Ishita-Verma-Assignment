package com.portal.DTO;

/**
 * Data Transfer Object (DTO) class representing
 * a response from the application.
 * This class encapsulates a message, associated data, and a status code to be
 * returned as a response from various operations in the application.
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Data from lombok.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ResponseDTO {

    /**
     * The message associated with the response.
     */
    private String message;
    private String role;
}
