package com.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class to handle resource not found scenarios.
 */
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException
     *  with the specified detail message.
     *
     * @param message The detail message.
     */
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
