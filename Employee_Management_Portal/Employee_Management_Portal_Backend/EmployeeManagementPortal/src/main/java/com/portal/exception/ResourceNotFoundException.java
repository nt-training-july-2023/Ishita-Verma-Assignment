package com.portal.exception;

/**
 * Custom exception class to handle resource not found scenarios.
 */
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
