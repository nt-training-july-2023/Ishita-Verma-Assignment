package com.portal.exceptions;
/**
 * Custom exception class to handle resource not found scenarios.
 */
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Constructs a new ResourceNotFoundException
     *  with the specified detail message.
     * @param message The detail message.
     */
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
